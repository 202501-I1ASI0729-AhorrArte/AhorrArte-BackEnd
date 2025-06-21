package com.finsuma.ahorrarte.platform.userContext.domain.services;

import com.finsuma.ahorrarte.platform.userContext.domain.model.entities.ConsultaAsesoria;
import com.finsuma.ahorrarte.platform.userContext.domain.model.queries.GetAllConsultasAsesoriasQuery;
import com.finsuma.ahorrarte.platform.userContext.domain.model.queries.GetConsultaAsesoriaByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ConsultaAsesoriaQueryService {
    List<ConsultaAsesoria> handle(GetAllConsultasAsesoriasQuery query);
    Optional<ConsultaAsesoria> handle(GetConsultaAsesoriaByIdQuery query);
}
