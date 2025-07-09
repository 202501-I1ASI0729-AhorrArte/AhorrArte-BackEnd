package com.FinSuma.AhorrArte.platform.iam.interfaces.rest.transform;

import com.FinSuma.AhorrArte.platform.iam.domain.model.aggregates.User;
import com.FinSuma.AhorrArte.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}

