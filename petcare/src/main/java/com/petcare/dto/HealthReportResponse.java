package com.petcare.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HealthReportResponse {

    private Long id;
    private LocalDate reportDate;
    private Double weight;
    private Double temperature;
    private Integer heartRate;

    private String medicalReport;
    private String lifestyleNutrition;
    private String preventiveCare;
    private String behaviorWellbeing;
    private String emergencyInfo;
    private String advancedMetrics;

    private String notes;

    private Long petId;
}