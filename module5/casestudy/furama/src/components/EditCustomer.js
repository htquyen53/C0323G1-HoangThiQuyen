import { useEffect, useState } from 'react';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import { useNavigate, useParams } from 'react-router';
import * as Yup from 'yup';
import * as customerService from "../service/CustomerService";
import "../css/crudstyle.css";

function EditCustomer() {
    const navigate = useNavigate();
    const params = useParams();
    const [customer, setCustomer] = useState();
    const [customerTypes, setCustomerTypes] = useState([]);
    const loadCustomerDetail = async (id) => {
        const res = await customerService.getCustomerDetail(id);
        setCustomer(res);
    }
    const loadCustomerTypes = async () => {
        const res = await customerService.getCustomerTypes();
        console.log(res)
        setCustomerTypes(res);
    }
    const handleSubmit = async (formData) => {
        await customerService.updateCustomer(formData);
        navigate('/furama/customers');
    }

    useEffect(() => {
        if (params.id) {
            loadCustomerDetail(params.id);
            loadCustomerTypes();
        }
    }, [params])

    if (!customer) {
        return null;
    }
    return (
        <main className="grid">
            <div class="main-title">
                <h1>EDIT CUSTOMER</h1>
            </div>
            <Formik initialValues={{
                id: customer?.id,
                name: customer?.name,
                birthday: customer?.birthday,
                gender: customer?.gender,
                citizenId: customer?.citizenId,
                numberphone: customer?.numberphone,
                email: customer?.email,
                typeOfCustomer: customer?.typeOfCustomer,
                address: customer?.address
            }}
                validationSchema={Yup.object({
                    name: Yup.string().required("Name is not empty!"),
                    birthday: Yup.string().required("Birthday is not empty!"),
                    gender: Yup.string().required("Gender is not empty!"),
                    citizenId: Yup.string().required("CitizenId is not empty!")
                        .matches(/^[0-9]{13}$/, "CitizenId is not matches!"),
                    address: Yup.string().required("Address is not empty!")
                })}
                onSubmit={(values) => {
                    handleSubmit(values);
                }}
            >
                <Form className='form'>
                    <div className='mb-3'>
                        <label htmlFor='name' className='form-label'>Name:</label>
                        <Field type="text" name="name" id="name" className="form-control" />
                        <ErrorMessage name='name' component='span' className='text-red' />
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
                        <Field className="form-select"name="typeOfCustomer" id="typeOfCustomer" as="select" >
                            {customerTypes.map((customerType) => (
                                <option key={customerType.idType} value={customerType.idType}>{customerType.nameType}</option>
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
export default EditCustomer;