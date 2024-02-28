package com.lab1.entities;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.memento.TransactionMemento;
import com.lab1.entities.models.memento.TransactionMementoStorage;
import com.lab1.enums.TransactionStatus;
import com.lab1.enums.TransactionType;
import com.lab1.services.TransactionMapper;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaction {
    @NonNull
    private UUID id;
    @NonNull
    private Account account;
    private Account destinationAccount;
    private TransactionType type;
    private double money;
    private TransactionStatus status;

    private final TransactionMementoStorage transactionMementoStorage;

    public Transaction(Account account, Account destinationAccount, TransactionType type, double money, TransactionStatus status) {
        id = UUID.randomUUID();
        this.account = account;
        this.destinationAccount = destinationAccount;
        this.type = type;
        this.money = money;
        this.status = status;
        this.transactionMementoStorage = new TransactionMementoStorage();
    }

    public void createMemento(){
        transactionMementoStorage.getStorage().push(TransactionMapper.mapToTransactionMemento(this));
    }

    public void restore(){
        TransactionMemento transactionMemento = transactionMementoStorage.getStorage().pop();
        Transaction transaction = TransactionMapper.mapToTransaction(transactionMemento);
        this.id = transaction.getId();
        this.account = transaction.getAccount();
        this.destinationAccount = transaction.getDestinationAccount();
        this.type = transaction.getType();
        this.money = transaction.getMoney();
        this.status = transaction.getStatus();
    }
}
