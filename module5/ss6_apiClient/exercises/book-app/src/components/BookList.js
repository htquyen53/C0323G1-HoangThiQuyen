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
            <button className='btn btn-success'>Add a new book</button>
            </div>
            <table className='table table-hover'>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th align='center'>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map((book) => (
                            <tr key={book.id}>
                                <td>{book.title}</td>
                                <td>{book.quantity}</td>
                                <td>
                                    <button className='btn btn-primary'>Edit</button>
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