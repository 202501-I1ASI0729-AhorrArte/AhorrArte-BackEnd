package com.finsuma.ahorrarte.platform.userTransaction.application.internal.commandservices;

import com.finsuma.ahorrarte.platform.userTransaction.domain.model.aggregates.Transaction;
import com.finsuma.ahorrarte.platform.userTransaction.infrastructure.persistence.jpa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionCommandServiceImpl {
    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction command) {
        Transaction transaction = new Transaction(
                null,
                command.getDescription(),
                command.getAmount(),
                command.getDate(),
                command.getCategory(),
                command.getUserId()
        );
        return transactionRepository.save(transaction);
    }
}
