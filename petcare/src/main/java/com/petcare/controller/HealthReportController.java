package com.petcare.controller;

import com.petcare.dto.HealthReportRequest;
import com.petcare.dto.HealthReportResponse;
import com.petcare.service.HealthReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets/{petId}/health-reports")
@RequiredArgsConstructor
public class HealthReportController {

    private final HealthReportService healthReportService;

    @PostMapping
    public ResponseEntity<HealthReportResponse> addReport(
            @PathVariable Long petId,
            @Valid @RequestBody HealthReportRequest request) {

        return ResponseEntity.ok(
                healthReportService.addReport(petId, request)
        );
    }

    @GetMapping
    public ResponseEntity<List<HealthReportResponse>> getReports(
            @PathVariable Long petId) {

        return ResponseEntity.ok(
                healthReportService.getReports(petId)
        );
    }
}