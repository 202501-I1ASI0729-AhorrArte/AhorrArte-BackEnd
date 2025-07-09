package com.FinSuma.AhorrArte.platform.inflationReport.interfaces.rest.transform;

import com.FinSuma.AhorrArte.platform.inflationReport.domain.model.InflationReport;
import com.FinSuma.AhorrArte.platform.inflationReport.interfaces.rest.resources.InflationReportResource;
import org.springframework.stereotype.Component;

@Component
public class InflationReportCommandFromResourceAssembler {

    public InflationReport toEntity(InflationReportResource resource) {
        InflationReport inflationReport = new InflationReport();
        inflationReport.setReportId(resource.getReportId());
        inflationReport.setAnnualInflation(resource.getAnnualInflation());
        inflationReport.setReportDate(resource.getReportDate());
        inflationReport.setAnalysis(resource.getAnalysis());
        return inflationReport;
    }
}

