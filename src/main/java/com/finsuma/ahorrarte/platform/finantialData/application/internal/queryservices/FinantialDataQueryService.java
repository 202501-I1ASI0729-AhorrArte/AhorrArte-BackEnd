package com.FinSuma.AhorrArte.platform.finantialData.application.internal.queryservices;

import com.FinSuma.AhorrArte.platform.finantialData.domain.model.FinantialData;
import com.FinSuma.AhorrArte.platform.finantialData.infrastructure.persistence.jpa.FinantialDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinantialDataQueryService {

    private final FinantialDataRepository repository;

    public FinantialDataQueryService(FinantialDataRepository repository) {
        this.repository = repository;
    }

    public List<FinantialData> findAll() {
        return repository.findAll();
    }

    public Optional<FinantialData> findById(Long id) {
        return repository.findById(id);
    }
}

