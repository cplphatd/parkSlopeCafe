$(document).ready(function() {
    $("#addBeerButton").click(function() {
        $(location).attr("href", "beers/createBeer");
    })
});