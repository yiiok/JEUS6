/*
	Copyright (c) 2004-2009, The Dojo Foundation All Rights Reserved.
	Available via Academic Free License >= 2.1 OR the modified BSD license.
	see: http://dojotoolkit.org/license for details
*/


if(!dojo._hasResource["jeus.Loading"]){dojo._hasResource["jeus.Loading"]=true;dojo.provide("jeus.Loading");dojo.require("dijit.Dialog");dojo.declare("jeus.Loading",dijit.DialogUnderlay,{_count:0,show:function(){if(this._count==0){this.inherited(arguments);}this._count++;},hide:function(){this._count--;this._count=Math.max(0,this._count);if(this._count==0){this.inherited(arguments);}}});}