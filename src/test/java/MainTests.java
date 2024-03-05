import com.lab1.entities.Transaction;
import com.lab1.entities.User;
import com.lab1.entities.models.Account;
import com.lab1.entities.models.Bank;
import com.lab1.entities.models.CentralBank;
import com.lab1.entities.models.notifications.BankNotification;
import com.lab1.enums.AccountType;
import com.lab1.enums.TransactionStatus;
import com.lab1.enums.TransactionType;
import com.lab1.enums.UserType;
import com.lab1.entities.observers.impl.CentralBankObserverImpl;
import com.lab1.entities.observers.interfaces.CentralBankObserver;
import com.lab1.services.impl.BankServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    @Test
    public void testVerification(){

        User user = new User("Alex", "Green", null, 0);
        Account account = new Account(user.getId(), AccountType.DEBIT, 0);

        CentralBank centralBank = CentralBank.getInstance();
        BankNotification notification = new BankNotification();
        CentralBankObserver centralBankObserver = new CentralBankObserverImpl(notification);

        double creditLimit = 1_000_000;
        double unverifiedLimit = 200_000;
        Bank bank = new Bank(centralBankObserver, creditLimit, unverifiedLimit);

        bank.getClients().add(user);
        bank.getAccounts().add(account);

        Assert.assertEquals(UserType.UNVERIFIED, user.getStatus());
    }

    @Test
    public void testNotValidTransaction(){

        User user = new User("Alex", "Green", null, 0);
        Account account = new Account(user.getId(), AccountType.DEBIT,  0);

        CentralBank centralBank = CentralBank.getInstance();
        BankNotification notification = new BankNotification();
        CentralBankObserver centralBankObserver = new CentralBankObserverImpl(notification);

        double creditLimit = 1_000_000;
        double unverifiedLimit = 200_000;
        Bank bank = new Bank(centralBankObserver, creditLimit, unverifiedLimit);

        bank.getClients().add(user);
        bank.getAccounts().add(account);

        BankServiceImpl bankService = new BankServiceImpl(bank);

        double withdrawingMoney = 1000;
        Transaction transaction = new Transaction(account, account, TransactionType.WITHDRAW, withdrawingMoney);

        try {
            bankService.makeTransaction(transaction);
        }
        catch (Exception ex) {
            transaction.setStatus(TransactionStatus.FAILED);
        }

        Assert.assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }

    @Test
    public void testNotVerifiedUserTransaction(){

        User user = new User("Alex", "Green", null, 0);
        Account account = new Account(user.getId(), AccountType.DEBIT,  0);

        CentralBank centralBank = CentralBank.getInstance();
        BankNotification notification = new BankNotification();
        CentralBankObserver centralBankObserver = new CentralBankObserverImpl(notification);

        double creditLimit = 1_000_000;
        double unverifiedLimit = 200_000;
        Bank bank = new Bank(centralBankObserver, creditLimit, unverifiedLimit);

        bank.getClients().add(user);
        bank.getAccounts().add(account);

        BankServiceImpl bankService = new BankServiceImpl(bank);

        double replenishingMoney = 1_000_001;
        Transaction transaction = new Transaction(account, account, TransactionType.REPLENISH, replenishingMoney);

        try {
            bankService.makeTransaction(transaction);
            transaction.setStatus(TransactionStatus.SUCCEED);
        }
        catch (Exception ex) {
            transaction.setStatus(TransactionStatus.FAILED);
        }

        Assert.assertEquals(TransactionStatus.FAILED, transaction.getStatus());
    }
}
