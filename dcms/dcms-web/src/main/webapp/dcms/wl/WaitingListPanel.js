Ext.define('DCMS.wl.WaitingListPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'wlpanel',
	closable : true,
	autoScroll : true,
	title : 'Manage Waiting List',
	layout : {
		type : 'border'
	},
	items : [ {
		xtype : 'wlgrid',
		region : 'center'
	} ]
});