import { useState } from "react";
import Article from "./components/article";
import Vehicle from "./components/vehicle";
import Navbar from "./components/navbar";
import {mockVehicles} from "./data/data.js";
const vehicles = mockVehicles;

function App() {

  const [makeFilter, setMakeFilter] = useState("");
  const [serviceFilter, setServiceFilter] = useState("");
  const [statusFilter, setStatusFilter] = useState("");

  return (
    <div id="principal">
      <Article /> 
      <Navbar makeFilter={makeFilter} setMakeFilter={setMakeFilter} serviceFilter={serviceFilter} 

        setServiceFilter={setServiceFilter} statusFilter={statusFilter} setStatusFilter={setStatusFilter} />
      <main>
        {vehicles.filter(vehicle => Vehicle.status !== "Done" && (makeFilter === "" || vehicle.make === makeFilter) 
          && (serviceFilter === "" || vehicle.service === serviceFilter) 
          && (statusFilter === "" || vehicle.status === statusFilter)).map(vehicle => <Vehicle onAddVehicle={() => {
          setShowForm(true);
          setSelectedVehicle(vehicle);
        }} key={vehicle.id} vehicleInfo={vehicle}/>)}
      </main>
    </div>
  )
}

export default App
