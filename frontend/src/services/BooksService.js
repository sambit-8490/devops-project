import axios from 'axios';
const REST_API_BASE_URL = 'http://localhost:8080/book/books';
export const listBooks = () =>{
    return axios.get(REST_API_BASE_URL);
}

const REST_API_BASE_URL2 = 'http://localhost:8080/book';
export const createBook = () =>{
    return axios.get(REST_API_BASE_URL2);
}