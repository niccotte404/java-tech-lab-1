package com.lab1.entities.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Tuple<FirstElement, SecondElement> {
    private FirstElement first;
    private SecondElement second;
}
