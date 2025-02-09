import React from "react";
import CarList from "./component/CarList";
import AddCarForm from "./component/AddCarForm";
import CarApiNews from "./component/CarApiNews";


function App() {
    return (
        <div>
            <h1>Car API Frontend</h1>
            <CarList/>
            <AddCarForm/>
            <CarApiNews/>
        </div>
    );
}

export default App;
