
/*
 * 获取xmlHttpRequest对象
 */
function getXMLHttpRequest() {
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = newXMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = newActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
