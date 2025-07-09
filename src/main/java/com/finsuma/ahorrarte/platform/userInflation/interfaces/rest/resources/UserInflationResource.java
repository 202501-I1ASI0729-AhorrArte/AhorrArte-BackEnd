package com.FinSuma.AhorrArte.platform.userInflation.interfaces.rest.resources;

public class UserInflationResource {

    private Long userId;
    private Long reportId;

    public UserInflationResource() {
    }

    public UserInflationResource(Long userId, Long reportId) {
        this.userId = userId;
        this.reportId = reportId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }
}

