package com.finsuma.ahorrarte.platform.userContext.infrastructure.persistence.jpa.repositories;

import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.UserConsult;
import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.UserConsultId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConsultRepository extends JpaRepository<UserConsult, UserConsultId> { }

