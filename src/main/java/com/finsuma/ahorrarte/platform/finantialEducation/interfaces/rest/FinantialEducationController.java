package com.FinSuma.AhorrArte.platform.finantialEducation.interfaces.rest;

import com.FinSuma.AhorrArte.platform.finantialEducation.aplication.internal.commandservices.FinantialEducationCommandService;
import com.FinSuma.AhorrArte.platform.finantialEducation.aplication.internal.queryservices.FinantialEducationQueryService;
import com.FinSuma.AhorrArte.platform.finantialEducation.aplication.internal.queryservices.PreguntasQueryService;
import com.FinSuma.AhorrArte.platform.finantialEducation.aplication.internal.queryservices.RespuestasQueryService;
import com.FinSuma.AhorrArte.platform.finantialEducation.domain.model.aggregates.FinantialEducation;
import com.FinSuma.AhorrArte.platform.finantialEducation.domain.model.entities.Preguntas;
import com.FinSuma.AhorrArte.platform.finantialEducation.domain.model.entities.Respuestas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finantial-education")
public class FinantialEducationController {

    private final FinantialEducationCommandService commandService;
    private final FinantialEducationQueryService queryService;
    private final PreguntasQueryService preguntasQueryService;
    private final RespuestasQueryService respuestasQueryService;

    public FinantialEducationController(
            FinantialEducationCommandService commandService,
            FinantialEducationQueryService queryService,
            PreguntasQueryService preguntasQueryService,
            RespuestasQueryService respuestasQueryService) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.preguntasQueryService = preguntasQueryService;
        this.respuestasQueryService = respuestasQueryService;
    }

    @GetMapping
    public List<FinantialEducation> getAll() {
        return queryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinantialEducation> getById(@PathVariable Long id) {
        return queryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FinantialEducation create(@RequestBody FinantialEducation finantialEducation) {
        return commandService.save(finantialEducation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinantialEducation> update(@PathVariable Long id, @RequestBody FinantialEducation updatedEducation) {
        return queryService.findById(id)
                .map(existing -> {
                    existing.setTitulo(updatedEducation.getTitulo());
                    Preguntas pregunta = preguntasQueryService.findById(updatedEducation.getPregunta().getId())
                            .orElseThrow(() -> new IllegalArgumentException("Pregunta no encontrada"));
                    existing.setPregunta(pregunta);
                    Respuestas respuesta = respuestasQueryService.findById(updatedEducation.getRespuesta().getId())
                            .orElseThrow(() -> new IllegalArgumentException("Respuesta no encontrada"));
                    existing.setRespuesta(respuesta);

                    return ResponseEntity.ok(commandService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (queryService.findById(id).isPresent()) {
            commandService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

