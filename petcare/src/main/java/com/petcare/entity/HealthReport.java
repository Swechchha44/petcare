package com.petcare.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_report")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 1000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}