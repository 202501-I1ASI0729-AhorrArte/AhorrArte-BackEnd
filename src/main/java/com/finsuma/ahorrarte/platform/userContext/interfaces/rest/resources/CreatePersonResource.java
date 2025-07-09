package com.finsuma.ahorrarte.platform.userContext.interfaces.rest.resources;

public record CreatePersonResource(String firstName,
                                   String lastName,
                                   String email,
                                   String street,
                                   String number) { }
