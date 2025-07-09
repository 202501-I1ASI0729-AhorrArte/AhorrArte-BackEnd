package com.FinSuma.AhorrArte.platform.userTransaction.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class TransactionAmount {
    private double value;

    @JsonCreator
    public TransactionAmount(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        this.value = value;
    }

    public TransactionAmount() {

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

