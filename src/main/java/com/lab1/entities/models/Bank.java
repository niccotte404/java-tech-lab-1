package com.lab1.entities.models;

import com.lab1.entities.User;
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

    public Bank() {
        this.id = UUID.randomUUID();
    }
}
