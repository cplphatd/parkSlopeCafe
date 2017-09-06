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
                   "                        <span class='beerName'>" + beerList[i].name + "</span>" +
                   "                        <a href='#'>\n" +
                   "                            <img class='beerPic' src='" + beerList[i].picture + "'/>\n" +
                   "                        </a>\n" +
                   "                    </div>\n" +
                   "                </div>"
           } else {
               carouselIndicators += "<li data-target='#myCarousel' data-slide-to='" + i + "' class=''></li>";
               carouselInner += "<div class='item'>\n" +
                   "                    <div class='container'>\n" +
                   "                        <span class='beerName'>" + beerList[i].name + "</span>" +
                   "                        <a href='#'>\n" +
                   "                            <img class='beerPic' src='" + beerList[i].picture + "'/>\n" +
                   "                        </a>\n" +
                   "                    </div>\n" +
                   "                </div>"
           }
       }

       $(".carousel-indicators").html(carouselIndicators);
       $(".carousel-inner").html(carouselInner);
   });

   request.fail(function() {
       console.log("Beer list ajax failed.")
   });

   request.always(function() {
       console.log("Beer list ajax complete.");
   });

});