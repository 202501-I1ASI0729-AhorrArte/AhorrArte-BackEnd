package com.finsuma.ahorrarte.platform.userContext.interfaces.rest.transform;

import com.finsuma.ahorrarte.platform.userContext.domain.model.commands.CreatePersonCommand;
import com.finsuma.ahorrarte.platform.userContext.interfaces.rest.resources.CreatePersonResource;

public class CreatePersonCommandFromResourceAssembler {
    public static CreatePersonCommand toCommandFromResource(CreatePersonResource resource) {
        return new CreatePersonCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street(),
                resource.number());
    }
}
