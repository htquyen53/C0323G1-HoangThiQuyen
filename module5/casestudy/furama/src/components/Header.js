import { Component } from "react";
import { Link } from "react-router-dom";
import "../css/stylePage.css";
class Header extends Component {
    render() {
        return (
            <header class="grid">
                <div className="title">
                    <h1>Furama</h1>
                    <h5>- HOTEL RESORT -</h5>
                </div>
                <nav>
                    <ul>
                        <li><Link to="/furama">Home</Link></li>
                        <li><Link>Management</Link>
                            <ul className="dropdown">
                                <li><Link to="/furama/facilities">Facility</Link></li>
                                <li><Link to="/furama/customers">Customer</Link></li>
                                <li><Link to="/furama/contacts">Contact</Link></li>
                            </ul>
                        </li>
                        <li><Link>About us</Link></li>
                        <li><Link>Contact</Link></li>
                        <li><Link className="elementor-button">BOOK NOW</Link></li>
                    </ul>
                </nav>
            </header >
        )
    }
}
export default Header;