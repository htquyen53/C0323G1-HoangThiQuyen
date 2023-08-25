import { Link } from 'react-router-dom';
import * as bookService from '../services/BookService';
import { useEffect, useState } from 'react';

export function BookList() {
    const [books, setBooks] = useState([])
    useEffect(() => {
        getAll();
    }, [])
    const getAll = async () => {
        const result = await bookService.getAll();
        setBooks((prev) => result);
    }
    return (
        <div className='container'>
            <div>
            <h1>LIST OF BOOKS</h1>
            <Link to="/create-book"><button className='btn btn-success' id="add-btn">Add a new book</button></Link>
            </div>
            <table className='table table-hover'>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th className='center-text'>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map((book) => (
                            <tr key={book.id}>
                                <td>{book.title}</td>
                                <td>{book.quantity}</td>
                                <td>
                                   <Link to="/edit-book/{id}" ><button className='btn btn-primary'>Edit</button></Link>
                                    <button className='btn btn-danger'>Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}