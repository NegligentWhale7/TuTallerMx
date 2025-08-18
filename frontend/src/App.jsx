import Article from "./components/article";
import Vehicle from "./components/vehicle";
import {mockVehicles} from "./data/data.js";
const vehicles = mockVehicles;

function App() {

  return (
    <div id="principal">
      <Article /> 
      <main>
        {vehicles.map(vehicle => <Vehicle onAddVehicle={() => {
          setShowForm(true);
          setSelectedVehicle(vehicle);
        }} key={vehicle.id} vehicleInfo={vehicle}/>)}
      </main>
    </div>
  )
}

export default App
