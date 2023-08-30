import axios from "axios";

export const getContacts = async () => {
    try {
        const result = await axios.get(`http://localhost:8080/contact`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
 export const getContactDetail = async (id) => {
    try {
        const result = await axios.get(`http://localhost:8080/contact/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
 }
 export const createContact = async (contact) => {
    try {
        await axios.post(`http://localhost:8080/contact`, contact);
    } catch (e) {
        console.log(e);
    }
 }
 export const updateContact = async (contact) => {
    try {
        await axios.put(`http://localhost:8080/contact/${contact.id}`,contact);
    } catch (e) {
        console.log(e);
    }
 }
 export const deleteFacility = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/contact/${id}`);
    } catch (e) {
        console.log(e);
    }
 }