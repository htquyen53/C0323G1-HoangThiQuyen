import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as facilityService from "../service/FacilityService";
import Modal from "./Modal";
import "../css/listStyle.css";

function ListFacility() {
    const navigate = useNavigate();
    const [villas, setVillas] = useState([]);
    const [houses, setHouses] = useState([]);
    const [rooms, setRooms] = useState([]);
    const [modalData, setModalData] = useState({
        show: false,
        data: null,
        facilityType: " "
    });

    // ------------------------------------Lấy list villa, house, room từ api------------------------------------------
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

    // --------------------------------------------------Delete modal--------------------------------------------------

    const handleDelete = async (id, type) => {
        console.log(type);
        switch (type) {
            case "villa":
                await facilityService.deleteVilla(id);
                loadVillasInfo();
                break;
            case "house":
                await facilityService.deleteHouse(id);
                loadHousesInfo();
                break;
            case "room":
                await facilityService.deleteRoom(id);
                loadRoomInfo();
                break;
            default:
                alert("Not found!");
        }
        handleCloseModal();
    }
    const handleCloseModal = () => {
        setModalData({ show: false, data: null, facilitytype: "" })
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
            <h2>Our Services</h2>
            <div>
                <button type='button' className='btn btn-outline-dark' onClick={() => {
                    navigate(`/furama/facility-create`)
                }}>Create a new Facility</button>
            </div>
            <h3>- Villas -</h3>
            <div className="list">
                <table className="table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Usable Area</th>
                            <th>Price</th>
                            <th>Max Quantity</th>
                            <th>Rental Type</th>
                            <th>Room Standard</th>
                            <th>Pool Area</th>
                            <th>Floor</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            villas.map((villa, index) => (
                                <tr key={index}>
                                    <td>{index+1}</td>
                                    <td>{villa?.name}</td>
                                    <td>{villa?.usableArea}</td>
                                    <td>{villa?.price}</td>
                                    <td>{villa?.maxQuantity}</td>
                                    <td>{villa?.rentalType}</td>
                                    <td>{villa?.roomStandard}</td>
                                    <td>{villa?.poolArea}</td>
                                    <td>{villa?.floor}</td>
                                    <td>
                                        <button className="btn btn-secondary" type="button" onClick={() => {
                                            navigate(`/furama/facility/${villa.id}/edit-villa/`)
                                        }}>Edit</button>
                                        <button className="btn btn-secondary" type="button"
                                            onClick={() => setModalData({
                                                show: true,
                                                data: villa,
                                                facilityType: "villa"
                                            })}>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
            <h3>- Houses -</h3>
            <div className="list">
                <table className="table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Usable Area</th>
                            <th>Price</th>
                            <th>Max Quantity</th>
                            <th>Rental Type</th>
                            <th>Room Standard</th>
                            <th>Floor</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            houses.map((house, index) => (
                                <tr key={index}>
                                    <td>{index+1}</td>
                                    <td>{house?.name}</td>
                                    <td>{house?.usableArea}</td>
                                    <td>{house?.price}</td>
                                    <td>{house?.maxQuantity}</td>
                                    <td>{house?.rentalType}</td>
                                    <td>{house?.roomStandard}</td>
                                    <td>{house?.floor}</td>
                                    <td>
                                        <button className="btn btn-secondary" type="button" onClick={() => {
                                            navigate(`/furama/facility/${house.id}/edit-house/`)
                                        }}>Edit</button>
                                        <button className="btn btn-secondary" type="button" onClick={() => setModalData({
                                            show: true,
                                            data: house,
                                            facilityType: "house"
                                        })}>Delete</button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>

            <h3>- Rooms -</h3>
            <div className="list">
                <table className="table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Usable Area</th>
                            <th>Price</th>
                            <th>Max Quantity</th>
                            <th>Rental Type</th>
                            <th>Free Service</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            rooms.map((room, index) => (
                                <tr key={index}>
                                    <td>{index+1}</td>
                                    <td>{room?.name}</td>
                                    <td>{room?.usableArea}</td>
                                    <td>{room?.price}</td>
                                    <td>{room?.maxQuantity}</td>
                                    <td>{room?.rentalType}</td>
                                    <td>{room?.freeService}</td>
                                    <td>
                                        <button className="btn btn-secondary" type="button" onClick={() => {
                                            navigate(`/furama/facility/${room.id}/edit-room/`)
                                        }}>Edit</button>
                                        <button className="btn btn-secondary" type="button"
                                            onClick={() => setModalData({
                                                show: true,
                                                data: room,
                                                facilityType: "room"
                                            })}>Delete</button>
                                    </td>

                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>

            {
                modalData.show && (
                    <Modal title={'Delete Facility Confimation'}
                        msg={`Do you want to delete the Facility: ${modalData.data.name}?`}
                        onClose={handleCloseModal}
                        onConfirm={() => handleDelete(modalData.data.id, modalData.facilityType)}
                    ></Modal>
                )
            }
        </main>
    )
}
export default ListFacility;