package com.FinSuma.AhorrArte.platform.userInflation.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_INFLATION")
public class UserInflation {

    @EmbeddedId
    private UserInflationId id;

    public UserInflation() {}

    public UserInflation(UserInflationId id) {
        this.id = id;
    }

    public UserInflationId getId() {
        return id;
    }

    public void setId(UserInflationId id) {
        this.id = id;
    }
}

