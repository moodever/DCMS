Ext.define('DCMS.enroll.EnrollmentChartModel', {
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
	} ]
});

Ext.define('DCMS.enroll.EnrollmentChartGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'enrollchartgrid',
	collapsible : false,
	multiSelect : false,
	columns : [ {
		text : 'Date of Birth',
		width : 100,
		sortable : true,
		dataIndex : 'dateOfBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
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
	tbar : [ {
		fieldLabel : 'Select Classroom to View',
		xtype : 'combo',
		itemId : 'classroomCombo',
		store : DCMS.wl.classStore,
		queryMode : 'local',
		displayField : 'name',
		valueField : 'value',
		value : 'Infant',
		editable : false,
		labelWidth : 160,
		listeners : {
			change : function() {
				this.up('enrollchartgrid').refresh();
			}
		}
	}, {
		itemId : 'downloadButton',
		text : 'Download Chart',
		handler : function() {
		}
	} ],
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.enroll.EnrollmentChartModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	},
	refresh : function() {
		var grid = this;
		var selectedClassroom = this.down('#classroomCombo').getValue();
		var dto = {
			"classroomName" : selectedClassroom
		};
		EnrollmentService.generateEnrolChart(dto, {
			callback : function(result) {
				if (!result.success) {
					Ext.MessageBox.alert("Error", result.errorMessage);
				} else {
					debugger;
					var nodes = result.kidsChartNodes;
					grid.store.setData(nodes);
				}
			}
		});
	},
	listeners : {
		afterrender : function() {
			this.refresh();
		}
	}
});
