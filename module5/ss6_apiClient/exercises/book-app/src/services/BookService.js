import axios from "axios";
export const getAll = async () => {
    try {
        const result = await axios.get(`https://my-json-server.typicode.com/codegym-vn/mock-api-books/books`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const addNewBook = async (book) => {
    try {
        const result = await axios.post(`https://my-json-server.typicode.com/codegym-vn/mock-api-books/`,book);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const findBookById = async (id) => {
    try {
        const result = await axios.get(`https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const updateBook = async (book) => {
    try {
        const result = await axios.put(`https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/${book.id}`, book);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const deleteBook = async (id) => {
    try {
        const result = await axios.delete(`https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/${id}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
}