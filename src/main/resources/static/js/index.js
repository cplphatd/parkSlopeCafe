$(document).ready(function() {

    //Sends ajax request on page load
    var request = $.ajax({
       url: "/beerList.json"
   });

    //Generates html from returned JSON object of beers
    request.done(function(beerList) {
       var carouselIndicators = "";
       var carouselInner = "";

       for(var i = 0; i < beerList.length; i += 1) {
           if(i === 0) {
               carouselIndicators += "<li data-target='#myCarousel' data-slide-to='" + i + "' class='active'></li>";
               carouselInner += "<div class='item active'>\n" +
                   "                    <div class='container'>\n" +
                   "                        <h5 class='beerName'>" + beerList[i].name + "</h5>" +
                   "                        <img class='beerPic' src='" + beerList[i].picture + "'/>\n" +
                   "                        <button class='btn btn-secondary pscBtn my_popup" + i + "_open'>インフォ</button>" +
                   "                        <div id='my_popup" + i + "'>" +
                   "                            <h2>" + beerList[i].name + "</h2>" +
                   "                            <p>カテゴリー：" + beerList[i].category + "</p>" +
                   "                            <p>デスクリプション：" + beerList[i].description + "</p>" +
                   "                            <p>アベイラブル：" + beerList[i].inStock + "</p>" +
                   "                        </div>" +
                   "                    </div>\n" +
                   "                </div>";
           } else {
               carouselIndicators += "<li data-target='#myCarousel' data-slide-to='" + i + "' class=''></li>";
               carouselInner += "<div class='item'>\n" +
                   "                    <div class='container'>\n" +
                   "                        <h5 class='beerName'>" + beerList[i].name + "</h5>" +
                   "                        <img class='beerPic' src='" + beerList[i].picture + "'/>\n" +
                   "                        <button class='btn btn-secondary pscBtn my_popup" + i + "_open'>インフォ</button>" +
                   "                        <div id='my_popup" + i + "'>" +
                   "                            <h2>" + beerList[i].name + "</h2>" +
                   "                            <p>カテゴリー：" + beerList[i].category + "</p>" +
                   "                            <p>デスクリプション：" + beerList[i].description + "</p>" +
                   "                            <p>アベイラブル：" + beerList[i].inStock + "</p>" +
                   "                        </div>" +
                   "                    </div>\n" +
                   "                </div>";
           }
       }

       $(".carousel-indicators").html(carouselIndicators);
       $(".carousel-inner").html(carouselInner);

       //Initialize all the popups
       for (var j = 0; j < beerList.length; j += 1) {
           var beerPopupId = "#my_popup" + j;
           $(beerPopupId).popup({
               color: 'black',
               opacity: 1,
               transition: 'all 0.3s',
               scrolllock: true
           });
       }

   });

   request.fail(function() {
       console.log("Beer list ajax failed.")
   });

   request.always(function() {
       console.log("Beer list ajax complete.");
   });

    //Smooth scroll event listener
    $(document).on("click", ".anchorNav", function(event) {
        event.preventDefault();

        var nav =
        $("html, body").animate({
            scrollTop: $($.attr(this, "href")).offset().top
        }, 500);
    });

});