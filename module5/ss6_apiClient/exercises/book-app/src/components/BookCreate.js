import * as bookService from "../services/BookService";
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';

export function BookCreate() {
    const navigate = useNavigate();
    const addBook = async (values) => {
        const result = await bookService.addNewBook(values);
        toast(`The book ${values.title} create OK`)
        navigate("/books")
    }
    return (
        <>
            <Formik initialValues={{
                title: "",
                quantity: ""
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
                onSubmit={async(values) =>{
                    await addBook(values);
                }}
            >
                <div className="container">
                <h1>Create Book</h1>
                <Form>
                    <div className='mb-3 row'>
                        <label className="form-label">Title</label>
                        <Field className="form-control" type="text" name="title" id = "title" />
                        <ErrorMessage name="title" component='span' className="form-error" />
                    </div>
                    <div className="mb-3 row"> 
                        <label className="form-label">Quantity</label>
                        <Field className="form-control" type="text" name="quantity" id = "quantity" />
                        <ErrorMessage name="quantity" component='span' className="form-error" />
                    </div>
                    <div>
                        <button className="btn btn-primary" type="submit">Submit</button>
                    </div>
                </Form>
                </div>
            </Formik>
        </>
    )
}