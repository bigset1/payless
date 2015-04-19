routie({
    '': function () {
        React.render(
            <App>
                <AppIndex/>
            </App>,
            document.getElementById('content')
        );
    },
    'product/:barcode': function (barcode) {
        React.render(
            <App>
                <Product barcode={barcode}/>
            </App>,
            document.getElementById('content')
        );
    },
    'create-list/:barcode?': function (barcode) {
        React.render(
            <App>
                <CreateList barcode={barcode}/>
            </App>,
            document.getElementById('content')
        );
    },
    'about': function () {
        React.render(
            <App/>,
            document.getElementById('content')
        );
    },

    'map/:location?': function (location) {
        if (location) {
            var data = location.split('&');
            React.render(
                <App>
                    <ShopsMap location={data}/>
                </App>,
                document.getElementById('content')
            );
        } else {
            React.render(
                <App>
                    <ShopsMap/>
                </App>,
                document.getElementById('content')
            );
        }

    },
    '*': function () {
        routie('');
    }
});