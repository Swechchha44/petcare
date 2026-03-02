package com.petcare.service.impl;

import com.petcare.dto.HealthReportRequest;
import com.petcare.dto.HealthReportResponse;
import com.petcare.entity.HealthReport;
import com.petcare.entity.Pet;
import com.petcare.repository.HealthReportRepository;
import com.petcare.repository.PetRepository;
import com.petcare.service.HealthReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HealthReportServiceImpl implements HealthReportService {

    private final HealthReportRepository healthReportRepository;
    private final PetRepository petRepository;

    @Override
    public HealthReportResponse addReport(Long petId, HealthReportRequest request) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        HealthReport report = HealthReport.builder()
                .reportDate(request.getReportDate())
                .weight(request.getWeight())
                .temperature(request.getTemperature())
                .heartRate(request.getHeartRate())
                .medicalReport(request.getMedicalReport())
                .lifestyleNutrition(request.getLifestyleNutrition())
                .preventiveCare(request.getPreventiveCare())
                .behaviorWellbeing(request.getBehaviorWellbeing())
                .emergencyInfo(request.getEmergencyInfo())
                .advancedMetrics(request.getAdvancedMetrics())
                .notes(request.getNotes())
                .pet(pet)
                .build();

        HealthReport savedReport = healthReportRepository.save(report);

        return mapToResponse(savedReport);
    }

    @Override
    public List<HealthReportResponse> getReports(Long petId) {

        List<HealthReport> reports =
                healthReportRepository.findByPetIdOrderByReportDateAsc(petId);

        return reports.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public HealthReportResponse getReportById(Long reportId) {

        HealthReport report = healthReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Health report not found"));

        return mapToResponse(report);
    }

    @Override
    public void deleteReport(Long reportId) {

        HealthReport report = healthReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Health report not found"));

        healthReportRepository.delete(report);
    }

    private HealthReportResponse mapToResponse(HealthReport report) {

        return HealthReportResponse.builder()
                .id(report.getId())
                .reportDate(report.getReportDate())
                .weight(report.getWeight())
                .temperature(report.getTemperature())
                .heartRate(report.getHeartRate())
                .medicalReport(report.getMedicalReport())
                .lifestyleNutrition(report.getLifestyleNutrition())
                .preventiveCare(report.getPreventiveCare())
                .behaviorWellbeing(report.getBehaviorWellbeing())
                .emergencyInfo(report.getEmergencyInfo())
                .advancedMetrics(report.getAdvancedMetrics())
                .notes(report.getNotes())
                .petId(report.getPet().getId())
                .build();
    }
}