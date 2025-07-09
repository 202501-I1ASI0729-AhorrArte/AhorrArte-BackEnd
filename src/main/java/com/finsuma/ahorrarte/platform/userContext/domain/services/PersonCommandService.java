package com.FinSuma.AhorrArte.platform.userContext.domain.services;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.aggregates.Person;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.commands.CreatePersonCommand;

import java.util.Optional;

public interface PersonCommandService {
    Optional<Person> handle(CreatePersonCommand command);
}

