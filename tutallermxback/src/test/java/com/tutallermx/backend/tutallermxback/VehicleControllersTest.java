package com.tutallermx.backend.tutallermxback;
import com.tutallermx.backend.tutallermxback.models.Vehicle;
import com.tutallermx.backend.tutallermxback.models.VehicleServiceDTO;
import com.tutallermx.backend.tutallermxback.models.VehicleStatusDTO;
import com.tutallermx.backend.tutallermxback.services.VehicleService;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.tutallermx.backend.tutallermxback.controllers.VehicleController;

@WebMvcTest(VehicleController.class)
class VehicleControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleService;

    @Test
    void testGetAllVehicles() throws Exception {
        var vehicle1 = new Vehicle();
        vehicle1.setOwner("Lucas Lim");
        vehicle1.setPhone(1234567890L);
        vehicle1.setMake("Toyota");
        vehicle1.setModel("Camry");
        vehicle1.setCarYear(2020L);
        vehicle1.setVin("JH4TB2H26CC000000");

        var vehicle2 = new Vehicle();
        vehicle2.setOwner("Maria Garcia");
        vehicle2.setPhone(9876543210L);
        vehicle2.setMake("Honda");
        vehicle2.setModel("Civic");
        vehicle2.setCarYear(2019L);
        vehicle2.setVin("JH4TB2H26CC000001");

        var vehicles = List.of(vehicle1, vehicle2);

        when(vehicleService.getAllVehicles()).thenReturn(vehicles);

        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].owner").value("Lucas Lim"))
                .andExpect(jsonPath("$[0].make").value("Toyota"))
                .andExpect(jsonPath("$[1].owner").value("Maria Garcia"))
                .andExpect(jsonPath("$[1].make").value("Honda"));
    }

    @Test
    void testReturnsCorrectVehicleDetails() throws Exception {
        Long vehicleId = 1L;
        var vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Ford");
        vehicle.setModel("Focus");
        vehicle.setCarYear(2021L);
        vehicle.setVin("JH4TB2H26CC000002");

        when(vehicleService.getVehicleById(vehicleId)).thenReturn(vehicle);

        mockMvc.perform(get("/api/vehicles/{id}", vehicleId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(vehicleId))
                .andExpect(jsonPath("$.owner").value("John Doe"))
                .andExpect(jsonPath("$.make").value("Ford"))
                .andExpect(jsonPath("$.model").value("Focus"));
    }

    @Test
    void testPatchServiceCorrectly() throws Exception {
        var originalVehicle = new Vehicle();
        originalVehicle.setId(1L);
        originalVehicle.setOwner("John Doe");
        originalVehicle.setPhone(1234567890L);
        originalVehicle.setMake("Ford");
        originalVehicle.setModel("Focus");
        originalVehicle.setCarYear(2021L);
        originalVehicle.setVin("JH4TB2H26CC000002");
        originalVehicle.setServices("Unassigned");

        Long vehicleId = 1L;
        VehicleServiceDTO serviceDto = new VehicleServiceDTO();
        serviceDto.setService("Tire Rotation");

        var updatedVehicle = new Vehicle();
        updatedVehicle.setId(vehicleId);
        updatedVehicle.setOwner("John Doe");
        updatedVehicle.setPhone(1234567890L);
        updatedVehicle.setMake("Ford");
        updatedVehicle.setModel("Focus");
        updatedVehicle.setCarYear(2021L);
        updatedVehicle.setVin("JH4TB2H26CC000002");
        updatedVehicle.setServices("Tire Rotation");   

        when(vehicleService.patchVehicleServiceDto(eq(vehicleId), any(VehicleServiceDTO.class))).thenReturn(updatedVehicle);

        mockMvc.perform(patch("/api/vehicles/services/{id}", vehicleId)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"service\": \"Tire Rotation\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(vehicleId))
                .andExpect(jsonPath("$.services").value("Tire Rotation"));
    }

    @Test
    void testPatchStatusCorrectly() throws Exception {
        var originalVehicle = new Vehicle();
        originalVehicle.setId(1L);
        originalVehicle.setOwner("John Doe");
        originalVehicle.setPhone(1234567890L);
        originalVehicle.setMake("Ford");
        originalVehicle.setModel("Focus");
        originalVehicle.setCarYear(2021L);
        originalVehicle.setVin("JH4TB2H26CC000002");
        originalVehicle.setStatus("Unassigned");

        Long vehicleId = 1L;
        VehicleStatusDTO statusDto = new VehicleStatusDTO();
        statusDto.setStatus("Available");

        var updatedVehicle = new Vehicle();
        updatedVehicle.setId(vehicleId);
        updatedVehicle.setOwner("John Doe");
        updatedVehicle.setPhone(1234567890L);
        updatedVehicle.setMake("Ford");
        updatedVehicle.setModel("Focus");
        updatedVehicle.setCarYear(2021L);
        updatedVehicle.setVin("JH4TB2H26CC000002");
        updatedVehicle.setStatus("Available");

        when(vehicleService.patchVehicleStatusDto(eq(vehicleId), any(VehicleStatusDTO.class))).thenReturn(updatedVehicle);

        mockMvc.perform(patch("/api/vehicles/status/{id}", vehicleId)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\": \"Available\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(vehicleId))
                .andExpect(jsonPath("$.status").value("Available"));
    }
}
