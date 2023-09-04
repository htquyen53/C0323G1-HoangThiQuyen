import axios from "axios";

// Villas
export const getVillasForHome = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/villas?_limit=6`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const getVillas = async (currentPage, limit, searchName) => {
    try {
        const result = await axios.get(`http://localhost:8000/villas?_page=${currentPage}&_limit=${limit}&name_like=${searchName}`);
        return result;
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
export const getHousesForHome = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/houses?_limit=6`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const getHouses= async (currentPage, limit, searchName) => {
    try {
        const result = await axios.get(`http://localhost:8000/houses?_page=${currentPage}&_limit=${limit}&name_like=${searchName}`);
        return result;
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
export const getRoomsForHome = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/rooms?_limit=6`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const getRooms = async (currentPage, limit, searchName) => {
    try {
        const result = await axios.get(`http://localhost:8000/rooms?_page=${currentPage}&_limit=${limit}&name_like=${searchName}`);
        return result;
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
//  Rental Type:
export const getRentalTypes = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/rentalTypes`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

// Room Standard:
export const getRoomStandards = async () => {
    try {
        const result = await axios.get(`http://localhost:8000/roomStandards`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}