package com.finsuma.ahorrarte.platform.iam.application.internal.eventhanders;

import com.finsuma.ahorrarte.platform.iam.domain.model.commands.SeedRolesCommand;
import com.finsuma.ahorrarte.platform.iam.domain.services.RoleCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {

    private final RoleCommandService roleCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(RoleCommandService roleCommandService) {
        this.roleCommandService = roleCommandService;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}",
                applicationName, new Timestamp(System.currentTimeMillis()));
        var seedRolesCommand = new SeedRolesCommand();
        roleCommandService.handle(seedRolesCommand);
        LOGGER.info("Roles seeding verification finished for {} at {}",
                applicationName, new Timestamp(System.currentTimeMillis()));
    }
}
