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
    public HealthReportResponse addReport(@NonNull Long petId,
                                          @NonNull HealthReportRequest request) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        HealthReport report = HealthReport.builder()
                .reportDate(request.getReportDate())
                .weight(request.getWeight())
                .temperature(request.getTemperature())
                .heartRate(request.getHeartRate())
                .notes(request.getNotes())
                .pet(pet)
                .build();

        HealthReport savedReport = healthReportRepository.save(report);

        return mapToResponse(savedReport);
    }

    @Override
    public List<HealthReportResponse> getReports(@NonNull Long petId) {

        List<HealthReport> reports = healthReportRepository.findByPetId(petId);

        return reports.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HealthReportResponse getReportById(@NonNull Long reportId) {

        HealthReport report = healthReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Health report not found"));

        return mapToResponse(report);
    }

    @Override
    public void deleteReport(@NonNull Long reportId) {

        HealthReport report = healthReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Health report not found"));

        healthReportRepository.delete(report);
    }

    // Mapping method
    private HealthReportResponse mapToResponse(HealthReport report) {

        return HealthReportResponse.builder()
                .id(report.getId())
                .reportDate(report.getReportDate())
                .weight(report.getWeight())
                .temperature(report.getTemperature())
                .heartRate(report.getHeartRate())
                .notes(report.getNotes())
                .petId(report.getPet().getId())
                .build();
    }
}