import { ErrorMessage, Field, Form, Formik } from "formik";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import * as Yup from 'yup';
import * as facilityService from '../../../service/FacilityService';
import "../../../css/crudstyle.css";

function EditRoom() {
    const navigate = useNavigate();
    const params = useParams();
    const [room, setRoom] = useState();
    const [rentalTypes, setRentalTypes] = useState([]);

    const loadingRoomDetail = async (id) => {
        const data = await facilityService.getRoomDetail(id);
        setRoom(data);
    }
    const loadingRentalTypes = async () => {
        const data = await facilityService.getRentalTypes();
        setRentalTypes(data);
    }
    const handleSubmit = async (formData) => {
        await facilityService.updateRoom(formData);
        navigate('/furama/facilities');
    }
    useEffect(() => {
        if (params.id) {
            loadingRoomDetail(params.id);
            loadingRentalTypes();
        }
    }, [params])
    if (!room) {
        return null;
    }
    return (
        <main className="container">
            <h1>EDIT IMFOMATION OF FACILITY: ROOM</h1>
            <Formik initialValues={{
                id: room?.id,
                name: room?.name,
                usableArea: room?.usableArea,
                price: room?.price,
                maxQuantity: room?.maxQuantity,
                rentalType: room?.rentalType,
                freeService: room?.freeService,
                imgPath: room?.imgPath
            }}
                validationSchema={Yup.object({
                    name: Yup.string().required("Name is not empty!"),
                    usableArea: Yup.number().required().min(100, "Usable Area is more than 50 m2"),
                    price: Yup.number().required("Price is not empty!")
                        .min(100, "Price is more than 100 USD"),
                })}
                onSubmit={(values) => {
                    handleSubmit(values);
                }}
            >
                <Form>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="name">Name:</label>
                        <Field className="form-control" type="text" name="name" id="name" />
                        <ErrorMessage name="name" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="usableArea">Usable Area:</label>
                        <Field className="form-control" type="number" name="usableArea" id="usableArea" />
                        <ErrorMessage name="usableArea" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="price">Price:</label>
                        <Field className="form-control" type="number" name="price" id="price" />
                        <ErrorMessage name="price" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="maxQuantity">Max Quantity:</label>
                        <Field className="form-control" type="number" name="maxQuantity" id="maxQuantity" />
                        <ErrorMessage name="maxQuantity" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="rentalType">Type Rental:</label>
                        <Field className="form-control" name="rentalType" id="rentalType" as="select">
                            {rentalTypes.map((rentalType) => (
                                <option key={rentalType.idType} value={rentalType.nameType}>{rentalType.nameType}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="rentalType" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="freeService">Free-Service:</label>
                        <Field className="form-control" type="text" name="freeService" id="freeService" />
                        <ErrorMessage name="freeService" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <label className='form-label' htmlFor="imgPath">Img-Path:</label>
                        <Field className="form-control" type="text" name="imgPath" id="imgPath" />
                        <ErrorMessage name="imgPath" component='span' className="text-red" />
                    </div>
                    <div className="mb-3 row">
                        <button className="form-btn" type="submit"><b>Edit</b></button>
                    </div>
                </Form>
            </Formik>
        </main>
    )
}
export default EditRoom;