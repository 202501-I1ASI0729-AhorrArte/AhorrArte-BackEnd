package com.FinSuma.AhorrArte.platform.userContext.domain.services;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.aggregates.Person;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetAllPersonsQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetPersonByEmailQuery;
import com.FinSuma.AhorrArte.platform.userContext.domain.model.queries.GetPersonByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PersonQueryService {
    Optional<Person> handle(GetPersonByIdQuery query);
    Optional<Person> handle(GetPersonByEmailQuery query);
    List<Person> handle(GetAllPersonsQuery query);
}

