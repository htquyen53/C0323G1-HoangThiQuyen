import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as Yup from 'yup';
// import { useState } from 'react';


export function ContactForm() {
    // const [form, setForm] = useState({});
    // function handleChange(event) {
    //     setForm({
    //         ...form, [event.target.name]: event.target.value
    //     })
    // }
    return (
        <>
            <Formik
                initialValues={
                    {
                        name: "",
                        email: "",
                        phone: "",
                        message: "",
                    }}
                validationSchema={Yup.object({
                    name: Yup.string()
                        .required("Name is not empty!")
                        .min(3, "Name too short!")
                        .max(30, "Name too long!")
                        .matches(/^[a-z A-Z]+$/, "Name invalid"),
                    email: Yup.string()
                        .required("Email is not empty!")
                        .matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, "Email is not matches!"),
                    phone: Yup.string()
                        .required("Phone is not empty!")
                        .matches(/(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/, "Number Phone is not valid!")
                })}
                onSubmit={(values, { setSubmitting }) => {
                    setTimeout(() => {
                        setSubmitting(false);
                        console.log(values);
                        alert("Submit Successful!");
                    }, 2000)
                }}
            >
                {
                    <div className='container'>
                        <h1>Contact Form</h1>
                        <Form>
                            <div className='mb-3 row'>
                                <label htmlFor='name' className='form-label'>Name: </label>
                                <Field type="text" name="name" id="name" className="form-control" />
                                <ErrorMessage name="name" component='span' className="form-error" />
                            </div>
                            <div className='mb-3 row'>
                                <label htmlFor='email' className='form-label'>Email: </label>
                                <Field type="text" name="email" id="email" className="form-control" />
                                <ErrorMessage name="email" component='span' className="form-error" />
                            </div>
                            <div className='mb-3 row'>
                                <label htmlFor='phone' className='form-label'>Phone: </label>
                                <Field type="text" name="phone" id="phone" className="form-control" />
                                <ErrorMessage name="phone" component='span' className="form-error" />
                            </div>
                            <div className='mb-3 row'>
                                <label htmlFor='message' className='form-label'>Message: </label>
                                <Field type="text" name="message" id="message" className="form-control" />
                                <ErrorMessage name="message" component='span' className="form-error" />
                            </div>
                            <div><button type='submit' className='btn btn-primary'>Submit</button></div>
                        </Form>
                    </div>
                }
            </Formik>
        </>
    )
}
