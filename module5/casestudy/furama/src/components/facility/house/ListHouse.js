import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import * as houseService from "../../../service/FacilityService";
import ReactPaginate from "react-paginate";
import "../../../css/listStyle.css";
import Modal from "../../common/Modal";

function ListHouse() {
    const [houses, setHouses] = useState([]);
    const navigate = useNavigate();
    const [pageCount, setPageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchName, setSearchName] = useState("");
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })

    let limit = 5;

    const loadHouseInfo = async (currentPage, limit, searchName) => {
        const dataHouses = await houseService.getHouses(currentPage, limit, searchName);
        const total = dataHouses.headers['x-total-count'];
        setPageCount(Math.ceil(total / limit));
        setHouses(dataHouses.data);
    }

    const handelPageClick = (data) => {
        let numberPage = data.selected + 1;
        setCurrentPage(numberPage);
    }
    const handleDelete = async (id) => {
        await houseService.deleteHouse(id);
        loadHouseInfo(currentPage, limit, searchName);
        handleCloseModal();
    }
    const handleCloseModal = () => {
        setModalData({
            show: false,
            data: null
        })
    }
    const handleEnter = async (event) => {
        if (event.key === `Enter`) {
            setSearchName(event.target.value);
            const result = await houseService.getHouses(1, limit, searchName);
            if (result.data.length === 0) {
                setSearchName("");
            }
        }
    }

    useEffect(() => {
        loadHouseInfo(currentPage, limit, searchName);
    }, [currentPage, limit, searchName])

    return (
        <main className="grid">
            <h3>- Houses -</h3>
            <div className="list">
                <div className="searchBar">
                    <input type="text" placeholder="Search..." value={searchName}
                        onChange={(event) => { setSearchName(event.target.value) }}
                        onKeyDown={(event) => { handleEnter(event) }} />
                </div>
                <table className="table table-hover">
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
                            houses.map((house) => (
                                <tr key={house?.id}>
                                    <td>{house?.id}</td>
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
                        msg={`Do you want to delete the House: ${modalData.data.name}?`}
                        onClose={handleCloseModal}
                        onConfirm={() => handleDelete(modalData.data.id)}
                    ></Modal>
                )
            }
        </main>
    )
}
export default ListHouse;