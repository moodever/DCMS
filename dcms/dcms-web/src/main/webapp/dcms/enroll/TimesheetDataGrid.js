Ext.define('DCMS.enroll.TimesheetDataModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'mwf',
		type : 'auto'
	}, {
		name : 'tt',
		type : 'auto'
	} ]
});

Ext.define('DCMS.enroll.TimesheetDataGrid1', {
	extend : 'Ext.grid.Panel',
	xtype : 'tstdatagrid1',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	columns : [ {
		text : '7:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[0] ? 'X' : '';
		}
	}, {
		text : '8:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[1] ? 'X' : '';
		}
	}, {
		text : '8:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[2] ? 'X' : '';
		}
	}, {
		text : '9:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[3] ? 'X' : '';
		}
	}, {
		text : '9:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[4] ? 'X' : '';
		}
	}, {
		text : '10:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[5] ? 'X' : '';
		}
	}, {
		text : '10:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[6] ? 'X' : '';
		}
	}, {
		text : '11:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[7] ? 'X' : '';
		}
	}, {
		text : '11:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[8] ? 'X' : '';
		}
	}, {
		text : '12:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[9] ? 'X' : '';
		}
	}, {
		text : '12:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[10] ? 'X' : '';
		}
	}, {
		text : '13:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[11] ? 'X' : '';
		}
	}, {
		text : '13:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[12] ? 'X' : '';
		}
	}, {
		text : '14:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[13] ? 'X' : '';
		}
	}, {
		text : '14:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[14] ? 'X' : '';
		}
	}, {
		text : '15:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[15] ? 'X' : '';
		}
	}, {
		text : '15:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[16] ? 'X' : '';
		}
	}, {
		text : '16:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[17] ? 'X' : '';
		}
	}, {
		text : '16:30',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[18] ? 'X' : '';
		}
	}, {
		text : '17:00',
		width : 50,
		sortable : false,
		dataIndex : 'mwf',
		renderer : function(data) {
			return data[19] ? 'X' : '';
		}
	} ],
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.enroll.TimesheetDataModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	}
});

Ext.define('DCMS.enroll.TimesheetDataGrid2', {
	extend : 'Ext.grid.Panel',
	xtype : 'tstdatagrid2',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	columns : [ {
		text : '7:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[0] ? 'X' : '';
		}
	}, {
		text : '8:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[1] ? 'X' : '';
		}
	}, {
		text : '8:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[2] ? 'X' : '';
		}
	}, {
		text : '9:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[3] ? 'X' : '';
		}
	}, {
		text : '9:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[4] ? 'X' : '';
		}
	}, {
		text : '10:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[5] ? 'X' : '';
		}
	}, {
		text : '10:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[6] ? 'X' : '';
		}
	}, {
		text : '11:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[7] ? 'X' : '';
		}
	}, {
		text : '11:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[8] ? 'X' : '';
		}
	}, {
		text : '12:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[9] ? 'X' : '';
		}
	}, {
		text : '12:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[10] ? 'X' : '';
		}
	}, {
		text : '13:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[11] ? 'X' : '';
		}
	}, {
		text : '13:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[12] ? 'X' : '';
		}
	}, {
		text : '14:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[13] ? 'X' : '';
		}
	}, {
		text : '14:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[14] ? 'X' : '';
		}
	}, {
		text : '15:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[15] ? 'X' : '';
		}
	}, {
		text : '15:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[16] ? 'X' : '';
		}
	}, {
		text : '16:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[17] ? 'X' : '';
		}
	}, {
		text : '16:30',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[18] ? 'X' : '';
		}
	}, {
		text : '17:00',
		width : 50,
		sortable : false,
		dataIndex : 'tt',
		renderer : function(data) {
			return data[19] ? 'X' : '';
		}
	} ],
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.enroll.TimesheetDataModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	}
});