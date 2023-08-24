import { Form, Field, Formik, ErrorMessage } from "formik";
import { useParams } from "react-router-dom";
import * as bookService from "../services/BookService";
import { useNavigate } from "react-router-dom";

export function BookUpdate() {
    const navigate = useNavigate();
    const param = useParams();
    const searchBook = async(param) =>
    {
        const result = await bookService.findBookById(param);

    }
    if (result!=null) {
        const editBook = async(values) => {
            const updateResult = await bookService.updateBook(values);
            alert("Update successful!")
            navigate("/books")
        }
        return (
            <>
                <h1>Edit Book</h1>
                <Formik initialValues={{
                    title: {result.title},
                    quantity: {result.quantity}
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
else {
    alert("This book haven't exist!")
}
   
}