import axios from 'axios';

export const getProducts = async (page, searchName, size) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/products?page=${page}&searchName=${searchName}&size=${size}`);
        console.log(res.data.content);
        return res;
    } catch (e) {
        console.log(e);
    }
}

export const getProductDetail = async (id) => {
    try {
        const res = await axios.get(`http://localhost:8080/api/products/${id}`);
        return res.data;
    } catch (e) {
        console.log(e);
    }
}

export const createProduct = async (product) => {
    try {
        const res = await axios.post(`http://localhost:8080/api/products`, product);
        return res;
    } catch (e) {
        console.log(e);
    }
}

export const editProduct = async (product) => {
    try {
        const res = await axios.put(`http://localhost:8080/api/products/${product.id}`, product);
        return res;
    } catch (e) {
        console.log(e);
    }
}

export const deleteProduct = async(id) => {
    try {
        const res = await axios.delete(`http://localhost:8080/api/products/${id}`);
        return res;
    } catch (e) {
        console.log(e);
    }
}

export const getProductTypes = async () => {
    try {
        const res = await axios.get('http://localhost:8080/api/products/productTypes');
        return res.data;
    } catch (e) {
        console.log(e);
    }
}