import { useState, useEffect } from "react";
import { Formik, Form, ErrorMessage, Field } from "formik";
import * as productService from '../service/ProductService';
import { useNavigate } from "react-router";
import * as Yup from 'yup';
import { toast } from 'react-toastify';

function CreateProduct() {
    const navigate = useNavigate();
    const [productTypes, setProductTypes] = useState([]);

    const loadProductTypes = async () => {
        const res = await productService.getProductTypes();
        setProductTypes(res);
    }

    const handleSubmit = async (values) => {
        const res = await productService.createProduct(values);
        if (res.status === 201) {
            toast.success(`Create successful!`, {
                position: "top-center",
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        } else {
            toast.error('Crearte failed!', {
                position: "top-center",
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        }
        navigate('/products');
    }
    useEffect(() => {
        loadProductTypes();
    }, []);

    return (
        <div className="container">
            <h1>Create New Product</h1>
            <Formik initialValues={{
                name: "",
                imputDate: "",
                quantity: 0,
                productTypes: ""
            }}
                validationSchema={Yup.object({
                    name: Yup.string().required('Không được để trống tên!'),
                    inputDate: Yup.string().required('Không để trống ngày nhập'),
                    quantity: Yup.number().min(0, 'Số lượng phải lớn hơn 0')
                })}
                onSubmit={(values) => { handleSubmit(values) }}>
                <Form className="form-control">
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Tên sản phẩm</label>
                        <Field type="text" name="name" id="name" className="form-control" />
                        <ErrorMessage name="name" component='span' className="form-error" />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="inputDate" className="form-label">Ngày nhập:</label>
                        <Field type="date" name="inputDate" id="inputDate" className="form-control" />
                        <ErrorMessage name="inputDate" component='span' className="form-error" />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="quantity" className="form-label">Số lượng: </label>
                        <Field type="number" name="quantity" id="quantity" className="form-control" />
                        <ErrorMessage name="quantity" component='span' className="form-error" />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="productType" className="form-label">Loại sản phẩm</label>
                        <Field name="productType" className="form-select" as='select' >
                            <option>-Chọn loại sản phẩm-</option>
                            {productTypes.map((type) => (
                                <option key={type?.idType} value={type?.idType}>{type?.nameType}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="name" component='span' className="form-error" />
                    </div>
                    <div>
                        <button type="submit" className="btn btn-primary">Create</button>
                    </div>
                </Form>
            </Formik>
        </div>
    )
}
export default CreateProduct;