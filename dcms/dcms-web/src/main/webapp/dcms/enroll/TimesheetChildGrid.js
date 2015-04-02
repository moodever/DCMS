Ext.define('DCMS.enroll.TimesheetChildModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'childName'
	}, {
		name : 'dateBirth',
		type : 'date'
	}, {
		name : 'dateType'
	} ]
});

Ext.define('DCMS.enroll.TimesheetChildGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'tstchildgrid',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	columns : [ {
		text : 'Child Name',
		width : 100,
		sortable : true,
		dataIndex : 'childName'
	}, {
		text : 'DOB',
		width : 100,
		sortable : true,
		dataIndex : 'dateBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Days',
		width : 120,
		sortable : false,
		dataIndex : 'dateType'
	} ],
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.enroll.TimesheetChildModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	}
});