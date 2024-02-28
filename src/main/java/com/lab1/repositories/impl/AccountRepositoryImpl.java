package com.lab1.repositories.impl;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.enums.AccountType;
import com.lab1.repositories.interfaces.AccountRepository;

import java.util.List;
import java.util.UUID;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public List<Account> getAccountsByUserIdAndBankAndAccountType(UUID userId, Bank bank, AccountType accountType) {
        return bank.getAccounts().stream().filter(account -> account.getUserId() == userId && account.getType() == accountType).toList();
    }
}
