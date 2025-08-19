package com.tutallermx.backend.tutallermxback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutallermx.backend.tutallermxback.models.Vehicle;
import com.tutallermx.backend.tutallermxback.models.VehicleServiceDTO;
import com.tutallermx.backend.tutallermxback.models.VehicleStatusDTO;
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

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle patchVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = getVehicleById(id);
        if (existingVehicle != null) {
            existingVehicle.setOwner(vehicle.getOwner());
            existingVehicle.setPhone(vehicle.getPhone());
            existingVehicle.setMake(vehicle.getMake());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setCarYear(vehicle.getCarYear());
            existingVehicle.setVin(vehicle.getVin());
            existingVehicle.setStatus(vehicle.getStatus());
            existingVehicle.setServices(vehicle.getServices());
            vehicleRepository.save(existingVehicle);
        }
        return existingVehicle;
    }

    public Vehicle patchVehicleStatusDto(Long id, VehicleStatusDTO vehicleDto) {
        System.out.println("Updating vehicle " + id + " with status: " + vehicleDto.getStatus());
        Vehicle existingVehicle = getVehicleById(id);
        if (existingVehicle != null) {
            System.out.println("Vehicle found: " + existingVehicle.getStatus() + " -> " + vehicleDto.getStatus());
            existingVehicle.setStatus(vehicleDto.getStatus());
            Vehicle savedVehicle = vehicleRepository.save(existingVehicle);
            System.out.println("Vehicle saved with status: " + savedVehicle.getStatus());
            return savedVehicle;
        }
        System.out.println("Vehicle not found with id: " + id);
        return null;
    }

    public Vehicle patchVehicleServiceDto(Long id, VehicleServiceDTO vehicleDto) {
        System.out.println("Updating vehicle " + id + " with service: " + vehicleDto.getService());
        Vehicle existingVehicle = getVehicleById(id);
        if (existingVehicle != null) {
            System.out.println("Vehicle found: " + existingVehicle.getServices() + " -> " + vehicleDto.getService());
            existingVehicle.setServices(vehicleDto.getService());
            Vehicle savedVehicle = vehicleRepository.save(existingVehicle);
            System.out.println("Vehicle saved with service: " + savedVehicle.getServices());
            return savedVehicle;
        }
        System.out.println("Vehicle not found with id: " + id);
        return null;
    }
}
