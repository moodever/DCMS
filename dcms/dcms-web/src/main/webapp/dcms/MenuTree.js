Ext.namespace("DCMS");
DCMS.menuStore = Ext.create('Ext.data.TreeStore');
DCMS.menuItems = new Array();

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

DCMS.menuStore.setRootNode(menuRoot);

function displayNode(id) {
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
}

Ext.define("DCMS.MenuTree", {
	extend : 'Ext.tree.Panel',
	collapsible : true,
	title : 'Operations',
	xtype : 'menutree',
	store : DCMS.menuStore,
	rootVisible : false,
	width : 200,
	listeners : {
		select : function(tree, record, row, opt) {
			if (record.raw.leaf) {
				displayNode(record.raw.id);
			}
		}
	}
});
