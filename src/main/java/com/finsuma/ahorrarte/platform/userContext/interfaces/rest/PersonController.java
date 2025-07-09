package com.FinSuma.AhorrArte.platform.userContext.interfaces.rest;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetAllPersonsQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetPersonByIdQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.services.PersonCommandService;
import com.FinSuma.AhorrArte.platform.userContext.domain.services.PersonQueryService;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.resources.CreatePersonResource;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.resources.PersonResource;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.transform.CreatePersonCommandFromResourceAssembler;
import com.FinSuma.AhorrArte.platform.userContext.interfaces.rest.transform.PersonResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/persons", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Persons", description = "Person Management Endpoints")
public class PersonController {
    private final PersonCommandService personCommandService;
    private final PersonQueryService personQueryService;

    public PersonController(PersonCommandService personCommandService, PersonQueryService personQueryService) {
        this.personCommandService = personCommandService;
        this.personQueryService = personQueryService;
    }

    @PostMapping
    public ResponseEntity<PersonResource> createPerson(@RequestBody CreatePersonResource resource) {
        var createPersonCommand = CreatePersonCommandFromResourceAssembler.toCommandFromResource(resource);
        var person = personCommandService.handle(createPersonCommand);
        if (person.isEmpty()) return ResponseEntity.badRequest().build();
        var personResource = PersonResourceFromEntityAssembler.toResourceFromEntity(person.get());
        return new ResponseEntity<>(personResource, HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResource> getPersonById(@PathVariable Long personId) {
        var getPersonByIdQuery = new GetPersonByIdQuery(personId);
        var person = personQueryService.handle(getPersonByIdQuery);
        if (person.isEmpty()) return ResponseEntity.notFound().build();
        var personResource = PersonResourceFromEntityAssembler.toResourceFromEntity(person.get());
        return ResponseEntity.ok(personResource);
    }

    @GetMapping
    public ResponseEntity<List<PersonResource>> getAllPersons() {
        var getAllPersonsQuery = new GetAllPersonsQuery();
        var persons = personQueryService.handle(getAllPersonsQuery);
        var personResources = persons.stream()
                .map(PersonResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(personResources);
    }


}

