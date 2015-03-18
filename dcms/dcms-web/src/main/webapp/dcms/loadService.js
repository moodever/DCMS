window.Utils = {};
Utils.loadjs = function(jsurl) {
	// var request = new XMLHttpRequest();
	// request.open("GET", jsurl, false);
	// request.send();
	// if (request.status == 200) {
	// eval(request.responseText);
	// } else {
	// console.log("Failed to load " + jsurl);
	// }

	// if (filetype == "js") { // if filename is a external JavaScript file
	var fileref = document.createElement('script');
	fileref.setAttribute("type", "text/javascript");
	fileref.setAttribute("src", jsurl);
	// } else if (filetype == "css") { // if filename is an external CSS file
	// var fileref = document.createElement("link")
	// fileref.setAttribute("rel", "stylesheet")
	// fileref.setAttribute("type", "text/css")
	// fileref.setAttribute("href", filename)
	// }
	// if (typeof fileref != "undefined")
	document.getElementsByTagName("head")[0].appendChild(fileref);

};

Utils.loadhtml = function(htmlurl) {
	var request = new XMLHttpRequest();
	request.open("GET", htmlurl, false);
	request.send();
	if (request.status == 200)
		return request.responseText;
	return '';
};

Utils.loadjs('/dcms-web/dwr/engine.js');
Utils.loadjs('/dcms-web/dwr/interface/WaitingListService.js');
Utils.loadjs('/dcms-web/dwr/interface/EnrollmentService.js');
// Utils.loadjs('dwr/interface/nodeService.js');
// Utils.loadjs('dwr/interface/vmService.js');
