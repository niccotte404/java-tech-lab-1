package com.lab1.entities.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class CentralBank {
    private static final CentralBank INSTANCE = new CentralBank();
    public final List<Bank> banks = new ArrayList<>();
    public static CentralBank getInstance() {
        return INSTANCE;
    }
}
