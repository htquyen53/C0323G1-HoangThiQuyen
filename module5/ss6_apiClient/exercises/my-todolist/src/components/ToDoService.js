import axios from "axios";
export const getAll = async() => {
    try {
        const result = await axios.get('https://jsonplaceholder.typicode.com/todos');
        return result.data;
    } catch(e) {
        console.log(e);
    }
}
export const addNew = async (todo) => {
    try {
        const result = await axios.post('https://jsonplaceholder.typicode.com/todos', todo)
        return result.data;
    } catch(e) {
        console.log(e);
    }
}