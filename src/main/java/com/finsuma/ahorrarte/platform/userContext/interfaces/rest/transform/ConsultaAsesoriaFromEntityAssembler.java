package com.finsuma.ahorrarte.platform.userContext.interfaces.rest.transform;

import com.finsuma.ahorrarte.platform.userContext.domain.model.entities.ConsultaAsesoria;
import com.finsuma.ahorrarte.platform.userContext.interfaces.rest.resources.ConsultaAsesoriaResource;
import org.springframework.stereotype.Component;

@Component
public class ConsultaAsesoriaFromEntityAssembler {
    public static ConsultaAsesoriaResource toResourceFromEntity(ConsultaAsesoria entity) {
        return new ConsultaAsesoriaResource(
                entity.getId(),
                entity.getTipoConsulta(),
                entity.getFechaConsulta(),
                entity.getResultado()
        );
    }
}
