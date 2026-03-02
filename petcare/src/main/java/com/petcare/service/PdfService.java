package com.petcare.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.petcare.entity.HealthReport;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generateHealthReportPdf(HealthReport report) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("PET HEALTH REPORT"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Report Date: " + report.getReportDate()));
        document.add(new Paragraph("Pet ID: " + report.getPet().getId()));
        document.add(new Paragraph("Weight: " + report.getWeight()));
        document.add(new Paragraph("Temperature: " + report.getTemperature()));
        document.add(new Paragraph("Heart Rate: " + report.getHeartRate()));
        document.add(new Paragraph("Medical Report: " + report.getMedicalReport()));
        document.add(new Paragraph("Lifestyle & Nutrition: " + report.getLifestyleNutrition()));
        document.add(new Paragraph("Preventive Care: " + report.getPreventiveCare()));
        document.add(new Paragraph("Behavior & Wellbeing: " + report.getBehaviorWellbeing()));
        document.add(new Paragraph("Emergency Info: " + report.getEmergencyInfo()));
        document.add(new Paragraph("Advanced Metrics: " + report.getAdvancedMetrics()));
        document.add(new Paragraph("Notes: " + report.getNotes()));

        document.close();

        return out.toByteArray();
    }
}