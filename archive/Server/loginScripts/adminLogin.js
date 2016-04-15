$(document).ready(function() {
	$("login-button").on('click', login);
		/* $.ajax({
			method: "POST",
			url: "authentication/authenticator.php",
			data: {test: "test"},
			success: function(data) {
				handleLoginResult(data);
			},
			datatype: text 
		}); */
	});
	$("register-button").on('click', register);
});

function login() {

}

function register() {

}

function handleLoginResult(data) {
	if (data == true) {
		$("#alert").text("Login Successful.");
	} else {
		$("#alert").text(data);
	}
}

function handleRegisterResult(data) {

}