Ext.define('DCMS.setting.SysSettingModel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'name'
	}, {
		name : 'grade',
		type : 'int'
	}, {
		name : 'term'

	}, {
		name : 'student_num',
		type : 'int'
	}, {
		name : 'capacity',
		type : 'int'
	}, {
		name : 'age_from',
		type : 'int'

	}, {
		name : 'age_to',
		type : 'int'
	} ],
	idProperty : 'name'
});

Ext.define('DCMS.setting.SysSettingGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'syssettinggrid',
	collapsible : false,
	multiSelect : false,
	anchor : '100%',
	columns : [ {
		text : 'name',
		width : 150,
		sortable : false,
		dataIndex : 'name'
	}, {
		text : 'grade',
		width : 80,
		sortable : true,
		dataIndex : 'grade'
	}, {
		text : 'term',
		width : 100,
		sortable : true,
		dataIndex : 'term'
	}, {
		text : 'student_num',
		width : 100,
		sortable : true,
		dataIndex : 'student_num',
	}, {
		text : 'capacity',
		width : 100,
		sortable : false,
		dataIndex : 'capacity'
	}, {
		text : 'age_from',
		width : 100,
		sortable : false,
		dataIndex : 'age_from'
	}, {
		text : 'age_to',
		width : 100,
		sortable : false,
		dataIndex : 'age_to'
	} ],

	initComponent : function() {
		this.store = Ext.create('Ext.data.ArrayStore', {
			model : 'DCMS.setting.SysSettingModel'
		});
		this.selModel = Ext.create('Ext.selection.RowModel');
		this.callParent();
	}
});
