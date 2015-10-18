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
var infowindow = new google.maps.InfoWindow();
var defaultIcon;

function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        zoom: 15,
        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(33.003568, -96.845070), // Dallas
        // Disables the default Google Maps UI components
        disableDefaultUI: true,
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
    defaultIcon = 'img/map-marker-dark.png'
    map.data.setStyle(function (feature) {
            var type = feature.getProperty('type');
            switch (type) {
                case "Arrest":
                    return ({
                        icon: imgArrest,
                        title: type
                    });
                case "Arson":
                    return ({
                        icon: imgArson,
                        title: type
                    });
                case "Assault":
                    return ({
                        icon: imgAssault,
                        title: 'Assault'
                    });
                case "Burglary":
                    return ({
                        icon: imgBurglary,
                        title: 'Burglay'
                    });
                case "Robbery":
                    return ({
                        icon: imgRobbery,
                        title: 'Robbery'
                    });
                case "Shooting":
                    return ({
                        icon: imgShooting,
                        title: 'Shooting'
                    });
                case "Theft":
                    return ({
                        icon: imgTheft,
                        title: 'Theft'
                    });
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
        // Custom Map Marker Icon - Customize the map-marker.png file to customizes your icon
    var geocoder = new google.maps.Geocoder();

    document.getElementById('submit').addEventListener('click', function () {
        geocodeAddress(geocoder, map);
    });
    document.getElementById('address').addEventListener('keyup', function (e) {
        if (e.keyCode === 13 || e.which === 13) {
            geocodeAddress(geocoder, map);
        }
    });

    map.data.addListener('click', function (event) {
        var type = event.feature.getProperty('type');
        var city = event.feature.getProperty('city');
        var details = event.feature.getProperty('details');
        infowindow.setContent('<h4 style="color: #444">' + type + '</h4><h5 style="color: #444">city: </h5><p style="font-size: 14px; color: #444">' + city + '</p><h5 style="color: #444"><strong>details: </strong></h5><p style="font-size: 14px; color: #444">' + details + '</p>');
        infowindow.setPosition(event.feature.getGeometry().get());
        infowindow.setOptions({
            pixelOffset: new google.maps.Size(0, -30)
        });
        infowindow.open(map);
    });
}

function refreshData() {
    var bound = map.getBounds().getCenter();
    var geoString = 'http://jh2015.deneb.uberspace.de/api.php?lng=' + bound.lat() + '&lat=' + bound.lng();
    console.log(geoString);
    console.log(map.data.loadGeoJson(geoString));
    map.data.loadGeoJson(geoString);
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
                position: results[0].geometry.location,
                icon: defaultIcon
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}
