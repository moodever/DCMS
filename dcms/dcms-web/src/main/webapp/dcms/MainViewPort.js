Ext.define("DCMS.MainViewPort", {
	extend : 'Ext.container.Viewport',
	id : 'mainpanel',
	layout : {
		type : 'border'
	},
	items : [ {
		xtype : 'tabpanel',
		id : 'maintab',
		closeAction : 'hide',
		region : 'center',
		items : [ {
			xtype : 'summaryPanel'
		} ]
	} ]
});