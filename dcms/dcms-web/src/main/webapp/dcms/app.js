Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'DCMS' : 'dcms'
	}
});
Ext.require([ 'DCMS.common.DataCollector' ]);
Ext.require([ 'DCMS.common.DataConv' ]);
Ext.require([ 'DCMS.MainViewPort', 'DCMS.MainPanel', 'DCMS.LoginPanel',
		'DCMS.SummaryPanel', 'DCMS.MenuTree' ]);
Ext.require([ 'DCMS.wl.WaitingListPanel', 'DCMS.wl.WaitingListGrid',
		'DCMS.wl.NewWaitingEntryWindow', 'DCMS.wl.OfferPositionWindow' ]);
Ext.require([ 'DCMS.enroll.ManageEnrollmentGrid',
		'DCMS.enroll.ManageEnrollmentPanel' ]);
Ext.require([ 'DCMS.enroll.EnrollmentChartGrid',
		'DCMS.enroll.EnrollmentChartPanel' ]);

Ext.require([ 'DCMS.enroll.TimesheetChildGrid',
		'DCMS.enroll.TimesheetDataGrid', 'DCMS.enroll.TimesheetSummaryGrid',
		'DCMS.enroll.TimesheetPanel' ]);

Ext.require([ 'DCMS.enroll.ProjectionChartGrid',
		'DCMS.enroll.ProjectionChartPanel' ]);
Ext.require([ 'DCMS.setting.SysSettingGrid', 'DCMS.setting.SysSettingPanel' ]);

Ext.define('Ext.overrides.selection.CheckboxModel', {
	override : 'Ext.selection.CheckboxModel',
	privates : {
		selectWithEventMulti : function(record, e, isSelected) {
			var me = this;

			if (!e.shiftKey && !e.ctrlKey && e.getTarget(me.checkSelector)) {
				if (isSelected) {
					me.doDeselect(record); // Second param here is suppress
					// event, not "keep selection"
				} else {
					me.doSelect(record, true);
				}
			} else {
				me.callParent([ record, e, isSelected ]);
			}
		}
	}
});

Ext.application({
	name : 'Child Care Management System',
	launch : function() {
		Ext.create('DCMS.MainViewPort');
	}
});