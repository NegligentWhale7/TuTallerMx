import PropTypes from "prop-types";
 
function Window({onClose, vehicleInfo}) {
 
    return (
<div id="modalForm">
<article>
<div className="windowHeader">
<div className="closeAux"></div>
<button id="close" onClick={onClose}>X</button> {/* Boton para cerrar el formulario */}
</div>
<h1>Vehicle information</h1> {/* Titulo del formulario */}     
</article>
<main className="windowMain">
<div className="vehiclePhoto" style={{ backgroundImage: `url(${vehicleInfo.image})` }}></div>
<div className="properties">
<div className="property">Vehicle: </div> 
<div className="value">{vehicleInfo.vehicleYear} {vehicleInfo.make} {vehicleInfo.model}</div>
</div>
<div className="properties">
<div className="property">Vin: </div> 
<div className="value">{vehicleInfo.vin}</div>
</div>
<div className="properties">
<div className="property">Service required: </div> 
<div className="value">{vehicleInfo.service}</div>
</div>
</main>
</div>
    );
}
 
Window.propTypes = {
    onClose: PropTypes.func,
    vehicleInfo: PropTypes.object
};
 
export default Window;