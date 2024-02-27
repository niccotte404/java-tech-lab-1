package com.lab1.entities.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CentralBank {
    private final List<Bank> banks = new ArrayList<>();
}
