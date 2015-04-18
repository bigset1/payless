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
}

var formatBarcodeSearchResults = function () {


};


var AppConfigObject = function () {
    this.getFromApi = function () {
        
    }
};
