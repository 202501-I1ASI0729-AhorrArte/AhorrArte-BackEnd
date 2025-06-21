package com.finsuma.ahorrarte.platform.userInflation.infraestructure.persistence.jpa;

import com.finsuma.ahorrarte.platform.userInflation.domain.model.UserInflation;
import com.finsuma.ahorrarte.platform.userInflation.domain.model.UserInflationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInflationRepository extends JpaRepository<UserInflation, UserInflationId> {
}
