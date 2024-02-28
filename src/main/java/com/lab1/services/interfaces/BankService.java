package com.lab1.services.interfaces;

import com.lab1.entities.Transaction;
import com.lab1.entities.models.Account;
import com.lab1.entities.models.Percentage;
import com.lab1.entities.User;

public interface BankService {
     void registerBankUser(User user);
     void createBankAccount(Account account);
     void addPercentage(Percentage percentage);
     Transaction makeTransaction(Transaction transaction);
     Transaction makeRestore(Transaction transaction);
}
