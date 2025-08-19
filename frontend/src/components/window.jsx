import PropTypes from "prop-types";
import { useState } from "react";
import { patchVehicleStatus } from "../api";

function Window({ onClose, vehicleInfo, onStatusChange }) {
  const [status, setStatus] = useState(vehicleInfo.status);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleStatusChange = async (e) => {
    const newStatus = e.target.value;
    setStatus(newStatus);
    setLoading(true);
    setError(null);
    try {
      await patchVehicleStatus(vehicleInfo.id, newStatus);
      setLoading(false);
      if (onStatusChange) {
        onStatusChange(vehicleInfo.id, newStatus);
      }
    } catch (err) {
      setError("Failed to update status");
      setLoading(false);
    }
  };

  return (
    <div id="modalForm">
      <article>
        <div className="windowHeader">
          <div className="closeAux"></div>
          <button id="close" onClick={onClose}>
            X
          </button>{" "}
        </div>
        <h1>Vehicle information</h1>
      </article>
      <main className="windowMain">
        <div
          className="vehiclePhoto"
          style={{ backgroundImage: `url(${vehicleInfo.image})` }}
        ></div>
        <div className="properties">
          <div className="property">Contact owner: </div>
          <a
            href={
              "https://api.whatsapp.com/send?phone=" +
              vehicleInfo.phone +
              "&text=Hey! I would like to schedule an appointment for your car service"
            }
            className="value owner"
          >
            {vehicleInfo.owner}
          </a>
        </div>
        <div className="properties">
          <div className="property">Vehicle: </div>
          <div className="value">
            {vehicleInfo.carYear} {vehicleInfo.make} {vehicleInfo.model}
          </div>
        </div>
        <div className="properties">
          <div className="property">Vin: </div>
          <div className="value">{vehicleInfo.vin}</div>
        </div>
        <div className="properties">
          <div className="property">Service required: </div>
          <div className="value">{vehicleInfo.services}</div>
        </div>

        <div className="properties">
          <div className="property">Status: </div>
          <select name="status" id="status" value={status} onChange={handleStatusChange} disabled={loading}>
            <option value="Unassigned">Unassigned</option>
            <option value="In progress">In progress</option>
            <option value="Done">Done</option>
          </select>
          {loading && <span>Updating...</span>}
          {error && <span style={{color: 'red'}}>{error}</span>}
        </div>
      </main>
    </div>
  );
}

Window.propTypes = {
  onClose: PropTypes.func,
  vehicleInfo: PropTypes.object,
  onStatusChange: PropTypes.func,
};

export default Window;
