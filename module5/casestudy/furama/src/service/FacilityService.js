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

//  House
export const getHouses= async () => {
    try {
        const result = await axios.get(`http://localhost:8000/houses`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
 export const getHouseDetail = async (id) => {
    try {
        const result = await axios.get(`http://localhost:8000/houses/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
 }
 export const createHouse = async (house) => {
    try {
        await axios.post(`http://localhost:8000/houses`, house);
    } catch (e) {
        console.log(e);
    }
 }
 export const updateHouse = async (house) => {
    try {
        await axios.put(`http://localhost:8000/houses/${house.id}`,house);
    } catch (e) {
        console.log(e);
    }
 }
 export const deleteHouse = async (id) => {
    try {
        await axios.delete(`http://localhost:8000/houses/${id}`);
    } catch (e) {
        console.log(e);
    }
 }
//  Room
export const getRooms = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/rooms`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
 export const getRoomDetail = async (id) => {
    try {
        const result = await axios.get(`http://localhost:8000/rooms/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
 }
 export const createRoom = async (room) => {
    try {
        await axios.post(`http://localhost:8000/rooms`, room);
    } catch (e) {
        console.log(e);
    }
 }
 export const updateRoom = async (room) => {
    try {
        await axios.put(`http://localhost:8000/rooms/${room.id}`,room);
    } catch (e) {
        console.log(e);
    }
 }
 export const deleteRoom = async (id) => {
    try {
        await axios.delete(`http://localhost:8000/rooms/${id}`);
    } catch (e) {
        console.log(e);
    }
 }