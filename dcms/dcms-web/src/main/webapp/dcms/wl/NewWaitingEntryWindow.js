Ext.define('DCMS.wl.NewWaitingEntryWindow', {
	extend : 'Ext.window.Window',
	xtype : 'newwlwindow',
	title : 'Add Waiting List Entry',
	height : 450,
	width : 800,
	layout : 'fit',
	collapsible : true,
	animCollapse : true,
	maximizable : true,
	modal : true,
	items : [ {
		xtype : 'tabpanel',
		items : [ {
			title : 'Basic Info',
			layout : 'border',
			border : false,
			items : [ {
				bodyPadding : 10,
				region : 'center',
				layout : 'anchor',
				items : [ {
					fieldLabel : 'Notes for Application:',
					itemId : 'note',
					xtype : 'textareafield',
					anchor : '65%'
				}, {
					fieldLabel : 'Notes for Child:',
					itemId : 'childNote',
					xtype : 'textareafield',
					anchor : '65%'
				} ]
			}, {
				layout : 'column',
				region : 'north',
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

					}, {
						fieldLabel : 'Primary Phone',
						itemId : 'phone',
						xtype : 'textfield',
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
						fieldLabel : 'Expected Class',
						xtype : 'combo',
						itemId : 'expectGrade',
						store : DCMS.wl.classStore,
						queryMode : 'local',
						displayField : 'name',
						valueField : 'value',
						value : 'Infant',
						editable : false,
						anchor : '95%'
					} ]
				} ]
			} ]
		}, {
			title : 'Contact Info',
			layout : 'vbox',
			border : false,
			bodyPadding : 10,
			items : [ {
				xtype : 'fieldset',
				title : 'Contact 1',
				width : '100%',
				flex : 1,
				defaultType : 'textfield',
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
					fieldLabel : 'Aff. Status',
					itemId : 'contactAffStatus',
					xtype : 'combo',
					store : DCMS.wl.affiliationStore,
					queryMode : 'local',
					displayField : 'name',
					valueField : 'value',
					editable : false,
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
			}, {
				xtype : 'fieldset',
				title : 'Contact 2',
				width : '100%',
				flex : 1,
				defaultType : 'textfield',
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
				items : [ {
					itemId : 'contactFirstName2',
					fieldLabel : 'First Name',
					width : '95%'
				}, {
					itemId : 'contactLastName2',
					fieldLabel : 'Last Name',
					width : '95%'
				}, {
					itemId : 'contactRelation2',
					fieldLabel : 'Relationship',
					width : '95%'
				}, {
					itemId : 'contactEmail2',
					fieldLabel : 'Email',
					vtype : 'email',
					width : '95%'
				}, {
					itemId : 'contactPhone2',
					fieldLabel : 'Phone',
					width : '95%'
				}, {
					itemId : 'contactMobile2',
					fieldLabel : 'Mobile',
					width : '95%'
				}, {
					fieldLabel : 'Aff. Status',
					itemId : 'contactAffStatus2',
					xtype : 'combo',
					store : DCMS.wl.affiliationStore,
					queryMode : 'local',
					displayField : 'name',
					valueField : 'value',
					editable : false,
					width : '95%'
				}, {
					itemId : 'contactAddress2',
					fieldLabel : 'Address',
					colspan : 3,
					width : '100%',
					style : {
						paddingRight : '12px'
					}
				} ]
			} ]
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
		dc.addMapping('note', 'note');
		dc.addMapping('childNote', 'childNote');
		dc.addMapping('phone','phone')

		dc.addMapping('contactFirstName', 'contact.firstName');
		dc.addMapping('contactLastName', 'contact.lastName');
		dc.addMapping('contactRelation', 'contact.role');
		dc.addMapping('contactEmail', 'contact.email');
		dc.addMapping('contactPhone', 'contact.phone1');
		dc.addMapping('contactMobile', 'contact.phone2');
		dc.addMapping('contactAddress', 'contact.address');
		dc.addMapping('contactAffStatus', 'contact.status');

		dc.addMapping('contactFirstName2', 'contact2.firstName');
		dc.addMapping('contactLastName2', 'contact2.lastName');
		dc.addMapping('contactRelation2', 'contact2.role');
		dc.addMapping('contactEmail2', 'contact2.email');
		dc.addMapping('contactPhone2', 'contact2.phone1');
		dc.addMapping('contactMobile2', 'contact2.phone2');
		dc.addMapping('contactAddress2', 'contact2.address');
		dc.addMapping('contactAffStatus2', 'contact2.status');

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
				data.status = 0; // New
				data.displayStatus = 0;// New
				data.contacts = new Array();
				data.contacts.push(data.contact);
				data.contacts.push(data.contact2);
				data.contact = undefined;
				data.contact2 = undefined;

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
		}
	}
});