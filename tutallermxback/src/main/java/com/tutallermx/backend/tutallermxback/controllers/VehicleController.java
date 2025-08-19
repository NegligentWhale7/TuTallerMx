package com.tutallermx.backend.tutallermxback.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutallermx.backend.tutallermxback.models.Vehicle;
import com.tutallermx.backend.tutallermxback.services.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
}
