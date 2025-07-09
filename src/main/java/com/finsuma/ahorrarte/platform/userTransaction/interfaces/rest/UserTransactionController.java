package com.finsuma.ahorrarte.platform.userTransaction.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.finsuma.ahorrarte.platform.userTransaction.domain.model.aggregates.Transaction;
import com.finsuma.ahorrarte.platform.userTransaction.application.internal.commandservices.TransactionCommandServiceImpl;
import com.finsuma.ahorrarte.platform.userTransaction.application.internal.queryservices.TransactionQueryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-transactions")
public class UserTransactionController {

    private final TransactionCommandServiceImpl commandService;
    private final TransactionQueryServiceImpl queryService;

    public UserTransactionController(TransactionCommandServiceImpl commandService, TransactionQueryServiceImpl queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }


    // Endpoint para crear una transacción
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = commandService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED); // Retorna la transacción creada con código 201
    }

    // Endpoint para obtener transacciones por userId
    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable String userId) {
        List<Transaction> transactions = queryService.getTransactionsByUser(userId);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 si no hay transacciones
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK); // Retorna la lista de transacciones con código 200
    }
}
