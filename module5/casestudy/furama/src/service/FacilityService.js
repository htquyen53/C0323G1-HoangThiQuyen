import axios from "axios";

// Villas

export const getVillas = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/villas`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
 export const getVillaDetail = async (id) => {
    try {
        const result = await axios.get(`http://localhost:8000/villas/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
 }
 export const createVilla = async (villa) => {
    try {
        await axios.post(`http://localhost:8000/villas`, villa);
    } catch (e) {
        console.log(e);
    }
 }
 export const updateVilla = async (villa) => {
    try {
        await axios.put(`http://localhost:8000/villas/${villa.id}`,villa);
    } catch (e) {
        console.log(e);
    }
 }
 export const deleteVilla = async (id) => {
    try {
        await axios.delete(`http://localhost:8000/villas/${id}`);
    } catch (e) {
        console.log(e);
    }
 }