import { useNavigate, Link } from 'react-router';
import { useState, useEffect } from 'react';
import * as customerService from '../../service/CustomerService';
import "../../css/listStyle.css";
import Modal from '../common/Modal';
import ReactPaginate from 'react-paginate';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import date from 'date-and-time';

function ListCustomer() {
    const navigate = useNavigate();
    const [customers, setCustomers] = useState();
    const [pageCount, setPageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchItem, setSearchItem] = useState("");
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })
    let limit = 5;

    // const loadCustomers = async () => {
    //     const dataCustomers = await customerService.getCustomers();
    //     setCustomers(dataCustomers);
    // }

    const getCustomerList = async (currentPage, limit, searchItem) => {
        const res = await customerService.getCustomersData(currentPage, limit, searchItem);
        const totalPage = res.headers['x-total-count'];
        // console.log(JSON.stringify(res.headers))
        setPageCount(Math.ceil(totalPage / limit));
        setCustomers(res.data);
    }

    const handlePageClick = (data) => {
        let numberPage = data.selected + 1;
        setCurrentPage(numberPage);
    }
    const handleEnter = async (event) => {
        if (event.key === `Enter`) {
            setSearchItem(event.target.value)
            const result = await customerService.getCustomersData(1, limit, searchItem);
            // console.log("result length: " + result.data.length)
            if (result.data.length === 0) {
                // alert("Your search item is not exist");
                setSearchItem("");
                // getCustomerList(currentPage,limit,searchItem);
            }
        }
    }
    const handleCloseModal = () => {
        setModalData({ show: false, data: null })
    }
    const handleDeleteCustomer = async (id) => {
        const res = await customerService.deleteCustomer(id);
        if (res.status === 200) {
            toast.success(`Delete the customer ${modalData.data.name} successful!`, {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
            await getCustomerList(currentPage, limit, searchItem);
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
  
    useEffect(() => {
        // loadCustomers();
        getCustomerList(currentPage, limit, searchItem);
    }, [currentPage, limit, searchItem])

    if (!customers) {
        return null;
    }

    return (
        <main className="grid">
            <div className="list">
                <h1>Customer List</h1>
                <div>
                    <button type='button' className='btn btn-outline-dark'
                        onClick={() => { navigate(`/furama/customer-create`) }}>Create a new customer</button>
                    <input type='text' placeholder='Search...' value={searchItem}
                        onChange={(event) => { setSearchItem(event.target.value) }}
                        onKeyDown={(event) => { handleEnter(event) }} />
                </div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Full Name</th>
                            <th>Birthday</th>
                            <th>Gender</th>
                            <th>CitizenID</th>
                            <th>Numberphone</th>
                            <th>Email</th>
                            <th>Type of Customer</th>
                            <th>Address</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {customers.map((customer) => (
                            <tr key={customer?.id}>
                                <td>{customer?.id}</td>
                                <td>{customer?.name}</td>
                                <td>{date.format(new Date(customer?.birthday),'DD/MM/YYYY')}</td>
                                <td>{customer?.gender}</td>
                                <td>{customer?.citizenId}</td>
                                <td>{customer?.numberphone}</td>
                                <td>{customer?.email}</td>
                                <td>{customer?.typeOfCustomer}</td>
                                <td>{customer?.address}</td>
                                <td>
                                    <button type="button" className='btn btn-secondary' onClick={() => {
                                        navigate(`/furama/customers/${customer.id}`)
                                    }}>Detail</button>
                                    <button type="button" className='btn btn-secondary' onClick={() => {
                                        navigate(`/furama/${customer.id}/customer-edit`)
                                    }}>Edit</button>
                                    <button type="button" className='btn btn-secondary' onClick={() => {
                                        setModalData({ show: true, data: customer })
                                    }} >Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
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
                <div className='paginate'>
                    <ReactPaginate
                        previousLabel={'Previous'}
                        nextLabel={'Next'}
                        breakLabel={'...'}
                        pageCount={pageCount}
                        marginPagesDisplayed={2}
                        pageRangeDisplayed={3}
                        onPageChange={handlePageClick}
                        containerClassName={'pagination justify-content-center'}
                        pageClassName={'page-item'}
                        pageLinkClassName={'page-link'}
                        previousClassName={'page-item'}
                        nextClassName={'page-item'}
                        previousLinkClassName={'page-link'}
                        nextLinkClassName={'page-link'}
                        activeClassName={'active'}
                    />
                </div>
            </div>
            {
                modalData.show && (
                    <Modal title={'Delete customer confirmation'}
                        msg={`Do you want to delethe the customer: ${modalData.data.name} ?`}
                        onClose={handleCloseModal}
                        onConfirm={()=> handleDeleteCustomer(modalData.data.id)} />

                )
            }
        </main>
    )
}
export default ListCustomer;