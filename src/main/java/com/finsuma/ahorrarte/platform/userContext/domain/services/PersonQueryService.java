package com.finsuma.ahorrarte.platform.userContext.domain.services;

import com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates.Person;
import com.finsuma.ahorrarte.platform.userContext.domain.model.queries.GetAllPersonsQuery;
import com.finsuma.ahorrarte.platform.userContext.domain.model.queries.GetPersonByEmailQuery;
import com.finsuma.ahorrarte.platform.userContext.domain.model.queries.GetPersonByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PersonQueryService {
    Optional<Person> handle(GetPersonByIdQuery query);
    Optional<Person> handle(GetPersonByEmailQuery query);
    List<Person> handle(GetAllPersonsQuery query);
}
