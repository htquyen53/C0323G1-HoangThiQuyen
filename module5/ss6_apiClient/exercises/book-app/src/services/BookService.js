import axios from "axios";
export const getAll = async () => {
    try {
        const result = await axios.get('https://my-json-server.typicode.com/codegym-vn/mock-api-books/books');
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const addNewBook = async () => {
    try {
        const result = await axios.post('https://my-json-server.typicode.com/codegym-vn/mock-api-books/books');
        return result.data;
    } catch (e) {
        console.log(e);
    }
}

export const findBookById = async () => {
    try {
        const result = await axios.get('https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/{id}');
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const updateBook = async () => {
    try {
        const result = await axios.put('https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/{id}');
        return result.data;
    } catch (e) {
        console.log(e);
    }
}
export const deleteBook = async () => {
    try {
        const result = await axios.delete('https://my-json-server.typicode.com/codegym-vn/mock-api-books/books/{id}');
        return result.data;
    } catch (e) {
        console.log(e);
    }
}