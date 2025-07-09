package com.FinSuma.AhorrArte.platform.userInflation.infraestructure.persistence.jpa;

import com.FinSuma.AhorrArte.platform.userInflation.domain.model.UserInflation;
import com.FinSuma.AhorrArte.platform.userInflation.domain.model.UserInflationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInflationRepository extends JpaRepository<UserInflation, UserInflationId> {
}

