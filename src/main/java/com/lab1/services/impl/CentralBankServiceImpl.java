package com.lab1.services.impl;

import com.lab1.entities.Transaction;
import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.CentralBank;
import com.lab1.entities.models.Percentage;
import com.lab1.entities.models.data.DateInDays;
import com.lab1.enums.AccountType;
import com.lab1.services.interfaces.CentralBankService;

/**
 * CentralBankService(Impl)
 * Please see the {@link CentralBankService} class for true identity
 * @author niccotte
 */
public class CentralBankServiceImpl implements CentralBankService {
    private double currMoney;
    private final CentralBank centralBank;

    public CentralBankServiceImpl(CentralBank centralBank) {
        this.centralBank = centralBank;
    }

    @Override
    public void createBank(Bank bank) {
        centralBank.getBanks().add(bank);
    }

    /**
     * <p>This is a simple description of the method</p>
     * @param transaction provides api to the action
     * @param departionBank add source bank
     * @param destinationBank add destination bank
     * @since 1.0
     */
    @Override
    public void semiBankTransaction(Transaction transaction, Bank departionBank, Bank destinationBank) {
        transaction.getAccount().setMoney(transaction.getAccount().getMoney() - transaction.getMoney());
        transaction.getDestinationAccount().setMoney(transaction.getDestinationAccount().getMoney() + transaction.getMoney());
    }

    /**
     * <p>This is a simple description of the method countBankCommission</p>
     * This method is used to count commission and get amount of money after passing required amount days
     * @param days used to time traveling during counting commission
     * @param bank used to identify source bank and find required percents
     * @param account used to count money amount in the result
     * @since 1.0
     */
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
