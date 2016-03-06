Ext.define('DCMS.wl.WaitingListModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'id'
	}, {
		name : 'name'
	}, {
		name : 'dateOfBirth',
		type : 'date'
	}, {
		name : 'affiliation'
	}, {
		name : 'status'
	}, {
		name : 'displayStatus'
	}, {
		name : 'phone'
	}, {
		name : 'applicationDate',
		type : 'date'
	}, {
		name : 'desireDate',
		type : 'date'
	}, {
		name : 'expectGrade'
	}, {
		name : 'attendingMode'
	}, {
		name : 'firstParentName'
	}, {
		name : 'firstParentRole'
	}, {
		name : 'firstParentStatus'
	}, {
		name : 'secondParentName'
	}, {
		name : 'secondParentRole'
	}, {
		name : 'secondParentStatus'
	}, {
		name : 'note'
	} ],
	idProperty : 'id'
});

Ext.define('DCMS.wl.WaitingListGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'wlgrid',
	collapsible : false,
	multiSelect : false,
	columns : [ {
		text : 'Name',
		width : 125,
		sortable : true,
		dataIndex : 'name'
	}, {
		text : 'Date of Birth',
		width : 100,
		sortable : true,
		dataIndex : 'dateOfBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Phone',
		width : 120,
		sortable : false,
		dataIndex : 'phone'
	}, {
		text : 'Affiliation',
		width : 90,
		sortable : false,
		dataIndex : 'affiliation'
	}, {
		text : 'Status',
		width : 150,
		sortable : false,
		dataIndex : 'displayStatus'
	}, {
		text : 'Date of App.',
		width : 100,
		sortable : true,
		dataIndex : 'applicationDate',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Desired Enrollment Day',
		width : 100,
		sortable : true,
		dataIndex : 'desireDate',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Grade',
		width : 100,
		sortable : false,
		dataIndex : 'expectGrade'
	}, {
		text : 'Attending Days',
		width : 120,
		sortable : false,
		dataIndex : 'attendingMode'
	}, {
		text : 'Parent Name1',
		width : 130,
		sortable : false,
		dataIndex : 'firstParentName'
	}, {
		text : 'Relationship 1',
		width : 105,
		sortable : false,
		dataIndex : 'firstParentRole'
	}, {
		text : 'Aff. Status 1',
		width : 100,
		sortable : false,
		dataIndex : 'firstParentStatus'
	}, {
		text : 'Parent Name2',
		width : 130,
		sortable : false,
		dataIndex : 'secondParentName'
	}, {
		text : 'Relationship 2',
		width : 105,
		sortable : false,
		dataIndex : 'secondParentRole'
	}, {
		text : 'Aff. Status 2',
		width : 100,
		sortable : false,
		dataIndex : 'secondParentStatus'
	}, {
		text : 'Notes',
		width : 150,
		sortable : false,
		dataIndex : 'note'
	} ],
	tbar : [
			{
				itemId : 'refreshButton',
				text : 'Refresh',
				handler : function() {
					this.up('wlgrid').refresh();
				}
			},
			{
				itemId : 'addButton',
				text : 'Add Child',
				handler : function() {
					var win = Ext.create('DCMS.wl.NewWaitingEntryWindow');
					var grid = this.up('wlgrid');
					win.on('close', function(win) {
						debugger;
						if (win.submitted)
							grid.refresh();
					}, win);

					win.show();
				}
			},
			{
				itemId : 'offerButton',
				text : 'Offer a Position',
				hidden : true,
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						if (firstSelect.status == 'OFFERED') {
							Ext.MessageBox.alert('Info', "This child has been "
									+ "offered a position. "
									+ "The new information "
									+ "will replace the" + " existing one.");
						}
						var win = Ext.create('DCMS.wl.OfferPositionWindow');
						win.waitingListId = firstSelect.id;
						var grid = this.up('wlgrid');
						win.on('close', function(win) {
							if (win.submitted) {
								var dto = win.dataObject;

								EnrollmentService.prepareEnrollment(dto, {
									callback : function(result) {
										if (!result.success) {
											Ext.MessageBox.alert('Error',
													result.errorMessage);
										} else {
											Ext.MessageBox.alert('Info',
													"Operation succeed");
											grid.refresh();
											grid.getSelectionModel()
													.deselectAll();
										}
									},
									errorHandler : function(error, errorMsg) {

									}
								});
							}
						}, win);

						win.show();
					}
				}
			},
			{
				itemId : 'confirmButton',
				text : 'Confirm Contract',
				hidden : true,
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.enrollmentContracted(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'contractFailButton',
				text : 'Contract Fail',
				hidden : true,

				// enrollmentContractFail
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.enrollmentContractFail(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'removeButton',
				text : 'Remove',
				hidden : true,
				// removeWaitingEntry
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.removeWaitingEntry(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'keepOnListButton',
				text : 'Keep On List',
				hidden : true
			},
			{
				itemId : 'acceptButton',
				text : 'Accept Offer',
				hidden : true,
				// enrollmentOfferAccepted
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.enrollmentOfferAccepted(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'noResponseButton',
				text : 'No Response',
				hidden : true
			},
			{
				itemId : 'deClineButton',
				text : 'Decline Offer',
				hidden : true,
				// enrollmentOfferRefused

				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.enrollmentOfferRefused(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'returnToListButton',
				text : 'Return to list',
				hidden : true,
				handler : function() {
					var grid = this.up('wlgrid');
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.returnToList(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			},
			{
				itemId : 'enrollButton',
				text : 'Enroll',
				hidden : true,
				handler : function() {
					var grid = this.up('wlgrid');

					// setEnrollStatus
					if (grid.getSelectionModel().hasSelection()) {
						var selectedItems = grid.getSelectionModel()
								.getSelection();
						var firstSelect = selectedItems[0];
						var dto = {
							"waitingListId" : firstSelect.id
						};
						EnrollmentService.setEnrollStatus(dto, {
							callback : function(result) {
								if (!result.success) {
									Ext.MessageBox.alert('Error',
											result.errorMessage);
								} else {
									Ext.MessageBox.alert('Info',
											"Operation succeed");
									grid.refresh();
								}
							},
							errorHandler : function(error, errorMsg) {

							}
						});

					}
				}

			} ],

	viewConfig : {
		stripeRows : true,
		enableTextSelection : true
	},
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.wl.WaitingListModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	},
	listeners : {
		select : function(view, records, index, eopts) {
			debugger;
			this.refreshButton();
		},
		deselect : function(view, records, index, eopts) {
			this.refreshButton();
		},
		afterrender : function() {
			this.refresh();
		}
	},
	refreshButton : function() {
		debugger;
		var selected = this.getSelectionModel().hasSelection();

		this.down('#removeButton').setHidden(selected);
		this.down('#offerButton').setHidden(selected);
		this.down('#keepOnListButton').setHidden(selected);
		this.down('#acceptButton').setHidden(selected);
		this.down('#noResponseButton').setHidden(selected);
		this.down('#deClineButton').setHidden(selected);
		this.down('#confirmButton').setHidden(selected);
		this.down('#contractFailButton').setHidden(selected);
		this.down('#enrollButton').setHidden(selected);
		this.down('#returnToListButton').setHidden(selected);

		if (selected) {
			var selectedItems = this.getSelectionModel().getSelection();
			var data = selectedItems[0].getData();
			if (data.status == 'NEW') {
				this.down('#removeButton').setHidden(!selected);
				this.down('#offerButton').setHidden(!selected);
				this.down('#keepOnListButton').setHidden(!selected);

			} else if (data.status == 'OFFERED') {
				this.down('#acceptButton').setHidden(!selected);
				this.down('#noResponseButton').setHidden(!selected);
				this.down('#deClineButton').setHidden(!selected);
				this.down('#confirmButton').setHidden(!selected);
				this.down('#contractFailButton').setHidden(!selected);

			} else if (data.status == 'DECLINED') {
				this.down('#removeButton').setHidden(!selected);
				this.down('#returnToListButton').setHidden(!selected);

			} else if (data.status == 'ACCEPTED') {
				this.down('#contractFailButton').setHidden(!selected);
				this.down('#confirmButton').setHidden(!selected);

			}

			// ACTIVE, OFFERED, CONFIRMED, INVALID, RETURNED,
			// REMOVED
			else if (data.status == 'CONTRACT_CONFIRMED') {
				this.down('#enrollButton').setHidden(!selected);
				this.down('#removeButton').setHidden(!selected);

			}
		}
	},
	refresh : function() {
		var grid = this;
		WaitingListService.findWaitingList({}, {
			callback : function(result) {
				if (result.success) {
					var wl = result.waitingLists;
					debugger;
					DCMS.common.DataConv.convertAff(wl, 'affiliation');
					DCMS.common.DataConv.convertAff(wl, 'firstParentStatus');
					DCMS.common.DataConv.convertAff(wl, 'secondParentStatus');
					grid.store.setData(wl);
				}
			},
			errorHandler : function(errorString, exception) {
				console.log(errorString);
				console.log(exception);
			}
		});
	}
});