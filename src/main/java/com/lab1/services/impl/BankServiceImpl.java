package com.lab1.services.impl;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.Percentage;
import com.lab1.entities.User;
import com.lab1.services.interfaces.BankService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private final Bank currentBank;

    @Override
    public void registerBankUser(User user) {
        currentBank.getClients().add(user);
    }
    @Override
    public void createBankAccount(Account account) {
        currentBank.getAccounts().add(account);
    }
    @Override
    public void addPercentage(Percentage percentage) {
        currentBank.getPercents().add(percentage);
    }
}
