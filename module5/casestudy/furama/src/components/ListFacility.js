import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as facilityService from "../service/FacilityService";
import Modal from "./Modal";

function ListFacility() {
    const navigate = useNavigate();
    const [villas, setVillas] = useState([]);
    const [houses, setHouses] = useState([]);
    const [rooms, setRooms] = useState([]);
    const [modalDate, setModalData] = useState({
        show: false,
        data: null
    });

    // Lấy list villa, house, room từ api
    const loadVillasInfo = async () => {
        const dataVillas = await facilityService.getVillas();
        setVillas(dataVillas);
    }
    const loadHousesInfo = async () => {
        const dataHouses = await facilityService.getHouses();
        setHouses(dataHouses);
    }
    const loadRoomInfo = async () => {
        const dataRooms = await facilityService.getRooms();
        setRooms(dataRooms);
    }

    useEffect (()=> {
        loadVillasInfo();
        loadHousesInfo();
        loadRoomInfo();
    },[])
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
            <h3>Villas</h3>
            {
                villas.map((villa,index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                        <img src="https://i0.wp.com/vietnamtravel.in/wp-content/uploads/2019/07/furama-resort-danang-2-2.jpg?resize=1260%2C844&ssl=1"
                            alt="" />
                        <h3>{villa.name}</h3>
                        <p>Price: {villa.price}</p>
                        <button type="button">!</button>
                        <button type="button">x</button>
                        <a href="#">More...</a>
                    </div>
                    )
                })
            }
            <h3>Houses</h3>
            {
                houses.map((house,index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                        <img src="https://i0.wp.com/vietnamtravel.in/wp-content/uploads/2019/07/furama-resort-danang-2-2.jpg?resize=1260%2C844&ssl=1"
                            alt="" />
                        <h3>{house.name}</h3>
                        <p>Price: {house.price}</p>
                        <a href="#">More...</a>
                    </div>
                    )
                })
            }
            <h3>Rooms</h3>
            {
                rooms.map((room,index) => {
                    return (
                        <div key={`p_${index}`} className="card">
                        <img src="https://i0.wp.com/vietnamtravel.in/wp-content/uploads/2019/07/furama-resort-danang-2-2.jpg?resize=1260%2C844&ssl=1"
                            alt="" />
                        <h3>{room.name}</h3>
                        <p>Price: {room.price}</p>
                        <a href="#">More...</a>
                    </div>
                    )
                })
            }
        </main>
    )
}
export default ListFacility;