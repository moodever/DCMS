Ext.namespace('DCMS.wl');

DCMS.wl.affiliationStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		"name" : "None",
		"value" : 0
	}, {
		"name" : "Faculty",
		"value" : 1
	}, {
		"name" : "Student",
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

DCMS.wl.classStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		'name' : 'Infant',
		"value" : 'Infant'
	}, {
		'name' : 'Toddler1',
		'value' : 'Toddler1'
	}, {
		'name' : 'Toddler2',
		'value' : 'Toddler2'
	}, {
		'name' : 'Progressive Room',
		'value' : 'Progressive Room'
	}, {
		'name' : "Preschool3",
		'value' : 'Preschool3'
	}, {
		'name' : 'Preschool4',
		'value' : 'Preschool4'
	}, {
		'name' : 'School Age',
		'value' : 'School Age'
	} ]
});

DCMS.wl.termStore = Ext.create('Ext.data.Store', {
	fields : [ 'name', 'value' ],
	data : [ {
		'name' : 'Spring 15',
		"value" : 'spring15'
	}, {
		'name' : 'Fall 15',
		'value' : 'fall15'
	}, {
		'name' : 'Spring 16',
		'value' : 'spring16'
	}, {
		'name' : 'Fall 16',
		'value' : 'fall16'
	}, {
		'name' : "Spring 17",
		'value' : 'spring17'
	}, {
		'name' : 'Fall 17',
		'value' : 'fall17'
	}, {
		'name' : 'Spring 18',
		'value' : 'spring18'
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