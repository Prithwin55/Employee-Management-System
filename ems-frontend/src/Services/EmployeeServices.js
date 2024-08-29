import axios from "axios";

const BASE_REST_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => {
    return axios.get(BASE_REST_URL);
}

export const createEmployee = (employee) => axios.post(BASE_REST_URL, employee);

export const getEmployee = (employee) => axios.get(BASE_REST_URL + '/' + employee)

export const updateEmployee = (employee, empobj) => axios.put(BASE_REST_URL + '/' + employee, empobj)

export const removeEmployee = (employee) => axios.delete(BASE_REST_URL + '/' + employee)