package com.lab1.entities.models;

import com.lab1.enums.AccountType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Percentage {
    private double percents;
    private Tuple<Double, Double> range;
    private AccountType accountType;
}
