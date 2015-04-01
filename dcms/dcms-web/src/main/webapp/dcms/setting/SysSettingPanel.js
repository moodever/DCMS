Ext.define('DCMS.setting.SysSettingPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'syssettingpanel',
	closable : true,
	autoScroll : true,
	title : 'System Setting View',
	layout : {
		type : 'anchor'
	},
	initComponent : function(arguments) {
		this.callParent(arguments);
	},
	tbar : [ {
		fieldLabel : 'Target Date',
		itemId : 'targetDate',
		xtype : 'datefield',
		editable : false
	}, {
		itemId : 'CreateClassForTermButton',
		text : 'Create Class for New Term',
		handler : function() {
			this.up('syssettingpanel').refresh();
		}
	} ],
	refresh : function() {
		var panel = this;
		var targetDate = this.down("#targetDate").getValue();
		if (targetDate == null) {
			Ext.MessageBox.alert("Error", "Please select a date");
			return;
		}
		var dto = {
			'date' : targetDate
		};
		SettingService.generateClassForTerm(dto, {
			callback : function(result) {
				if (!result.success) {
					Ext.MessageBox.alert("Error", result.errorMessage);
					return;
				}
				debugger;
				var datanodes = result.classroomNodes;
				panel.removeAll();
				
				if (datanodes.length != 0) {
					var grid = Ext
							.create('DCMS.setting.SysSettingGrid');
					grid.store.setData(datanodes);
					panel.add(grid);
				}
				
				//for (var i = 0; i < dataarray.length; i++) {
				//	var data = dataarray[i];
				//	var datanodes = data.nodes;
				//	if (datanodes.length != 0) {
				//		var grid = Ext
				//				.create('DCMS.setting.SysSettingGrid');
				//		grid.store.setData(datanodes);
				//		panel.add(grid);
				//	}
				//}
			}
		});
	},
	listeners : {
		afterrender : function() {

		}
	},
	items : []
});