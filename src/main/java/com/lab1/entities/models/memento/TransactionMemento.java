package com.lab1.entities.models.memento;

import com.lab1.entities.models.Account;
import com.lab1.enums.TransactionStatus;
import com.lab1.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class TransactionMemento {
    @NonNull
    private UUID id;
    @NonNull
    private Account account;
    private Account destinationAccount;
    private TransactionType type;
    private double money;
    private TransactionStatus status;
}
