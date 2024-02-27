package com.lab1.entities.models;

import com.lab1.enums.TransactionStatus;
import com.lab1.enums.TransactionType;
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
    private int accountId;
    private int destinationAccountId;
    private TransactionType type;
    private double money;
    private TransactionStatus status;

    public Transaction(int accountId, int destinationAccountId, TransactionType type, double money, TransactionStatus status) {
        id = UUID.randomUUID();
        this.accountId = accountId;
        this.destinationAccountId = destinationAccountId;
        this.type = type;
        this.money = money;
        this.status = status;
    }
}
