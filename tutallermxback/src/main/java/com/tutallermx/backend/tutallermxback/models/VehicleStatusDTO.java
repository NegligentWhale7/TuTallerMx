package com.tutallermx.backend.tutallermxback.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Data transfer object for vehicle status")
public class VehicleStatusDTO {
    @Pattern(regexp = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ\\s])+$", message = "Status must not contain special characters")
    private String status = "Unassigned";
}
