package com.finsuma.ahorrarte.platform.inflationReport.infrastructure.persistence.jpa;

import com.finsuma.ahorrarte.platform.inflationReport.domain.model.InflationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflationReportRepository extends JpaRepository<InflationReport, Long> {
}
