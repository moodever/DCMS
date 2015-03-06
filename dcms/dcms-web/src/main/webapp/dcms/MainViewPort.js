Ext.define("DCMS.MainViewPort", {
	extend : 'Ext.container.Viewport',
	id : 'mainpanel',
	layout : {
		type : 'border'
	},
	items : [ {
		xtype : 'menutree',
		id : 'menuTree',
		region : 'west'
	}, {
		xtype : 'tabpanel',
		id : 'maintab',
		closeAction : 'hide',
		region : 'center',
		items : [ {
			xtype : 'summaryPanel'
		} ]
	} ]
});