$(document).ready(function() {
    $("#show-register-button").on('click', function() {
        $("#login-form").addClass("hidden");
        $("#register-form").removeClass("hidden");
    });
    $("#show-login-button").on('click', function() {
    	 $("#register-form").addClass("hidden");
    	 $("#login-form").removeClass("hidden");	
    });
});