package com.lab1.services;

import com.lab1.entities.Transaction;
import com.lab1.entities.models.memento.TransactionMemento;

public class TransactionMapper {
    public static Transaction mapToTransaction(TransactionMemento transactionMemento) {
        return Transaction.builder()
                .id(transactionMemento.getId())
                .account(transactionMemento.getAccount())
                .destinationAccount(transactionMemento.getDestinationAccount())
                .type(transactionMemento.getType())
                .money(transactionMemento.getMoney())
                .status(transactionMemento.getStatus())
                .build();
    }

    public static TransactionMemento mapToTransactionMemento(Transaction transaction) {
        return TransactionMemento.builder()
                .id(transaction.getId())
                .account(transaction.getAccount())
                .destinationAccount(transaction.getDestinationAccount())
                .type(transaction.getType())
                .money(transaction.getMoney())
                .status(transaction.getStatus())
                .build();
    }
}
