import * as facilityService from '../service/FacilityService';
import { useNavigate } from 'react-router';
import { ToastContainer,toast } from 'react-toastify';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import "../css/crudstyle.css";
import { useState, useEffect } from 'react';

function CreateVilla() {
    const navigate = useNavigate();
    const [rentalTypes, setRentalTypes] = useState([]);
    const [roomStandards, setroomStandards] = useState([]);
    const loadingRentalTypes = async () => {
        const data = await facilityService.getRentalTypes();
        setRentalTypes(data);
    }
    const loadingRoomStandards = async () => {
        const data = await facilityService.getRoomStandards();
        setroomStandards(data);
    }
    useEffect(() => {
        loadingRentalTypes();
        loadingRoomStandards();
    },[])
    const addVilla = async (values) => {
        await facilityService.createVilla(values);
        toast(`The villa ${values.name} create successful!`);
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
                roomStandard: "",
                poolArea: "",
                floor: ""
            }}
                validationSchema={Yup.object({
                    name: Yup.string().required("Name is not empty!"),
                    usableArea: Yup.number().min(100, "Usable Area is more than 50 m2"),
                    price: Yup.number().required("Price is not empty!")
                        .min(100, "Price is more than 100 USD"),
                    roomStandard: Yup.string().required("Room Standard is not empty!"),
                    floor: Yup.number().required("Floor is not empty!")
                        .min(1, "Floor must be more than 0")
                })}
                onSubmit={async (values) => {
                    await addVilla(values);
                }}
            >
                <div className='container'>
                    <h1>Create Villa</h1>
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
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="price">Price:</label>
                            <Field className="form-control" type="number" name="price" id="price" />
                            <ErrorMessage name="price" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="maxQuantity">Max Quantity:</label>
                            <Field className="form-control" type="number" name="maxQuantity" id="maxQuantity" />
                            <ErrorMessage name="maxQuantity" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="rentalType">Type Rental:</label>
                            <Field className="form-control" name="rentalType" id="rentalType" as="select">
                                {rentalTypes.map((rentalType) => (
                                    <option key={rentalType.idType} value={rentalType.nameType}>{rentalType.nameType}</option>
                                ))}
                            </Field>
                            <ErrorMessage name="rentalType" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="roomStandard">Room Standard:</label>
                            <Field className="form-control" name="roomStandard" id="roomStandard" as="select">
                                {roomStandards.map((roomStandard) => (
                                    <option key={roomStandard.idRoom} value={roomStandard.nameRoom}>{roomStandard.nameRoomStandard}</option>
                                ))}
                            </Field>
                            <ErrorMessage name="roomStandard" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="poolArea">Pool Area:</label>
                            <Field className="form-control" type="number" name="poolArea" id="poolArea" />
                            <ErrorMessage name="poolArea" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="floor">Floor:</label>
                            <Field className="form-control" type="number" name="floor" id="floor" />
                            <ErrorMessage name="floor" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <label className='form-label' htmlFor="imgPath">Img-Path:</label>
                            <Field className="form-control" type="text" name="imgPath" id="imgPath" />
                            <ErrorMessage name="imgPath" component='span' className="form-error" />
                        </div>
                        <div className='mb-3 row'>
                            <button className="btn btn-success" type="submit"><b>Create</b></button>
                        </div>
                    </Form>
                </div>
            </Formik>
            <ToastContainer />
        </>
    )
}
export default CreateVilla;