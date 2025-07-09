package com.finsuma.ahorrarte.platform.finantialData.interfaces.rest;

import com.finsuma.ahorrarte.platform.finantialData.application.internal.commandservices.FinantialDataCommandService;
import com.finsuma.ahorrarte.platform.finantialData.application.internal.queryservices.FinantialDataQueryService;
import com.finsuma.ahorrarte.platform.finantialData.domain.model.FinantialData;
import com.finsuma.ahorrarte.platform.finantialData.interfaces.rest.resources.FinantialDataResource;
import com.finsuma.ahorrarte.platform.finantialData.interfaces.rest.transform.CreateFinantialDataCommandFromResourceAssembler;
import com.finsuma.ahorrarte.platform.finantialData.interfaces.rest.transform.FinantialDataResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/finantial-data")
public class FinantialDataController {

    private final FinantialDataCommandService commandService;
    private final FinantialDataQueryService queryService;
    private final CreateFinantialDataCommandFromResourceAssembler createAssembler;
    private final FinantialDataResourceFromEntityAssembler resourceAssembler;

    public FinantialDataController(FinantialDataCommandService commandService,
                                   FinantialDataQueryService queryService,
                                   CreateFinantialDataCommandFromResourceAssembler createAssembler,
                                   FinantialDataResourceFromEntityAssembler resourceAssembler) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.createAssembler = createAssembler;
        this.resourceAssembler = resourceAssembler;
    }

    @GetMapping
    public List<FinantialDataResource> getAll() {
        return queryService.findAll().stream()
                .map(resourceAssembler::toResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinantialDataResource> getById(@PathVariable Long id) {
        Optional<FinantialData> finantialData = queryService.findById(id);
        return finantialData.map(data -> ResponseEntity.ok(resourceAssembler.toResource(data)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FinantialDataResource create(@RequestBody FinantialDataResource resource) {
        FinantialData finantialData = createAssembler.toEntity(resource);
        FinantialData savedData = commandService.save(finantialData);
        return resourceAssembler.toResource(savedData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinantialDataResource> update(@PathVariable Long id, @RequestBody FinantialDataResource resource) {
        Optional<FinantialData> existingData = queryService.findById(id);

        if (existingData.isPresent()) {
            FinantialData finantialData = existingData.get();
            finantialData.setTipoDato(resource.getTipoDato());
            finantialData.setMonto(resource.getMonto());
            finantialData.setFecha(resource.getFecha());
            finantialData.setDescripcion(resource.getDescripcion());
            FinantialData updatedData = commandService.save(finantialData);
            return ResponseEntity.ok(resourceAssembler.toResource(updatedData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (queryService.findById(id).isPresent()) {
            commandService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
