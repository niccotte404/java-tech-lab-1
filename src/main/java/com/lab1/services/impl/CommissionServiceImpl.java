package com.lab1.services.impl;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.DateInDays;
import com.lab1.entities.models.Percentage;
import com.lab1.services.interfaces.CommissionService;

public class CommissionServiceImpl implements CommissionService {
    private double currMoney;
    private double moneyWithCommission;
    private Account account;
    private Bank bank;

    public CommissionServiceImpl(Account account, Bank bank) {
        this.account = account;
        this.bank = bank;
        this.currMoney = account.getMoney();
    }

    @Override
    public void countCommission(int days) {

        Percentage percents = bank.getPercents().stream().filter(
                percentage -> percentage.getAccountType() == account.getType()
                && percentage.getRange().getFirst() <= currMoney
                && percentage.getRange().getSecond() >= currMoney).findAny().get();

        double percentsPerDay = percents.getPercents() / DateInDays.YEAR;
        int months = days / DateInDays.MONTH;

        for (int i = 0; i < months; i++){
            moneyWithCommission = account.getMoney() * percentsPerDay * DateInDays.MONTH;
            currMoney = account.getMoney() + moneyWithCommission;
            account.setMoney(currMoney);
        }
    }
}
