/**
 * Created by bigset1 on 4/17/15.
 */
var animateHeader = function () {

    //Animated header positioning
    var $head = $('.header-fixed');

    console.log($head);

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

var formatBarcodeSearchResults = function () {


};

var getApiRequestUrl = function (path) {
    var url = "http://server-payless2015.rhcloud.com/";
    return url + path;
};

var AppConfigObject = function () {
    var url = "http://server-payless2015.rhcloud.com/";
    this.getFromApi = function (path) {
        return url + path;
    }
};
