package com.lab1.entities.observers.interfaces;

import com.lab1.entities.models.Bank;

public interface CentralBankObserver {
    void registerBank(Bank bank);
    void removeBank(Bank bank);
    void notifyBank();
}
