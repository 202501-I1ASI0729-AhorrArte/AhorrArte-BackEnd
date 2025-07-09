package com.finsuma.ahorrarte.platform.userContext.interfaces.rest.transform;

import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.Person;
import com.finsuma.ahorrarte.platform.userContext.interfaces.rest.resources.PersonResource;

public class PersonResourceFromEntityAssembler {
    public static PersonResource toResourceFromEntity(Person entity) {
        return new PersonResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getStreetAddress());
    }
}
