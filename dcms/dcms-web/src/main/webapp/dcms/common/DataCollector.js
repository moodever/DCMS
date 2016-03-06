Ext.define('DCMS.common.DataCollector', {
	addMapping : function(itemId, attrName) {
		if (this.mappings == undefined) {
			this.mappings = new Array();
		}
		this.mappings.push({
			'itemId' : itemId,
			'attrName' : attrName
		})
	},
	collect : function(target) {
		var object = {};
		for (var i = 0; i < this.mappings.length; i++) {
			var mapping = this.mappings[i];

			var splitkey = mapping.attrName.split('.');
			var datatarget = object;
			for (var si = 0; si < splitkey.length - 1; si++) {
				if (object[splitkey[si]] === undefined) {
					object[splitkey[si]] = {};
				}
				datatarget = object[splitkey[si]];
			}
			var item = target.down('#' + mapping.itemId);
			if (item != null) {
				datatarget[splitkey[splitkey.length - 1]] = item.value;
			} else {
				alert("From DataCollector:" + mapping.itemId + " cannot find");
			}
		}
		return object;
	}
});