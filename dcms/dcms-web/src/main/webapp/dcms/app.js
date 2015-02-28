Ext.Loader.setConfig({
	enabled : true,
	paths : {
		'DCMS' : 'dcms'
	}
});
Ext.require([ 'Ext.data.TreeStore' ]);
Ext.require('Ext.ux.CheckColumn');
Ext.require([ 'Ext.chart.*', 'Ext.chart.axis.Gauge', 'Ext.chart.series.*',
		'Ext.Window' ]);
Ext.require([ 'Ext.grid.*', 'Ext.data.*', 'Ext.util.*', 'Ext.state.*' ]);

Ext.require([ 'DCMS.MainViewPort', 'DCMS.SummaryPanel' ]);

Ext.application({
	name : 'DCMS',
	launch : function() {
		Ext.create('DCMS.MainViewPort');
	}
});