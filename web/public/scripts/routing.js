routie({
    '': function () {
        React.render(
            <AppIndex/>,
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
    'create-list': function () {
        React.render(
            <App>
                <CreateList/>
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
    'map': function () {
        React.render(
            <App>
                <ShopsMap/>
            </App>,
            document.getElementById('content')
        );
    },
    '*': function () {
        routie('');
    }
});