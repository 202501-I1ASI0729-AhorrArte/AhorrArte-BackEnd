package com.finsuma.ahorrarte.platform.userTransaction.domain.model.queries;

public class GetTransactionsByUserQuery {
    private final String userId;

    public GetTransactionsByUserQuery(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
