package com.petcare.service;

import java.util.List;

import com.petcare.dto.HealthReportRequest;
import com.petcare.dto.HealthReportResponse;

public interface HealthReportService {

    HealthReportResponse addReport(Long petId, HealthReportRequest request);

    List<HealthReportResponse> getReports(Long petId);

    HealthReportResponse getReportById(Long reportId);

    void deleteReport(Long reportId);
}