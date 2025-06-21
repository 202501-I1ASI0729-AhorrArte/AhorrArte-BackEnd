package com.finsuma.ahorrarte.platform.finantialEducation.infrastructure.persistence.jpa;

import com.finsuma.ahorrarte.platform.finantialEducation.domain.model.entities.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Preguntas, Long> {
}
