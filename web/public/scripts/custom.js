/**
 * Created by bigset1 on 4/17/15.
 */
var animateHeader = function () {

    //Animated header positioning
    var $head = $('.header-fixed');


    $('.waypoint').each(function (i) {
        var $el = $(this),
            animClassDown = $el.data('animateDown'),
            animClassUp = $el.data('animateUp');

        $el.waypoint(function (direction) {
            if (direction === 'down' && animClassDown) {
                $head.attr('class', 'header-fixed ' + animClassDown);
            }
            else if (direction === 'up' && animClassUp) {
                $head.attr('class', 'header-fixed ' + animClassUp);
            }
        }, {offset: -250});
    });
};


//Counter for progress bar and achivemt
function countValue(value, result, target, duration) {
    if (duration) {
        var count = 0;
        var speed = parseInt(duration / value);
        var interval = setInterval(function () {
            if (count - 1 < value) {
                target.html(count);
            }
            else {
                target.html(result);
                clearInterval(interval);
            }
            count++;
        }, speed);
    }
    else {
        target.html(result);
    }
}

function initProgressBar($selector, duration) {
    $selector.each(function () {
        var container = $(this).find('.progress-value');
        var value = $(this).find('.progress').attr('data-level');
        var result = value;
        if (duration) {
            $(this).find('.progress-bar').animate({width: value + '%'}, duration);
        }
        else {
            $(this).find('.progress-bar').css({'width': value + '%'});
        }

        countValue(value, result, container, duration);
    });
}

var formatBarcodeSearchResults = function (data, e, e1, e2) {
    console.log(data, e, e1, e2);

};
var formatRepo = function (data, e, e1, e2) {
    if (data.disabled === undefined) {
        console.log(data);
        return "<a href=\"#product/" + data.barcode + "\">" + data.name + " (" + data.barcode + ")</a>"
    }
};

var getApiRequestUrl = function (path) {
    var url = " http://payless.cloudapp.net/";
    return url + path;
};

var AppConfigObject = function () {
    var url = "http://server-payless2015.rhcloud.com/";
    this.getFromApi = function (path) {
        return url + path;
    }
};


var InitSearchBar = function (selector, resultTemplateFunction) {
    $(selector).select2({
        placeholder: "  Type product name  . . .",
        ajax: {
            url: getApiRequestUrl('product/search/name'),
            headers: {'X-Requested-With': 'XMLHttpRequest'},
            crossDomain: false,
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    name: params.term, // search term
                    page: params.page
                };
            },
            processResults: function (data, page) {
                return {
                    results: data
                };
            },
            cache: true
        },
        escapeMarkup: function (markup) {
            return markup;
        }, // let our custom formatter work
        minimumInputLength: 4,
        templateResult: resultTemplateFunction // omitted for brevity, see the source of this page
        //templateSelection: formatBarcodeSearchResults// omitted for brevity, see the source of this page
    })
};
var DestroySearchBar = function (selector) {
    $(selector).select2('destroy');
};

function initMapVintage(selector, location) {
    //Map start init - location New York
    var mapOptions = {
        scaleControl: true,
        center: new google.maps.LatLng(location.lat, location.log),
        zoom: 12,
        scrollwheel: false,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        panControl: true,
        zoomControl: true,
        mapTypeControl: false,
        scaleControl: false,
        streetViewControl: false,
        overviewMapControl: false
    };

    var myIcon = new google.maps.MarkerImage("http://atech.designzway.com/demo/images/components/marker.png", null, null, null, new google.maps.Size(57, 64));

    var map = new google.maps.Map(selector, mapOptions);
    var marker = new google.maps.Marker({
        map: map,
        position: map.getCenter(),
        icon: myIcon
    });

    var roadAtlasStyles = [
        {
            "featureType": "road.highway",
            "elementType": "geometry",
            "stylers": [
                {"saturation": -100},
                {"lightness": -8},
                {"gamma": 1.18}
            ]
        }, {
            "featureType": "road.arterial",
            "elementType": "geometry",
            "stylers": [
                {"saturation": -100},
                {"gamma": 1},
                {"lightness": -24}
            ]
        }, {
            "featureType": "poi",
            "elementType": "geometry",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "administrative",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "transit",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "water",
            "elementType": "geometry.fill",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "road",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "administrative",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "landscape",
            "stylers": [
                {"saturation": -100}
            ]
        }, {
            "featureType": "poi",
            "stylers": [
                {"saturation": -100}
            ]
        }, {}
    ]

    var styledMapOptions = {};

    var usRoadMapType = new google.maps.StyledMapType(
        roadAtlasStyles, styledMapOptions);

    map.mapTypes.set('usroadatlas', usRoadMapType);
    map.setMapTypeId('usroadatlas');
}