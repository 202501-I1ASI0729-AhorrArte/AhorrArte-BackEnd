package com.FinSuma.AhorrArte.platform.userContext.domain.model.queries;

import com.FinSuma.AhorrArte.platform.userContext.domain.model.valueobjects.EmailAddress;

public record GetPersonByEmailQuery(EmailAddress emailAddress) {
}

