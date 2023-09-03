import { useNavigate, Link } from 'react-router';
import { useState, useEffect } from 'react';
import * as customerService from '../../service/CustomerService';
import "../../css/listStyle.css";
import Modal from '../common/Modal';
import ReactPaginate from 'react-paginate';

function ListCustomer() {
    const navigate = useNavigate();
    const [customers, setCustomers] = useState();
    const [pageCount, setPageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(1);
    const [searchItem, setSearchItem] = useState("");
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
                                <td>{customer?.birthday}</td>
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
                                    <button type="button" className='btn btn-secondary'>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
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
        </main>
    )
}
export default ListCustomer;