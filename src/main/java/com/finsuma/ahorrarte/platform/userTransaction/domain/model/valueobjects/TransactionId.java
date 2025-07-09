package com.FinSuma.AhorrArte.platform.userTransaction.domain.model.valueobjects;

import java.util.UUID;

public class TransactionId {
    private final UUID id;

    public TransactionId() {
        this.id = UUID.randomUUID();
    }

    public TransactionId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}

