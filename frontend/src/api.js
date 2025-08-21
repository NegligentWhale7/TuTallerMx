import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/vehicles'; // Updated to match backend endpoint

export const getVehicles = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching vehicles:', error);
    throw error;
  }
};

export const patchVehicleStatus = async (id, status) => {
  try {
    const response = await axios.patch(`${API_BASE_URL}/status/${id}`, { status });
    return response.data;
  } catch (error) {
    console.error('Error updating vehicle status:', error);
    throw error;
  }
};
