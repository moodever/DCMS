Ext.define('DCMS.enroll.ProjectionChartModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'firstName'
	}, {
		name : 'lastName'
	}, {
		name : 'dateOfBirth',
		type : 'date'
	}, {
		name : 'sequenceNum',
		type : 'int'
	}, {
		name : 'monday'
	}, {
		name : 'tuesday'
	}, {
		name : 'wednesday'
	}, {
		name : 'thursday'
	}, {
		name : 'friday'
	}, {
		name : 'affiliation'
	}, {
		name : 'notes'
	}, {
		name : 'attendingMode'
	} ]
});

Ext.define('DCMS.enroll.ProjectionChartGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'projectchartgrid',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	columns : [ {
		text : 'Num',
		width : 50,
		sortable : false,
		dataIndex : 'sequenceNum'
	}, {
		text : 'First Name',
		width : 80,
		sortable : true,
		dataIndex : 'firstName'
	}, {
		text : 'Last Name',
		width : 80,
		sortable : true,
		dataIndex : 'lastName'
	}, {
		text : 'Date of Birth',
		width : 100,
		sortable : true,
		dataIndex : 'dateOfBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Days',
		width : 120,
		sortable : false,
		dataIndex : 'attendingMode'
	}, {
		text : 'Monday',
		width : 120,
		sortable : false,
		dataIndex : 'monday'
	}, {
		text : 'Tuesday',
		width : 120,
		sortable : false,
		dataIndex : 'tuesday'
	}, {
		text : 'Wednesday',
		width : 120,
		sortable : false,
		dataIndex : 'wednesday'
	}, {
		text : 'Thursday',
		width : 120,
		sortable : false,
		dataIndex : 'thursday'
	}, {
		text : 'Friday',
		width : 120,
		sortable : false,
		dataIndex : 'friday'
	}, {
		text : 'Affiliation',
		width : 80,
		sortable : false,
		dataIndex : 'affiliation'
	}, {
		text : 'Notes',
		width : 80,
		sortable : false,
		dataIndex : 'notes'
	} ],
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.enroll.ProjectionChartModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	},
	viewConfig : {
		stripeRows : false,
		getRowClass : function(record) {
			return record.get('firstName') == undefined ? 'empty-row' : 'nonempty-row';
		}
	}
});
