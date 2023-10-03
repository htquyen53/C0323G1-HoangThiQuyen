import { useNavigate, Link } from 'react-router';
import { useState, useEffect } from 'react';
import * as roomService from '../service/GymRoomService';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Modal from '../components/Modal';
// import date from 'date-and-time';

function GymRoomList() {
    const navigate = useNavigate();
    const [gymRooms, setGymRooms] = useState();
    const [page, setPage] = useState(0);
    const [totalPage, setTotalPage] = useState(0);
    const [roomName, setRoomName] = useState("");
    const [managerName, setManagerName] = useState("");
    const [optionSearch, setOptionSearch] = useState();
    const [searchValue, setSearchValue] = useState("");
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })
    const [managers, setManagers] = useState([]);

    const loadingManagerList = async () => {
        const result = await roomService.getManagers();
        if(result?.status===200) {
            setManagers(result.data.content)
        }
    }

    // ------------------- Load GymRoom --------------------
    const loadGymRooms = async (roomName, managerName, page) => {
        const result = await roomService.getAllGymRoom(roomName, managerName, page);
        console.log(result);
        if (result?.status === 200) {
            setGymRooms(result?.data.content);
            setTotalPage(result?.data.totalPages);
        } else {
            toast.error('Dữ liệu không tồn tại', {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        }
    }
    // ----------------------------------------------------------- Pagination ---------------------------------------------
    const previousPage = () => {
        if (page > 0) {
            setPage((pre) => pre - 1)
        }
    }

    const nextPage = () => {
        if (page + 1 < totalPage) {
            setPage((pre) => pre + 1)
        }
    }
    const handleKeyDown = event => {
        if (event.key === 'Enter') {
            handleSearchEvent();
        }
    }
    const handleSearchEvent = () => {
        if (optionSearch == 0) {
            setGymRooms(searchValue);
            console.log("Aaaa"+searchValue);
        } else {
            setManagerName(searchValue);
        }
    }
    // ------------------------------------------------------  Searching function -----------------------------------------
    const handleInputChange = (e) => {
        const { value } = e.target
        setSearchValue(value.trim());
    }
    const handleOptionSearchChange = (e) => {
        const { value } = e.target;
        setOptionSearch(+value);
        setSearchValue(document.getElementById("search").value);
    }
    // Xóa
    const handleDeleteRoom = async (id) => {
        const res = await roomService.deleteGymRoom(id);
        if (res.status === 200) {
            toast.success(`Xóa cơ sở ${modalData.data.name} successful!`, {
                position: "top-center",
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
            await roomService.getAllGymRoom(roomName, managerName, page);
            handleCloseModal();
        }
        else {
            toast.error('Delete failed!', {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        }
    }
    const handleCloseModal = () => {
        setModalData({ show: false, data: null })
    }
    // --------------------------------------------------------------Use Effect ----------------------------------------------------
    useEffect(() => {
        loadingManagerList();
        loadGymRooms(roomName, managerName, page);
    }, [roomName, managerName, page]);

    if (!gymRooms) {
        return <div></div>;
    }
    return (
        <div className="container">
            <h1 style={{ textAlign: "center", color: "#0d6efd" }} className="m-4">
                DANH SÁCH CƠ SỞ CG FITNESS
            </h1>
            <div className="row m-3" style={{ display: "flex" }}>
                <div className="col-12 col-search">
                    <label className="m-1"> </label>
                    <div className="btn-group">
                        <select name='optionSearch' defaultValue={0} onChange={handleOptionSearchChange} className="form-select m-1" style={{ width: 200 }}>
                            <option value={0}>Tên cơ sở</option>
                            <option value={1}>Người quản lý</option>
                        </select>
                        <div>
                            {optionSearch === 1 && <select className="form-select m-1" style={{ width: 160 }} name="groupValue" >
                               {managers.map((manager)=>{
                                <option value={manager?.id}>{manager.name}</option>
                               })}
                            </select>}
                        </div>
                    </div>
                    <input style={{
                        width: 250,
                        borderRadius: 5,
                        padding: 5,
                        border: "1px black solid"
                    }}
                        placeholder={"Nhập tên tìm kiếm..."}
                        className="bg-white align-middle appearance-none m-1"
                        aria-describedby="button-addon"
                        id="search"
                        onKeyDown={handleKeyDown}
                        onChange={handleInputChange}
                    />
                    <button onClick={()=>{handleSearchEvent()}}
                        className="btn btn-outline-primary"
                        style={{ marginRight: "auto", width: "auto", marginLeft: 5 }}
                        id="button-addon">
                        <i className="fa-solid fa-magnifying-glass" /> Tìm kiếm
                    </button>
                </div>
            </div>

            <div className="d-inline-block w-100 shadow rounded-lg overflow-hidden">
                <table
                    className="table table-hover w-100 leading-normal overflow-hidden rounded-3 m-0"
                    id="myTable"
                >
                    <thead>
                        <tr
                            style={{ background: "#0d6efd", color: "#ffffff", height: 50 }}
                        >
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 50 }}>
                                STT
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 190 }}>
                                Mã cơ sở
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 270 }}>
                                Tên cơ sở
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 150 }}>
                                Ngày khai trương
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 270 }}>
                                Địa chỉ
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 170 }}>
                                Người quản lý
                            </th>
                            <th className="px-3 py-3 border-b-2 text-left text-xs uppercase tracking-wider" style={{ width: 170 }}>
                                Chức năng
                            </th>
                        </tr>
                    </thead>
                    {gymRooms && gymRooms.length !== 0 ?
                        <tbody className="bg-light">
                            {gymRooms?.map((room, index) => (
                                <tr key={index} id={index}>
                                    <td className="px-3 py-3 border-b border-gray-200 text-sm">
                                        {index + 1}
                                    </td>
                                    <td className="px-3 py-3 border-b border-gray-200 text-sm">
                                        {room?.code}
                                    </td>
                                    <td className="px-3 py-3 border-b border-gray-200 text-sm">
                                        {room?.name}
                                    </td>
                                    <td className="px-3 py-3 border-b border-gray-200  text-sm">
                                        {room?.startDate}
                                    </td>
                                    <td className="px-3 py-3 border-b border-gray-200 text-sm">
                                        {room?.address}
                                    </td>
                                    <td className="px-3 py-3 border-b border-gray-200 text-sm">
                                        {room?.manager}
                                    </td>
                                    <td>
                                        <button type="button" className='btn btn-secondary' onClick={() => {
                                            setModalData({ show: true, data: room })
                                        }} >Delete</button>
                                    </td>
                                </tr>
                            ))}
                        </tbody> :
                        <tbody>
                            <tr style={{ height: '150px' }}>
                                <td style={{ fontSize: '30px', textAlign: 'center' }} colSpan="8">Không có dữ
                                    liệu
                                </td>
                            </tr>
                        </tbody>
                    }
                </table>
                <ToastContainer
                    position="top-center"
                    autoClose={5000}
                    hideProgressBar={false}
                    newestOnTop={false}
                    closeOnClick
                    rtl={false}
                    pauseOnFocusLoss
                    draggable
                    pauseOnHover
                    theme="light"
                />
                <div className="px-5 py-3 bg-white border-t flex flex-col xs:flex-row items-center xs:justify-between">
                    <div className="justify-content-center d-flex">
                        <button className="btn btn-primary" style={{ margin: 5 }} onClick={() => previousPage()} href="#">
                            Previous
                        </button>
                        <div
                            className="text-sm py-2 px-4"
                            style={{
                                background: "#0d6efd",
                                color: "#ffffff",
                                margin: 5,
                                borderRadius: 5,
                            }}>
                            <span>{page + 1}/{totalPage}</span>
                        </div>
                        <button className="btn btn-primary" style={{ margin: 5 }} onClick={() => nextPage()} href="#"> Next
                        </button>
                        <div
                            className="rounded-lg"
                            style={{
                                background: "#0d6efd",
                                color: "black",
                                margin: 5,
                                borderRadius: 5,
                            }}>
                        </div>
                    </div>
                </div>
            </div>
            {
                modalData.show && (
                    <Modal title={'Delete confirmation'}
                        msg={`Bạn có muốn xóa cơ sở: ${modalData.data.name} ?`}
                        onClose={handleCloseModal}
                        onConfirm={() => handleDeleteRoom(modalData.data.id)} />

                )
            }
        </div >
    )
}
export default GymRoomList;