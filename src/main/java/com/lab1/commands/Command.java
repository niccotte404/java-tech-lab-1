package com.lab1.commands;

import com.lab1.entities.Transaction;

public interface Command {
    Transaction execute();
}
