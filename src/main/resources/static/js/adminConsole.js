$(document).ready(function() {

    //Ajax request sent when storeClosed button clicked
    $("#storeClosed").click(function () {

        var storeStatus = $(this).val();

        var url = "/changeStoreStatus/" + storeStatus;

        var request = $.ajax({
            url: url,
            type: "GET"
        });

        request.done(function() {
            console.log("store status ajax success");
            location.reload();
        });

        request.fail(function() {
            console.log("store status ajax error");
        });

        request.always(function() {
            console.log("store status ajax complete");
        });
    });

    //Ajax request sent when storeOpen button is clicked
    $("#storeOpen").click(function () {

        var storeStatus = $(this).val();

        var url = "/changeStoreStatus/" + storeStatus;

        var request = $.ajax({
            url: url,
            type: "GET"
        });

        request.done(function() {
            console.log("store status ajax success");
            location.reload();
        });

        request.fail(function() {
            console.log("store status ajax error");
        });

        request.always(function() {
            console.log("store status ajax done");
        });
    });

    //Event listener to uncheck other checkboxes when one is checked
    $('.checkbox').on('change', function() {
        $('.checkbox').not(this).prop('checked', false);

        var url = "/changeStoreDecoration/";
        var request;

        //If checked, the decoration is passed as a path variable, otherwise "none" is passed
        if($(this).is(":checked")) {
            var decoration = $(this).val();
            url += decoration;

            request = $.ajax({
                url: url,
                type: "GET"
            });

            request.done(function() {
                console.log("decoration ajax success");
            });

            request.fail(function() {
                console.log("decoration ajax error");
            });

            request.always(function() {
                console.log("decoration ajax complete")
            });
        } else {
            url += "none";
            console.log(url);

            request = $.ajax({
                url: url,
                type: "GET"
            });

            request.done(function() {
                console.log("decoration ajax success");
            });

            request.fail(function() {
                console.log("decoration ajax error");
            });

            request.always(function() {
                console.log("decoration ajax complete")
            });
        }
    });


});