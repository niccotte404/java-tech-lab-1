package com.lab1.repositories.interfaces;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.enums.AccountType;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    List<Account> getAccountsByUserIdAndBankAndAccountType(UUID userId, Bank bank, AccountType accountType);
}
