$(document).ready(function() {
    const client = filestack.init("AI8WHlvxJQ3aUOZNIhe01z");
    const link = document.getElementById("beerPicture");
    const saveUrl = document.getElementById("beerPictureUrl");

    $("#uploadBtn").click(function() {
        console.log("click");
        client.pick({
            accept: 'image/*',
            lang: "ja"
        }).then(function(result) {
            const fileUrl = result.filesUploaded[0].url;
            link.src=fileUrl;
            saveUrl.value=fileUrl;
        });
    });
});