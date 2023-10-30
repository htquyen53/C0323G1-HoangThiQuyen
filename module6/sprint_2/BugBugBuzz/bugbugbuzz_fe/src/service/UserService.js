import axios from "axios";

export const getAvatar = async (userName) => {
    const response = await axios.get(`http://localhost:8080/api/user/home/get-avatar?username=${userName}`);
    return response.data;
}