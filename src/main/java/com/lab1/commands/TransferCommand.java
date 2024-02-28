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
    public Transaction execute(double limit) {
        if (transaction.getAccount().getMoney() - transaction.getMoney() < 0
                || transaction.getDestinationAccount().getMoney() + transaction.getMoney() > limit)
            throw new ArithmeticException("Out of account limit");
        transaction.getAccount().setMoney(transaction.getAccount().getMoney() - transaction.getMoney());
        transaction.getDestinationAccount().setMoney(transaction.getDestinationAccount().getMoney() + transaction.getMoney());
        transaction.setStatus(TransactionStatus.SUCCEED);
        transaction.createMemento();

        return transaction;
    }
}
