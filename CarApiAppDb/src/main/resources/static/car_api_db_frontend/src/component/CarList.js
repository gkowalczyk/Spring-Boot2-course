import React, { useState } from "react";
import { getCars } from "../services/CarService";

const CarList = () => {
    const [carList, setCarList] = useState([]);
    const [fromDate, setFromDate] = useState("");
    const [toDate, setToDate] = useState("");


    const fetchCars = () => {
        getCars(fromDate, toDate)
            .then((response) => {
                console.log("API Response:", response.data);
                setCarList(response.data);
            })
            .catch((error) => console.error("Error fetching cars:", error));
    };

    return (
        <div className="date-filter">
            <h2 className="date-filter-title">Filter by date</h2>

            <label>From</label>
            <input
                type="date"
                value={fromDate}
                onChange={(e) => setFromDate(e.target.value)}
            />

            <label>To</label>
            <input
                type="date"
                value={toDate}
                onChange={(e) => setToDate(e.target.value)}
            />

            <button onClick={fetchCars}>Filter</button>

            <ul className="car-list">
                {carList.map((car) => (
                    <li key={car.id}>
                        <span>
                            {car.brand} {car.model} {car.color} {car.dateProduced}
                        </span>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CarList;
