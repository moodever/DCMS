Ext.define('DCMS.SummaryPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'summaryPanel',
	title : 'Summary',
	autoScroll : true,
	layout : {
		type : 'table',
		columns : 2,
		tdAttrs : {
			valign : 'top',
			style : {
				padding : '10 10 10 10'
			}
		}
	},
	items : [ {
		xtype : 'panel',
		width : '100%',
		height : 45,
		bodyCls : 'banner',
		html : 'Child Care Manage System',
		colspan : 2
	}, {
		xtype : 'panel',
		title : 'Overview',
		collapsible : true,
		width : 650,
		height : 300,
		items : [ {
			xtype : 'image',
			style : 'float:left;',
			src : 'image/data_center.jpg',
			width : 100,
			height : 100,
			margin : 10
		}, {
			xtype : 'container',
			id : 'summaryContent',
			style : 'float:left;',
			margin : 10,
			width : 350,
			height : 120,
			baseHtml : 'gdc/summary/summary.html'
		}, {
			xtype : 'container',
			style : 'float:left',
			width : 60,
			height : 120
		} ]
	}, {
		xtype : 'panel',
		rowspan : 3,
		width : 250,
		height : 640,
		collapsible : true,
		bodyStyle : 'padding:10px;',
		title : 'Introduction',
		autoLoad : 'gdc/summary/summary_intro.html'
	} ]
});