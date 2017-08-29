$(document).ready(function() {
    const client = filestack.init("AI8WHlvxJQ3aUOZNIhe01z");
    const link = document.getElementById("beerPicture");
    const saveUrl = document.getElementById("beerPictureUrl");

    $("#uploadBtn").click(function() {

        client.pick({
            accept: 'image/*',
            lang: "ja"
        }).then(function(result) {
            const fileUrl = result.filesUploaded[0].url;
            link.src=fileUrl;
            saveUrl.value=fileUrl;
        });
    });

    $("#deleteButton").click(function() {
        var url = "/deleteBeer/" + $("#beerId").val();

        var request = $.ajax({
            url: url,
            type: "GET"
        });

        request.done(function() {
            console.log("beer delete ajax success");
            $(location).attr("href", "../beers");
        });

        request.fail(function() {
            console.log("beer delete ajax error");
        });

        request.always(function() {
            console.log("beer delete ajax complete");
        })
    })
});