package com.lab1.entities.observers.interfaces;

import com.lab1.entities.User;

public interface BankObserver {
    void registerUser(User user);
    void removeUser(User user);
    void notifyUser();
}
