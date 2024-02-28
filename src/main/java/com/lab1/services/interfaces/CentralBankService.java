package com.lab1.services.interfaces;

import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.Transaction;

public interface CentralBankService {
    void createBank(Bank bank);
    void semiBankTransaction(Transaction transaction, Bank departionBank, Bank destinationBank);
    void countBankCommission(int days, Bank bank, Account account);

}
