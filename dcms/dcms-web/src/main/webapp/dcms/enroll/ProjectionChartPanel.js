Ext.define('DCMS.enroll.ProjectionChartPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'projectchartpanel',
	closable : true,
	autoScroll : true,
	title : 'Projection Chart View',
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
		itemId : 'projectButton',
		text : 'Generate Projection Chart',
		handler : function() {
			this.up('projectchartpanel').refresh();
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
			'targetDate' : targetDate
		};
		EnrollmentService.projectEnrolChart(dto, {
			callback : function(result) {
				if (!result.success) {
					Ext.MessageBox.alert("Error", result.errorMessage);
					return;
				}
				debugger;
				var dataarray = result.nodes;
				panel.removeAll();
				for (var i = 0; i < dataarray.length; i++) {
					debugger;
					var data = dataarray[i];

					// data is ClassroomDto
					var capacity = data.capacity;

					var datanodes = data.nodes;

					var weekday_remain = capacity;
					var mwf_remain = 0;
					var tt_remain = 0;

					for (var j = 0; j < datanodes.length; j++) {
						if (datanodes[j].attendingMode === 'WEEKDAY') {
							weekday_remain--;
						}
						if (datanodes[j].attendingMode === 'MON_WED_FRI') {
							if (mwf_remain != 0) {
								mwf_remain--;
							} else {
								weekday_remain--;
								tt_remain++;
							}
						}
						if (datanodes[j].attendingMode === 'TUE_THU') {
							if (tt_remain != 0) {
								tt_remain--;
							} else {
								weekday_remain--;
								mwf_remain++;
							}
						}
					}

					// Insert empty data
					for (var j = 0; j < weekday_remain; j++) {
						datanodes.push({
							"attendingMode" : 'WEEKDAY'
						});
					}
					for (var j = 0; j < mwf_remain; j++) {
						datanodes.push({
							"attendingMode" : 'MON_WED_FRI'
						});
					}
					for (var j = 0; j < tt_remain; j++) {
						datanodes.push({
							"attendingMode" : 'TUE_THU'
						});
					}

					var grid = Ext.create('DCMS.enroll.ProjectionChartGrid');
					grid.store.setData(datanodes);
					grid.title = data.className;
					panel.add(grid);

				}
			}
		});
	},
	listeners : {
		afterrender : function() {

		}
	},
	items : []
});