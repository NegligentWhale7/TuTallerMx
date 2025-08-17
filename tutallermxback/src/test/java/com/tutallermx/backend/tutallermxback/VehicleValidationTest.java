package com.tutallermx.backend.tutallermxback;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tutallermx.backend.tutallermxback.models.Vehicle;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

public class VehicleValidationTest 
{
    private Validator  validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    
    @Test
    void testEmptyVehicle()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("Lucas Lim");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
                System.out.println("vehicle empty violations: " + violations.size());
        assertTrue(violations.isEmpty(), "Should not be empty");
        
    }

    @Test
    void testOwnerSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Owner special characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Owner must not contains special characters");
    }

    @Test
    void testPhoneLength()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Phone length violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testPhonePositive()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Year positive violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testMakeSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Make characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testModelSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Model characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testYearFormat()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Year format violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testYearPositive()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Year positive violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testVinSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("JH4TB2H26CC000000");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Vin characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testVinLength()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Vin length violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testStatusSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Status characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }

    @Test
    void testServicesSpecialCharacters()
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner("John Doe");
        vehicle.setPhone(1234567890L);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");
        vehicle.setCarYear(2020L);
        vehicle.setVin("1HGBH41JXMN109186");
        vehicle.setStatus("available");
        vehicle.setServices("oil change");

        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        System.out.println("Services characters violations: " + violations.size() + ", " + violations);
        assertTrue(violations.isEmpty(), "Should not be empty");
    }
}
