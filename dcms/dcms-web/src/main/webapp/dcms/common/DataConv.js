Ext.namespace('DCMS.common');
DCMS.common.DataConv = {
	convertAff : function(input, datakey) {
		for (var i = 0; i < input.length; i++) {
			var wlitem = input[i];
			var access = this.accessObject(wlitem, datakey);
			var target = access.target;
			var key = access.key;
			switch (target[key]+'') {
			case '0':
				target[key] = 'None';
				break;
			case '1':
				target[key] = 'Student';
				break;
			case '2':
				target[key] = 'Faculty';
				break;
			default:
				break;
			}
		}
	},
	accessObject : function(data, datakey) {
		if (datakey.indexOf('.') == -1) {
			return {
				'target' : data,
				'key' : datakey
			};
		}
		var splitkey = mapping.attrName.split('.');
		var target = data;
		for (var i = 0; i < splitkey.length - 1; i++) {
			target = target[splitkey[i]];
		}
		return {
			'target' : target,
			'key' : splitkey[splitkey.length - 1]
		};
	}
};