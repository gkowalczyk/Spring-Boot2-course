import React from "react";
import CarList from "./component/CarList";
import CarDetails from "./component/CarDetails";
import AddCarForm from "./component/AddCarForm";
import UpdateField from "./component/UpdateField";

function App() {
 return (
     <div>
      <h1>Car API Frontend</h1>
      <CarList />
         <CarDetails />
         <AddCarForm />
         <UpdateField />
     </div>
 );
}

export default App;
