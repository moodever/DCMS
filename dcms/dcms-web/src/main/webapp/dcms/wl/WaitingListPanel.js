Ext.namespace('DCMS.wl');

DCMS.wl.affiliationStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		"name" : "Faculty",
		"value" : 0
	}, {
		"name" : "Student",
		"value" : 1
	}, {
		"name" : "None",
		"value" : 2
	} ]
});

DCMS.wl.gradeStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		"name" : "Infant",
		"value" : 0
	}, {
		"name" : "Toddler",
		"value" : 1
	}, {
		"name" : "Super Toddler",
		"value" : 2
	} ]
});

DCMS.wl.attendingModeStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		"name" : "Weekdays",
		"value" : 0
	}, {
		"name" : "Mon, Wed, Fri",
		"value" : 1
	}, {
		"name" : "Tue, Thu",
		"value" : 2
	} ]
});

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