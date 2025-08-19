import PropTypes from 'prop-types';

function Vehicle({vehicleInfo, onAddVehicle}) {
    return (
        <div className="vehicle" style={{ 
            boxShadow: vehicleInfo.status === "Unassigned" ? "0 0 1.5rem rgb(255, 77, 243)" : "0 0 1.5rem rgb(255, 255, 255)", 
            backgroundColor: vehicleInfo.status === "Unassigned" ? "rgba(81, 25, 77, 1)" : "rgb(250, 250, 250)",}}>
            <div className="photoContainer">
                <button className='vehicleImg' onClick={onAddVehicle} style={{ backgroundImage: `url(${vehicleInfo.image})` }}></button>
            </div>
            <div className='vehicleInfo'>{vehicleInfo.make} {vehicleInfo.model}</div>
            <div className='vehicleService'>{vehicleInfo.services}</div>
        </div>
    )
}  

Vehicle.propTypes = {
    vehicleInfo: PropTypes.object,
    onAddVehicle: PropTypes.func
};

export default Vehicle;