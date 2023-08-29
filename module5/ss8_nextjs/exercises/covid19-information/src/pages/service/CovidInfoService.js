import axios from 'axios';
export const getAll = async() => {
    try {
        const res = await axios.get('http://localhost:8000/covidInfo');
        return res.data;
    } catch (e) {
        console.log(e);
    }
}