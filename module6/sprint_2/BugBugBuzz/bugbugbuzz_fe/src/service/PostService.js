import axios from "axios";

export const baseURL = 'http://localhost:8080/api/post';

// Get posts list
export const getAllPosts = async (page, rowsPerPage) => {
    const config = {
        headers: {
            "Content-Type": "application/json",
        },
        withCeredentials: true,
    };
    const response = await axios.get(`${baseURL}/home/list?page=${page}&postsPerPage=${rowsPerPage}`, null, config);
    console.log(response.data);
    return response;
}

// Create a new post
export const addNewPost = async (accessToken, post) => {
    const config = {
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${accessToken}`,
        },
        withCeredentials: true,
    };
    const response = await axios.post(`${baseURL}/create`, post, config);
    return response;
}