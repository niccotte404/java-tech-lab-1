package com.lab1.commands;

import com.lab1.entities.Transaction;
import com.lab1.enums.TransactionStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransferCommand implements Command {

    @NonNull
    private Transaction transaction;
    @Override
    public Transaction execute() {
        transaction.getAccount().setMoney(transaction.getAccount().getMoney() - transaction.getMoney());
        transaction.getDestinationAccount().setMoney(transaction.getDestinationAccount().getMoney() + transaction.getMoney());
        transaction.setStatus(TransactionStatus.SUCCEED);
        transaction.createMemento();

        return transaction;
    }
}
