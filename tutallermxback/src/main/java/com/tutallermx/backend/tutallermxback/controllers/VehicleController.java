package com.tutallermx.backend.tutallermxback.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutallermx.backend.tutallermxback.models.Vehicle;
import com.tutallermx.backend.tutallermxback.models.VehicleServiceDTO;
import com.tutallermx.backend.tutallermxback.models.VehicleStatusDTO;
import com.tutallermx.backend.tutallermxback.services.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle Management", description = "Operations related to vehicle management")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @Operation(summary = "Get all vehicles", description = "Retrieves a list of all vehicles")
    @ApiResponse(responseCode = "200", description = "List of vehicles retrieved successfully")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get vehicle by ID", description = "Retrieves a vehicle by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if(vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }

    @PatchMapping("/status/{id}")
    @Operation(summary = "Update vehicle status", description = "Updates the status of a vehicle")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle status updated successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<Vehicle> patchVehicleStatus(@PathVariable Long id, @Valid @RequestBody VehicleStatusDTO statusDTO) {
        Vehicle vehicle = vehicleService.patchVehicleStatusDto(id, statusDTO);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }

    @PatchMapping("/services/{id}")
    @Operation(summary = "Update vehicle services", description = "Updates the services of a vehicle")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Vehicle services updated successfully"),
        @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
    public ResponseEntity<Vehicle> patchVehicleServices(@PathVariable Long id, @Valid @RequestBody VehicleServiceDTO serviceDTO) {
        Vehicle vehicle = vehicleService.patchVehicleServiceDto(id, serviceDTO);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicle);
    }
}
