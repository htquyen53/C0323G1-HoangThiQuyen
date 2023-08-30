import { useEffect, useState } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { useNavigate, useParams } from "react-router";
import * as Yup from 'yup';
import * as facilityService from '../service/FacilityService';
import "../css/crudstyle.css";

function EditVilla() {
    const navigate = useNavigate();
    const params = useParams();
    const [villa, setVilla] = useState();
    const [rentalTypes, setRentalTypes] = useState([]);
    const [roomStandards, setroomStandards] = useState([]);

    const loadingVillaDetail = async (id) => {
        const data = await facilityService.getVillaDetail(id);
        setVilla(data);
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
        await facilityService.updateVilla(formData);
        navigate('/furama/facilities');
    }   

    useEffect(() => {
        if (params.id) {
            loadingVillaDetail(params.id);
            loadingRentalTypes();
            loadingRoomStandards();
        }
    }, [params])
    if (!villa) {
        return null;
    }
    return (
        <main className="grid">
            <div className="main-edit-title">
                <h1>EDIT IMFOMATION OF FACILITY: VILLAS</h1>
            </div>
            <Formik initialValues={{
                id: villa?.id,
                name: villa?.name,
                usableArea: villa?.usableArea,
                price: villa?.price,
                maxQuantity: villa?.maxQuantity,
                rentalType: villa?.rentalType,
                roomStandard: villa?.roomStandard,
                poolArea: villa?.poolArea,
                floor: villa?.floor,
                imgPath: villa?.imgPath
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
                    <div>
                        <label htmlFor="name">Name:</label>
                        <Field type="text" name="name" id="name" />
                        <ErrorMessage name="name" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="usableArea">Usable Area:</label>
                        <Field type="number" name="usableArea" id="usableArea" />
                        <ErrorMessage name="usableArea" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="price">Price:</label>
                        <Field type="number" name="price" id="price" />
                        <ErrorMessage name="price" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="maxQuantity">Max Quantity:</label>
                        <Field type="number" name="maxQuantity" id="maxQuantity" />
                        <ErrorMessage name="maxQuantity" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="rentalType">Type Rental:</label>
                        <Field name="rentalType" id="rentalType" as="select">
                            {rentalTypes.map((rentalType) => (
                                <option key={rentalType.id} value={rentalType.nameType}>{rentalType.nameType}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="rentalType" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="roomStandard">Room Standard:</label>
                        <Field name="roomStandard" id="roomStandard" as="select">
                            {roomStandards.map((roomStandard) => (
                                <option key={roomStandard.idRoom} value={roomStandard.idRoom}>{roomStandard.nameRoomStandard}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="roomStandard" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="poolArea">Pool Area:</label>
                        <Field type="number" name="poolArea" id="poolArea" />
                        <ErrorMessage name="poolArea" component='span' className="text-red" />
                    </div>
                    <div>
                        <label htmlFor="floor">Floor:</label>
                        <Field type="number" name="floor" id="floor" />
                        <ErrorMessage name="floor" component='span' className="text-red" />
                    </div>
                    <div>
                            <label className='form-label' htmlFor="imgPath">Img-Path:</label>
                            <Field className="form-control" type="text" name="imgPath" id="imgPath" />
                            <ErrorMessage name="imgPath" component='span' className="form-error" />
                        </div>
                    <div>
                        <button class="form-btn" type="submit"><b>Edit</b></button>
                    </div>
                </Form>
            </Formik>
        </main>
    )
}
export default EditVilla;