/**
 * 
 */
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
	items : [ {
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
	}, {
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
		items : [ {
			xtype : 'panel',
			html : "",
			style : {
				paddingBottom : '10px'
			},
			width : '80px'
		}, {
			xtype : 'panel',
			html : " Time",
			style : {
				paddingBottom : '10px'
			}
		}, {
			xtype : 'panel',
			html : 'Monday'
		}, {
			itemId : 'mondayTime',
			width : '95%'
		}, {
			xtype : 'panel',
			html : 'Tuesday'
		}, {
			itemId : 'tuesdayTime',
			width : '95%'
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
			width : '95%'
		}, {
			xtype : 'panel',
			html : 'Friday'
		}, {
			itemId : 'fridayTime',
			width : '95%'
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