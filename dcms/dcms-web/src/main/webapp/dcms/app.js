Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'DCMS' : 'dcms'
	}
});
Ext.require([ 'DCMS.common.DataCollector' ]);
Ext.require([ 'DCMS.MainViewPort', 'DCMS.SummaryPanel', 'DCMS.MenuTree' ]);
Ext.require([ 'DCMS.wl.WaitingListPanel', 'DCMS.wl.WaitingListGrid',
		'DCMS.wl.NewWaitingEntryWindow' ]);

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