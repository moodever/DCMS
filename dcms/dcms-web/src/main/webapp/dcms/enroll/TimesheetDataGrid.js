Ext.define('DCMS.enroll.TimesheetDataModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'data',
		convert : function(v, record) {
			if (this.owner != undefined && this.owner.dataKey != undefined)
				return record.data[this.owner.dataKey];
		}
	} ]
});

Ext.namespace('DCMS.enroll.TimesheetData');
DCMS.enroll.TimesheetData.renderer = function(data, index) {
	if (typeof data[index] === 'boolean')
		return data[index] ? 'X' : '';
	return data[index];
};

Ext.define('DCMS.enroll.TimesheetDataGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'tstdatagrid',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	selModel : Ext.create('Ext.selection.RowModel'),
	columns : [ {
		text : '7:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 0);
		}
	}, {
		text : '8:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 1);
		}
	}, {
		text : '8:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 2);
		}
	}, {
		text : '9:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 3);
		}
	}, {
		text : '9:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 4);
		}
	}, {
		text : '10:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 5);
		}
	}, {
		text : '10:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 6);
		}
	}, {
		text : '11:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 7);
		}
	}, {
		text : '11:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 8);
		}
	}, {
		text : '12:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 9);
		}
	}, {
		text : '12:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 10);
		}
	}, {
		text : '13:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 11);
		}
	}, {
		text : '13:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 12);
		}
	}, {
		text : '14:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 13);
		}
	}, {
		text : '14:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 14);
		}
	}, {
		text : '15:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 15);
		}
	}, {
		text : '15:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 16);
		}
	}, {
		text : '16:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 17);
		}
	}, {
		text : '16:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 18);
		}
	}, {
		text : '17:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return DCMS.enroll.TimesheetData.renderer(data, 19);
		}
	} ]
});
