package com.lab1.entities.models;

import com.lab1.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Bank {
    private final List<Percentage> percents = new ArrayList<>();
    private final List<User> clients = new ArrayList<>();
    private final List<Account> accounts = new ArrayList<>();
}
