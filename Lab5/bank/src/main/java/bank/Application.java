package bank;

import java.util.Collection;

import bank.domain.*;
import bank.service.AccountService;
import bank.service.IAccountService;


public class Application {
    public static void main(String[] args) {

        HistoryList history = new HistoryList();

        IAccountService accountService = new AccountService();
        // create 2 accounts;
        accountService.createAccount(1263862, "Frank Brown");
        accountService.createAccount(4253892, "John Doe");
        //use account 1;
//        accountService.deposit(1263862, 240);
//        accountService.deposit(1263862, 529);
//        accountService.withdraw(1263862, 230);
        DepositCommand depositCommand1 = new DepositCommand(accountService, 1263862, 240);
        DepositCommand depositCommand2 = new DepositCommand(accountService, 1263862, 529);
        WithdrawCommand depositCommand3 = new WithdrawCommand(accountService, 1263862, 230);

        depositCommand1.execute();
        history.addCommand(depositCommand1);

        depositCommand2.execute();
        history.addCommand(depositCommand2);

        depositCommand3.execute();
        history.addCommand(depositCommand3);

        //use account 2;
//        accountService.deposit(4253892, 12450);
//        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");

        DepositCommand depositCommand4 = new DepositCommand(accountService, 4253892, 12450);
        TransferFundsCommand transferFundsCommand = new TransferFundsCommand(accountService, 4253892, 1263862, 100, "payment of invoice 10232");

        depositCommand4.execute();
        history.addCommand(depositCommand4);

        transferFundsCommand.execute();
        history.addCommand(transferFundsCommand);

        history.undo();

        // show balances

        Collection<Account> accountlist = accountService.getAllAccounts();
        Customer customer = null;
        for (Account account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            }
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }
    }

}


