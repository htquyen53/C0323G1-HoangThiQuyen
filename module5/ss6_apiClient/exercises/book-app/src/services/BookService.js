import axios from "axios";

export const getAll = async () => {
    try {
        const result = await axios.get(`https://localhost:8080/book-app`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const addNewBook = async (book) => {
    try {
        const result = await axios.post(`https://localhost:8080/book-app`,book);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const findBookById = async (id) => {
    try {
        const result = await axios.get(`https://localhost:8080/book-app/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const updateBook = async (book) => {
    try {
        const result = await axios.put(`https://localhost:8080/book-app/${book.id}`, book);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const deleteBook = async (id) => {
    try {
        const result = await axios.delete(`https://localhost:8080/book-app/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}