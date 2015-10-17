/*!
 * Start Bootstrap - Grayscale Bootstrap Theme (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

// jQuery to collapse the navbar on scroll
$(window).scroll(function() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
});

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});

// Google Maps Scripts
// When the window has finished loading create our google map below
google.maps.event.addDomListener(window, 'load', init);

function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        zoom: 15,
        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(33.003568, -96.845070), // Dallas
        // Disables the default Google Maps UI components
        disableDefaultUI: false,
        draggable: true,
    };
    var mapElement = document.getElementById('map');
    var map = new google.maps.Map(mapElement, mapOptions);
   // map.data.loadGeoJson('http://jh2015.deneb.uberspace.de/api.php?lng=33.003568&lat=-96.845070');
    google.maps.event.addDomListener(map, 'dragend', refreshData);
    google.maps.event.addDomListener(map, 'dblclick', refreshData);
    // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
}
function refreshData() {
    alert("test");
}
