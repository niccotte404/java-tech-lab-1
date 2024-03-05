package com.lab1.entities.observers.impl;

import com.lab1.entities.User;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.notifications.UserNotification;
import com.lab1.entities.observers.interfaces.BankObserver;
import com.lab1.repositories.impl.AccountRepositoryImpl;
import com.lab1.repositories.interfaces.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BankObserverImpl implements BankObserver {
    private final List<User> users = new ArrayList<>();

    @NonNull
    private UserNotification userNotification;
    private final AccountRepository accountRepository = new AccountRepositoryImpl();

    @NonNull
    private Bank bank;

    public void setUserNotification(UserNotification userNotification){
        this.userNotification = userNotification;
        notifyUser();
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public void notifyUser() {
        users.stream().filter(user -> !accountRepository.getAccountsByUserIdAndBankAndAccountType(user.getId(), bank, userNotification.getType()).isEmpty())
                .forEach(user -> user.update(userNotification));
    }
}
