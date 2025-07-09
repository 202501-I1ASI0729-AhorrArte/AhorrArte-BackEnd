package com.FinSuma.AhorrArte.platform.inflationReport.interfaces.rest.resources;

import jakarta.annotation.Resource;

import java.util.Date;

@Resource
public class InflationReportResource {

    private Long reportId;

    private double annualInflation;

    private Date reportDate;

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

