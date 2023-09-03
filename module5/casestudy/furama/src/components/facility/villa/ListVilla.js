import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import * as villaService from "../../../service/FacilityService";
import ReactPaginate from "react-paginate";
import Modal from "../../common/Modal";
import "../../../css/listStyle.css";

function ListVilla() {
    const navigate = useNavigate();
    const [villas, setVillas] = useState([]);
    const [pageCount, setPageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchName, setSearchName] = useState("");
    let limit = 5;
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })

    const loadVillasInfo = async (currentPage, limit, searchName) => {
        const res = await villaService.getVillas(currentPage, limit, searchName);
        const total = res.headers['x-total-count'];
        setPageCount(Math.ceil(total / limit));
        setVillas(res.data);
    }
    const handelPageClick = (data) => {
        let numberPage = data.selected + 1;
        setCurrentPage(numberPage);
    }
    const handleEnter = async (event) => {
        if (event.key === `Enter`) {
            setSearchName(event.target.value);
            const result = await villaService.getVillas(1, limit, searchName);
            if (result.data.length === 0) {
                setSearchName("");

            }
        }
    }
    const handleCloseModal = () => {
        setModalData({
            show: false,
            data: null
        })
    }

    const handleDelete = async (id) => {
        await villaService.deleteVilla(id);
        loadVillasInfo(currentPage, limit, searchName);
        handleCloseModal();
    }

    useEffect(() => {
        loadVillasInfo(currentPage, limit, searchName);
    }, [currentPage, limit, searchName]);

    if (!villas) {
        return null;
    }

    return (
        <main className="grid">
            <div className="list">
                <h3>- Villas List -</h3>
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
                                <th>Room Standard</th>
                                <th>Pool Area</th>
                                <th>Floor</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                villas.map((villa) => (
                                    <tr key={villa.id}>
                                        <td>{villa.id}</td>
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
                                                    data: villa
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
            </div>
            {
                modalData.show && (
                    <Modal title={'Delete Facility Confimation'}
                        msg={`Do you want to delete the villa: ${modalData.data.name}?`}
                        onClose={handleCloseModal}
                        onConfirm={handleDelete(modalData.data.id)}
                    ></Modal>
                )
            }
        </main>
    )
}
export default ListVilla;