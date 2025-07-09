package com.FinSuma.AhorrArte.platform.inflationReport.infrastructure.persistence.jpa;

import com.FinSuma.AhorrArte.platform.inflationReport.domain.model.InflationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflationReportRepository extends JpaRepository<InflationReport, Long> {
}

