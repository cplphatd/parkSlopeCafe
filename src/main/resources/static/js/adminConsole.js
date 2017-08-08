$(document).ready(function() {
    $("#storeClosed").click(function () {

        var storeStatus = $(this).val();

        var url = "/changeStoreStatus/" + storeStatus;

        var request = $.ajax({
            url: url,
            type: "GET"
        });

        request.done(function() {
            console.log("success");
            location.reload();
        });

        request.fail(function() {
            console.log("error");
        });

        request.always(function() {
            console.log("done");
        });
    });

    $("#storeOpen").click(function () {

        var storeStatus = $(this).val();

        var url = "/changeStoreStatus/" + storeStatus;

        var request = $.ajax({
            url: url,
            type: "GET"
        });

        request.done(function() {
            console.log("success");
            location.reload();
        });

        request.fail(function() {
            console.log("error");
        });

        request.always(function() {
            console.log("done");
        });
    });
});