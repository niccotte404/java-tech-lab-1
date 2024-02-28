package com.lab1.observers.impl;

import com.lab1.entities.models.Bank;
import com.lab1.entities.models.notifications.BankNotification;
import com.lab1.observers.interfaces.CentralBankObserver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CentralBankObserverImpl implements CentralBankObserver {
    private final List<Bank> banks = new ArrayList<>();

    @NonNull
    private BankNotification bankNotification;

    private void setBankNotification(BankNotification bankNotification){
        this.bankNotification = bankNotification;
        notifyBank();
    }
    @Override
    public void registerBank(Bank bank) {
        banks.add(bank);
    }

    @Override
    public void removeBank(Bank bank) {
        banks.remove(bank);
    }

    @Override
    public void notifyBank() {
        banks.forEach(bank -> bank.update(bankNotification));
    }
}
