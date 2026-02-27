package com.petcare.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthReportResponse {

    private Long id;
    private LocalDate reportDate;
    private Double weight;
    private Double temperature;
    private Integer heartRate;
    private String notes;
    private Long petId;
}