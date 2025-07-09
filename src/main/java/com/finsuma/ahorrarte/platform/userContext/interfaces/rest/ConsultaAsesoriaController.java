package com.FinSuma.AhorrArte.platform.userContext.interfaces.rest;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetAllConsultasAsesoriasQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetConsultaAsesoriaByIdQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.services.ConsultaAsesoriaQueryService;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.resources.ConsultaAsesoriaResource;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.transform.ConsultaAsesoriaFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consultas-asesoria")
public class ConsultaAsesoriaController {

    private final ConsultaAsesoriaQueryService queryService;

    public ConsultaAsesoriaController(ConsultaAsesoriaQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaAsesoriaResource> getById(@PathVariable Long id) {
        var query = new GetConsultaAsesoriaByIdQuery(id);
        var consulta = queryService.handle(query);
        if (consulta.isEmpty()) return ResponseEntity.notFound().build();
        var resource = ConsultaAsesoriaFromEntityAssembler.toResourceFromEntity(consulta.get());
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaAsesoriaResource>> getAll() {
        var query = new GetAllConsultasAsesoriasQuery();
        var consultas = queryService.handle(query);
        var resources = consultas.stream()
                .map(ConsultaAsesoriaFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}

