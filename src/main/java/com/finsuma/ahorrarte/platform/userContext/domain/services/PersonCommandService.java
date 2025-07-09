package com.finsuma.ahorrarte.platform.userContext.domain.services;

import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.Person;
import com.finsuma.ahorrarte.platform.userContext.domain.model.commands.CreatePersonCommand;

import java.util.Optional;

public interface PersonCommandService {
    Optional<Person> handle(CreatePersonCommand command);
}
