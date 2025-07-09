package com.finsuma.ahorrarte.platform.iam.interfaces.rest.transform;

import com.finsuma.ahorrarte.platform.iam.domain.model.commands.SignInCommand;
import com.finsuma.ahorrarte.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
