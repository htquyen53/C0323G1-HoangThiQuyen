import { useEffect, useState } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useNavigate, useParams } from "react-router";
import * as Yup from 'yup';
import * as facilityService from '../../../service/FacilityService';
import "../../../css/crudstyle.css";

function EditHouse() {
    const navigate = useNavigate();
    const params = useParams();
    const [house, setHouse] = useState();
    const [rentalTypes, setRentalTypes] = useState([]);
    const [roomStandards, setroomStandards] = useState([]);

    const loadingHouseDetail = async (id) => {
        const data = await facilityService.getHouseDetail(id);
        setHouse(data);
    }
    const loadingRentalTypes = async () => {
        const data = await facilityService.getRentalTypes();
        setRentalTypes(data);
    }
    const loadingRoomStandards = async () => {
        const data = await facilityService.getRoomStandards();
        setroomStandards(data);
    }

    const handleSubmit = async (formData) => {
        await facilityService.updateHouse(formData);
        navigate('/furama/facilities');
    }
    useEffect(() => {
        if (params.id) {
            loadingHouseDetail(params.id);
            loadingRentalTypes();
            loadingRoomStandards();
        }
    }, [params]);

    if (!house) {
        return null;
    }
    return (
        <main className="grid">
            <h2>EDIT IMFOMATION OF FACILITY: HOUSE</h2>
            <Formik initialValues={{
                id: house?.id,
                name: house?.name,
                usableArea: house?.usableArea,
                price: house?.price,
                maxQuantity: house?.maxQuantity,
                rentalType: house?.rentalType,
                roomStandard: house?.roomStandard,
                floor: house?.floor,
                imgPath: house?.imgPath

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
                onSubmit={(values) => {
                    handleSubmit(values);
                }}
            >
                <Form>
                    <div className='mb-3 row'>
                        <label htmlFor="name">Name:</label>
                        <Field type="text" name="name" id="name" />
                        <ErrorMessage name="name" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="usableArea">Usable Area:</label>
                        <Field type="number" name="usableArea" id="usableArea" />
                        <ErrorMessage name="usableArea" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="price">Price:</label>
                        <Field type="number" name="price" id="price" />
                        <ErrorMessage name="price" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="maxQuantity">Max Quantity:</label>
                        <Field type="number" name="maxQuantity" id="maxQuantity" />
                        <ErrorMessage name="maxQuantity" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="rentalType">Type Rental:</label>
                        <Field name="rentalType" id="rentalType" as="select">
                            {rentalTypes.map((rentalType) => (
                                <option key={rentalType.idType} value={rentalType.nameType}>{rentalType.nameType}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="rentalType" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="roomStandard">Room Standard:</label>
                        <Field name="roomStandard" id="roomStandard" as="select">
                            {roomStandards.map((roomStandard) => (
                                <option key={roomStandard.idRoom} value={roomStandard.nameRoom}>{roomStandard.nameRoomStandard}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="roomStandard" component='span' className="text-red" />
                    </div>
                    <div className='mb-3 row'>
                        <label htmlFor="floor">Floor:</label>
                        <Field type="number" name="floor" id="floor" />
                        <ErrorMessage name="floor" component='span' className="text-red" />
                    </div>
                    <div>
                        <label className='form-label' htmlFor="imgPath">Img-Path:</label>
                        <Field className="form-control" type="text" name="imgPath" id="imgPath" />
                        <ErrorMessage name="imgPath" component='span' className="form-error" />
                    </div>
                    <div className='mb-3 row'>
                        <button className="form-btn" type="submit"><b>Edit</b></button>
                    </div>
                </Form>
            </Formik>
        </main>
    )
}
export default EditHouse;