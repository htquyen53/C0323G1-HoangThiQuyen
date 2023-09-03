import * as facilityService from '../../../service/FacilityService';
import { useNavigate } from 'react-router';
import { ToastContainer,toast } from 'react-toastify';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import "../../../css/crudstyle.css";
import { useState, useEffect } from 'react';

function CreateRoom() {
    const navigate = useNavigate();
    const [rentalTypes, setRentalTypes] = useState([]);
    const loadingRentalTypes = async () => {
        const data = await facilityService.getRentalTypes();
        setRentalTypes(data);
    }
    useEffect(() => {
        loadingRentalTypes();
    },[])
    const addRoom = async (values) => {
        await facilityService.createRoom(values);
        toast(`The room ${values.name} create successful!`);
        navigate('/furama/facilities');
    }
    return (
        <>
            <Formik initialValues={{
                name: " ",
                usableArea: "",
                price: "",
                maxQuantity: "",
                rentalType: "",
                freeService: ""
            }}
                validationSchema={Yup.object({
                    name: Yup.string().required("Name is not empty!"),
                    usableArea: Yup.number().min(100, "Usable Area is more than 50 m2"),
                    price: Yup.number().required("Price is not empty!")
                        .min(100, "Price is more than 100 USD")
                })}
                onSubmit={async (values) => {
                    await addRoom(values);
                }}
            >
                <div className='container'>
                    <h1>Create Room</h1>
                    <Form>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor='name'>Name:</label>
                            <Field className="form-control" type="text" name="name" id="name" />
                            <ErrorMessage name='name' component='span' className='form-error' />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor='usableArea'>Usable:</label>
                            <Field className="form-control" type="text" name="usableArea" id="usableArea" />
                            <ErrorMessage name='usableArea' component='span' className='form-error' />
                        </div>
                        <div>
                            <label className='form-label' htmlFor="price">Price:</label>
                            <Field className="form-control" type="number" name="price" id="price" />
                            <ErrorMessage name="price" component='span' className="form-error" />
                        </div>
                        <div>
                            <label className='form-label' htmlFor="maxQuantity">Max Quantity:</label>
                            <Field className="form-control" type="number" name="maxQuantity" id="maxQuantity" />
                            <ErrorMessage name="maxQuantity" component='span' className="form-error" />
                        </div>
                        <div>
                            <label className='form-label' htmlFor="typeRental">Type Rental:</label>
                            <Field className="form-control" name="typeRental" id="typeRental" as="select">
                                {rentalTypes.map((rentalType) => (
                                    <option key={rentalType.id} value={rentalType.nameType}>{rentalType.nameType}</option>
                                ))}
                            </Field>
                            <ErrorMessage name="rentalType" component='span' className="form-error" />
                        </div>
                        <div>
                            <label className='form-label' htmlFor="freeService">Free-Service:</label>
                            <Field className="form-control" type="text" name="freeService" id="freeService" />
                            <ErrorMessage name="freeService" component='span' className="form-error" />
                        </div>
                        <div>
                            <label className='form-label' htmlFor="imgPath">Img-Path:</label>
                            <Field className="form-control" type="text" name="imgPath" id="imgPath" />
                            <ErrorMessage name="imgPath" component='span' className="form-error" />
                        </div>
                        <div>
                            <button className="btn btn-success" type="submit"><b>Create</b></button>
                        </div>
                    </Form>
                </div>
            </Formik>
            <ToastContainer />
        </>
    )
}
export default CreateRoom;