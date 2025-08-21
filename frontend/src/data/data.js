/**
 * @typedef {Object} Vehicle
 * @property {number} id - Unique identifier for the vehicle
 * @property {string} owner - Name of the vehicles owner
 * @property {number} phone - Phone number of the vehicles owner
 * @property {"Toyota"|"Honda"|"Ford"|"Chevrolet"|"Nissan"|"Volkswagen"|"BMW"|"Mercedes-Benz"|"Audi"|"Hyundai"|"Kia"
 *  |"Mazda"|"Subaru"|"Jeep"|"Tesla"|"Volvo"|"Peugeot"|"Renault"|"Fiat"|"Lexus"} make - Vehicle make
 * @property {"Corolla"|"Civic"|"Mustang"|"Camaro"|"Altima"|"Golf"|"3 Series"|"C-Class"|"A4"|"Elantra"|"Sportage"|"CX-5"
 *  |"Outback"|"Wrangler"|"Model 3"|"XC60"|"208"|"Clio"|"500"|"RX"} model - Vehicle model
 * @property {"1990"|"1991"|"1992"|"1993"|"1994"|"1995"|"1996"|"1997"|"1998"|"1999"|"2000"|"2001"|"2002"|"2003"|"2004"
 *  |"2005"|"2006"|"2007"|"2008"|"2009"|"2010"|"2011"|"2012"|"2013"|"2014"|"2015"|"2016"|"2017"|"2018"|"2019"|"2020"
 *  |"2021"|"2022"|"2023"|"2024"|"2025"} carYear - Vehicle year
 * @property {string} vin - Vehicle vin
 * @property {string} image - Vehicle image
 * @property {"Oil change"|"Brake inspection"|"Wheel alignment"|"Tire replacement"|"Battery check"|"Exterior wash"
 *  |"Interior vacuuming"|"Air filter replacement"|"Oil filter replacement"|"Light inspection"|"Fluid level check"
 *  |"Tire rotation"|"Exhaust system check"|"Suspension check"|"Steering system check"|"AC recharge"|"Belt inspection"
 *  |"Spark plug check"|"Windshield inspection"|"Wiper blade check"} services - Service type
 * @property {"Unassigned"|"In progress"|"Completed"} status - Status of the vehicle service
 */

/**
 * Mock vehicles data for the application
 * @type {Vehicle[]}
 */
const mockVehicles = [
    {
    "id": 1,
    "owner": "Alice",
    "phone": 9838289499,
    "make": "Toyota",
    "model": "Corolla",
    "carYear": "2003",
    "vin": "VIN00001",
    "image": "././public/images/ToyotaCorolla.jpg",
    "services": "Oil change",
    "status": "Unassigned"
  },
  {
    "id": 2,
    "name": "Bob",
    "phone": 6770051030,
    "make": "Honda",
    "model": "Civic",
    "vehicleYear": "2003",
    "vin": "VIN00002",
    "image": "././public/images/HondaCivic.jpg",
    "service": "Brake inspection",
    "status": "Unassigned"
  },
  {
    "id": 3,
    "name": "Charlie",
    "phone": 7545481497,
    "make": "Ford",
    "model": "Mustang",
    "vehicleYear": "2006",
    "vin": "VIN00003",
    "image": "././public/images/FordMustang.jpg",
    "service": "Wheel alignment",
    "status": "Unassigned"
  },
  {
    "id": 4,
    "name": "Diana",
    "phone": 7172071935,
    "make": "Chevrolet",
    "model": "Camaro",
    "vehicleYear": "1998",
    "vin": "VIN00004",
    "image": "././public/images/ChevroletCamaro.jpg",
    "service": "Tire replacement",
    "status": "Unassigned"
  },
  {
    "id": 5,
    "name": "Ethan",
    "phone": 6113918029,
    "make": "Nissan",
    "model": "Altima",
    "vehicleYear": "2002",
    "vin": "VIN00005",
    "image": "././public/images/NissanAltima.jpg",
    "service": "Battery check",
    "status": "Unassigned"
  },
  {
    "id": 6,
    "name": "Fiona",
    "phone": 8824134117,
    "make": "Volkswagen",
    "model": "Golf",
    "vehicleYear": "1990",
    "vin": "VIN00006",
    "image": "././public/images/VolkswagenGolf.jpg",
    "service": "Exterior wash",
    "status": "Unassigned"
  },
  {
    "id": 7,
    "name": "George",
    "phone": 9097910009,
    "make": "BMW",
    "model": "3 Series",
    "vehicleYear": "1991",
    "vin": "VIN00007",
    "image": "././public/images/Bmw3Series.jpg",
    "service": "Interior vacuuming",
    "status": "Unassigned"
  },
  {
    "id": 8,
    "name": "Hannah",
    "phone": 9646660372,
    "make": "Mercedes-Benz",
    "model": "C-Class",
    "vehicleYear": "2016",
    "vin": "VIN00008",
    "image": "././public/images/MercedesBenzCClass.jpg",
    "service": "Air filter replacement",
    "status": "Unassigned"
  },
  {
    "id": 9,
    "name": "Ian",
    "phone": 9694663138,
    "make": "Audi",
    "model": "A4",
    "vehicleYear": "2004",
    "vin": "VIN00009",
    "image": "././public/images/AudiA4.jpg",
    "service": "Oil filter replacement",
    "status": "Unassigned"
  },
  {
    "id": 10,
    "name": "Julia",
    "phone": 6980764497,
    "make": "Hyundai",
    "model": "Elantra",
    "vehicleYear": "1991",
    "vin": "VIN00010",
    "image": "././public/images/HyundaiElantra.jpg",
    "service": "Light inspection",
    "status": "Unassigned"
  },
  {
    "id": 11,
    "name": "Kevin",
    "phone": 8111154629,
    "make": "Kia",
    "model": "Sportage",
    "vehicleYear": "1994",
    "vin": "VIN00011",
    "image": "././public/images/KiaSportage.jpg",
    "service": "Fluid level check",
    "status": "Unassigned"
  },
  {
    "id": 12,
    "name": "Laura",
    "phone": 6553388129,
    "make": "Mazda",
    "model": "CX-5",
    "vehicleYear": "2022",
    "vin": "VIN00012",
    "image": "././public/images/MazdaCX5.jpg",
    "service": "Tire rotation",
    "status": "Unassigned"
  },
  {
    "id": 13,
    "name": "Mike",
    "phone": 9209042800,
    "make": "Subaru",
    "model": "Outback",
    "vehicleYear": "1996",
    "vin": "VIN00013",
    "image": "././public/images/SubaruOutback.jpg",
    "service": "Exhaust system check",
    "status": "Unassigned"
  },
  {
    "id": 14,
    "name": "Oscar",
    "phone": 6822994923,
    "make": "Tesla",
    "model": "Model 3",
    "vehicleYear": "2023",
    "vin": "VIN00015",
    "image": "././public/images/TeslaModel3.jpg",
    "service": "Steering system check",
    "status": "Unassigned"
  },
  {
    "id": 15,
    "name": "Paula",
    "phone": 6666733269,
    "make": "Volvo",
    "model": "XC60",
    "vehicleYear": "2004",
    "vin": "VIN00016",
    "image": "././public/images/VolvoXC60.jpg",
    "service": "AC recharge",
    "status": "Unassigned"
  },
  {
    "id": 16,
    "name": "Quentin",
    "phone": 7741096067,
    "make": "Peugeot",
    "model": "208",
    "vehicleYear": "1990",
    "vin": "VIN00017",
    "image": "././public/images/Peugeot208.jpg",
    "service": "Belt inspection",
    "status": "Unassigned"
  },
  {
    "id": 17,
    "name": "Rachel",
    "phone": 6325917896,
    "make": "Renault",
    "model": "Clio",
    "vehicleYear": "1991",
    "vin": "VIN00018",
    "image": "././public/images/RenaultClio.jpg",
    "service": "Spark plug check",
    "status": "Unassigned"
  },
  {
    "id": 18,
    "name": "Steve",
    "phone": 9008383898,
    "make": "Fiat",
    "model": "500",
    "vehicleYear": "1992",
    "vin": "VIN00019",
    "image": "././public/images/Fiat500.jpg",
    "service": "Windshield inspection",
    "status": "Unassigned"
  },
  {
    "id": 19,
    "name": "Tina",
    "phone": 6674963825,
    "make": "Lexus",
    "model": "RX",
    "vehicleYear": "2019",
    "vin": "VIN00020",
    "image": "././public/images/LexusRx.jpg",
    "service": "Wiper blade check",
    "status": "Unassigned"
  }
];

export {mockVehicles};