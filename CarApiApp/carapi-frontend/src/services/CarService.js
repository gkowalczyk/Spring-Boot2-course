import axios from "axios";

const API_URL = "http://localhost:8080/cars";
export const getCars = () => axios.get(API_URL );
export const getCarById = (id) => axios.get(`${API_URL}/${id}`);
export const addCar = (car) => axios.post(API_URL, car)
export const deleteCar = (id) => axios.delete(`${API_URL}/${id}`);
export const updateCarField = (id, field, value) => axios.patch(`${API_URL}/${id}`, null, {params: {field, value}});