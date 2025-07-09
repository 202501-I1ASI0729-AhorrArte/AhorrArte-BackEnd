package com.finsuma.ahorrarte.platform.iam.domain.services;

import com.finsuma.ahorrarte.platform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
