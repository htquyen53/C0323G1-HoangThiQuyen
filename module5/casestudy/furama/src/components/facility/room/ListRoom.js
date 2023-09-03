import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import ReactPaginate from "react-paginate";
import * as roomService from "../../../service/FacilityService";
import "../../../css/listStyle.css";
import Modal from "../../common/Modal";

function ListRoom() {
    const navigate = useNavigate();
    const [rooms, setRooms] = useState([]);
    const [pageCount, setPageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchName, setSearchName] = useState("");
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })
    let limit = 5;

    const loadRoomInfo = async (currentPage, limit, searchName) => {
        const dataRooms = await roomService.getRooms(currentPage, limit, searchName);
        const total = dataRooms.headers['x-total-count'];
        setPageCount(Math.ceil(total / limit));
        setRooms(dataRooms.data);
    }

    const handelPageClick = (data) => {
        let numberPage = data.selected + 1;
        setCurrentPage(numberPage);
    }

    const handleDelete = async (id) => {
        await roomService.deleteRoom(id);
        loadRoomInfo();
        handleCloseModal();
    }
    const handleCloseModal = () => {
        setModalData({ show: false, data: null });
    }
    const handleEnter = async (event) => {
        if (event.key === `Enter`) {
            setSearchName(event.target.value);
            const result = await roomService.getRooms(1, limit, searchName);
            if (result.data.length === 0) {
                setSearchName("");
            }
        }
    }

    useEffect(() => {
        loadRoomInfo(currentPage, limit, searchName);
    }, [currentPage, limit, searchName]);

    if (!rooms) {
        return <></>;
    }
    return (
        <main>
            <h3>- Rooms -</h3>
            <div className="list">
                <div className="searchBar">
                    <input type="text" value={searchName} id="searchName" placeholder="Search..."
                        onChange={(event) => { setSearchName(event.target.value) }}
                        onKeyDown={(event) => { handleEnter(event) }} />
                </div>
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
                            rooms.map((room) => (
                                <tr key={room?.id}>
                                    <td>{room?.id}</td>
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
                <div className="paginate">
                    <ReactPaginate
                        previousLabel={'Previous'}
                        nextLabel={'Next'}
                        breakLabel={'...'}
                        pageCount={pageCount}
                        marginPagesDisplayed={2}
                        pageRangeDisplayed={3}
                        onPageChange={handelPageClick}
                        containerClassName={"pagination justify-content-center"}
                        pageLinkClassName={"page-link"}
                        pageClassName={"page-item"}
                        previousClassName={"page-item"}
                        nextClassName={"page-item"}
                        previousLinkClassName={"page-link"}
                        nextLinkClassName={"page-link"}
                        activeClassName={"active"}
                    />
                </div>
            </div>
            {
                modalData.show && (
                    <Modal title={'Delete Facility Confimation'}
                        msg={`Do you want to delete the Room: ${modalData.data.name}?`}
                        onClose={handleCloseModal}
                        onConfirm={handleDelete(modalData.data.id)}
                    ></Modal>
                )
            }
        </main>
    )
}
export default ListRoom;