import React, {useState} from "react";
import {addCar} from "../services/CarService";

const AddCarForm = () => {

    const [car, setCar] = useState({brand: "", model: "", color: ""});

    const handleInputChange = (event) => {

        addCar(car)
            .then((response) => alert("Car added successfully"))
            .catch((error) => console.error("Error adding car:", error));
    };


    return (
        <form onSubmit={handleInputChange}>
            <div>
                <h2>Add Car</h2>
            </div>
            <input type="text"
                   placeholder="Brand"
                   value={car.brand}
                   onChange={(e) => setCar({...car, brand: e.target.value})}/>

            <input type={"text"}
                   placeholder={"Model"}
                   value={car.model}
                   onChange={(e) => setCar({...car, model: e.target.value})}/>

            <input type={"text"}
                   placeholder={"Color"}
                   value={car.color}
                   onChange={(e) => setCar({...car, color: e.target.value})}/>
            <button type="submit">Add Car</button>

        </form>
    );
};
export default AddCarForm;


