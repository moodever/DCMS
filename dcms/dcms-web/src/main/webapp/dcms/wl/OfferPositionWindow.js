/**
 * 
 */
Ext.namespace('DCMS.wl');

/**
 * This is a function to validate timesheet format
 */
DCMS.wl.validateTimesheet = function(value) {
	if (value == '')
		// Accept empty string
		return true;
	var regex = /^((\d{1,2}(:(00|30))?)(\s*-\s*(\d{1,2}(:(00|30))?))?)(\s*,\s*(\d{1,2}(:(00|30))?)(-(\d{1,2}(:(00|30))?))?)*$/;
	if (!regex.test(value)) {
		return false;
	}
	var parts = value.split(',');
	var verifyNum = function(value) {
		var first = value;
		var second = 0;
		if (value.indexOf(':') != -1) {
			var sp = value.split(':');
			first = sp[0];
			second = sp[1] == '00' ? 0 : 0.5;
		}
		var res = parseInt(first);
		if (isNaN(res) || res < 0 || res > 23) {
			return -1;
		}
		return res + second;

	};
	for (var i = 0; i < parts.length; i++) {
		var part = parts[i].trim();
		if (part.indexOf('-') == -1) {
			var num = verifyNum(part);
			if (num == -1 || num < 7.5 || num > 17) {
				return false;
			}
		} else {
			var split = part.split('-');
			var first = verifyNum(split[0].trim());
			var second = verifyNum(split[1].trim());
			if (first == -1 || second == -1)
				return false;
			if (first > second)
				return false;
			if (first < 7.5)
				return false;
			if (second > 17)
				return false;
		}
	}
	return true;
};

Ext.define('DCMS.wl.OfferPositionWindow', {
	extend : 'Ext.window.Window',
	xtype : 'offerposwindow',
	title : 'Offer a Position',
	width : 600,
	height : 400,
	collapsible : true,
	maximizable : true,
	modal : true,
	layout : 'border',
	items : [
			{
				region : 'north',
				layout : 'column',
				border : false,
				items : [ {
					columnWidth : 0.5,
					bodyPadding : 10,
					border : false,
					layout : 'anchor',
					defaultType : 'textfield',
					items : [ {
						fieldLabel : 'Class',
						itemId : 'class',
						xtype : 'combo',
						store : DCMS.wl.classStore,
						queryMode : 'local',
						displayField : 'name',
						valueField : 'value',
						editable : false,
						anchor : '95%'
					}, {
						fieldLabel : 'Start Date',
						itemId : 'startDate',
						xtype : 'datefield',
						editable : false,
						anchor : '95%'
					}, {
						fieldLabel : 'Accept Date',
						itemId : 'acceptDate',
						xtype : 'datefield',
						editable : false,
						anchor : '95%'
					}

					]
				}, {
					columnWidth : 0.5,
					bodyPadding : 10,
					border : false,
					layout : 'anchor',
					defaultType : 'textfield',
					items : [ {
						fieldLabel : 'Term',
						itemId : 'term',
						xtype : 'combo',
						store : DCMS.wl.termStore,
						queryMode : 'local',
						displayField : 'name',
						valueField : 'value',
						editable : false,
						anchor : '95%'
					}, {
						fieldLabel : 'Attending Day',
						itemId : 'attendingDay',
						xtype : 'combo',
						store : DCMS.wl.attendingModeStore,
						queryMode : 'local',
						displayField : 'name',
						valueField : 'value',
						editable : false,
						anchor : '95%'
					} ]
				} ]
			},
			{
				region : 'center',
				layout : {
					type : 'table',
					columns : 2,
					tableAttrs : {
						style : {
							width : '100%',
							paddingTop : '10px'
						}
					},
					tdAttrs : {
						style : {
							paddingLeft : '10px',
							paddingRight : '10px'
						}
					}
				},
				border : false,
				defaultType : 'textfield',
				flex : 1,
				items : [
						{
							xtype : 'panel',
							html : "",
							style : {
								paddingBottom : '10px'
							},
							width : '80px'
						},
						{
							xtype : 'panel',
							html : " Time (in 24 hr format,"
									+ " e.g: 14:00, 9:00-17:30 or 13-15, "
									+ "comma as separator)",
							style : {
								paddingBottom : '10px'
							}
						}, {
							xtype : 'panel',
							html : 'Monday'
						}, {
							itemId : 'mondayTime',
							width : '95%',
							validator : DCMS.wl.validateTimesheet
						}, {
							xtype : 'panel',
							html : 'Tuesday'
						}, {
							itemId : 'tuesdayTime',
							width : '95%',
							validator : DCMS.wl.validateTimesheet
						}, {
							xtype : 'panel',
							html : 'Wednesday'
						}, {
							itemId : 'wednesdayTime',
							width : '95%'
						}, {
							xtype : 'panel',
							html : 'Thursday'
						}, {
							itemId : 'thursdayTime',
							width : '95%',
							validator : DCMS.wl.validateTimesheet
						}, {
							xtype : 'panel',
							html : 'Friday'
						}, {
							itemId : 'fridayTime',
							width : '95%',
							validator : DCMS.wl.validateTimesheet
						} ]
			} ],
	initComponent : function() {
		var dc = Ext.create('DCMS.common.DataCollector');

		// dc.addMapping('itemId', 'dataAttribute');

		dc.addMapping('mondayTime', 'monTime');
		dc.addMapping('tuesdayTime', 'tueTime');
		dc.addMapping('wednesdayTime', 'wedTime');
		dc.addMapping('thursdayTime', 'thuTime');
		dc.addMapping('fridayTime', 'friTime');
		dc.addMapping('attendingDay', 'attendingMode');
		dc.addMapping('class', 'classroomName');
		dc.addMapping('startDate', 'contractFrom');
		dc.addMapping('term', 'term');
		dc.addMapping('acceptDate', 'acceptDate')

		this.dataCollector = dc;
		this.callParent();
	},
	dockedItems : [ {
		xtype : 'toolbar',
		dock : 'bottom',
		ui : 'footer',
		layout : {
			pack : 'center'
		},
		items : [ {
			minWidth : 80,
			text : 'Confirm',
			handler : function() {
				// Collect information from fields
				var window = this.up('offerposwindow');
				var data = window.dataCollector.collect(window);

				data.waitingListId = window.waitingListId;
				debugger;
				window.submitted = true;
				window.dataObject = data;
				window.close();
			}
		}, {
			minWidth : 80,
			text : 'Cancel',
			handler : function() {
				var window = this.up('offerposwindow');

				window.submitted = false;
				window.close();
			}
		} ]
	} ]
});