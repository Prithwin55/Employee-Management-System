import axios from "axios";

const BASE_REST_URL = 'http://localhost:8080/api/department';

export const getalldepartment = () => {
    return axios.get(BASE_REST_URL);
}