import React, {useEffect, useState} from "react";
import {getCars, deleteCar} from "../services/CarService";

const CarList = () => {
    const [carList, setCarList] = useState([]);

    useEffect(() => {
        getCars()
            .then((response) => {
                console.log("API Response:", response.data);
                setCarList(response.data._embedded.carList);
            })
            .catch((error) => console.error("Error fetching cars:", error));
    }, []);

    const handleDelete = (id) => {
        deleteCar(id)
            .then((response) =>

        setCarList(carList.filter((car) => car.id !== id)))

        .catch((error) => console.error("Error deleting car:", error));
    };

    return (
        <div className="car-list-container">
            <h2 className="car-list-title">Car List</h2>
            <ul className="car-list">
                {carList.map((car) => (
                    <li key={car.id}>
            <span>
              {car.brand} {car.model} ({car.color})
                <button onClick={() => handleDelete(car.id)}>Delete</button>
            </span>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CarList;