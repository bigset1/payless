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

        /*$.ajax({
         url: getApiRequestUrl('basket/barcode'),
         dataType: 'json',
         type: 'GET',
         data: {
         barcode: this.props.barcode
         },
         success: function (data) {
         this.setState({loaded: data});
         }.bind(this),
         error: function (xhr, status, err) {
         console.error(this.props.url, status, err.toString());
         }.bind(this)
         });*/

        /*this.setState({data: comments}, function () {
         // `setState` accepts a callback. To avoid (improbable) race condition,
         // `we'll send the ajax request right after we optimistically set the new
         // `state.

         });*/
    },

    render: function () {

        if (this.state.info) {

            var info = this.state.info;


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
                                            class="progress-value">0</span>%</span>
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
        InitSearchBar(React.findDOMNode(this.refs.barcodeSearchTool));
    },
    componentDidUnMount: function () {
        DestroySearchBar(React.findDOMNode(this.refs.barcodeSearchTool));
    },
    handleChange: function (e) {
        //$.ajax({});
    },
    render: function () {
        return (
            <div className="wrapper" id="top">
                <header className="header header--light">

                    <div className="header-fixed header-down">
                        <div className="container">

                            <AppHeader.Logo/>
                            <AppHeader.Menu/>
                        </div>
                        <div className="devider-color devider-color--onepage"></div>
                    </div>
                </header>
                <main>
                    <div className="search-container start-block">
                        <img
                            src="http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png"/*Insert our logo here  Yopta*/
                            className="search-logo"/>
                        <select className="search-input select-box" multiple="multiple"
                                ref="barcodeSearchTool"></select>
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

    componentDidMount: function () {

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
    render: function () {
        var ContentTable;
        if (this.state.confirm && this.state.shops !== false) {

            ContentTable = <div className="col-sm-9">
                <div className="table-responsive">
                    <CreateList.Confirm list={this.state.shops}/>
                </div>
            </div>
        } else {
            var ConfirmButton;
            if (this.state.confirm) {
                ConfirmButton = <div className="btn-container">
                    <button className="btn btn-lg btn-warning">
                        <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Loading...
                    </button>
                </div>
            } else {
                ConfirmButton = <div className="btn-container btn-container-info">
                    <button className="btn btn-info btn--minimal btn-lg-bordered btn-inverse"
                            onClick={this.handleConfirmList}>Button
                    </button>
                </div>
            }

            ContentTable = <div className="col-sm-9">
                <CreateList.Search/>

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


CreateList.Search = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {
        InitSearchBar(React.findDOMNode(this.refs.barcodeSearchTool));
    },
    componentDidUnMount: function () {
        DestroySearchBar(React.findDOMNode(this.refs.barcodeSearchTool));
    },

    render: function () {
        return (
            <select className="search-input select-box" multiple="multiple"
                    ref="barcodeSearchTool"></select>
        );
    }
});

CreateList.ListTable = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    handleClick: function (i, item, e) {
        this.props.removeListItem(i);
    },
    render: function () {
        console.info(this.props.list);
        return (
            <table className="table table--target table-present">
                <colgroup className="col-large"/>
                <colgroup className="col-small"/>
                {/*<thead>
                 <tr>
                 <th className="table-main">Product Name</th>
                 <th>Remove</th>
                 </tr>
                 </thead>*/}

                <tbody>

                {this.props.list.map(function (result, i) {
                    return (
                        <tr key={result.barcode}>
                            <td>{result.name} ({result.barcode})</td>
                            <td>
                                <button onClick={this.handleClick.bind(this,i,result)} className="btn btn-danger btn-sm"
                                        key={i}>
                                    <i className="fa fa-times"></i> Remove
                                </button>
                            </td>
                        </tr>
                    );
                }, this)}
                </tbody>
            </table>
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
                    <th>#</th>
                    <th>Date</th>
                    <th>Ship to</th>
                    <th>Order Total</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                {/*this.props.list.map(function (result) {
                 return (
                 <tr>
                 <td>100032993</td>
                 <td>05/14/2014</td>
                 <td>John Stewart</td>
                 <td>$ 2 199.00</td>
                 <td className="table__wait"><i
                 className="fa fa-spinner"></i> Pending
                 </td>
                 <td><a className="btn btn-primary btn-sm" href="#">View
                 Order</a></td>
                 </tr>
                 );
                 })*/}
                </tbody>
            </table>
        );
    }
});
