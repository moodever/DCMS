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
			EnrollmentService.viewTimesheet({
				'classroomName' : combo.getValue()
			}, {
				callback : function(result) {
					if (!result.success) {
						Ext.Message.alert('Error', result.errorMessage);
						return;
					}
					debugger;
				},
				errorHandler : function(error, errorMsg) {
					console.log(error);
					console.log(errorMsg);
				}
			});
		}
	} ],
	items : [ {
		xtype : 'tabpanel',
		closeable : false,
		region : 'center',
		items : [ /*
					 * { xtype : 'tstdatagrid1', title :
					 * 'Monday/Wednesday/Friday' }, { xtype : 'tstdatagrid2',
					 * title : 'Tuesday/Thursday' }
					 */]
	}, {
		xtype : 'tstchildgrid',
		region : 'west'
	} ]
});