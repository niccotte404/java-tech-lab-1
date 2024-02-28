package com.lab1.entities.models.memento;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Stack;

@Getter
@NoArgsConstructor
public class TransactionMementoStorage {
    private final Stack<TransactionMemento> storage = new Stack<>();
}
