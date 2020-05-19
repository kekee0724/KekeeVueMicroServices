/* Create a new XMLHttpRequest object to talk to the Web server */
var xmlHttp = false;
/*@cc_on @*/
/*@if (@_jscript_version >= 5)
try {
  	xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
  	try {
    		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  	} catch (e2) {
    		xmlHttp = false;
  	}
}
@end @*/

if (!xmlHttp && typeof XMLHttpRequest != "undefined") {
  xmlHttp = new XMLHttpRequest();
}
