Ext.define('DCMS.LoginPanel', {
	extend : 'Ext.window.Window',
	xtype : 'loginpanel',
	id : 'loginpanel',
	bodyPadding : 10,
	title : 'Login Window',
	closable : false,
	modal : true,
	resizable : false,
	draggable : false,
	autoShow : true,
	width : 300,
	height : 180,

	items : [ {
		xtype : 'form',
		id : 'loginform',
		reference : 'form',
		items : [ {
			xtype : 'textfield',
			name : 'username',
			fieldLabel : 'Username',
			allowBlank : false
		}, {
			xtype : 'textfield',
			name : 'password',
			inputType : 'password',
			fieldLabel : 'Password',
			allowBlank : false
		}, {
			xtype : 'displayfield',
			name : 'message',
			hideEmptyLabel : false,
			value : ''
		} ]
	} ],
	buttons : [ {
		text : 'Login',
		formBind : true,
		listeners : {
			click : function() {
				var form = Ext.getCmp('loginform').getForm();

				var username = form.findField('username').getValue();
				var passwd = form.findField('password').getValue();

				if (username == "admin" && passwd == "1234") {

					Ext.getCmp('mainvp').getLayout().setActiveItem(1);

				} else {

					form.findField('message').setValue("Incorrect password");
				}

			}
		}
	} ]
});