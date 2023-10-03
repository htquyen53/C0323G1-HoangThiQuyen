import axios from "axios";

export const getAllGymRoom = async (roomName, managerName, page) => {
    try {
      const result = await axios.get(`http://localhost:8080/gym_room/api/list?roomName=${roomName}&managerName=${managerName}&page=${page}`);
      return result;
    } catch (e) {
      console.log(e);
    }
  }
  export const deleteGymRoom = async (id) => {
    try {
      const result = await axios.delete(`http://localhost:8080/gym_room/api/delete/${id}`);
      console.log(result)
      return result;
    } catch (e) {
      console.log(e);
    }
  }
   export const getManagers = async() => {
    try {
        const result = await axios.get('http://localhost:8080/gym_room/managers');
        console.log(result)
        return result;
      } catch (e) {
        console.log(e);
      }
   }