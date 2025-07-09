package com.FinSuma.AhorrArte.platform.iam.domain.services;

import com.FinSuma.AhorrArte.platform.iam.domain.model.entities.Role;
import com.FinSuma.AhorrArte.platform.iam.domain.model.queries.GetAllRolesQuery;
import com.FinSuma.AhorrArte.platform.iam.domain.model.queries.GetRolesByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRolesByNameQuery query);
}

