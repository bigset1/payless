var App = React.createClass({
    propTypes: {
        //componentName: React.PropTypes.element
    },
    getInitialState: function () {
        return {
            page: 'index'
        };
    },
    componentWillMount: function () {

    },
    render: function () {
        return (
            <div className="wrapper" id="top">
                <AppHeader/>
                <AppBreadcrumb/>
                {this.props.children}
            </div>
        );
    }
});


var AppContent = React.createClass({
    getInitialState: function () {
        return {};
    },
    componentDidMount: function () {

    },
    render: function () {
        return (
            <section>
                <div className="container">
                    <h2 className="block-title">Default Header</h2>

                    <p></p>
                </div>
            </section>
        );
    }
});

var Product = React.createClass({
    getInitialState: function () {
        return {
            loaded: false
        };
    },
    getDefaultProps: function () {
        return {
            info: {}
        }
    },

    componentDidMount: function () {

    },

    componentWillMount: function () {

        this.setState({data: comments}, function () {
            // `setState` accepts a callback. To avoid (improbable) race condition,
            // `we'll send the ajax request right after we optimistically set the new
            // `state.
            $.ajax({
                url: this.props.url,
                dataType: 'json',
                type: 'POST',
                data: comment,
                success: function (data) {
                    this.setState({data: data});
                }.bind(this),
                error: function (xhr, status, err) {
                    console.error(this.props.url, status, err.toString());
                }.bind(this)
            });
        });
    },

    render: function () {

        if (this.state.loaded) {

            var info = this.props.info;


            return (
                <div className="product product--single">
                    <div className="row">
                        <div className="col-sm-4">
                            <div className="img-container">
                                <img alt="" src={info.image}/>
                            </div>
                        </div>

                        <div className="col-sm-8">
                            <div className="product__decribe product__decribe--full">
                                <h3 className="product__title">{info.name}</h3>

                                <p className="product__info">{info.producer}</p>

                                <p className="product__info">{info.country}</p>

                                <p className="product__info">{info.barcode}</p>

                                <p className="product__info">{info.description}</p>

                            </div>
                        </div>
                    </div>
                </div>
            );
        } else {
            return (
                <div>
                    <h3>Loading....</h3>
                </div>
            );
        }
    }
});


var AppIndex = React.createClass({
    getInitialState: function () {
        return {
            page: 'index'
        };
    },

    componentDidMount: function () {
        $(React.findDOMNode(this.refs.barcodeSearchTool)).select2({
         placeholder: "  Type product name  . . .",
            ajax: {
                url: "https://api.github.com/search/repositories",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        q: params.term, // search term
                        page: params.page
                    };
                },
                processResults: function (data, page) {
                    // parse the results into the format expected by Select2.
                    // since we are using custom formatting functions we do not need to
                    // alter the remote JSON data
                    return {
                        results: data.items
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            }, // let our custom formatter work
            minimumInputLength: 1,
            //templateResult: formatRepo, // omitted for brevity, see the source of this page
            templateSelection: formatBarcodeSearchResults// omitted for brevity, see the source of this page
        })
    },
    handleChange: function (e) {
        //$.ajax({});
    },
    render: function () {
        return (
            <div className="wrapper" id="top">
                <header className="header header--slice">

                    <div className="header-fixed header-down">
                        <div className="container">

                            <AppHeader.Logo/>
                            <AppHeader.Menu/>
                        </div>
                    </div>
                    <div className="search-container start-block">
                        <img src="http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png"/*Insert our logo here  Yopta*/  className="search-logo"/>
                        <select className="search-input select-box" multiple="multiple" ref="barcodeSearchTool">
                        </select>
                    </div>
                    <div className="devider-color devider-color--onepage"></div>
                </header>
            </div>
        );
    }
});


