import { useNavigate, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import * as productService from '../service/ProductService';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import date from 'date-and-time';
import "../css/style.css";
import Modal from './Modal';
import ReactPaginate from 'react-paginate';



function ListProduct() {
    const navigate = useNavigate();
    const [products, setProducts] = useState([]);
    const [searchName, setSearchName] = useState("");
    const [currentPage, setCurrentPage] = useState(0);
    const [countPage, setCountPage] = useState(0);
    const [modalData, setModalData] = useState({
        show: false,
        data: null
    })
    let size = 5;
    const loadProducts = async (currentPage,searchName, size) => {
        const result = await productService.getProducts(currentPage,searchName, size);
        let total = result.data.totalElements;
        setCountPage(Math.ceil(total/size));
        setProducts(result.data.content);
    }
    // const handleSearch = async (searchName) => {
    //     setSearchName(searchName);
    // }
    const handleCloseModal = () => {
        setModalData({
            show: false,
            data: null
        })
    }
    const handlePageClick = (data) => {
        console.log(data)
        let numberPage = data.selected;
        setCurrentPage(numberPage);
    }

    const handleEnter = (event) => {
        if (event.key === `Enter`) {
            setSearchName(event.target.value);
        }
    }
    const handleDelete = async (id) => {
        const res = await productService.deleteProduct(id);
        if (res.status === 200) {
            toast.success(`Delete the customer ${modalData.data.name} successful!`, {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        } else {
            toast.error('Delete failed!', {
                position: "top-center",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        }
        navigate('/products');
        handleCloseModal();
    }

    useEffect(() => {
        loadProducts(currentPage,searchName,size);
    }, [currentPage,searchName,size]);

    if (!products) {
        return <div></div>;
    }
    return (
        <>
            <div className='container'>
                <h1>Product List</h1>
                <div className='list'>
                    <Link to="/products/create"><button className='btn btn-success'>Create New!</button></Link>
                    <input className='searchBar' type="text" placeholder='Search...' defaultValue={searchName} onKeyDown={(event) => {handleEnter(event)}}></input>
                    <table className='table table-hover'>
                        <thead>
                            <tr>
                                <th>Mã sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Ngày nhập</th>
                                <th>Số lượng</th>
                                <th>Loại sản phẩm</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            {products.map((product) => (
                                <tr key={product?.id}>
                                    <td>{product?.id}</td>
                                    <td>{product?.name}</td>
                                    <td>{date.format(new Date(product?.inputDate), 'DD/MM/YYYY')}</td>
                                    <td>{product?.quantity}</td>
                                    <td>{product?.productType.nameType}</td>
                                    <td>
                                        <button className='btn btn-outline-success' onClick={() => navigate(`/products/${product.id}/edit`)}>Edit</button>
                                        <button className='btn btn-outline-danger' onClick={() => {
                                            setModalData({
                                                show: true,
                                                data: product
                                            })
                                        }}>Delete</button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
            <div className='paginate'>
                <ReactPaginate 
                previousLabel={'Previous'}
                nextLabel={'Next'}
                breakLabel={'...'}
                pageCount={countPage}
                marginPagesDisplayed={2}
                pageRangeDisplayed={3}
                onPageChange={handlePageClick}
                containerClassName={'pagination justify-content-center'}
                pageClassName={'page-item'}
                pageLinkClassName={'page-link'}
                nextClassName={'page-item'}
                previousClassName={'page-item'}
                nextLinkClassName={'page-link'}
                previousLinkClassName={'page-link'}
                />
            </div>
    
            <ToastContainer
                position="top-center"
                autoClose={5000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="light"
            />
            {
                modalData.show && (<Modal
                    title={'Delete product confimation'}
                    msg={`Do you want to delete the product: ${modalData.data.name}?`}
                    onClose={handleCloseModal}
                    onConfirm={()=> handleDelete(modalData.data.id)}>
                </Modal>
                )
            }
        </>
    )
}
export default ListProduct;
