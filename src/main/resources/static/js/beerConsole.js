$(document).ready(function() {
    $("#addBeerButton").click(function() {
        $(location).attr("href", "beers/createBeer");
    });

    $(".inStockStatus").click(function() {
        var url = "/updateStock/" + $(this).attr("id");
        var request;
        var inStock;

        if($(this).is(":checked")) {
            inStock = "/true";
            url += inStock;

            request = $.ajax({
                url: url,
                type: "GET"
            });

            request.done(function() {
                console.log("update stock ajax success");
                location.reload();
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
                console.log("update stock ajax success");
                location.reload();
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