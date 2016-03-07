Ext.define("DCMS.MainViewPort", {
	extend : 'Ext.container.Viewport',
	id : 'mainvp',
	layout : 'card',
	activeItem : 0,
	items : [ {
		xtype : 'panel',
		bodyStyle : {
			background : 'ddd'
		},
		layout : 'border',
		items : [ {
			xtype : 'loginpanel',
			id : 'loginpanel'
		} ]
	}, {
		xtype : 'mainpanel',
		id : 'mainpanel'
	} ]
});