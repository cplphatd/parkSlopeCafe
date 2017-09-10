$(document).ready(function() {

    //Javascript redirect for add beer button
    $("#addBeerButton").click(function() {
        $(location).attr("href", "beers/createBeer");
    });

    //Ajax request to update stock status of beer and changes link color based on availability
    $(".inStockStatus").click(function() {
        var url = "/updateStock/" + $(this).attr("id");
        var request;
        var inStock;
        var linkId = "#" + $(this).attr('id') + "link";

        if($(this).is(":checked")) {
            inStock = "/true";
            url += inStock;

            request = $.ajax({
                url: url,
                type: "GET"
            });

            request.done(function() {
                $(linkId).removeClass("outOfStock");
                $(linkId).addClass("inStock");
                console.log("update stock ajax success");
            });

            request.fail(function() {
                console.log("update stock ajax error");
            });

            request.always(function() {
                console.log("update stock ajax done");
            });

        } else {
            inStock = "/false";
            url += inStock;

            request = $.ajax({
                url: url,
                type: "GET"
            });

            request.done(function() {
                $(linkId).removeClass("inStock");
                $(linkId).addClass("outOfStock");
                console.log("update stock ajax success");
            });

            request.fail(function() {
                console.log("update stock ajax error");
            });

            request.always(function() {
                console.log("update stock ajax done");
            });
        }

     });
});