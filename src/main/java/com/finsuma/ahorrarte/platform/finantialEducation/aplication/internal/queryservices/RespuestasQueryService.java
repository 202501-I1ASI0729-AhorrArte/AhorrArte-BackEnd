package com.finsuma.ahorrarte.platform.finantialEducation.aplication.internal.queryservices;

import com.finsuma.ahorrarte.platform.finantialEducation.domain.model.entities.Respuestas;
import com.finsuma.ahorrarte.platform.finantialEducation.infrastructure.persistence.jpa.RespuestasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestasQueryService {

    private final RespuestasRepository repository;

    public RespuestasQueryService(RespuestasRepository repository) {
        this.repository = repository;
    }

    public List<Respuestas> findAll() {
        return repository.findAll();
    }

    public Optional<Respuestas> findById(Long id) {
        return repository.findById(id);
    }
}
