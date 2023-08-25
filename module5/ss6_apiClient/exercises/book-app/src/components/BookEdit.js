import { Form, Field, Formik, ErrorMessage } from "formik";
import { useParams } from "react-router-dom";
import * as bookService from "../services/BookService";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import * as Yup from 'yup';

export function BookEdit() {
    const navigate = useNavigate();
    const param = useParams();

    
    const [book, setBook] = useState([]);
    const getBook = async (param) => {
        const loandingBook = await bookService.findBookById(param);
        setBook(loandingBook);
        console.log(loandingBook)
    }

    const editBook = async (values) => {
        const updateResult = await bookService.updateBook(values);
        alert("Update successful!")
        navigate("/books")
    }

    useEffect(() => { getBook() }, []);
    if (!book) {
        return null;
    }
    return (
        <>
            <h1>Edit Book</h1>
            <Formik initialValues={{
                id: book.id,
                title: book.title,
                quantity: book.quantity
            }}
                validationSchema={Yup.object(
                    {
                        title: Yup.string()
                            .required("Title is not empty!"),
                        quantity: Yup.number()
                            .required("Quantity is not empty!")
                            .min(0, "Quantity is not negative!")
                    }
                )}
                onSubmit={async (values) => {
                    await editBook(values);
                }}>
                <Form>
                    <div className="mb-3 row">
                        <label className="form-label">Title:</label>
                        <Field className="form-control" name="title" />
                        <ErrorMessage className="form-error" name="title" component='span' />
                    </div>
                    <div className="mb-3 row">
                        <label className="form-label">Quantity:</label>
                        <Field className="form-control" name="quantity" />
                        <ErrorMessage className="form-error" name="quantity" component='span' />
                    </div>
                    <div>
                        <button className="btn btn-primary" type="submit">Submit</button>
                    </div>
                </Form>
            </Formik>
        </>
    )
}

   