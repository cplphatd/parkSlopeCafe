$(document).ready(function () {

    //Check if password is correct length
    $("#password").keyup(function() {
        var password = $("#password").val();

        if (password.length >= 8) {
            $("#passwordLength").addClass("hidden");
        } else {
            $("#passwordLength").removeClass("hidden");
        }
    });

    //Check if passwords match when entering confirmation password
    $("#passwordConfirm").keyup(function() {
        var password = $("#password").val();

        if (password === $(this).val()) {
            $("#passwordMatch").addClass("hidden");
        } else {
            $("#passwordMatch").removeClass("hidden");
        }

        if (password === $(this).val() && password.length >= 8) {
            $("#errorMessage").addClass("hidden");
            $("button").prop("disabled", false);
        } else {
            $("#errorMessage").removeClass("hidden");
            $("button").prop("disabled", true);
        }
    });

    //Check is passwords match when entering password
    $("#password").keyup(function() {
        var password = $("#password").val();

        if (password === $("#passwordConfirm").val()) {
            $("#passwordMatch").addClass("hidden");
        } else {
            $("#passwordMatch").removeClass("hidden");
        }

        if (password === $("#passwordConfirm").val() && password.length >= 8) {
            $("#errorMessage").addClass("hidden");
            $("button").prop("disabled", false);
        } else {
            $("#errorMessage").removeClass("hidden");
            $("button").prop("disabled", true);
        }
    });
});