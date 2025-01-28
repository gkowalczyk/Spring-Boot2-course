import React, {useState} from "react";
import {getCarById} from "../services/CarService";

const CarDetails = () => {
    const [car, setCar] = useState(null);
    const [id, setId] = useState("1");

    const fetchCarDetails = () => {
        getCarById(id)
            .then((response) => {
                console.log("API Response:", response.data);
                setCar(response.data);
            })
            .catch((error) => console.error("Error fetching car:", error));
    };


    return (
        <div>
            <h2>Car Details</h2>
            <input type="text"
                   placeholder="Enter car ID"
                   value={id}
                   onChange={(event) => setId(event.target.value)}/>
            <button onClick={fetchCarDetails}>Get Details of a car</button>
            {car && (
                <div>
                    <p>Brand: {car.brand}</p>
                    <p>Model: {car.model}</p>
                    <p>Color: {car.color}</p>
                </div>
            )}
        </div>
    );
};


export default CarDetails;
