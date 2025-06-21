package com.finsuma.ahorrarte.platform.finantialData.infrastructure.persistence.jpa;

import com.finsuma.ahorrarte.platform.finantialData.domain.model.FinantialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinantialDataRepository extends JpaRepository<FinantialData, Long> {
}
