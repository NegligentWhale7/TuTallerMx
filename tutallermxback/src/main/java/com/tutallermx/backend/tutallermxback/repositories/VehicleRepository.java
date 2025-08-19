package com.tutallermx.backend.tutallermxback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutallermx.backend.tutallermxback.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
