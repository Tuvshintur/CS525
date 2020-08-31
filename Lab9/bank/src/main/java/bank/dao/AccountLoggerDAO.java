package bank.dao;

import bank.domain.Account;

import java.util.Collection;

public class AccountLoggerDAO extends AccountDAO{

    public void saveAccount(Account account) {
        super.saveAccount(account);
        System.out.println("logging");
    }

    public void updateAccount(Account account) {
        System.out.println("logging");
        super.updateAccount(account);
    }

    public Account loadAccount(long accountnumber) {
        System.out.println("logging");
        return super.loadAccount(accountnumber);
    }

    public Collection<Account> getAccounts() {
        System.out.println("logging");
        return super.getAccounts();
    }
}
