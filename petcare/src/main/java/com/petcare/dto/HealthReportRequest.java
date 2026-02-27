package com.petcare.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthReportRequest {

    private LocalDate reportDate;
    private Double weight;
    private Double temperature;
    private Integer heartRate;
    private String notes;
}