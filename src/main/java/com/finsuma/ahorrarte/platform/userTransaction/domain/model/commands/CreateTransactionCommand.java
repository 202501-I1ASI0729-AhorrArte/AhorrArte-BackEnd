package com.FinSuma.AhorrArte.platform.userTransaction.domain.model.commands;

import com.FinSuma.AhorrArte.platform.userTransaction.domain.model.valueobjects.TransactionAmount;

import java.util.Date;

public class CreateTransactionCommand {
    private final String description;
    private final TransactionAmount amount;
    private final Date date;
    private final String category;
    private final Long userId;
    public CreateTransactionCommand(String description, TransactionAmount amount, Date date, String category, Long userId) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.userId = userId;
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

