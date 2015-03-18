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
		idProperty : 'id'
	} ]
});

Ext.define('DCMS.wl.WaitingListGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'wlgrid',
	collapsible : false,
	multiSelect : false,
	columns : [ {
		text : 'Name',
		width : 200,
		sortable : true,
		dataIndex : 'name'
	}, {
		text : 'Date of Birth',
		width : 150,
		sortable : true,
		dataIndex : 'dateOfBirth',
		xtype : 'datecolumn',
		format : 'm/d/Y'
	}, {
		text : 'Affiliation',
		width : 150,
		sortable : false,
		dataIndex : 'affiliation'
	}, {
		text : 'Status',
		width : 150,
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
			}, {
				itemId : 'confirmButton',
				text : 'Contract Confirm',
				hidden : true
			}, {
				itemId : 'contractFailButton',
				text : 'Contract Fail',
				hidden : true
			}, {
				itemId : 'removeButton',
				text : 'Remove',
				hidden : true
			}, {
				itemId : 'keepOnListButton',
				text : 'Keep On List',
				hidden : true
			}, {
				itemId : 'acceptButton',
				text : 'Accept Offer',
				hidden : true
			}, {
				itemId : 'noResponseButton',
				text : 'Accept Offer',
				hidden : true
			}, {
				itemId : 'deClineButton',
				text : 'Decline Offer',
				hidden : true
			}, {
				itemId : 'returnToListButton',
				text : 'return to list',
				hidden : true
			}, {
				itemId : 'enrollButton',
				text : 'Enroll',
				hidden : true
			} ],
	viewConfig : {
		stripeRows : true,
		enableTextSelection : true
	},
	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.wl.WaitingListModel'
		});
		this.selModel = Ext.create('Ext.selection.CheckboxModel');
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
		if (selected) {
			var selectedItems = this.getSelectionModel().getSelection();
			var data = selectedItems[0].getData();
			if (data.status == 'NEW') {
				this.down('#removeButton').setHidden(!selected);
				this.down('#offerButton').setHidden(!selected);
				this.down('#keepOnListButton').setHidden(!selected);

			} else if (data.status == 'OFFERED') {
				this.down('#acceptButton').setHidden(!selected);
				this.down('#noResponseButton').setHidden(selected);
				this.down('#deClineButton').setHidden(selected);

			}
			// ACTIVE, OFFERED, CONFIRMED, INVALID, RETURNED, REMOVED
			else if (data.status == 'CONTRACT_CONFIRMED') {
				this.down('#enrollButton').setHidden(!selected);
				this.down('#removeButton').setHidden(!selected);
				this.down('#returnToListButton').setHidden(!selected);
			} else if (data.status == 'DECLINED') {

				this.down('#removeButton').setHidden(!selected);
				this.down('#returnToListButton').setHidden(!selected);
			} else if (data.status == 'ACCEPTED') {

				this.down('#confirmButton').setHidden(!selected);
				this.down('#contractFailButton').setHidden(!selected);
			}
		}
	},
	refresh : function() {
		var grid = this;
		WaitingListService.findWaitingList({}, {
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