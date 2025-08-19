package com.tutallermx.backend.tutallermxback;
import com.tutallermx.backend.tutallermxback.models.Vehicle;
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
}
