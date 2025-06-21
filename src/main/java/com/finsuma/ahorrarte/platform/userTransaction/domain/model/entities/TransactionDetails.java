package com.finsuma.ahorrarte.platform.userTransaction.domain.model.entities;

import com.finsuma.ahorrarte.platform.userTransaction.domain.model.valueobjects.TransactionAmount;
import com.finsuma.ahorrarte.platform.userTransaction.domain.model.valueobjects.TransactionId;

import java.util.Date;

public class TransactionDetails {
    private final TransactionId transactionId;
    private final String description;
    private final TransactionAmount amount;
    private final Date date;
    private final String category;
    private final Long userId;

    public TransactionDetails(TransactionId transactionId, String description, TransactionAmount amount, Date date, String category, Long userId) {
        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.userId = userId;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public String getDescription() {
        return description;
    }

    public TransactionAmount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
}
