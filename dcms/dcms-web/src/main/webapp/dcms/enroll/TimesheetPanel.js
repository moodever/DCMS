Ext.namespace('DCMS.enroll.Timesheet');
DCMS.enroll.Timesheet.calStaff = function(input) {
	var result = {};
	for ( var key in input) {
		var data = input[key];
		var calculated = [];
		for (var i = 0; i < data.length; i++) {
			calculated[i] = Math.ceil(data[i] / 7);
		}
		result[key] = calculated;
	}
	return result;
};

Ext.define('DCMS.enroll.TimesheetPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'timesheetpanel',
	closable : true,
	autoScroll : true,
	title : 'Timesheet',
	layout : {
		type : 'border'
	},
	tbar : [ {
		fieldLabel : 'Choose a class',
		itemId : 'targetClass',
		editable : false,
		xtype : 'combo',
		itemId : 'classroomCombo',
		store : DCMS.wl.classStore,
		queryMode : 'local',
		displayField : 'name',
		valueField : 'value',
		value : 'Infant',
	}, {
		itemId : 'viewButton',
		text : 'View Timesheet',
		handler : function() {
			var combo = this.up('timesheetpanel').down('#classroomCombo');
			var panel = this.up('timesheetpanel');
			EnrollmentService.viewTimesheet({
				'classroomName' : combo.getValue()
			}, {
				callback : function(result) {
					if (!result.success) {
						Ext.MessageBox.alert('Error', result.errorMessage);
						return;
					}
					debugger;
					var staff = DCMS.enroll.Timesheet.calStaff(result.summary);
					var summary = [ result.summary, staff ];
					panel.down('#childGrid').store.setData(result.entries);

					panel.down('#mondayData').store.setData(result.entries);
					panel.down('#mondaySummary').store.setData(summary);

					panel.down('#tuesdayData').store.setData(result.entries);
					panel.down('#tuesdaySummary').store.setData(summary);

					panel.down('#wednesdayData').store.setData(result.entries);
					panel.down('#wednesdaySummary').store.setData(summary);

					panel.down('#thursdayData').store.setData(result.entries);
					panel.down('#thursdaySummary').store.setData(summary);

					panel.down('#fridayData').store.setData(result.entries);
					panel.down('#fridaySummary').store.setData(summary);

				},
				errorHandler : function(error, errorMsg) {
					console.log(error);
					console.log(errorMsg);
				}
			});
		}
	} ],
	bodyStyle : {
		"background-color" : "white"
	},
	items : [ {
		xtype : 'tabpanel',
		closeable : false,
		region : 'center',
		items : [ {
			layout : 'vbox',
			itemId : 'mondayTab',
			title : 'Monday',
			items : [ {
				xtype : 'tstdatagrid',
				flex : 1,
				itemId : 'mondayData',
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetDataModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'monday';
					}
				}
			}, {
				xtype : 'tstsummarygrid',
				title : 'Summary',
				itemId : 'mondaySummary',
				height : 200,
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetSummaryModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'monday';
					}
				}
			} ]
		},

		{
			layout : 'vbox',
			itemId : 'tuesdayTab',
			title : 'Tuesday',
			items : [ {
				xtype : 'tstdatagrid',
				flex : 1,
				itemId : 'tuesdayData',
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetDataModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'tuesday';
					}
				}
			}, {
				xtype : 'tstsummarygrid',
				title : 'Summary',
				itemId : 'tuesdaySummary',
				height : 200,
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetSummaryModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'tuesday';
					}
				}
			} ]
		}, 
		
		{
			layout : 'vbox',
			itemId : 'wednesdayTab',
			title : 'Wednesday',
			items : [ {
				xtype : 'tstdatagrid',
				flex : 1,
				itemId : 'wednesdayData',
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetDataModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'wednesday';
					}
				}
			}, {
				xtype : 'tstsummarygrid',
				title : 'Summary',
				itemId : 'wednesdaySummary',
				height : 200,
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetSummaryModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'wednesday';
					}
				}
			} ]
		},
		
		{
			layout : 'vbox',
			itemId : 'thursdayTab',
			title : 'thursday',
			items : [ {
				xtype : 'tstdatagrid',
				flex : 1,
				itemId : 'thursdayData',
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetDataModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'thursday';
					}
				}
			}, {
				xtype : 'tstsummarygrid',
				title : 'Summary',
				itemId : 'thursdaySummary',
				height : 200,
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetSummaryModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'thursday';
					}
				}
			} ]
		},
		
		
		
		{
			layout : 'vbox',
			itemId : 'fridayTab',
			title : 'friday',
			items : [ {
				xtype : 'tstdatagrid',
				flex : 1,
				itemId : 'fridayData',
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetDataModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'friday';
					}
				}
			}, {
				xtype : 'tstsummarygrid',
				title : 'Summary',
				itemId : 'fridaySummary',
				height : 200,
				width : '100%',
				store : Ext.create('Ext.data.ArrayStore', {
					model : Ext.create('DCMS.enroll.TimesheetSummaryModel')
				}),
				listeners : {
					afterrender : function() {
						this.store.model.dataKey = 'friday';
					}
				}
			} ]
		}
		
		
		
		]
	}, {
		layout : 'vbox',
		region : 'west',
		items : [ {
			xtype : 'tstchildgrid',
			itemId : 'childGrid',
			margin : '36px 0 0 0',
			width : 300,
			minWidth : 300,
			flex : 1
		}, {
			width : 300,
			height : 180,
			layout : 'vbox',
			bodyStyle : 'padding-top:50px;padding-left: 150px;',
			items : [ {
				height : 30,
				html : 'Total Child'
			}, {
				height : 30,
				html : 'Staff needed'
			} ]
		} ]
	} ]
});