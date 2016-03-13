$(document).ready(function() {
	$.ajax({
		method: "POST",
		url: Authenticator.php,
		data: {test: "test"},
		success: function(data) {
			handleData(data);
		},
		datatype: text
	})
});

//reads from the inputs and then calls the ajax to the authenticator
function login() {
	
}
function handleData(input) {
	alert(input);
}