/*
	Copyright (c) 2004-2009, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["jeus.Dialog"]){dojo._hasResource["jeus.Dialog"]=true;dojo.provide("jeus.Dialog");dojo.require("dijit.Dialog");dojo.declare("jeus.Dialog",dijit.Dialog,{_position:function(){if(!dojo.hasClass(dojo.body(),"dojoMove")){var _1=this.domNode,_2=dijit.getViewport(),p=this._relativePosition,bb=p?null:dojo._getBorderBox(_1),l=Math.floor(_2.l+(p?p.x:(_2.w-bb.w)/2)),t=Math.max(0,Math.floor(_2.t+(p?p.y:(_2.h-bb.h)/2)));dojo.style(_1,{left:l+"px",top:t+"px"});}}});}