Ext.define('DCMS.enroll.WaitingListModel', {
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
	} ],
	idProperty : 'id'
});

Ext.define('DCMS.enroll.ManageEnrollmentGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'manageenrollmentgrid',
	collapsible : false,
	multiSelect : false,
	columns : [ {
		text : 'Name',
		width : 150,
		sortable : true,
		dataIndex : 'name'
	}, {
		text : 'Date of Birth',
		width : 130,
		sortable : true,
		dataIndex : 'dateOfBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Affiliation',
		width : 100,
		sortable : false,
		dataIndex : 'affiliation'
	}, {
		text : 'Status',
		width : 180,
		sortable : false,
		dataIndex : 'status'
	}, {
		text : 'Notes',
		flex : 1,
		sortable : false
	} ],
	tbar : [
			{
				itemId : 'refreshButton',
				text : 'Refresh',
				handler : function() {
					this.up('manageenrollmentgrid').refresh();
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');
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
					var grid = this.up('manageenrollmentgrid');

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
		WaitingListService.findEnrollmentList({}, {
			callback : function(result) {
				if (result.success) {
					var wl = result.waitingLists;
					for (var i = 0; i < wl.length; i++) {
						var wlitem = wl[i];
						switch (wlitem.affiliation) {
						case 0:
							wlitem.affiliation = 'None';
							break;
						case 1:
							wlitem.affiliation = 'Student';
							break;
						case 2:
							wlitem.affiliation = 'Faculty';
							break;
						default:
							break;
						}
					}

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