Ext.define('DCMS.wl.NewWaitingEntryWindow',
		{
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
					layout : 'column',
					border : false,
					items : [ {
						columnWidth : 0.5,
						bodyPadding : 10,
						border : false,
						layout : 'anchor',
						defaultType : 'textfield',
						items : [ {
							itemId : 'contactName',
							fieldLabel : 'Contact Name',
							anchor : '90%'
						}, {
							itemId : 'contactEmail',
							fieldLabel : 'Email',
							anchor : '90%'
						} ]
					}, {
						columnWidth : 0.5,
						bodyPadding : 10,
						border : false,
						layout : 'anchor',
						defaultType : 'textfield',
						items : [ {
							itemId : 'contactRelation',
							fieldLabel : 'Relationship',
							anchor : '90%'
						}, {
							itemId : 'contactPhone',
							fieldLabel : 'Phone',
							anchor : '90%'
						} ]
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
			dockedItems : [ {
				xtype : 'toolbar',
				dock : 'bottom',
				ui : 'footer',
				layout : {
					pack : 'center'
				},
				items : [
						{
							minWidth : 80,
							text : 'Confirm',
							handler : function() {
								// Collect information from fields

								var data = {};

								data.childFirstName = this.up('newwlwindow')
										.down('#firstName').value;
								data.childMiddleName = this.up('newwlwindow')
										.down('#middleName').value;
								data.childLastName = this.up('newwlwindow')
										.down('#lastName').value;
								data.childDateBirth = this.up('newwlwindow')
										.down('#dob').value;
								data.applicationDate = this.up('newwlwindow')
										.down('#appDate').value;
								data.desireDate = this.up('newwlwindow').down(
										'#desireDate').value;
								data.expectGrade = this.up('newwlwindow').down(
										'#expectGrade').value;
								data.affiliation = this.up('newwlwindow').down(
										'#affiliation').value;
								data.attendingMode = this.up('newwlwindow')
										.down('#attendingMode').value;
								data.childNote = this.up('newwlwindow').down(
										'#note').value;
								debugger;

								WaitingListService.saveWaitingEntry(data, {
									callback : function() {
										this.up('newwlwindow').submitted = false;
										this.up('newwlwindow').close();
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
			} ]
		});