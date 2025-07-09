package com.FinSuma.AhorrArte.platform.userTransaction.domain.model.queries;

public class GetTransactionsByUserQuery {
    private final String userId;

    public GetTransactionsByUserQuery(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

