package com.FinSuma.AhorrArte.platform.inflationReport.interfaces.rest;

import com.FinSuma.AhorrArte.platform.inflationReport.domain.model.InflationReport;
import com.FinSuma.AhorrArte.platform.inflationReport.application.internal.commandservices.InflationReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class InflationReportController {

    @Autowired
    private InflationReportService service;

    @GetMapping
    public List<InflationReport> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InflationReport> getReportById(@PathVariable Long id) {
        return ResponseEntity.of(service.getReportById(id));
    }

    @PostMapping
    public InflationReport createReport(@RequestBody InflationReport report) {
        return service.createReport(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InflationReport> updateReport(
            @PathVariable Long id, @RequestBody InflationReport report) {
        return ResponseEntity.of(service.updateReport(id, report));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        service.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}

