var AppHeader = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {
        animateHeader();
    },

    render: function () {
        return (
            <header className="header header--light">
                <div className="header-fixed">
                    <AppHeader.Line/>

                    <div className="fixed-top header-down">
                        <AppHeader.Container/>

                    </div>
                </div>
                <div className="devider-color"></div>
            </header>
        );
    }
});

AppHeader.Line = React.createClass({
    render: function () {
        return (
            <div className="header-line waypoint" data-animate-down="header-up" data-animate-up="header-down">
                <div className="container">
                    {/*                    <address className="contact-info pull-left hidden-lower">
                     <span className="contact-info__item">
                     <i className="fa fa-location-arrow"></i>
                     101 West Street, New York, NY 12345
                     </span>
                     <span className="contact-info__item">
                     <i className="fa fa-mobile"></i>
                     +1 - 888 - 555 - 5555
                     </span>
                     <span className="contact-info__item">
                     <i className="fa fa-envelope"></i>
                     info@allec.com
                     </span>
                     </address>


                     <form className="search pull-right" id="search-form" name="search-form" method="get" action="#">
                     <input className="search__field" name="search-request" type="search" placeholder="search"
                     value=""/>
                     <button className="search__btn" type="submit">
                     <i className="fa fa-search"></i>
                     </button>
                     </form>*/}
                </div>
            </div>
        );
    }
});
AppHeader.Container = React.createClass({
    render: function () {
        return (
            <div className="container">
                <AppHeader.Logo/>

                <AppHeader.Menu/>
            </div>
        )
    }
});

AppHeader.Menu = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    render: function () {
        return (
            <nav className="z-nav">
                <a href="#" className="z-nav__toggle">
                    <span className="menu-icon"></span>
                    <span className="menu-text">navigation</span>

                    <div className="menu-head"></div>
                </a>

                <div className="z-nav-inner">
                    <ul className="z-nav__list">
                        <li className="z-nav__item">
                            <a className="z-nav__link z-nav__link--simple" href="#">Home</a>
                        </li>

                        <li className="z-nav__item">
                            <a className="z-nav__link z-nav__link--simple" href="#create-list">Create Basket</a>
                        </li>

                        <li className="z-nav__item">
                            <a className="z-nav__link z-nav__link--simple" href="#map">Map</a>
                        </li>
                    </ul>
                </div>

            </nav>
        );
    }
});


AppHeader.Logo = React.createClass({
    render: function () {
        return (
            <a className="logo" href="#">
                <img src="images/logo_v1.png" alt="Pay Less"/>
                    {/*<h1 className="logo__text">Pay<span className="highlight">Less</span><br/>
                    <span className="logo__slogan">buy more</span>
                </h1>*/}
            </a>
        );
    }
});


var AppBreadcrumb = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    render: function () {

        var links = [];

        {
            /*<section className="page-indecator">
             <div className="container">
             <h2 className="heading">Headers</h2>

             <ol className="breadcrumb">
             <li><a href="index.html">Home</a></li>
             <li className="active">Headers</li>
             </ol>

             <div className="devider devider--bottom-sm"></div>
             </div>
             </section>*/
        }
        return (
            <div></div>
        );
    }
});

var AppSidebar = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    render: function () {
        return (
            <aside className="col-sm-3">
                <div className="sidebar">

                </div>
            </aside>
        );
    }
});


var AppFooter = React.createClass({
    getInitialState: function () {
        return {};
    },

    componentDidMount: function () {

    },

    render: function () {
        return (
            <footer className="footer footer--light footer--cut">
                <div className="container">
                    <div className="copy">
                        &copy; <a href="index.html">PayLess, 2015.</a> All rights reserved.
                    </div>
                </div>
            </footer>
        );
    }
});


var SearchBar = React.createClass({
    getDefaultProps: function () {
        return {
            'custom-class-names': [],
            headerCallbackHandle: null,
            searchTemplate: function () {

            }
        }
    },

    handleSearchItemClick: function (barcode, e) {
        if (this.props.headerCallbackHandle !== null) {
            e.preventDefault();
            this.props.headerCallbackHandle(barcode)
        }
    },
    componentDidMount: function () {
        InitSearchBar(React.findDOMNode(this.refs.barcodeSearchTool), this.props.searchTemplate);
    },
    componentWillUnmount: function () {
        DestroySearchBar(React.findDOMNode(this.refs.barcodeSearchTool));
    },

    render: function () {
        return (
            <select className={'search-input '+this.props['custom-class-names']} multiple="multiple"
                    ref="barcodeSearchTool"></select>
        );
    }
});


var AppAbout = React.createClass({
    render: function () {
        return (
            <div className="container">
                <div className="row">
                </div>
            </div>
        );
    }
});

SearchBar.IndexTemplate = React.createClass({
    render: function () {
        var data = this.props.data;
        return (
            <a href={'#product/' + data.barcode}>{data.name} ({data.barcode})</a>
        );
    }
});

SearchBar.CreateListTemplate = React.createClass({
    handleItemClick: function (data, e) {
        e.preventDefault;
        console.log(this);
    },
    render: function () {
        var data = this.props.data;
        return (
            <a href={'#product/' + data.barcode} onClick={this.handleItemClick.bind(this,data)}>{data.name}
                ({data.barcode})</a>
        );
    }
});
