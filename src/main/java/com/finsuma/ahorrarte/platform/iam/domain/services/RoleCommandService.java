package com.FinSuma.AhorrArte.platform.iam.domain.services;

import com.FinSuma.AhorrArte.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}

