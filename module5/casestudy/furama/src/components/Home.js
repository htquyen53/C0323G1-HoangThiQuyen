import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as facilityService from "../service/FacilityService";
import "../css/stylePage.css";

function Home() {
    const navigate = useNavigate();
    const [villas, setVillas] = useState([]);
    const [houses, setHouses] = useState([]);
    const [rooms, setRooms] = useState([]);

    // ------------------------------------Lấy list villa, house, room từ api------------------------------------------
    const loadVillasInfo = async () => {
        const dataVillas = await facilityService.getVillasForHome();
        setVillas(dataVillas);
    }
    const loadHousesInfo = async () => {
        const dataHouses = await facilityService.getHousesForHome();
        setHouses(dataHouses);
    }
    const loadRoomInfo = async () => {
        const dataRooms = await facilityService.getRoomsForHome();
        setRooms(dataRooms);
    }

    
    // ------------------------------------------------- useEffect ---------------------------------------------------
    useEffect(() => {
        loadVillasInfo();
        loadHousesInfo();
        loadRoomInfo();
    }, [])


    // --------------------------------------------------- Return ----------------------------------------------------

    return (
        <main className="grid">
            <img src="https://tadivui.com/wp-content/uploads/2016/05/furama-1.jpg" alt="furama  resort" />
            <div className="welcome">
                <h2>Welcome Furama Resort</h2>
                <p>Overlooking the long stretch of wide white sand on Danang Beach, Furama Resort Danang is a gateway to
                    three World Heritage Sites of Hoi An (20 minutes), My Son (90 minutes) and Hue (2 hours). The 196
                    rooms and suites plus 70 two to four bedroom pool villas feature tasteful décor, designed with
                    traditional Vietnamese style and a touch of French colonial architecture and guarantee the Vietnam’s
                    the most prestigious resort -counting royalty, presidents, movie stars and international business
                    leaders among its celebrity guests.</p>
            </div>
            <h2>Our Services</h2>

            <h3>- Villas -</h3>
            {
                villas.map((villa, index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                            <img src={villa.imgPath}
                                alt="" />
                            <h3>{villa.name}</h3>
                            <p>Price: {villa.price}</p>
                            <Link><button className="btn btn-outline-warning">Book</button></Link>
                        </div>
                    )
                })
            }

            <h3>- Houses -</h3>
            {
                houses.map((house, index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                            <img src={house.imgPath}
                                alt="" />
                            <h3>{house.name}</h3>
                            <p>Price: {house.price}</p>
                            <Link><button className="btn btn-outline-warning">Book</button></Link>
                        </div>
                    )
                })
            }
            
            <h3>- Rooms -</h3>
            {
                rooms.map((room, index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                            <img src={room.imgPath  }
                                alt="" />
                            <h3>{room.name}</h3>
                            <p>Price: {room.price}</p>
                            <Link><button className="btn btn-outline-warning">Book</button></Link>
                        </div>
                    )
                })
            }
        </main>
    )
}
export default Home;