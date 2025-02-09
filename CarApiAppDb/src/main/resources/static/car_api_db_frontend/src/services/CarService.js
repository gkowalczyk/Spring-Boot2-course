import axios from "axios";

const API_URL = "http://localhost:8080/cars";
export const getCars = (from, to) => axios.get(API_URL, {params: {from, to}});
export const addCar = (car) => axios.post(API_URL, car)
export const getCarsNews = () => axios.get(API_URL + "/news");
export const updateNews = (id, description) =>
    axios.put(`http://localhost:8080/cars?id=${id}&description=${description}`);
export const getCarsNewsFromDb = () => axios.get(API_URL + "/news/db");