import { useState, useEffect } from "react";
import { Formik, Form, Field, Link, ErrorMessage } from 'formik';
import { useNavigate } from 'react-router';
import * as Yup from 'yup';
import "../../css/crudstyle.css";
import { ToastContainer, toast } from "react-toastify";
import * as customerService from '../../service/CustomerService';

function CreateCustomer() {
    const navigate = useNavigate();
    const [customerTypes, setCustomerTypes] = useState([]);
    const loadingCustomerType = async () => {
        const res = await customerService.getCustomerTypes();
        setCustomerTypes(res);
    }

    useEffect(() => {
        loadingCustomerType();
    }, []);

    const addCustomer = async (values) => {
        await customerService.createCustomer(values);
        toast(`The customer ${values.name} created successfull!`);
        navigate('/furama/customers');
    }

    return (
        <main className="container">
            <h1>Create Customer</h1>
            <Formik initialValues={{
                name: "",
                birthday: "",
                gender: "",
                citizenId: "",
                numberphone: "",
                email: "",
                typeOfCustomer: "",
                address: ""
            }} validationSchema={Yup.object({
                name: Yup.string().required("Name is not empty!"),
                birthday: Yup.string().required("Birthday is not empty!"),
                gender: Yup.string().required("Gender is not empty!"),
                citizenId: Yup.string().required("CitizenId is not empty!")
                    .matches(/^[0-9]{13}$/, "CitizenId is not matches!"),
                address: Yup.string().required("Address is not empty!")
            })}
            onSubmit={async (values)=> {
                await addCustomer(values);
            }}>
                <Form>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="name">Name: </label>
                        <Field className="form-control" name="name" id="name" type="text" />
                        <ErrorMessage name="name" className="form-error" component='span' />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='birthday' className='form-label'>Birthday:</label>
                        <Field type="date" name="birthday" id="birthday" className='form-control' />
                        <ErrorMessage name='birthday' component='span' className='text-red' />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='gender' className='form-label'>Gender:</label>
                        <div className='form-control'>
                            <div className='form-check form-check-inline'>
                                <Field className="form-check-input" type="radio" name="gender" value="Nam" /> Nam
                            </div>
                            <div className='form-check form-check-inline'>
                                <Field className="form-check-input" type="radio" name="gender" value="Nữ" /> Nữ
                            </div>
                            <div className='form-check form-check-inline'>
                                <Field className="form-check-input" type="radio" name="gender" value="Giới tính khác" /> Giới tính khác
                            </div>
                            <ErrorMessage name='gender' component='span' className='text-red' />
                        </div>
                    </div>
                    <div className='mb-3'>
                        <label htmlFor='citizenId' className='form-label'>CitizenId:</label>
                        <Field className="form-control" type="text" name="citizenId" id="citizenId" />
                        <ErrorMessage name='citizenId' component='span' className='text-red' />
                    </div>
                    <div>
                        <label htmlFor='numberphone'>Number Phone:</label>
                        <Field className="form-control" type="text" name="numberphone" id="numberphone" />
                        <ErrorMessage name='numberphone' component='span' className='text-red' />
                    </div>
                    <div>
                        <label htmlFor='email'>Email:</label>
                        <Field className="form-control" type="text" name="email" id="email" />
                        <ErrorMessage name='email' component='span' className='text-red' />
                    </div>
                    <div>
                        <label htmlFor='typeOfCustomer'>Type Of Customer:</label>
                        <Field className="form-select"name="typeOfCustomer" id="typeOfCustomer" as="select" selectoption = 
                        {customerTypes} defaultValue={customerTypes[1]} >
                            {customerTypes.map((customerType) => (
                                <option key={customerType.idType} value={customerType.nameType}>{customerType.nameType}</option>
                            ))}
                        </Field>
                        <ErrorMessage name='typeOfCustomer' component='span' className='text-red' />
                    </div>
                    <div>
                        <label htmlFor='address'>Address:</label>
                        <Field className="form-control" type="text" name="address" id="address" />
                        <ErrorMessage name='address' component='span' className='text-red' />
                    </div>
                    <div>
                        <button class="form-btn" type="submit"><b>Edit</b></button>
                    </div>
                </Form>
            </Formik>
        </main>
    )
}
export default CreateCustomer;