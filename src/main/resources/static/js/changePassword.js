$(document).ready(function () {
    $("#passwordConfirm").keyup(function() {
        var password = $("#password").val();

        if (password === $(this).val()) {
            $("button").prop("disabled", false);
        } else {
            $("button").prop("disabled", true);
        }
    })
});