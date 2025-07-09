package com.FinSuma.AhorrArte.platform.inflationReport.domain.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "INFLATION_REPORT")
public class InflationReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long reportId;

    @Column(name = "ANNUAL_INFLATION")
    private double annualInflation;

    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Lob
    @Column(name = "ANALYSIS")
    private String analysis;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public double getAnnualInflation() {
        return annualInflation;
    }

    public void setAnnualInflation(double annualInflation) {
        this.annualInflation = annualInflation;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}

