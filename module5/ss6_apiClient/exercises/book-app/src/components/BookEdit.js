import { Form, Field, Formik, ErrorMessage } from "formik";
import { useParams } from "react-router-dom";
import * as bookService from "../services/BookService";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import * as Yup from 'yup';

export function BookEdit() {
    const navigate = useNavigate();
    const params = useParams();
    const [book, setBook] = useState();

    useEffect(()=>{
        if ( params.id ) {
            getBook(params.id)
        }
    },[params])

    const getBook = async (id) => {
        const selectedBook = await bookService.findBookById(id);
        setBook(selectedBook);
        console.log(book);
    }


    const handleSubmit = async (formData) => {
        console.log("aaaaa")
        console.log(formData);
        await bookService.updateBook(formData);
        alert("Update successful!");
        navigate("/books");
    }

    if (!book) {
        return null;
    }

    return (
        <>
        <div className="container">
        <h1>Edit Book</h1>
            <Formik initialValues={{
                id: book?.id,
                title: book?.title,
                quantity: book?.quantity
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
                    await handleSubmit(values);
                }}>
                <Form>
                    <div className="mb-3 row">
                        <label className="form-label" htmlFor="name">Title:</label>
                        <Field className="form-control" name="title" id="title" />
                        <ErrorMessage className="form-error" name="title" component='span' />
                    </div>
                    <div className="mb-3 row">
                        <label className="form-label" htmlFor="quantity">Quantity:</label>
                        <Field className="form-control" name="quantity" id="quantity" />
                        <ErrorMessage className="form-error" name="quantity" component='span' />
                    </div>
                    <div>
                        <button className="btn btn-primary" type="submit">Submit</button>
                    </div>
                </Form>
            </Formik>
        </div>
        </>
    )
}

   