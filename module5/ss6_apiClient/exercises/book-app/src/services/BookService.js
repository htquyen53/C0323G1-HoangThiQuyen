import axios from "axios";

export const getAll = async () => {
    try {
        const result = await axios.get(`http://localhost:8080/book-app`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const addNewBook = async (book) => {
    try {
        const result = await axios.post(`http://localhost:8080/book-app`,book);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const findBookById = async (id) => {
    try {
        const result = await axios.get(`http://localhost:8080/book-app/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const updateBook = async (book) => {
    try {
        await axios.put(`http://localhost:8080/book-app/${book.id}`, book);
    } catch (e) {
        console.log(e);
    }
}
export const deleteBook = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/book-app/${id}`);
    } catch (e) {
        console.log(e);
    }
}