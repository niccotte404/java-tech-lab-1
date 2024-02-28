package com.lab1.entities.models;

import com.lab1.entities.Transaction;
import com.lab1.enums.AccountType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @NonNull
    private UUID id;
    @NonNull
    private UUID userId;
    private AccountType type;
    private double money;
    // deside what type of collection to use
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(UUID userId, AccountType type, double money, List<Transaction> transactionHistory) {
        id = UUID.randomUUID();
        this.userId = userId;
        this.type = type;
        this.money = money;
        this.transactionHistory = transactionHistory;
    }
}
