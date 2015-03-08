Ext.define('DCMS.wl.NewWaitingEntryWindow', {
	extend : 'Ext.window.Window',
	xtype : 'newwlwindow',
	title : 'Add Waiting List Entry',
	height : 400,
	width : 800,
	layout : 'border',
	collapsible : true,
	animCollapse : true,
	maximizable : true,
	modal : true,
	items : [ {
		xtype : 'tabpanel',
		region : 'north',
		items : [ {
			title : 'Basic Info',
			layout : 'column',
			border : false,
			items : [ {
				columnWidth : .33,
				bodyPadding : 10,
				border : false,
				layout : 'anchor',
				defaultType : 'textfield',
				items : [ {
					fieldLabel : 'First Name',
					itemId : 'firstName',
					anchor : '95%'
				}, {
					fieldLabel : 'Date of Birth',
					itemId : 'dob',
					xtype : 'datefield',
					editable : false,
					anchor : '95%'
				}, {
					fieldLabel : 'Affiliation',
					itemId : 'affiliation',
					xtype : 'combo',
					store : DCMS.wl.affiliationStore,
					queryMode : 'local',
					displayField : 'name',
					valueField : 'value',
					editable : false,
					anchor : '95%'

				} ]
			}, {
				columnWidth : .33,
				bodyPadding : 10,
				border : false,
				layout : 'anchor',
				defaultType : 'textfield',
				items : [ {
					fieldLabel : 'Middle Name',
					itemId : 'middleName',
					anchor : '95%'
				}, {
					fieldLabel : 'Application Date',
					itemId : 'appDate',
					xtype : 'datefield',
					editable : false,
					anchor : '95%'
				}, {
					fieldLabel : 'Attending Mode',
					itemId : 'attendingMode',
					xtype : 'combo',
					store : DCMS.wl.attendingModeStore,
					queryMode : 'local',
					displayField : 'name',
					valueField : 'value',
					editable : false,
					anchor : '95%'
				} ]
			}, {
				columnWidth : .34,
				bodyPadding : 10,
				border : false,
				layout : 'anchor',
				defaultType : 'textfield',
				items : [ {
					fieldLabel : 'Last Name',
					itemId : 'lastName',
					anchor : '95%'
				}, {
					fieldLabel : 'Desire Date',
					itemId : 'desireDate',
					xtype : 'datefield',
					editable : false,
					anchor : '95%'
				}, {
					fieldLabel : 'Expected Grade',
					xtype : 'combo',
					itemId : 'expectGrade',
					store : DCMS.wl.gradeStore,
					queryMode : 'local',
					displayField : 'name',
					valueField : 'value',
					editable : false,
					anchor : '95%'
				} ]
			} ]
		}, {
			title : 'Contact Info',
			layout : {
				type : 'table',
				columns : 3,
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
			items : [ {
				itemId : 'contactFirstName',
				fieldLabel : 'First Name',
				width : '95%'
			}, {
				itemId : 'contactLastName',
				fieldLabel : 'Last Name',
				width : '95%'
			}, {
				itemId : 'contactRelation',
				fieldLabel : 'Relationship',
				width : '95%'
			}, {
				itemId : 'contactEmail',
				fieldLabel : 'Email',
				vtype : 'email',
				width : '95%'
			}, {
				itemId : 'contactPhone',
				fieldLabel : 'Phone',
				width : '95%'
			}, {
				itemId : 'contactMobile',
				fieldLabel : 'Mobile',
				width : '95%'
			}, {
				itemId : 'contactAddress',
				fieldLabel : 'Address',
				colspan : 3,
				width : '100%',
				style : {
					paddingRight : '12px'
				}
			} ]
		} ]
	}, {
		bodyPadding : 10,
		region : 'center',
		layout : 'fit',
		items : [ {
			fieldLabel : 'Notes:',
			itemId : 'note',
			xtype : 'textareafield',
		} ]
	} ],
	initComponent : function() {
		var dc = Ext.create('DCMS.common.DataCollector');

		dc.addMapping('firstName', 'childFirstName');
		dc.addMapping('middleName', 'childMiddleName');
		dc.addMapping('lastName', 'childLastName');
		dc.addMapping('dob', 'childDateBirth');
		dc.addMapping('appDate', 'applicationDate');
		dc.addMapping('desireDate', 'desireDate');
		dc.addMapping('expectGrade', 'expectGrade');
		dc.addMapping('affiliation', 'affiliation');
		dc.addMapping('attendingMode', 'attendingMode');
		dc.addMapping('contactFirstName', 'contact.firstName');
		dc.addMapping('contactLastName', 'contact.lastName');
		dc.addMapping('contactRelation', 'contact.role');
		dc.addMapping('contactEmail', 'contact.email');
		dc.addMapping('contactPhone', 'contact.phone');
		dc.addMapping('contactMobile', 'contact.phone2');
		dc.addMapping('contactAddress', 'contact.address');

		dc.addMapping('note', 'childNote');

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
				var window = this.up('newwlwindow');
				var data = window.dataCollector.collect(window);
				data.status = 0; // Active
				data.contacts = new Array();
				data.contacts.push(data.contact);
				data.contact = undefined;

				WaitingListService.saveWaitingEntry(data, {
					callback : function() {
						window.submitted = true;
						window.close();
					}
				});

			}
		}, {
			minWidth : 80,
			text : 'Cancel',
			handler : function() {
				this.up('newwlwindow').submitted = false;
				this.up('newwlwindow').close();
			}
		} ]
	} ],
	listeners : {
		afterrender : function() {
			this.down('#desireDate').setValue(new Date());
			this.down('#appDate').setValue(new Date());
			this.down('#affiliation').setValue(0);
			this.down('#attendingMode').setValue(0);
			this.down('#expectGrade').setValue(0);
		}
	}
});