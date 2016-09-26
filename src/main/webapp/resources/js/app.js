$(function() {
	$("#language").change(
			function() {
				window.location = "locale?lang=" + this.value;
			});
	var lang = getCookie("lang");
	if (lang != "") {
		$("#language").val(lang);
		$("#language").
		parent().
		next("span.selected").
		text( $("#language option:selected").text());
		console.log(lang);
	}
	$("#currency").change(
			function() {
				window.location = "currency?currency=" + this.value;
			});
	var currency = getCookie("currency");
	if (currency != "") {
		$("#currency").val(currency);
		$("#currency").
		parent().
		next("span.selected").
		text( $("#currency option:selected").text());
		console.log(currency);
	}
});
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}