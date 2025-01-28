import React, {useState} from "react";
import {updateCarField} from "../services/CarService";

const UpdateField = () => {

    const [id, setId] = useState("");
    const [field, setField] = useState("");
    const [value, setValue] = useState("");


    const handleUpdate = () => {
        updateCarField(id, field, value)
            .then((response) => alert("Car updated successfully"))
            .catch((error) => console.error("Error updating car:", error));
    };

    return (
        <div>
            <h2>Update Field</h2>
            <form onSubmit={handleUpdate}>
                <input
                    type="text"
                    placeholder="Car ID"
                    value={id}
                    onChange={(e) => setId(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Field (brand, model, color)"
                    value={field}
                    onChange={(e) => setField(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="New Value"
                    value={value}
                    onChange={(e) => setValue(e.target.value)}
                />
                <button type="submit">Update Field</button>
            </form>
        </div>
    );
};

export default UpdateField;
