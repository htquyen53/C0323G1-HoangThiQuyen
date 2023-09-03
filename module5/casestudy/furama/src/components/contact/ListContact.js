import { useState, useEffect } from 'react';
import "../../css/listStyle.css";
import { useNavigate } from 'react-router';
import * as contactService from '../../service/ContactService';

function ListContact() {
    const navigate = useNavigate();
    const [contacts, setContacts] = useState();

    const loadContacts = async () => {
        const dataContacts = await contactService.getContacts();
        setContacts(dataContacts);
    }

    useEffect(() => { loadContacts(); }, []);

    if (!contacts) {
        return null;
    }

    return (
        <main className="container">
            <h1>Contracts List</h1>
            <div>
                <button type='button' className='btn btn-outline-dark' onClick={() => {
                    navigate(`/furama/contact-create`)
                }}>Create a new contact</button>
            </div>
            <div className="list">
                <table className='table'>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Start-Day</th>
                            <th>End-Day</th>
                            <th>Deposit</th>
                            <th>Total Payment</th>
                        </tr>
                    </thead>
                    <tbody>
                        {contacts.map((contact) => (
                            <tr key={contact.id}>
                                <td>{contact.id}</td>
                                <td>{contact.startDay}</td>
                                <td>{contact.endDay}</td>
                                <td>{contact.deposit}</td>
                                <td>{contact.totalPayment}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </main >
    )
}
export default ListContact;