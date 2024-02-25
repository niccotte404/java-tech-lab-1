package com.lab1.models;

import com.lab1.enums.AccountType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private AccountType type;
    private double money;
    // deside what type of collection to use
    private List<Transaction> transactionHistory = new ArrayList<>();
}
