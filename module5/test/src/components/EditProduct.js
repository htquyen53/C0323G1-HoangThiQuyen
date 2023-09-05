import { useState, useEffect } from "react";
import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import * as productService from '../service/ProductService';
import { useNavigate } from 'react-router';
import { useParams } from "react-router";
import { toast } from 'react-toastify';

function EditProduct() {
    const navigate = useNavigate();
    const param = useParams();
    console.log(param);
    const [product, setProduct] = useState();
    const [productTypes, setProductTypes] = useState([]);

    const loadProductDetail = async (param) => {
        const result = await productService.getProductDetail(param.id);
        setProduct(result);
    }

    const loadProductTypes = async() => {
        const result = await productService.getProductTypes();
        setProductTypes(result);
    }
    const handleSubmit = async (values) => {
        const res = await productService.editProduct(values);
        toast('Update Successful!');
        navigate('/products');
    }

    useEffect(() => {
        loadProductDetail(param);
        loadProductTypes();
    }, [param])

    if (!product) {
        return <div></div>;
    }
    return (
        <div className="container">
            <h1>Edit product</h1>
            <Formik initialValues={{
                id: product?.id,
                name: product?.name,
                inputDate: product?.inputDate,
                quantity: product?.quantity,
                productType: product?.productType
            }} validationSchema={Yup.object(
                {
                    name: Yup.string().required('Không được để trống tên!'),
                    
                }
            )}
            
            onSubmit={(values) => {handleSubmit(values)}}
            >
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
                        {productTypes.map((type) => (
                            <option key={type.idType} value={type.idName}>{type.nameType}</option>
                        ))}
                        </Field>
                        <ErrorMessage name="name" component='span' className="form-error" />
                    </div>
                    <div>
                        <button type="submit" className="btn btn-primary">Edit</button>
                    </div>
                </Form>
            </Formik>
        </div>
    )

}
export default EditProduct;