Ext.define('DCMS.enroll.ManageEnrollmentPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'manageenrollmentpanel',
	closable : true,
	autoScroll : true,
	title : 'Manage Enrollment',
	layout : {
		type : 'border'
	},
	items : [ {
		xtype : 'manageenrollmentgrid',
		region : 'center'
	} ]
});