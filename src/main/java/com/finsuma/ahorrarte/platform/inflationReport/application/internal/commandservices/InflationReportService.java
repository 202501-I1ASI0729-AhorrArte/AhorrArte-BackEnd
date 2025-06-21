package com.finsuma.ahorrarte.platform.inflationReport.application.internal.commandservices;

import com.finsuma.ahorrarte.platform.inflationReport.domain.model.InflationReport;
import com.finsuma.ahorrarte.platform.inflationReport.infrastructure.persistence.jpa.InflationReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InflationReportService {

    @Autowired
    private InflationReportRepository repository;

    public List<InflationReport> getAllReports() {
        return repository.findAll();
    }

    public Optional<InflationReport> getReportById(Long id) {
        return repository.findById(id);
    }

    public InflationReport createReport(InflationReport report) {
        return repository.save(report);
    }

    public Optional<InflationReport> updateReport(Long id, InflationReport newReport) {
        return repository.findById(id).map(report -> {
            report.setAnnualInflation(newReport.getAnnualInflation());
            report.setReportDate(newReport.getReportDate());
            report.setAnalysis(newReport.getAnalysis());
            return repository.save(report);
        });
    }

    //DELETE
    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}
