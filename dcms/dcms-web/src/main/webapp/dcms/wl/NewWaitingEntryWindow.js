Ext.define('DCMS.wl.NewWaitingEntryWindow', {
	extend : 'Ext.window.Window',
	xtype : 'newwlwindow',
	title : 'Add Waiting List Entry',
	height : 600,
	width : 800,
	layout : 'fit',
	collapsible : true,
	animCollapse : true,
	maximizable : true,
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
				this.up('newwlwindow').close();
			}
		}, {
			minWidth : 80,
			text : 'Cancel',
			handler : function() {
				this.up('newwlwindow').close();
			}
		} ]
	} ]
});