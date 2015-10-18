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

    var imgArrest = 'img/arrest.png';
    var imgArson = 'img/arson.png';
    var imgAssault = 'img/assault.png';
    var imgBurglary = 'img/burglary.png';
    var imgRobbery = 'img/robbery.png';
    var imgShooting = 'img/shooting.png';
    var imgTheft = 'img/theft.png';
    var imgVandalism = 'img/vandalism.png';
    var defaultIcon = 'img/map-marker-dark.png'
    map.data.setStyle(function (feature) {
            var type = feature.getProperty('type');
            switch (type) {
                case "Arrest":
                    return ({
                        icon: imgArrest,
                        title: type
                    });
                    break;
                case "Arson":
                    return ({
                        icon: imgArson,
                        title: type
                    });
                    break;
                case "Assault":
                    return ({
                        icon: imgAssault,
                        title: 'Assault'
                    });
                    break;
                case "Burglary":
                    return ({
                        icon: imgBurglary,
                        title: 'Burglay'
                    });
                    break;
                case "Robbery":
                    return ({
                        icon: imgRobbery,
                        title: 'Robbery'
                    });
                    break;
                case "Shooting":
                    return ({
                        icon: imgShooting,
                        title: 'Shooting'
                    });
                    break;
                case "Theft":
                    return ({
                        icon: imgTheft,
                        title: 'Theft'
                    });
                    break;
                case "Vandalism":
                    return ({
                        icon: imgVandalism,
                        title: 'Vandalism'
                    });
                case "Other":
                    return ({
                        icon: defaultIcon,
                        title: type
                    });
                default:
                    console.log("No Type defined in GeoJSON");
                    break;
            }
        })
        // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
    var geocoder = new google.maps.Geocoder();

    document.getElementById('submit').addEventListener('click', function () {
        geocodeAddress(geocoder, map);
    });
    document.getElementById('address').addEventListener('keyup', function (event) {
        if (event.keyCode === 13 || event.which === 13) {
            geocodeAddress(geocoder, map);
        }
    });
}

function refreshData() {
    var bound = map.getBounds().getCenter();
    var lat = bound.lat();
    var lng = bound.lng();
    map.data.loadGeoJson('http://jh2015.deneb.uberspace.de/api.php?lng=' + lng + '&lat=' + lat);
}

function address(e) {
    geocodeAddress(geocoder, map);
    return false;
}


function geocodeAddress(geocoder, resultsMap) {
    var address = document.getElementById('address').value;
    geocoder.geocode({
        'address': address
    }, function (results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: resultsMap,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}
