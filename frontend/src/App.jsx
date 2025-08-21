import { useState, useEffect } from "react";
import Article from "./components/article";
import Vehicle from "./components/vehicle";
import Navbar from "./components/navbar";
import Window from "./components/window.jsx";
import { getVehicles } from "./api";

function App() {
  const [vehicles, setVehicles] = useState([]);
  const [makeFilter, setMakeFilter] = useState("");
  const [serviceFilter, setServiceFilter] = useState("");
  const [statusFilter, setStatusFilter] = useState("");
  const [selectedVehicle, setSelectedVehicle] = useState(null);
  const [showForm, setShowForm] = useState(false);

  useEffect(() => {
    async function fetchVehicles() {
      try {
        const data = await getVehicles();
        setVehicles(data);
      } catch (error) {
        // Optionally handle error
      }
    }
    fetchVehicles();
  }, []);

  return (
    <div id="principal">
      <Article />
      <Navbar makeFilter={makeFilter} setMakeFilter={setMakeFilter} serviceFilter={serviceFilter}
        setServiceFilter={setServiceFilter} statusFilter={statusFilter} setStatusFilter={setStatusFilter} />
      <main>
        {vehicles.filter(vehicle => vehicle.status !== "Done" && (makeFilter === "" || vehicle.make === makeFilter)
          && (serviceFilter === "" || vehicle.services === serviceFilter)
          && (statusFilter === "" || vehicle.status === statusFilter)).map(vehicle => <Vehicle onAddVehicle={() => {
            setShowForm(true);
            setSelectedVehicle(vehicle);
          }} key={vehicle.id} vehicleInfo={vehicle} />)}
      </main>
      {showForm && (
        <div id="windowBackground">
          <Window 
            onClose={() => setShowForm(false)} 
            vehicleInfo={selectedVehicle} 
            onStatusChange={(id, newStatus) => {
              setVehicles(vehicles => vehicles.map(v => v.id === id ? { ...v, status: newStatus } : v));
              setSelectedVehicle(selectedVehicle => selectedVehicle ? { ...selectedVehicle, status: newStatus } : selectedVehicle);
            }}
          />
        </div>
      )}
    </div>
  )
}

export default App
