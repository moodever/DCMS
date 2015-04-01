Ext.define('DCMS.enroll.EnrollmentChartPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'enrollchartpanel',
	closable : true,
	autoScroll : true,
	title : 'Enrollment Chart View',
	layout : {
		type : 'border'
	},
	items : [ {
		xtype : 'enrollchartgrid',
		region : 'center'
	} ]
});