package com.finsuma.ahorrarte.platform.userContext.application.internal.commandservices;

import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.Person;
import com.finsuma.ahorrarte.platform.userContext.domain.model.commands.CreatePersonCommand;
import com.finsuma.ahorrarte.platform.userContext.domain.model.valueobjects.EmailAddress;
import com.finsuma.ahorrarte.platform.userContext.domain.services.PersonCommandService;
import com.finsuma.ahorrarte.platform.userContext.infrastructure.persistence.jpa.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonCommandServiceImpl implements PersonCommandService {
    private final PersonRepository personRepository;

    public PersonCommandServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> handle(CreatePersonCommand command) {
        var emailAddress = new EmailAddress(command.email());
        if (personRepository.existsByEmail(emailAddress))
            throw new IllegalArgumentException("Person with email " + command.email() + " already exists");
        var person = new Person(command);
        personRepository.save(person);
        return Optional.of(person);
    }
}
