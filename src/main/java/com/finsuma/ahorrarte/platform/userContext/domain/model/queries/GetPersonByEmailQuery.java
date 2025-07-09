package com.finsuma.ahorrarte.platform.userContext.domain.model.queries;

import com.finsuma.ahorrarte.platform.userContext.domain.model.valueobjects.EmailAddress;

public record GetPersonByEmailQuery(EmailAddress emailAddress) {
}
