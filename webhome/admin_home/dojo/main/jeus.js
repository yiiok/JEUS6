if(!dojo._hasResource["jeus.core"]){ //_hasResource checks added by build. Do not use _hasResource directly in your code.
dojo._hasResource["jeus.core"] = true;
dojo.provide("jeus.core");

dojo.require("dojo.parser");

dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.ContentPane");
dojo.require("dojox.layout.ContentPane");
dojo.require("dijit.layout.AccordionContainer");
dojo.require("dijit.TitlePane");
dojo.require("dijit.Tooltip");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.Textarea");
dojo.require("dojo.data.ItemFileReadStore");
dojo.require("dijit.Tree");
dojo.require("dojo.i18n");
dojo.require("dojo.io.iframe");
dojo.require("dojo.cache");

dojo.require("dijit.Declaration");


//dojo.registerModulePath("jeus","../../dojo_js");
dojo.require("jeus.Chart");
dojo.require("jeus.Loading");
dojo.require("jeus.Dialog");
dojo.require("jeus.Menu");
dojo.require("jeus.Tree");
dojo.require("jeus.TargetExplorer");
dojo.require("jeus.Palette");
dojo.require("jeus.Stacktrace");
dojo.require("jeus.ListenerConnection");
dojo.requireLocalization("jeus", "common", null, "ROOT,ko");

function decodeURL(str){

    var s0, i, j, s, ss, u, n, f;
    s0 = "";                // decoded str

    for (i = 0; i < str.length; i++){   // scan the source str
        s = str.charAt(i);
        if (s == "+"){s0 += " ";}       // "+" should be changed to SP
        else {
            if (s != "%"){s0 += s;}     // add an unescaped char
            else{               // escape sequence decoding
                u = 0;          // unicode of the character
                f = 1;          // escape flag, zero means end of this sequence

                while (true) {
                    ss = "";        // local str to parse as int
                        for (j = 0; j < 2; j++ ) {  // get two maximum hex characters for parse
                            sss = str.charAt(++i);
                            if (((sss >= "0") && (sss <= "9")) || ((sss >= "a") && (sss <= "f"))  || ((sss >= "A") && (sss <= "F"))) {
                                ss += sss;      // if hex, add the hex character
                            } else {--i; break;}    // not a hex char., exit the loop
                        }

                    n = parseInt(ss, 16);           // parse the hex str as byte
                    if (n <= 0x7f){u = n; f = 1;}   // single byte format
                    if ((n >= 0xc0) && (n <= 0xdf)){u = n & 0x1f; f = 2;}   // double byte format
                    if ((n >= 0xe0) && (n <= 0xef)){u = n & 0x0f; f = 3;}   // triple byte format
                    if ((n >= 0xf0) && (n <= 0xf7)){u = n & 0x07; f = 4;}   // quaternary byte format (extended)
                    if ((n >= 0x80) && (n <= 0xbf)){u = (u << 6) + (n & 0x3f); --f;}         // not a first, shift and add 6 lower bits
                    if (f <= 1){break;}         // end of the utf byte sequence
                    if (str.charAt(i + 1) == "%"){ i++ ;}                   // test for the next shift byte
                    else {break;}                   // abnormal, format error
                }
            s0 += String.fromCharCode(u);           // add the escaped character
            }
        }
    }
    return s0;
}

(function(){
	var jeus = window.jeus;
	dojo.mixin(jeus, {
		loading: null,
		append: function(target, value){
			target = dojo.byId(target);
			var old = dojo.trim(target.value);
			var append = "";
			if(!!old){
				append = " \r\n";
			}
			append += value;
			target.value = old + append;
		},
		fireEvent: function(element,event){
		    if (document.createEventObject){
		        var evt = document.createEventObject();
		        return element.fireEvent('on'+event,evt);
		    }
		    else{
	// 			dispatch for firefox + others
	//	        var evt = document.createEvent("HTMLEvents");
	//	        evt.initEvent(event, true, true ); // event type,bubbling,cancelable
	//	        return !element.dispatchEvent(evt);
				
				var evt = document.createEvent('MouseEvents');
				evt.initMouseEvent( event, true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null );
				element.dispatchEvent(evt);		
		    }
		},
		showContextMenu: function(evt, href) {

			var tn = dijit.getEnclosingWidget(evt.target);
			if(!!tn){
				var item = tn.item;
				var store = tn.tree.model.store;
				var type = store.getValue(item, "type");
				if(!!type){
				    if(!this.contextmenus)
		    			this.contextmenus = [];
					if(!this.contextmenus[type]){
						dojo.xhrGet({
							url: href,
							content:{
								"type": type
							},
							handleAs: "json",
							sync: true,
							load: dojo.hitch(this, function(response, ioArgs){
								if(response.success){
									this.contextmenus[type] = response.menu;
								}
							})
						});
						
					}

					var menu = this.contextmenus[type];
			        if( menu ){
			        	menu = dojo.clone(menu);	        	
			            menu.objectName = store.getValue(item, "objectName");
			            menu.state = store.getValue(item, "state");
			            menu.name = store.getValue(item, "label");
			            					
						var treeMenu = this._makeMenu(menu, false);
			            treeMenu.startup();
						treeMenu._openMyself(evt);
			        }
				}
			
			}
			dojo.stopEvent(evt);
			return false;
		},
		_makeMenu: function(items, isTop){
			var menu2 = dijit.byId("nodeTreeMenu");
			if(menu2 !== undefined){
		    	menu2.destroy(true);
		    }
		    menu2 = new dijit.Menu({id: "nodeTreeMenu", contextMenuForWindow: isTop});
			dojo.forEach(items, function(itemJson){
				// if submenu is specified, create the submenu and then make submenuId point to it
				if(itemJson.separator){
					menu2.addChild(new dijit.MenuSeparator());
				}else{
					if(itemJson.submenu){
						var submenu = this._makeMenu(itemJson.submenu, false);
						itemJson.submenuId = submenu.widgetId;
					}
					itemJson.label = itemJson.label.replace(/\{0\}/, items.name);
					var item = new jeus.MenuItem(itemJson);

					if( items.state && itemJson.enableStates && itemJson.enableStates.indexOf(items.state) < 0 ){
				        item.setDisabled(true);
				    }else{
				    	item.objectName = items.objectName;
				    }
					menu2.addChild(item);
				}
			});
			return menu2;
		},
		toggleButton: function(obj){
			var button = dojo.byId(obj);
		    var detail = dojo.byId(button.id + "_detail");
		    
		    if(!detail) return;

		    var messages = dojo.i18n.getLocalization("jeus", "common");
		    if(dojo.style(detail, "display") == 'block'){
		    	dojo.style(detail, "display", "none");
		        dojo.attr(button, "value", messages.detail);
		    }else{
		    	dojo.style(detail, "display", "block");
		        detail.focus();
				dojo.attr(button, "value", messages.hide);
		    }
		},
		showElementDocument: function(obj){
			var panel = dijit.byId("ElementDocument");
			if(!panel){
				var node = document.createElement("div");
				dojo.body().appendChild(node);
				var messages = dojo.i18n.getLocalization("jeus", "common");
				var params = {
					id : "ElementDocument",
					title : messages.elementDocument,
					refocus : false,
					autofocus : false,
					duration : 300
				};
				panel = new jeus.Dialog(params, node);
				panel.resize({ w:600 });
			}
			panel.setHref(obj.href);
			panel.show();
		},
		alert: function(message){
			var panel = dijit.byId("AlertDialog");
			if(!panel){
				var node = document.createElement("div");
				dojo.body().appendChild(node);
				var messages = dojo.i18n.getLocalization("jeus", "common");
				var params = {
					id : "AlertDialog",
					title : messages.info,
					refocus : false,
					autofocus : true,
					duration : 50,
					templateString: dojo.cache("jeus", "templates/AlertDialog.html")
				};
				panel = new jeus.Dialog(params, node);
				panel.resize({ w:400 });
			}
			panel.setContent(message);
			panel.show();
		},	
		confirm: function(message, func){
			var panel = dijit.byId("ConfirmDialog");
			if(!panel){
				var node = document.createElement("div");
				dojo.body().appendChild(node);
				var messages = dojo.i18n.getLocalization("jeus", "common");
				var params = {
					id : "ConfirmDialog",
					title : messages.confirm,
					refocus : false,
					autofocus : true,
					duration : 50,
					templateString: dojo.cache("jeus", "templates/ConfirmDialog.html")
				};
				panel = new jeus.Dialog(params, node);
				panel.resize({ w:400 });
			}
			panel.setContent(message);
			panel.execute = func;
			panel.show();
		},		
		onExtendedCheckbox: function(obj, parent){
			var checked = !obj.checked;
			dojo.query("input,textarea", dojo.byId(parent)).attr("disabled", checked);
			dojo.attr(dojo.byId(obj), "disabled", false);
			return true; 
		},
		onChangeInnerTabPanel: function(obj, targetId, index){
			dojo.xhrGet({
				url: obj.href + "&json=true"
			});
			
			dojo.query("> ul.top_nav > li > a", dojo.byId(targetId)).removeClass("selected");
			dojo.addClass(dojo.byId(obj), "selected");
			
			dojo.query("> div.top_content", dojo.byId(targetId)).style("display","none");
			dojo.style(targetId + "_" + index, "display","block");
		},
		helpURL: null,
		popupHelp: function(){
			var helpURL = this.helpURL;
		    if(helpURL != null) {
		        helpURL = helpURL.substring(1);
		    } else {
		        helpURL = "onlinehelp.html";
		    }
		    var src = "./app?page=OnlineHelp_Main&service=external&sp=" + escape(helpURL);
		    window.open(src , "help", "width=971,height=600,scrollbars=yes,toolbars=no,resizable=no").focus();
		},
		loadContent: function(page, href, noHistory){
			dijit.byId(page).attr("href", href);
			if(page == "rightPane" && !noHistory){
				var data = href || "";
				if(data.indexOf("service=external") != -1){
					jeus.back.addToHistory(href);
				}
			}
		},
		loadRightPane: function(evt){
			var href = evt.currentTarget.href || evt.target.href;
			this.loadContent("rightPane", href);
			dojo.stopEvent(evt);
		},
		rightPaneInit: function(){
			dojo.query('a[href]:not([href^="javascript:"]):not([onclick])', this.containerNode || this.domNode).forEach(function(src){
				if(dojo.hasClass(src, "confirm")){
					this.connect(src, "onclick", (function(){
						var message = dojo.attr(src, "message");
						var href = dojo.attr(src, "href");
						return function(e){
							dojo.stopEvent(e);
							jeus.confirm(decodeURL(message), function(){
								jeus.loadContent("rightPane", href);
							});
						};
					})());
				}else{
					this.connect(src, "onclick", dojo.hitch(jeus, "loadRightPane"));
				}
			}, this);
			
			dojo.query('input[type=button].refresh', this.containerNode || this.domNode).forEach(function(src){
				this.connect(dojo.byId(src), "onclick", function(e){
					dojo.stopEvent(e);
					dijit.byId("rightPane").refresh();
				});
			}, this);
			dojo.query('input[type=reset]', this.containerNode || this.domNode).forEach(function(src){
				this.connect(dojo.byId(src), "onclick", function(e){
					dojo.stopEvent(e);
					var messages = dojo.i18n.getLocalization("jeus", "common");
					var target = e.currentTarget;
					jeus.confirm(messages.resetConfirm, dojo.hitch(this, function(){
						target.form.reset();
					}));
				});
			}, this);
			dojo.query('form', this.containerNode || this.domNode).forEach(dojo.hitch(this, jeus.form.registerForm), this);
		},
		upload: function(element){
			jeus.loading.show();
			dojo.io.iframe.send({
				form: element.form,
				handleAs: "text",
				handle: function(response,ioArgs){
	            	dijit.byId("rightPane").setContent(response);
	            	jeus.loading.hide();
				}
			});
		},
		onChangeAllCheck: function(obj, target){
			dojo.query("td input[type=checkbox]:not([disabled])", dojo.byId(target)).forEach(function(src){
				src.checked = obj.checked;				
			},this);
		}
	});
})();
(function(){
	jeus.form = {
	    forms:{},
	  	registerForm: function(id) {
	        var form = dojo.byId(id);
	        if(!form){
	        	dojo.raise("Form not found with id " + id);
	            return;
	        }
	        // make sure id is correct just in case node passed in has only name
	        id = dojo.attr(form, "id");

	        // if previously connected, cleanup and reconnect
	        if(jeus.form.forms[id]){
	            delete jeus.form.forms[id];
	        }

	        jeus.form.forms[id] = {};

	        var elements = dojo.query("[type=submit]", form).concat(dojo.query("[type=button]", form), dojo.query("input[type=image]", form));
	        
	        var sync = dojo.hasClass(form, "sync");
	        if(sync){
		        dojo.forEach(elements, function(src){
		        	var message = dojo.attr(src, "message");
		        	if(!!!message){
		        	}else{
	        			this.connect(src, "onclick", (function(message){
			        		return function(e){
			        			dojo.stopEvent(e);
			        			var target = e.currentTarget || e.target;
								jeus.confirm(message, dojo.hitch(this, function(){
									target.form.submit();
								}));		        			
			        		};	        					        				
	        			})(message));
		        	}
		        }, this);
	        	
	        }else{
		        dojo.forEach(elements, function(src){
		        	var message = dojo.attr(src, "message");
		        	if(!!!message){
	        			this.connect(src, "onclick", dojo.hitch(jeus.form, "inputClicked"));
		        	}else{
		        		this.connect(src, "onclick", (function(message){
			        		return function(e){
			        			dojo.stopEvent(e);
								jeus.confirm(message, dojo.hitch(this, function(){
									jeus.form.inputClicked(e);
									jeus.form.overrideSubmit(e);
								}));		        			
			        		};
			        	})(message));
		        	}
		        }, this);
	        	this.connect(form, "onsubmit", dojo.hitch(jeus.form, "overrideSubmit"));
	        }
	    },
	    
	    overrideSubmit: function(e){
	        dojo.stopEvent(e);
	        var elm = e.target;
	        if (dojo.exists("form", elm)){
	            elm = elm.form;
	        }
	        jeus.form.submitAsync(elm);
	    },
	    
	    inputClicked: function(e){
	        var node = e.currentTarget || e.target;
	        if(node.disabled || !dojo.exists("form", node)){
	        	dojo.stopEvent(e);
	        	return; 
	        }
	        jeus.form.forms[node.form.getAttribute("id")].clickedButton = node;
	    },
	    
	    submitAsync: function(form, content, submitName, parms){
	        form = dojo.byId(form);
	        if(!form){
                console.log("Form not found with id " + id);
                return;
	        }
	        var formId = dojo.attr(form, "id");

	        if (submitName){
	            var previous = form.submitname.value;
	            form.submitname.value=submitName;
	            if(!content){ content={}; }
	            if(form[submitName]){
	                content[submitName]=form[submitName].value;
	            }
	        }
			
	        // handle submissions from input buttons
	        if (dojo.exists("clickedButton", jeus.form.forms[formId])) {
	            if (!content) { content={}; }
	            content[jeus.form.forms[formId].clickedButton.getAttribute("name")]=jeus.form.forms[formId].clickedButton.getAttribute("value");
	            delete jeus.form.forms[formId].clickedButton;
	        }

	        var kwArgs={
	            form:form,
	            sync:false,
	            content:content,
	            useCache:true,
	            preventCache:true,
	            error: function(response, ioArgs){
	        		jeus.loading.hide();
	        		var rightPane = dijit.byId("rightPane");
	        		rightPane._onError.call(rightPane, 'Download', response);
	        	},
	            load: function(response, ioArgs){
	            	jeus.loading.hide();	
	            	dijit.byId("rightPane").setContent(response);
	            },
	            handle: function(response, ioArgs){
	            }
	        };
			
	        // check for override
	        if (parms){
	            if (dojo.exists("url", parms)) { kwArgs.url=parms.url; }
	        }

			jeus.loading.show();
	        dojo.xhrPost(kwArgs);

	        if (submitName){
	            form.submitname.value = previous;
	        }
	    }
	};	
	
})();

(function(){ 
	var back = jeus.back = {};
	
	var currentHref = null;
	var historyIframe = null;

	function getUrlQuery(url){
		var segments = url.split("?");
		if(segments.length < 2){
			return null; //null
		}
		else{
			return segments[1]; //String
		}
	}
	
	function loadIframeHistory(href){
		var url = (dojo.config["dojoIframeHistoryUrl"] || dojo.moduleUrl("jeus", "resources/iframe_history.html")) + "?" + encodeURIComponent(href);
        if(historyIframe){
		    dojo.isSafari ? historyIframe.location = url : window.frames[historyIframe.name].location = url;
        }else{
        }
		return url; //String
	}

	back.init = function(href){
		if(dojo.byId("dj_history")){ return; } // prevent reinit
		currentHref = href;
		var src = dojo.config["dojoIframeHistoryUrl"] || dojo.moduleUrl("jeus", "resources/iframe_history.html") + "?" + encodeURIComponent(href);
		document.write('<iframe style="border:0;width:1px;height:1px;position:absolute;visibility:hidden;bottom:0;right:0;" name="dj_history" id="dj_history" src="' + src + '"></iframe>');
	};

	back.addToHistory = function(href){
		if(!historyIframe){
			if(dojo.config["useXDomain"] && !dojo.config["dojoIframeHistoryUrl"]){}
			historyIframe = window.frames["dj_history"];
		}
		currentHref = href;
		var url = loadIframeHistory(href);
	};

	back._iframeLoaded = function(evt, ifrLoc){
		var query = getUrlQuery(ifrLoc.href);
		query = decodeURIComponent(query);
		if(query != currentHref){
			currentHref = query;
			jeus.loadContent("rightPane", currentHref, true);
		}
	};
 })();



}
