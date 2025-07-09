package com.finsuma.ahorrarte.platform.userInflation.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserInflationId implements Serializable {

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "REPORT_ID")
    private Long reportId;

    public UserInflationId() {
    }

    public UserInflationId(Long userId, Long reportId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInflationId that = (UserInflationId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(reportId, that.reportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, reportId);
    }
}
