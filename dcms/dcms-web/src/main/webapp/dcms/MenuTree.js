Ext.namespace("DCMS.menuTree");
DCMS.menuTree.menuStore = Ext.create('Ext.data.TreeStore');
DCMS.menuTree.initStore = function() {
	var menuRoot = {};
	menuRoot.expanded = true;
	menuRoot.children = new Array();

	// Waiting List
	var menuWaitingList = {
		text : "Waiting List",
		id : 100,
		leaf : false,
		children : new Array()
	};
	menuRoot.children.push(menuWaitingList);

	var menuViewWaitingList = {
		text : "Manage Waiting List",
		id : 101,
		leaf : true
	};
	menuWaitingList.children.push(menuViewWaitingList);

	// Enrollment
	var menuEnrollment = {
		text : "Enrollment",
		id : 200,
		leaf : false,
		children : new Array()
	};
	menuRoot.children.push(menuEnrollment);

	var menuViewEnrollment = {
		text : "Manage Enrollment",
		id : 201,
		leaf : true
	};
	menuEnrollment.children.push(menuViewEnrollment);

	var menuViewEnrollChart = {
		text : "Enrollment Chart",
		id : 202,
		leaf : true
	};
	menuEnrollment.children.push(menuViewEnrollChart);

	var menuViewProjectionChart = {
		text : "Projection Chart",
		id : 203,
		leaf : true
	};
	menuEnrollment.children.push(menuViewProjectionChart);

	var menuTimesheet = {
		text : "Timesheet",
		id : 204,
		leaf : true
	};
	menuEnrollment.children.push(menuTimesheet);

	var menuSystemSetting = {
		text : "System Setting",
		id : 300,
		leaf : false,
		children : new Array()
	};
	menuRoot.children.push(menuSystemSetting);

	var menuViewSysSetting = {
		text : "Manage Setting",
		id : 301,
		leaf : true
	};
	menuSystemSetting.children.push(menuViewSysSetting);

	DCMS.menuTree.menuStore.setRootNode(menuRoot);
};

DCMS.menuTree.initStore();

DCMS.menuTree.displayNode = function(id) {
	var newid = "tab" + id;
	var mainTabPanel = Ext.getCmp('maintab');
	var existed = Ext.getCmp(newid);
	if (existed != null && existed.items.length == 0) {
		existed.destroy();
		existed = undefined;
	}
	if (undefined === existed || null == existed) {
		switch (id) {
		case 101: // Manage Waiting List
			existed = Ext.create('DCMS.wl.WaitingListPanel');
			break;
		case 201:
			existed = Ext.create('DCMS.enroll.ManageEnrollmentPanel');
			break;
		case 202:
			existed = Ext.create('DCMS.enroll.EnrollmentChartPanel');
			break;
		case 203:
			existed = Ext.create('DCMS.enroll.ProjectionChartPanel');
			break;
		case 204:
			existed = Ext.create('DCMS.enroll.TimesheetPanel');
			break;
		case 301:
			existed = Ext.create('DCMS.setting.SysSettingPanel');
			break;

		default:
			alert('Unrecognized function id:' + id);
			break;
		}
		existed.id = newid;
		Ext.ComponentManager.register(existed);
		mainTabPanel.add(existed);
	}

	// Set it as the active one
	// disable the listener
	var tabchangelistener = mainTabPanel.events.tabchange;
	mainTabPanel.events.tabchange = true;
	mainTabPanel.setActiveTab(newid);
	mainTabPanel.events.tabchange = tabchangelistener;
};

Ext.define("DCMS.MenuTree", {
	extend : 'Ext.tree.Panel',
	collapsible : true,
	title : 'Operations',
	xtype : 'menutree',
	id : 'menutree',
	store : DCMS.menuTree.menuStore,
	rootVisible : false,
	collapsed : false,
	width : 200,
	listeners : {
		select : function(tree, record, row, opt) {
			if (record.raw.leaf) {
				DCMS.menuTree.displayNode(record.raw.id);
			}
		},
		afterrender : function(eopts) {
			this.expandAll();
		}
	}
});
