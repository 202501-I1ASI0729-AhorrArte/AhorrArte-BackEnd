package com.FinSuma.AhorrArte.platform.userContext.infrastructure.persistence.jpa.repositories;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.entities.ConsultaAsesoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ConsultaAsesoriaRepository extends JpaRepository<ConsultaAsesoria, Long> {
}

