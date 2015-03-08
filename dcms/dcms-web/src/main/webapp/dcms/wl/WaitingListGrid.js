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
		width : 120,
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
		flex : 1,
		sortable : false,
		dataIndex : 'status'
	} ],
	tbar : [ {
		itemId : 'refreshButton',
		text : 'Refresh',
		handler : function() {
			this.up('wlgrid').refresh();
		}
	}, {
		itemId : 'addButton',
		text : 'Add Child',
		handler : function() {
			var win = Ext.create('DCMS.wl.NewWaitingEntryWindow');
			win.on('close', function(win) {
				debugger;
				if (win.submitted)
					this.up('wlgrid').refresh();
			}, win);

			win.show();
		}
	}, {
		itemId : 'offerButton',
		text : 'Offer a Position',
		disabled : true
	}, {
		itemId : 'confirmButton',
		text : 'Confirm',
		disabled : true
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
			var selected = this.getSelectionModel().hasSelection();
			this.down('#confirmButton').setDisabled(!selected);
			this.down('#offerButton').setDisabled(!selected);
		},
		deselect : function(view, records, index, eopts) {
			debugger;

			var selected = this.getSelectionModel().hasSelection();
			this.down('#confirmButton').setDisabled(!selected);
			this.down('#offerButton').setDisabled(!selected);
		},
		afterrender : function() {
			this.refresh();
		}
	},
	refresh : function() {
		var grid = this;
		WaitingListService.findWaitingList({}, {
			callback : function(result) {
				if (result.success) {
					var wl = result.waitingLists;
					grid.store.setData(wl);
				}
			},
			errorHandler : function(errorString, exception) {
				console.log(errorString);
				console.log(exception);
			}
		})
	}
});