import { Component } from "react";
class Header extends Component {
    render() {
        return (
            <header class="grid">
                <div className="title">
                    <h1>Furama</h1>
                    <h5>- HOTEL RESORT -</h5>
                </div>
                <nav>
                    <a href="#">Home</a>
                    <a className="dropdown" href="javascript:void(0)">Services</a>
                    <div className="dropdown-content">
                        <a href="#">Villas</a>
                        <a href="#">Houses</a>
                        <a href="#">Rooms</a>
                        <a href="#">Others</a>
                    </div>
                    <a href="#">Ahout us</a>
                    <a href="#">Contact</a>
                    <div className="elementor-button"><a href="#">BOOK NOW</a></div>
                </nav>
            </header>
        )
    }
}
export default Header;