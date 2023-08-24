import * as bookService from "../services/BookService";
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { Formik, Form, ErrorMessage } from 'formik';
import { Yup } from 'yup';


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
                validationSchema={Yub.object(
                    {
                        title: Yup.string()
                            .required("Title is not empty!"),
                        quantity: Yup.string()
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
                    <div>
                        <label>Title</label>
                        <Field className="input" type="text" name="title" id = "title" />
                    </div>
                    <div>
                        <label>Quantity</label>
                        <Field className="input" type="text" name="title" id = "title" />
                    </div>
                    <div>
                        <button type="submit">Submit</button>
                    </div>
                </Form>
                </div>
            </Formik>
        </>
    )
}