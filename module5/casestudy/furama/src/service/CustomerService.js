import axios from "axios";

export const getCustomers = async () => {
    try {
        const result = await axios.get(`http://localhost:80/customers`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
 export const getCustomerDetail = async (id) => {
    try {
        const result = await axios.get(`http://localhost:80/customers/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
 }
 export const createCustomer = async (customer) => {
    try {
        await axios.post(`http://localhost:80/customers`, customer);
    } catch (e) {
        console.log(e);
    }
 }
 export const updateCustomer = async (customer) => {
    try {
        await axios.put(`http://localhost:80/customers/${customer.id}`,customer);
    } catch (e) {
        console.log(e);
    }
 }
 export const deleteCustomer = async (id) => {
    try {
        await axios.delete(`http://localhost:80/customers/${id}`);
    } catch (e) {
        console.log(e);
    }
 }