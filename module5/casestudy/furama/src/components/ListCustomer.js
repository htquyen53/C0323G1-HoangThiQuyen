import { useNavigate, Link } from 'react-router';
import { useState, useEffect } from 'react';
import * as customerService from '../service/CustomerService';
import "../css/listStyle.css";
import Modal from './Modal';

function ListCustomer() {
    const navigate = useNavigate();
    const [customers, setCustomers] = useState();

    const loadCustomers = async () => {
        const dataCustomers = await customerService.getCustomers();
        setCustomers(dataCustomers);
    }

    useEffect(() => {
        loadCustomers();
    }, [])
    
    if (!customers) {
        return null;
    }

    return (
        <main className="grid">
            <div className="list">
                <h1>Customer List</h1>
                <div>
                    <button type='button' className='btn btn-outline-dark' onClick={()=>{
                        navigate(`/furama/customer-create`)
                    }}>Create a new customer</button>
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
                                    <button type="button" className='btn btn-secondary' onClick={()=>{
                                        navigate(`/furama/customers/${customer.id}`)
                                    }}>Detail</button>
                                    <button type="button" className='btn btn-secondary' onClick={()=> {
                                        navigate(`/furama/${customer.id}/customer-edit`)
                                    }}>Edit</button>
                                    <button type="button" className='btn btn-secondary'>Delete</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div >
        </main >
    )
}
export default ListCustomer;