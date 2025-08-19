import PropTypes from 'prop-types';

function Navbar({ makeFilter, setMakeFilter, serviceFilter, setServiceFilter, statusFilter, setStatusFilter }) {

    return (
        <nav>
            <label htmlFor="make">
                <p>Select Make</p>
                <select name="make" id="make" value={makeFilter} onChange={e => setMakeFilter(e.target.value)}>
                    <option value="">All Makes</option>
                    <option value="Toyota">Toyota</option>
                    <option value="Honda">Honda</option>
                    <option value="Ford">Ford</option>
                    <option value="Chevrolet">Chevrolet</option>
                    <option value="Nissan">Nissan</option>
                    <option value="Volkswagen">Volkswagen</option>
                    <option value="BMW">BMW</option>
                    <option value="Mercedes-Benz">Mercedes-Benz</option>
                    <option value="Audi">Audi</option>
                    <option value="Hyundai">Hyundai</option>
                    <option value="Kia">Kia</option>
                    <option value="Mazda">Mazda</option>
                    <option value="Subaru">Subaru</option>
                    <option value="Jeep">Jeep</option>
                    <option value="Tesla">Tesla</option>
                    <option value="Volvo">Volvo</option>
                    <option value="Peugeot">Peugeot</option>
                    <option value="Renault">Renault</option>
                    <option value="Fiat">Fiat</option>
                    <option value="Lexus">Lexus</option>
                </select>
            </label>
            <label htmlFor="service">
                <p>Select Service</p>
                <select name="service" id="service" value={serviceFilter} onChange={e => setServiceFilter(e.target.value)}>
                    <option value="">All Services</option>
                    <option value="Oil change">Oil change</option>
                    <option value="Brake inspection">Brake inspection</option>
                    <option value="Wheel alignment">Wheel alignment</option>
                    <option value="Tire replacement">Tire replacement</option>
                    <option value="Battery check">Battery check</option>
                    <option value="Exterior wash">Exterior wash</option>
                    <option value="Interior vacuuming">Interior vacuuming</option>
                    <option value="Air filter replacement">Air filter replacement</option>
                    <option value="Oil filter replacement">Oil filter replacement</option>
                    <option value="Light inspection">Light inspection</option>
                    <option value="Fluid level check">Fluid level check</option>
                    <option value="Tire rotation">Tire rotation</option>
                    <option value="Exhaust system check">Exhaust system check</option>
                    <option value="Suspension check">Suspension check</option>
                    <option value="Steering system check">Steering system check</option>
                    <option value="AC recharge">AC recharge</option>
                    <option value="Belt inspection">Belt inspection</option>
                    <option value="Spark plug check">Spark plug check</option>
                    <option value="Windshield inspection">Windshield inspection</option>
                    <option value="Wiper blade check">Wiper blade check</option>
                </select>
            </label>
            <label htmlFor="status">
                <p>Select Status</p>
                <select name="status" id="status" value={statusFilter} onChange={e => setStatusFilter(e.target.value)}>
                    <option value="">All Status</option>
                    <option value="Unassigned">Unassigned</option>
                    <option value="In Progress">In Progress</option>
                </select>
            </label>
        </nav>

    )

}

Navbar.propTypes = {

    makeFilter: PropTypes.string,

    setMakeFilter: PropTypes.func,

    serviceFilter: PropTypes.string,

    setServiceFilter: PropTypes.func,

    statusFilter: PropTypes.string,

    setStatusFilter: PropTypes.func

};

export default Navbar
