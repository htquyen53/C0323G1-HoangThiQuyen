import { Link, Navigate, useNavigate } from 'react-router-dom';
import * as bookService from '../services/BookService';
import { useEffect, useState } from 'react';
import Modal from "./Modal";

export function BookList() {
    const [books, setBooks] = useState([]);
    const navigate = useNavigate();
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    });
    const getAll = async () => {
        const result = await bookService.getAll();
        setBooks(result);
    }
    const handleDeleteBook = async (id) => {
        await bookService.deleteBook(id);
        await getAll();
        handleCloseModal();
    }
    const handleCloseModal = () => {
        setModalData({ show: false, data: null });
    }
    useEffect(() => {
        getAll();
    }, []);

    return (
        <div className='container'>
            <div>
                <h1>LIST OF BOOKS</h1>
                <Link to="books/create-book"><button className='btn btn-success' id="add-btn">Add a new book</button></Link>
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
                                    <button className='btn btn-primary' type='button' onClick={() => {
                                        navigate(`/books/edit-book/${book.id}`)
                                    }}>Edit</button>
                                    <button className='btn btn-danger' type='button' onClick={() => setModalData({
                                        show: true,
                                        data: book
                                    })}>Delete</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
            {
                modalData.show && (
                    <Modal title={'Delete book confirmation'}
                        msg={`Do you want to delete the book: ${modalData.data.title}?`}
                        onClose={handleCloseModal}
                        onCofirm={() => handleDeleteBook(modalData.data.id)}
                    >
                    </Modal>
                )
            }
        </div>
    )
}