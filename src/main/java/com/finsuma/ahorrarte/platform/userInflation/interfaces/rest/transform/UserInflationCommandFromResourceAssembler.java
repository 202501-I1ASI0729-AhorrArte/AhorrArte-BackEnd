package com.FinSuma.AhorrArte.platform.userInflation.interfaces.rest.transform;

import com.FinSuma.AhorrArte.platform.userInflation.domain.model.UserInflation;
import com.FinSuma.AhorrArte.platform.userInflation.domain.model.UserInflationId;
import com.FinSuma.AhorrArte.platform.userInflation.interfaces.rest.resources.UserInflationResource;
import org.springframework.stereotype.Component;

@Component
public class UserInflationCommandFromResourceAssembler {

    public UserInflation toEntity(UserInflationResource resource) {
        UserInflation userInflation = new UserInflation();
        userInflation.setId(new UserInflationId(resource.getUserId(), resource.getReportId()));
        return userInflation;
    }
}

