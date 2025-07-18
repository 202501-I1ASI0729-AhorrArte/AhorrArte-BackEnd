package com.finsuma.ahorrarte.platform.userContext.interfaces.rest.resources;

import java.time.LocalDate;

public record ConsultaAsesoriaResource(
        Long id,
        String tipoConsulta,
        LocalDate fechaConsulta,
        String resultado
) {}
