Ext.define('DCMS.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainpanel',
	layout : 'border',
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
