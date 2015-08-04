/*
	Copyright (c) 2004-2009, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["jeus.Menu"]){dojo._hasResource["jeus.Menu"]=true;dojo.provide("jeus.Menu");dojo.require("dijit.Menu");dojo.declare("jeus.MenuItem",dijit.MenuItem,{onClick:function(_1){var _2=this.click;if(!_2){return;}if(this.click==="refresh"){dijit.byId("nodetreePane").refresh();}else{if(_2.service){dojo.xhrGet({url:_2.url+this.objectName,load:function(_3,_4){alert(_3);}});}else{if(!!_2.popupName){setTimeout(dojo.hitch(this,function(){window.open(_2.url+this.objectName+_2.param,_2.popupName,_2.popupParam).focus();}),100);}else{jeus.loadContent(_2.target,_2.url+this.objectName+_2.param);}}}}});}