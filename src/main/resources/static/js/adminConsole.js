$(document).ready(function() {

    //Verify no special characters (need to find more efficient way to write this)
    var containsSpecialChars = function(str){
        return (str.indexOf("<") !== -1
            || str.indexOf(">") !== -1
            || str.indexOf("#") !== -1
            || str.indexOf("%") !== -1
            || str.indexOf("{") !== -1
            || str.indexOf("}") !== -1
            || str.indexOf("|") !== -1
            || str.indexOf("^") !== -1
            || str.indexOf("~") !== -1
            || str.indexOf("[") !== -1
            || str.indexOf("]") !== -1
            || str.indexOf("`") !== -1);
    };

    //Gets store status on page load
    var storeStatusRequest = $.ajax({
        url: "/getStoreStatus.json"
    });

    storeStatusRequest.done(function(storeStatus) {

        if(storeStatus.storeIsOpen === true) {
            $("#storeStatusMsg").html("Store is open");
        } else {
            $("#storeStatusMsg").html("Store is closed");
        }

        //Checks decoration checkbox if it is active
        $(".checkbox").each(function() {
            if($(this).val() === storeStatus.decoration) {
                $(this).prop("checked", true);
            }
        });

        console.log("get store status ajax success")
    });

    storeStatusRequest.fail(function() {
        console.log("get store status ajax failure");
    });

    storeStatusRequest.always(function() {
        console.log("get store status ajax complete");
    });

    //Ajax request sent when storeClosed button clicked
    $(".storeStatus").click(function () {

        var storeStatus = $(this).val();

        var url = "/changeStoreStatus/" + storeStatus + ".json";

        var request = $.ajax({
            url: url
        });

        request.done(function(storeStatus) {

            if(storeStatus.storeIsOpen === true) {
                $("#storeStatusMsg").html("Store is open");
            } else {
                $("#storeStatusMsg").html("Store is closed");
            }

            console.log("change store status ajax success");
        });

        request.fail(function() {
            console.log("change store status ajax error");
        });

        request.always(function() {
            console.log("change store status ajax complete");
        });
    });

    //Event listener to uncheck other checkboxes when one is checked
    $('.checkbox').on('change', function() {
        $('.checkbox').not(this).prop('checked', false);

        var url = "/changeStoreDecoration/";
        var request;

        //If checked, the decoration is passed as a path variable, otherwise "none" is passed
        if($(this).is(":checked")) {
            url += $(this).val();

            request = $.ajax({
                url: url
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
                url: url
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

    //Event listener and ajax for message
    $("#message").keyup(function() {
        var message = $("#message").val();
        var url = "/updateMessage/" + message;
        var request;

        if(containsSpecialChars(message)) {
            $("#specialCharacters").removeClass("hidden");
        } else {
            $("#specialCharacters").addClass("hidden");
        }

        request = $.ajax({
            url: url
        });

        request.done(function() {
            console.log("message ajax success");
        });

        request.fail(function() {
            console.log("message ajax error");
        });

        request.always(function() {
            console.log("message ajax complete")
        });
    });
});