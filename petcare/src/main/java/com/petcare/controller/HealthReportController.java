package com.petcare.controller;

import com.petcare.dto.HealthReportRequest;
import com.petcare.dto.HealthReportResponse;
import com.petcare.entity.HealthReport;
import com.petcare.repository.HealthReportRepository;
import com.petcare.service.HealthReportService;
import com.petcare.service.PdfService;
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
    private final HealthReportRepository healthReportRepository;
    private final PdfService pdfService;

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

    // ✅ PDF DOWNLOAD ENDPOINT
    @GetMapping("/{reportId}/pdf")
    public ResponseEntity<byte[]> downloadPdf(
            @PathVariable Long petId,
            @PathVariable Long reportId) {

        HealthReport report = healthReportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        byte[] pdfBytes = pdfService.generateHealthReportPdf(report);

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=health_report_" + reportId + ".pdf")
                .header("Content-Type", "application/pdf")
                .body(pdfBytes);
    }
}