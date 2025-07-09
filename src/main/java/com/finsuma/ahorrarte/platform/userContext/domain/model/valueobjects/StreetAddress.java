package com.FinSuma.AhorrArte.platform.userContext.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(
        String street,
        String number)
{
    public StreetAddress() {
        this(null, null);
    }

    public StreetAddress(String street) {
        this(street, null);
    }

    public String getStreetAddress() {
        return String.format("%s, %s", street, number);
    }

    public StreetAddress {
        if (street == null || street.isBlank()) throw new IllegalArgumentException("Street must not be null or blank");
        if (number == null || number.isBlank()) throw new IllegalArgumentException("Number must not be null or blank");
    }
}

