Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'DCMS' : 'dcms'
	}
});

Ext.require([ 'DCMS.MainViewPort', 'DCMS.SummaryPanel', 'DCMS.MenuTree' ]);
Ext.require([ 'DCMS.wl.WaitingListPanel', 'DCMS.wl.WaitingListGrid',
		'DCMS.wl.NewWaitingEntryWindow' ]);

Ext.application({
	name : 'Child Care Management System',
	launch : function() {
		Ext.create('DCMS.MainViewPort');
	}
});