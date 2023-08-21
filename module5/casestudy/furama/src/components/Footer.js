import { Component } from "react";
class Footer extends Component {
    render() {
        return (
            <footer className="grid">
            <div class="footer-content">
                <p>The luxurious Furama Resort Danang is a true icon of Vietnam tourism. This 5-star haven on
                    world-famous Da Nang beach is celebrated as Vietnam's most prestigious resort – counting royalty,
                    presidents, movie stars and international business leaders among its celebrity guests.</p>
            </div>
            <div className="footer-contact">
                <h4>CONTACT US</h4>
                <ul>
                    <li><i className="fas fa-phone-square-alt"></i> 0123456789</li>
                    <li><i className="fas fa-envelope"></i> furama@gmai.com</li>
                    <li><i className="fas fa-map-marker"></i> Ngu Hanh Son, Da Nang City</li>
                </ul>
            </div>
            <div className="social-link">
                <h4>FOLLOW US</h4>
                <a href="#"><i className="fab fa-facebook-f"></i></a>
                <a href="#"><i className="fab fa-instagram"></i></a>
                <a href="#"><i className="fab fa-twitter"></i></a>
                <a href="#"><i className="fab fa-linkedin-in"></i></a>
            </div >
        </footer >
        )
    }
}
export default Footer;