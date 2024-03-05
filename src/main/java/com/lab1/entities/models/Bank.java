package com.lab1.entities.models;

import com.lab1.entities.User;
import com.lab1.entities.models.data.Limits;
import com.lab1.entities.models.notifications.BankNotification;
import com.lab1.entities.observers.interfaces.CentralBankObserver;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Bank {
    @NonNull
    private final UUID id;
    private final List<Percentage> percents = new ArrayList<>();
    private final List<User> clients = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
    private final List<BankNotification> notifications = new ArrayList<>();
    private double creditLimit = Limits.CREDIT_LIMIT;
    private double unverifiedLimit = Limits.UNVERIFIED_LIMIT;

    public Bank(CentralBankObserver centralBankObserver, double creditLimit, double unverifiedLimit) {
        this.id = UUID.randomUUID();
        centralBankObserver.registerBank(this);
        this.creditLimit = creditLimit;
        this.unverifiedLimit = unverifiedLimit;
    }

    public void update(BankNotification bankNotification){
        notifications.add(bankNotification);
    }
}
