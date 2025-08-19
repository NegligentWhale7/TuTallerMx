package com.tutallermx.backend.tutallermxback.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Owner is mandatory")
    @Size(min = 1, max = 100, message = "Owner name must be between 1 and 100 characters")
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Owner name must not contain special characters")
    private String owner;
    @DecimalMin(value = "1000000000", message = "Phone number must be 10 digits")
    @DecimalMax(value = "9999999999", message = "Phone number must be 10 digits")
    @Positive(message = "Phone number must be positive")
    private Long phone;
    @NotBlank(message = "Make is mandatory")
    @Size(min = 1, max = 50, message = "Make must be between 1 and 50 characters")
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Make must not contain special characters")
    private String make;
    @NotBlank(message = "Model is mandatory")
    @Size(min = 1, max = 50, message = "Model must be between 1 and 50 characters")
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Model must not contain special characters")
    private String model;
    @DecimalMin(value = "1990", message = "Year must be greater than or equal to 1990")
    @DecimalMax(value = "2025", message = "Year must be less than or equal to 2025")
    @Positive(message = "Year must be positive")
    private Long carYear;
    @NotBlank(message = "VIN is mandatory")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    @Pattern(regexp = "^[A-HJ-NPR-Z0-9]{17}$", message = "VIN must contain only valid characters (no I, O, Q)")
    private String vin;
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Status must not contain special characters")
    private String status = "unassigned";
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Services must not contain special characters")
    private String services = "unassigned";
}
