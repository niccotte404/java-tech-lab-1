package com.lab1.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private List<User> clients = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
}
