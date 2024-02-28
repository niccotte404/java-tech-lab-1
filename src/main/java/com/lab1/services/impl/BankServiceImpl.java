package com.lab1.services.impl;

import com.lab1.commands.ReplenishCommand;
import com.lab1.commands.TransferCommand;
import com.lab1.commands.WithdrawCommand;
import com.lab1.entities.Transaction;
import com.lab1.entities.User;
import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.Percentage;
import com.lab1.enums.TransactionType;
import com.lab1.enums.UserType;
import com.lab1.services.interfaces.BankService;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService {

    private final Bank currentBank;
    private final Map<TransactionType, Transaction> actionMap = new HashMap<>();

    public BankServiceImpl(Bank currentBank) {
        this.currentBank = currentBank;
    }

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

    @Override
    public Transaction makeTransaction(Transaction transaction) {

        double unverifiedLimit;
        User currUser = currentBank.getClients().stream().filter(user -> user.getId() == transaction.getAccount().getUserId()).findFirst().get();

        if (currUser.getStatus() == UserType.UNVERIFIED)
            unverifiedLimit = currentBank.getUnverifiedLimit();
        else
            unverifiedLimit = Double.MAX_VALUE;

        actionMap.put(TransactionType.TRANSFER, new WithdrawCommand(transaction).execute(unverifiedLimit));
        actionMap.put(TransactionType.REPLENISH, new ReplenishCommand(transaction).execute(unverifiedLimit));
        actionMap.put(TransactionType.WITHDRAW, new TransferCommand(transaction).execute(currentBank.getCreditLimit()));

        return actionMap.get(transaction.getType());
    }

    @Override
    public Transaction makeRestore(Transaction transaction) {

        transaction.restore();

        return transaction;
    }
}
