Ext.define('DCMS.enroll.TimesheetSummaryModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'data',
		convert : function(v, record) {
			if (this.owner != undefined && this.owner.dataKey != undefined)
				return record.data[this.owner.dataKey];
		}
	} ]
});

Ext.define('DCMS.enroll.TimesheetSummaryGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'tstsummarygrid',
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
			return data[0];
		}
	}, {
		text : '8:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[1];
		}
	}, {
		text : '8:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[2];
		}
	}, {
		text : '9:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[3];
		}
	}, {
		text : '9:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[4];
		}
	}, {
		text : '10:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[5];
		}
	}, {
		text : '10:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[6];
		}
	}, {
		text : '11:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[7];
		}
	}, {
		text : '11:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[8];
		}
	}, {
		text : '12:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[9];
		}
	}, {
		text : '12:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[10];
		}
	}, {
		text : '13:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[11];
		}
	}, {
		text : '13:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[12];
		}
	}, {
		text : '14:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[13];
		}
	}, {
		text : '14:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[14];
		}
	}, {
		text : '15:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[15];
		}
	}, {
		text : '15:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[16];
		}
	}, {
		text : '16:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[17];
		}
	}, {
		text : '16:30',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[18];
		}
	}, {
		text : '17:00',
		width : 50,
		sortable : false,
		dataIndex : 'data',
		renderer : function(data) {
			return data[19];
		}
	} ]
});
