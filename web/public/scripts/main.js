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
            info: {
                "barcode": "5252454525",
                "name": "Test item",
                "producer": "test producer",
                "country": "Uk",
                "image": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAP8AAAD/CAYAAAA+CADKAAAFVElEQVR4nO3a0W3bZhiF4U9FBgjgMTqBV/Ag7godISvEg3gFT5AxDHSEXhRsFIaiSIrkT+k8z1XiKAhv3u+YRk51UM9P76+tnwHW8vH58tb6GfpOrR+gI3aSHOEYNItf7PBTi2Owe/yih8v2PAK7xS96mG6PI7B5/KKH5bY8ApvFL3pYzxZHYPX4RQ/bWfMIrBq/8GF7ax2A1eIXPuxnjQNwc/yih3ZuOQI3xS98aG/pAVgcv/DhOJYcgEXxCx+OZ+4BmB2/8OG45hyAWfELH45v6gGYHL/w4X5MOQB/7PEgwPFMWn6rD/fn2vpfjV/4cL/GDsBo/MKH+3fpAHjnh1AXl9/qw+MYWn/LD6EGl9/qw+Ppr7/lh1C/Lb/Vh8d1vv6WH0L9svxWHx5ft/6WH0L9v/xWH3J8fL68WX4IJX4IJX4Idaryvg+JLD+EEj+EEj+EOnnfh0yWH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0J9af0A/Ofbj6/fz3//95///HXpz4Y+N+Uz9/w8rE/8B9CFch7Otx9fv/cjmRLNGmEd7XnYhm/7G+uHdv7rsfVMeR62Y/kbm7uM5wFe+ruXPjMUdv/rez4PbVn+AxqL9DzQoSUe+8zQ1y79W3s8D22dnp/eX1s/BD9NiXHOZ4c+M/bDvBbPQxuW/0D2CmPofb7l89CG+A9iLLTup+3X/v7Ub6mHvu1v+Ty0If4DuLawU97Vp77PD/1wrx/pns9DO975G7u2jnPf1af855yxn/bv+Ty0JX4I5dt+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CHWqqnp+en9t/SDAfj4+X94sP4QSP4QSP4Q6db/w3g8ZPj5f3qosP8Q6nf/G+sNj61a/yvJDrFP/C9YfHtP56ldZfoj12/JXWX94NP3Vr7L8EGtw+ausPzyKodWvsvwQ6+LyV1l/uHeXVr/qSvxVDgDcq7HwqybEX+UAwL25Fn6Vd36INWn5q6w/3Ispq181I/4qBwCObmr4VTPjr3IA4KjmhF+1IP4qBwCOZm74VQvjr3IA4CiWhF91Q/xVDgC0tjT8qhvj7zgCsK9bou+sEn+VAwB7WSP8qhXjr3IAYGtrhV+1cvwdRwDWtWb0nU3i7zgCcJstou9sGn/HEYB5toy+s0v8HUcAxu0RfWfX+DuOAPxqz+g7TeLvcwxI0yL2vn8BNsLw/lzHAHYAAAAASUVORK5CYII=",
                "description": "dsf dsf sdf sdf sdf sdf d fs\n sdfv dsf sdfv "
            }
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

            var imageContainer ;
            if(info.imageUrl){
                imageContainer =  <div className="col-sm-3">
                                                              <div className="img-container thumbnail">
                                                                  <img alt="" className="img-thumbnail" src={info.imageUrl}/>
                                                              </div>
                                                          </div>
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
                                <tr>
                                    <td className="vertical-heading">Name</td>
                                    <td>{info.name}</td>
                                </tr>
                                <tr>
                                    <td className="vertical-heading">Producer</td>
                                    <td>{info.producer}</td>
                                </tr>
                                <tr>
                                    <td className="vertical-heading">Country</td>
                                    <td>{info.country}</td>
                                </tr>
                                <tr>
                                    <td className="vertical-heading">Barcode</td>
                                    <td>{info.barcode}</td>
                                </tr>
                                <tr>
                                    <td className="vertical-heading">Description</td>
                                    <td>{info.description}</td>
                                </tr>
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
                                        <th>Last Update</th>
                                        <th>Address</th>
                                        <th>Distance</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Silpo</td>
                                        <td className="product_price">$ 2</td>
                                        <td>5 jul 2015</td>
                                        <td>Yanhelya str., 22</td>
                                        <td>5 km</td>
                                        <td><a className="btn btn-primary btn-sm" href="#">Map</a></td>
                                    </tr>
                                    <tr>
                                        <td>MegaMarket</td>
                                        <td className="product_price">$ 5</td>
                                        <td>13 sept 2014</td>
                                        <td>Metalistov str., 11</td>
                                        <td>5 km</td>
                                        <td><a className="btn btn-primary btn-sm" href="#">Map</a></td>
                                    </tr>
                                    <tr>
                                        <td>Fora</td>
                                        <td className="product_price">$ 1</td>
                                        <td>5 jul 2015</td>
                                        <td>TestStreet str., 12</td>
                                        <td>5 km</td>
                                        <td><a className="btn btn-primary btn-sm" href="#">Map</a></td>
                                    </tr>
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
            <div className="wrapper" id="top">
                <AppHeader/>
                <main>
                    <div className="search-container start-block">
                        <SearchBar customClassNames="select-box home-item-search"
                                   searchTemplate={this.searchBarTemplate}/>
                        <img
                            src="http://icons.iconarchive.com/icons/alecive/flatwoken/256/Apps-Search-icon.png"/*Insert our logo here  Yopta*/
                            className="search-logo"/>
                    </div>
                </main>

            </div>
        );
    }
});


var CreateList = React.createClass({
    getInitialState: function () {
        return {
            list: [
                {
                    "barcode": "5252454525",
                    "name": "Test item",
                    "producer": "test producer",
                    "country": "Uk",
                    "image": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAP8AAAD/CAYAAAA+CADKAAAFVElEQVR4nO3a0W3bZhiF4U9FBgjgMTqBV/Ag7godISvEg3gFT5AxDHSEXhRsFIaiSIrkT+k8z1XiKAhv3u+YRk51UM9P76+tnwHW8vH58tb6GfpOrR+gI3aSHOEYNItf7PBTi2Owe/yih8v2PAK7xS96mG6PI7B5/KKH5bY8ApvFL3pYzxZHYPX4RQ/bWfMIrBq/8GF7ax2A1eIXPuxnjQNwc/yih3ZuOQI3xS98aG/pAVgcv/DhOJYcgEXxCx+OZ+4BmB2/8OG45hyAWfELH45v6gGYHL/w4X5MOQB/7PEgwPFMWn6rD/fn2vpfjV/4cL/GDsBo/MKH+3fpAHjnh1AXl9/qw+MYWn/LD6EGl9/qw+Ppr7/lh1C/Lb/Vh8d1vv6WH0L9svxWHx5ft/6WH0L9v/xWH3J8fL68WX4IJX4IJX4Idaryvg+JLD+EEj+EEj+EOnnfh0yWH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0J9af0A/Ofbj6/fz3//95///HXpz4Y+N+Uz9/w8rE/8B9CFch7Otx9fv/cjmRLNGmEd7XnYhm/7G+uHdv7rsfVMeR62Y/kbm7uM5wFe+ruXPjMUdv/rez4PbVn+AxqL9DzQoSUe+8zQ1y79W3s8D22dnp/eX1s/BD9NiXHOZ4c+M/bDvBbPQxuW/0D2CmPofb7l89CG+A9iLLTup+3X/v7Ub6mHvu1v+Ty0If4DuLawU97Vp77PD/1wrx/pns9DO975G7u2jnPf1af855yxn/bv+Ty0JX4I5dt+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CHWqqnp+en9t/SDAfj4+X94sP4QSP4QSP4Q6db/w3g8ZPj5f3qosP8Q6nf/G+sNj61a/yvJDrFP/C9YfHtP56ldZfoj12/JXWX94NP3Vr7L8EGtw+ausPzyKodWvsvwQ6+LyV1l/uHeXVr/qSvxVDgDcq7HwqybEX+UAwL25Fn6Vd36INWn5q6w/3Ispq181I/4qBwCObmr4VTPjr3IA4KjmhF+1IP4qBwCOZm74VQvjr3IA4CiWhF91Q/xVDgC0tjT8qhvj7zgCsK9bou+sEn+VAwB7WSP8qhXjr3IAYGtrhV+1cvwdRwDWtWb0nU3i7zgCcJstou9sGn/HEYB5toy+s0v8HUcAxu0RfWfX+DuOAPxqz+g7TeLvcwxI0yL2vn8BNsLw/lzHAHYAAAAASUVORK5CYII=",
                    "description": "dsf dsf sdf sdf sdf sdf d fs\n sdfv dsf sdfv "
                },
                {
                    "barcode": "52524545257",
                    "name": "Test item",
                    "producer": "test producer",
                    "country": "Uk",
                    "image": "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAP8AAAD/CAYAAAA+CADKAAAFVElEQVR4nO3a0W3bZhiF4U9FBgjgMTqBV/Ag7godISvEg3gFT5AxDHSEXhRsFIaiSIrkT+k8z1XiKAhv3u+YRk51UM9P76+tnwHW8vH58tb6GfpOrR+gI3aSHOEYNItf7PBTi2Owe/yih8v2PAK7xS96mG6PI7B5/KKH5bY8ApvFL3pYzxZHYPX4RQ/bWfMIrBq/8GF7ax2A1eIXPuxnjQNwc/yih3ZuOQI3xS98aG/pAVgcv/DhOJYcgEXxCx+OZ+4BmB2/8OG45hyAWfELH45v6gGYHL/w4X5MOQB/7PEgwPFMWn6rD/fn2vpfjV/4cL/GDsBo/MKH+3fpAHjnh1AXl9/qw+MYWn/LD6EGl9/qw+Ppr7/lh1C/Lb/Vh8d1vv6WH0L9svxWHx5ft/6WH0L9v/xWH3J8fL68WX4IJX4IJX4Idaryvg+JLD+EEj+EEj+EOnnfh0yWH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0KJH0J9af0A/Ofbj6/fz3//95///HXpz4Y+N+Uz9/w8rE/8B9CFch7Otx9fv/cjmRLNGmEd7XnYhm/7G+uHdv7rsfVMeR62Y/kbm7uM5wFe+ruXPjMUdv/rez4PbVn+AxqL9DzQoSUe+8zQ1y79W3s8D22dnp/eX1s/BD9NiXHOZ4c+M/bDvBbPQxuW/0D2CmPofb7l89CG+A9iLLTup+3X/v7Ub6mHvu1v+Ty0If4DuLawU97Vp77PD/1wrx/pns9DO975G7u2jnPf1af855yxn/bv+Ty0JX4I5dt+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CCV+CHWqqnp+en9t/SDAfj4+X94sP4QSP4QSP4Q6db/w3g8ZPj5f3qosP8Q6nf/G+sNj61a/yvJDrFP/C9YfHtP56ldZfoj12/JXWX94NP3Vr7L8EGtw+ausPzyKodWvsvwQ6+LyV1l/uHeXVr/qSvxVDgDcq7HwqybEX+UAwL25Fn6Vd36INWn5q6w/3Ispq181I/4qBwCObmr4VTPjr3IA4KjmhF+1IP4qBwCOZm74VQvjr3IA4CiWhF91Q/xVDgC0tjT8qhvj7zgCsK9bou+sEn+VAwB7WSP8qhXjr3IAYGtrhV+1cvwdRwDWtWb0nU3i7zgCcJstou9sGn/HEYB5toy+s0v8HUcAxu0RfWfX+DuOAPxqz+g7TeLvcwxI0yL2vn8BNsLw/lzHAHYAAAAASUVORK5CYII=",
                    "description": "dsf dsf sdf sdf sdf sdf d fs\n sdfv dsf sdfv "
                }
            ],
            confirm: false,
            shops: false
        };
    },
    componentDidUpdate: function () {
        if (this.state.confirm && this.state.shops === false) {
            var list = [];
            for (var i in this.state.list) {
                list.push(this.state.list[i].barcode);
            }

            $.ajax({
                url: getApiRequestUrl('basket/search'),
                dataType: 'json',
                type: 'GET',
                data: {
                    list: list,
                    location: null
                },
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

    componentWillUpdate: function () {
        if (this.props.item !== undefined) {
            var list = this.state.list;
            list.push(this.props.item);
            this.setState({
                list: list
            });
            return true;
        } else {
            return false;
        }
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
    handleAddItemToList: function (item) {
        var list = this.state.list;
        list.push(item);
        this.setState({
            list: list
        });
    },
    searchBarTemplate: function (data) {
        if (data.disabled === undefined) {

            return "<a href=\"#create-list/" + data + "\">" + data.name + " (" + data.barcode + ")</a>"
        }
    },
    render: function () {
        var ContentTable;
        if (this.state.confirm && this.state.shops !== false) {

            ContentTable = <div className="col-sm-12">
                <div className="devider-brand present-devider"></div>
                <div className="row">
                    <botton className="btn btn-general btn-md-rect btn-rect" onClick={this.handleBackToList}>
                        <i className="fa fa-arrow-circle-left"></i>BACK TO LIST
                    </botton>
                </div>
                <div className="row">
                    <div className="table-responsive">
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
            ContentTable = <div className="col-sm-9 list-creation-content">
                <SearchBar custom-class-names="select-box list-item-search"
                           headerCallbackHandle={this.handleAddItemToList}
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
                    <AppSidebar/>
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
        return (
<<<<<<< HEAD
<div className="table-responsive product-list-item">
           		<table className="table table--target table-present">
	              	<colgroup className="col-wide">
	              	</colgroup><colgroup className="col-middle">
	              	</colgroup><colgroup className="col-middle">
	              	</colgroup>
	              	{/*<colgroup className="col-small">
		            </colgroup>*/}
		            <colgroup className="col-small">
		            </colgroup>
		            <thead>
		                <tr>
		                    <th className="table-main">Product Name</th>
		                    <th>Country</th>
		                    <th>Producer</th>
		                    {/*<th>Price Range</th>*/}
		                    <th>Actions</th>
		                </tr>
		            </thead>

		            <tbody>
                {this.props.list.map(function (result, i) {
                    return (
                        <tr key={result.barcode}>
		                  <td><span className="product-name-column">{result.name}</span> <span>{result.description}</span></td>
		                  <td>{result.country}</td>
		                  <td>{result.producer}</td>
		                  {/*<td></td>*/}
                            <td>
                                <a href={"#product/"+result.barcode} className="actions-btn btn btn-success btn-sm-rect btn-sm">
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
=======
            <div className="table-responsive product-list-item">
                <table className="table table--target table-present">
                    <colgroup className="col-wide">
                    </colgroup>
                    <colgroup className="col-middle">
                    </colgroup>
                    <colgroup className="col-middle">
                    </colgroup>
                    {/*<colgroup className="col-small">
                     </colgroup>*/}
                    <colgroup className="col-small">
                    </colgroup>
                    <thead>
                    <tr>
                        <th className="table-main">Product Name</th>
                        <th>Country</th>
                        <th>Producer</th>
                        {/*<th>Price Range</th>*/}
                        <th>Actions</th>
                    </tr>
                    </thead>

                    <tbody>
                    {this.props.list.map(function (result, i) {
                        return (
                            <tr key={result.barcode}>
                                <td><span className="product-name-column">{result.name}</span>
                                    <span>{result.description}</span></td>
                                <td>{result.country}</td>
                                <td>{result.producer}</td>
                                {/*<td></td>*/}
                                <td>
                                    <button onClick={this.handleClick.bind(this,i,result)}
                                            className="btn btn-danger btn-sm-rect btn-sm"
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
>>>>>>> v0.0.0.17
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
            <table className="table table-bordered table--wide table-present">
                <colgroup className="col-sm-width"/>
                <colgroup className="col-sm-width"/>
                <colgroup className="col-sm-width"/>
                <colgroup className="col-sm-width"/>
                <colgroup className="col-sm-width"/>
                <colgroup className="col-sm-width"/>

                <thead>
                <tr>
                    <th>Name</th>
                    <th>Working Hours</th>
                    <th>Distance</th>
                    <th>Basket Sum</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                {this.props.list.map(function (result, i) {
                    return (
                        <tr key={result.store.brand+i}>
                            <td>{result.store.brand}</td>
                            <td>{result.store.workingHours}</td>
                            <td>{result.distance}</td>
                            <td>{result.productPricesSum}</td>
                            <td>
                                <botton disabled="disabled" className="btn btn-primary btn-sm">View
                                    Order
                                </botton>
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
        return {}
    },
    getInitialState: function () {
        return {
            shops: false,
            location: {
                lat: 50.439443,
                log: 30.514974
            }
        }
    },
    componentDidMount: function () {
        initMapVintage(React.findDOMNode(this.refs.shopsMapArea), this.state.location);
    },
    componentWillUnmount: function () {

    },

    render: function () {
        return (
            <div className="row">
                <div className="col-sm-12">
                    <div id='map-blackwhite-full' className="map map--wide" style={{height:500+'px'}}
                         ref="shopsMapArea"></div>
                </div>
            </div>
        );
    }
});