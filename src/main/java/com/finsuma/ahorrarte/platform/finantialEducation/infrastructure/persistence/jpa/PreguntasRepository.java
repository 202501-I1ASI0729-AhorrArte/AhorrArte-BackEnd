package com.FinSuma.AhorrArte.platform.finantialEducation.infrastructure.persistence.jpa;

import com.FinSuma.AhorrArte.platform.finantialEducation.domain.model.entities.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Preguntas, Long> {
}

