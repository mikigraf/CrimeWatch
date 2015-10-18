/*!
 * Start Bootstrap - Grayscale Bootstrap Theme (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

// jQuery to collapse the navbar on scroll
$(window).scroll(function () {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
});

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function () {
    $('a.page-scroll').bind('click', function (event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function () {
    $('.navbar-toggle:visible').click();
});

// Google Maps Scripts
// When the window has finished loading create our google map below
google.maps.event.addDomListener(window, 'load', init);
var map;

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
    map = new google.maps.Map(mapElement, mapOptions);
    map.data.loadGeoJson('http://jh2015.deneb.uberspace.de/api.php?lng=33.003568&lat=-96.845070');
    google.maps.event.addDomListener(map, 'dragend', refreshData);

    var imgArrest = 'img/';
    var imgArson = 'img/';
    var imgAssault = 'img/';
    var imgBurglay = 'img/';
    var imgRobbery = 'img/';
    var imgShooting = 'img/';
    var imgTheft = 'img/';
    var imgVandalism = 'img/';
    map.data.setStyle(function (feature) {
            var type = feature.getOwnProperty('type');
            switch (type) {
                case arrest:
                    return ({
                        icon: imgArrest,
                        title: 'Arrest'
                    });
                case arson:
                    return ({
                        icon: imgArson,
                        title: 'Arson'
                    });
                case assault:
                    return ({
                        icon: imgAssault,
                        title: 'Assault'
                    });
                case burglay:
                    return ({
                        icon: imgBurglay,
                        title: 'Burglay'
                    });
                case robbery:
                    return ({
                        icon: imgRobbery,
                        title: 'Robbery'
                    });
                case shooting:
                    return ({
                        icon: imgShooting,
                        title: 'Shooting'
                    });
                case theft:
                    return ({
                        icon: imgTheft,
                        title: 'Theft'
                    });
                case vandalism:
                    return ({
                        icon: imgVandalism,
                        title: 'Vandalism'
                    });
                default:
                    console.log("No Type defined in GeoJSON");
                    break;
            }
        })
        // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
}

function refreshData() {
    var bound = map.getBounds().getCenter();
    var lat = bound.lat();
    var lng = bound.lng();
    map.data.loadGeoJson('http://jh2015.deneb.uberspace.de/api.php?lng=' + lng + '&lat=' + lat);
}
