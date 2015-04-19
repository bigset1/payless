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
                {/* <AppBreadcrumb/>*/}
                {this.props.children}
                <AppFooter/>
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
            info: {},
            shops: []
        };
    },
    getDefaultProps: function () {
        return {
            barcode: null
        }
    },

    componentDidMount: function () {
        initProgressBar($(React.findDOMNode(this.refs.loaderBar)), 2500);
    },

    componentWillMount: function () {

        $.ajax({
            url: getApiRequestUrl('product/search/barcode'),
            dataType: 'json',
            type: 'GET',
            data: {
                barcode: this.props.barcode
            },
            success: function (data) {
                this.setState({info: data});

                JsBarcode(React.findDOMNode(this.refs.barcodeCanvas), data.barcode, {
                    width: 1,
                    height: 40,
                    quite: 15,
                    format: "CODE128",
                    displayValue: true,
                    font: "monospace",
                    textAlign: "center",
                    fontSize: 15,
                    backgroundColor: "",
                    lineColor: "#000"
                });

            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });

        $.ajax({
            url: getApiRequestUrl('product/search/location'),
            dataType: 'json',
            type: 'GET',
            //'contentType': 'application/json',
            data: {
                barcode: this.props.barcode,
                latitude: 50.439443,
                longitude: 30.514974,
                distance: 1.0
            },
            success: function (data) {
                this.setState({shops: data});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });


        /*this.setState({data: comments}, function () {
         // `setState` accepts a callback. To avoid (improbable) race condition,
         // `we'll send the ajax request right after we optimistically set the new
         // `state.

         });*/
    },

    render: function () {

        if (this.state.info) {

            var info = this.state.info;

            var imageContainer;
            if (info.imageUrl) {
                imageContainer = <div className="col-sm-3">
                    <div className="img-container thumbnail">
                        <img alt="" className="img-thumbnail" src={info.imageUrl}/>
                    </div>
                </div>
            }

            function getElement(title, str) {
                if (str) {
                    return (
                        <tr>
                            <td className="vertical-heading">{title}</td>
                            <td>{str}</td>
                        </tr>
                    )

                }
            }


            return (
                <div className="product product--single">

                    <div className="row product_info_container">
                        <div className="col-sm-1"/>
                        {imageContainer}

                        <div className="col-sm-7">

                            <table className="table table--vertical table-present">
                                <colgroup className="col-width-1">
                                </colgroup>
                                <colgroup className="col-width-3">
                                </colgroup>
                                <tbody>
                                {getElement('Product', info.name)}
                                {getElement('Producer', info.producer)}
                                {getElement('Country', info.country ? info.country : 'Ukraine')}
                                <tr>
                                    <td className="vertical-heading">Barcode</td>
                                    <td>
                                        <canvas ref="barcodeCanvas"></canvas>
                                    </td>
                                </tr>

                                {getElement('Description', info.description)}
                                </tbody>
                            </table>
                        </div>
                        <div className="col-sm-1"/>
                    </div>
                    <div className="row">

                        <div className="col-sm-1"/>

                        <div className="col-sm-10">
                            <div className="table-responsive">
                                <table className="table table-bordered table--wide table-present">
                                    <colgroup className="col-sm-width">
                                    </colgroup>
                                    <colgroup className="col-sm-width">
                                    </colgroup>
                                    <colgroup className="col-sm-width">
                                    </colgroup>
                                    <colgroup className="col-sm-width">
                                    </colgroup>
                                    <colgroup className="col-sm-width">
                                    </colgroup>
                                    <colgroup className="col-sm-width">

                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>Market</th>
                                        <th>Price</th>
                                        <th>Address</th>
                                        /*{<th>Working Hours</th>}*/
                                        <th>Distance</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {this.state.shops.map(function (result, i) {
                                        return (
                                            <tr key={i}>
                                                <td>{result.store.brand}</td>
                                                <td className="product_price">{result.price}</td>
                                                {/*<td>{result.store.workingHours}</td>*/}
                                                <td>{result.store.address}</td>
                                                <td>{result.distance.toFixed(2) + " km"}</td>
                                                <td><a className="btn btn-primary btn-sm"
                                                       href={"#map/"+result.store.latitude+"&"+result.store.longitude}>Map</a>
                                                </td>
                                            </tr>
                                        );
                                    }, this)}
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div className="col-sm-1"/>
                    </div>
                </div>
            );
        } else {
            return (
                <div className="product product--single">
                    <div className="row">
                        <div className="col-sm-3"></div>
                        <div className="col-sm-6">
                            <div className="progress-container progress--primary progress-cut" ref="loaderBar">
                                <div className="progress-quantity">Loading...</div>
                                <div className="progress" data-level="87">
                                    <div className="progress-bar" role="progressbar" aria-valuenow="60"
                                         aria-valuemin="0"
                                         aria-valuemax="100" style={{width: 0+'%'}}>
                                        <span className="progress-number"><span
                                            className="progress-value">0</span>%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-3"></div>
                    </div>
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

    },
    componentDidUnMount: function () {

    },
    handleChange: function (e) {
        //$.ajax({});
    },

    searchBarTemplate: function (data) {
        if (data.disabled === undefined) {
            return "<a href=\"#product/" + data.barcode + "\">" + data.name + " (" + data.barcode + ")</a>"
        }
    },
    render: function () {
        return (
            <main>
                <div className="search-container start-block">
                    <SearchBar customClassNames="select-box home-item-search"
                               searchTemplate={this.searchBarTemplate}/>
                    {/*<img
                     src="http://icons.iconarchive.com/icons/alecive/flatwoken/256/Apps-Search-icon.png"
                     className="search-logo"/>*/}
                </div>
                <section className="container">
                    <div className="row">
                        <div className="col-sm-6 col-md-4">
                            <div className="service">
                                <div className="icon icon--circle">
                                    <i className="icon__item fa fa-credit-card"></i>
                                </div>
                                <a className="service__link" href="single-service.html">
                                    <h3 className="service__heading">People’s Prices</h3>
                                </a>

                                <p>PayLess has the most recent price tickets for a diversity of products. We
                                    guarantee the price actuality as they are based on people’s commitment, not on
                                    fake price lists from supermarkets.
                                </p>
                            </div>
                        </div>

                        <div className="col-sm-6 col-md-4">
                            <div className="service">

                                <div className="icon icon--circle">
                                    <i className="icon__item fa fa-dashboard"></i>
                                </div>
                                {/*<div className="icon icon--circle icon--animate icon--animate-service">
                                 <div className="icon__item">
                                 <i className="livicon" data-name="dashboard" data-color="#fff"
                                 data-hovercolor="#fff"></i>
                                 </div>
                                 </div>*/}
                                <a className="service__link" href="single-service.html">
                                    <h3 className="service__heading">Cheapest Basket</h3>
                                </a>

                                <p>We provide a feature to fill the list of goods you are going to buy and the
                                    system will choose the supermarket near you with the most valuable prices.
                                </p>
                            </div>
                        </div>

                        <div className="col-sm-6 col-md-4">
                            <div className="service">
                                <div className="icon icon--circle">
                                    <i className="icon__item fa fa-magic"></i>
                                </div>

                                {/*<div className="icon icon--circle icon--animate icon--animate-service">
                                 <div className="icon__item">
                                 <i className="livicon" data-name="magic" data-color="#fff"
                                 data-hovercolor="#fff"></i>
                                 </div>
                                 </div>*/}
                                <a className="service__link" href="single-service.html">
                                    <h3 className="service__heading">Only Nearest Places</h3>
                                </a>

                                <p>PayLess cares about your free time and we suggest you only the nearest stores
                                    that are located in 5-10 minute walking distance from your current position.</p>
                            </div>
                        </div>
                    </div>
                    <div className="devider-brand devider--top-xs"></div>
                </section>
            </main>
        );
    }
});

var ItemsStaticListFuck = {};

var CreateList = React.createClass({
    getInitialState: function () {
        return {
            list: [],
            confirm: false,
            shops: false
        };
    },
    componentDidUpdate: function () {
        console.log(this.props.barcode);
        if (this.props.barcode !== undefined) {
            var item = ItemsStaticListFuck[this.props.barcode];
            if (item) {
                var list = this.state.list;
                list.unshift(item);
                this.setState({
                    list: list
                });
                ItemsStaticListFuck = {};
                routie('create-list');
            }
        }

        if (this.state.confirm && this.state.shops === false) {
            var list = [];
            for (var i in this.state.list) {
                list.push(this.state.list[i].barcode);
            }

            $.ajax({
                url: getApiRequestUrl('basket/search'),
                dataType: 'json',
                type: 'POST',
                'contentType': 'application/json',
                data: JSON.stringify({
                    barcodeList: list,
                    latitude: 50.439443,
                    longitude: 30.514974
                }),
                success: function (data) {
                    data.productPricesSum = 0;

                    for (var i in data.productPrices) {
                        data.productPricesSum += +data.productPrices[i];
                    }

                    this.setState({shops: data});
                }.bind(this),
                error: function (xhr, status, err) {
                    console.error(this.props.url, status, err.toString());
                }.bind(this)
            });
        }
    },
    componentWillMount: function () {
    },
    componentWillReceiveProps: function () {
    },

    handleRemoveListItem: function (i) {
        var list = this.state.list;
        delete list[i];
        this.setState({
            list: list
        });
    },
    handleConfirmList: function () {
        this.setState({
            confirm: true
        })
    },
    handleBackToList: function () {
        this.setState({
            confirm: false,
            shops: false
        })
    },
    searchBarTemplate: function (data) {
        if (data.disabled === undefined) {
            ItemsStaticListFuck[data.barcode] = data;
            return "<a href=\"#create-list/" + data.barcode + "\">" + data.name + " (" + data.barcode + ")</a>"
        }
    },
    render: function () {
        var ContentTable;
        if (this.state.confirm && this.state.shops !== false) {

            ContentTable = <div className="col-sm-12 basket-results-table">
                <div className="row">
                    <button className="btn btn-general btn-md-rect btn-rect" onClick={this.handleBackToList}>
                        <i className="fa fa-arrow-circle-left"></i>BACK TO LIST
                    </button>
                </div>
                <div className="row">
                    <div className="table-responsive product-list-item">
                        <CreateList.Confirm list={this.state.shops}/>
                    </div>
                </div>
            </div>
        } else {
            var ConfirmButton;
            if (this.state.confirm) {
                ConfirmButton =
                    <button className="btn btn-lg btn-lg-rect btn-rect btn-warning evaluate-btn">
                        Loading...
                    </button>
            } else {
                ConfirmButton =
                    <button className="btn btn-general btn-lg-rect btn-rect evaluate-btn"
                            onClick={this.handleConfirmList}>
                        <i className="fa fa-arrow-circle-right"></i>
                        Evaluate
                    </button>
            }
            ContentTable = <div className="col-sm-12 list-creation-content">
                <SearchBar custom-class-names="select-box list-item-search"
                           searchTemplate={this.searchBarTemplate}
                    />

                <div className="devider-brand present-devider"></div>
                <div className="table-responsive">
                    <CreateList.ListTable list={this.state.list} removeListItem={this.handleRemoveListItem}/>
                </div>
                {ConfirmButton}
            </div>
        }
        return (
            <section className="container">
                <div className="row">
                    {ContentTable}
                </div>
            </section>
        );
    }
});

CreateList.ListTable = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    onRemoveClick: function (i, item, e) {
        this.props.removeListItem(i);
    },
    render: function () {
        console.log(this.props.list);
        return (
            <div className="table-responsive product-list-item">
                <table className="table table--target table-present">
                    <colgroup className="col-middle">
                    </colgroup>
                    <colgroup className="col-small">
                    </colgroup>
                    <colgroup className="col-middle">
                    </colgroup>
                    <colgroup className="col-middle">
                    </colgroup>
                    <colgroup className="col-small">
                    </colgroup>
                    <thead>
                    <tr>
                        <th className="table-main">Product Name</th>
                        <th>Country</th>
                        <th>Producer</th>
                        <th>Price Range</th>
                        <th>Actions</th>
                    </tr>
                    </thead>

                    <tbody>
                    {this.props.list.map(function (result, i) {
                        return (
                            <tr key={i}>
                                <td><span className="product-name-column">{result.name}</span>
                                    <span>{result.description}</span></td>
                                <td>{result.country ? result.country : "Ukraine"}</td>
                                <td>{result.producer}</td>
                                <td>{result.minPrice + " грн. - " + result.maxPrice+ " грн."}</td>
                                <td>
                                    <a href={"#product/"+result.barcode}
                                       className="actions-btn btn btn-success btn-sm-rect btn-sm">
                                        <i className="fa fa-arrow-circle-right"></i> View
                                    </a>

                                    <button onClick={this.onRemoveClick.bind(this,i,result)}
                                            className="actions-btn btn btn-danger btn-sm-rect btn-sm"
                                            key={i}>
                                        <i className="fa fa-times"></i> Remove
                                    </button>
                                </td>
                            </tr>
                        );
                    }, this)}
                    </tbody>
                </table>
            </div>
        );
    }
});

CreateList.Confirm = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    render: function () {


        return (
            <table className="table table--target table-present">
                <colgroup className="col-middle"/>
                <colgroup className="col-middle"/>
                <colgroup className="col-small"/>
                <colgroup className="col-small"/>
                <colgroup className="col-small"/>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Distance</th>
                    <th>Total Price</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>
                {this.props.list.map(function (result, i) {
                    return (
                        <tr key={result.store.brand+i}>
                            <td><span className="product-name-column">{result.store.brand}</span></td>
                            <td>{result.store.address}</td>
                            <td>{result.distance.toFixed(2)+" км."}</td>
                            <td>{result.totalPrice+" грн."}</td>
                            <td>
                                <button disabled="disabled" className="btn btn-primary btn-sm">View Order</button>
                            </td>
                        </tr>
                    );
                })}
                </tbody>

            </table>
        );
    }
});


var ShopsMap = React.createClass({
    getDefaultProps: function () {
        return {
            location: [
                50.439443,
                30.514974
            ]
        }
    },
    getInitialState: function () {
        return {
            shops: [],
            location: {
                lat: 50.439443,
                log: 30.514974
            },
            distance: 5.0
        }
    },
    componentWillMount: function () {

    },
    componentDidMount: function () {
        var location = this.props.location;
        console.log(location);
        initMapVintage(React.findDOMNode(this.refs.shopsMapArea), {
            center: this.props.location,
            location: [this.state.location.lat, this.state.location.log]
        }, this);

        $.ajax({
            url: getApiRequestUrl('store/v2/stores'),
            dataType: 'json',
            type: 'GET',
            data: {
                latitude: this.state.location.lat,
                longitude: this.state.location.log,
                distance: this.state.distance
            },
            success: function (data) {

                var shopMarker = new google.maps.MarkerImage("https://cdn3.iconfinder.com/data/icons/mapicons/icons/grocery.png", null, null, null, new google.maps.Size(25, 25));

                var shopsMarkers = [];

                for (var i in data) {
                    var shop = data[i];

                    (function (info) {

                        var marker = new google.maps.Marker({
                            map: this.state.map,
                            position: new google.maps.LatLng(shop.store.latitude, shop.store.longitude),
                            icon: shopMarker
                        });
                        google.maps.event.addListener(marker, 'mouseover', function () {
                            info.open(this.state.map, marker);
                        }.bind(this));

                        google.maps.event.addListener(marker, 'mouseout', function () {
                            info.close(this.state.map, marker);
                        }.bind(this));
                        google.maps.event.addListener(marker, 'click', function () {
                            this.state.map.setCenter(marker.position);
                        }.bind(this));
                        shopsMarkers.push(marker);
                    }.bind(this))(new google.maps.InfoWindow({
                        content: "<i>" + shop.store.brand + "</i><br>" + (Math.round(shop.distance * 100) / 100) + 'km'
                    }));

                }
                this.setState({shops: data});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });

    },
    componentWillUnmount: function () {

    },

    render: function () {
        return (
            <div>
                <section className="container">
                    <div className="devider devider--bottom-md"></div>
                    <div className="row">
                        <div className="col-sm-6">

                            <table className="table table-bordered table--wide table-present">
                                <colgroup className="col-md-width"/>
                                <colgroup className="col-sm-width"/>
                                <colgroup className="col-sm-width"/>

                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Distance</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>

                                {this.state.shops.map(function (result, i) {
                                    return (
                                        <tr key={i}>
                                            <td>
                                                <b>{result.store.brand}</b><br/>
                                                <i>{result.store.address}</i>
                                            </td>
                                            <td>{Math.round(result.distance * 100) / 100}km</td>
                                            <td></td>
                                        </tr>
                                    );
                                })}
                                </tbody>
                            </table>

                        </div>
                        <div className="col-sm-6">
                            <div id='map-blackwhite-full' className="map map--wide" style={{height: 500 + 'px'}}
                                 ref="shopsMapArea"></div>
                        </div>
                    </div>
                </section>
            </div>
        );
    }
});