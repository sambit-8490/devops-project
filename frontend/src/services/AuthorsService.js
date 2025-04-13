import axios from 'axios';
const REST_API_BASE_URL = 'http://localhost:8080/author/authors';
export const listAuthors = () =>{
    return axios.get(REST_API_BASE_URL);
}

const REST_API_BASE_URL2 = 'http://localhost:8080/author';
export const createAuthor = (author) =>{
    return axios.post(REST_API_BASE_URL2, author);
}