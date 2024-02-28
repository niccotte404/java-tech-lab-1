package com.lab1.services.impl;

import com.lab1.entities.Transaction;
import com.lab1.entities.models.*;
import com.lab1.enums.AccountType;
import com.lab1.services.interfaces.CentralBankService;

public class CentralBankServiceImpl implements CentralBankService {
    private double currMoney;
    private final CentralBank centralBank;

    public CentralBankServiceImpl(CentralBank centralBank) {
        this.centralBank = centralBank;
    }

    @Override
    public void createBank(Bank bank) {
        centralBank.banks.add(bank);
    }

    @Override
    public void semiBankTransaction(Transaction transaction, Bank departionBank, Bank destinationBank) {
        transaction.getAccount().setMoney(transaction.getAccount().getMoney() - transaction.getMoney());
        transaction.getDestinationAccount().setMoney(transaction.getDestinationAccount().getMoney() + transaction.getMoney());
    }

    @Override
    public void countBankCommission(int days, Bank bank, Account account) {

        double moneyWithCommission;
        currMoney = account.getMoney();

        Percentage percents = bank.getPercents().stream().filter(
                percentage -> percentage.getAccountType() == account.getType()
                        && percentage.getRange().getFirst() <= currMoney
                        && percentage.getRange().getSecond() >= currMoney).findAny().get();

        double percentsPerDay = percents.getPercents() / DateInDays.YEAR;
        int months = days / DateInDays.MONTH;

        for (int i = 0; i < months; i++){
            moneyWithCommission = account.getMoney() * percentsPerDay * DateInDays.MONTH;
            if (account.getType() == AccountType.CREDIT)
                currMoney = account.getMoney() - moneyWithCommission;
            else
                currMoney = account.getMoney() + moneyWithCommission;
            account.setMoney(currMoney);
        }
    }
}
