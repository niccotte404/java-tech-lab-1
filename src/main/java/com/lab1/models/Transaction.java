package com.lab1.models;

import com.lab1.enums.TransactionType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaction {
    private int id;
    private int accountId;
    private TransactionType type;
    private double money;
}
