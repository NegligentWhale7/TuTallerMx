package com.tutallermx.backend.tutallermxback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutallermx.backend.tutallermxback.models.Vehicle;
import com.tutallermx.backend.tutallermxback.repositories.VehicleRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
