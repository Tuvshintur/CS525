package bank.mock;

import bank.dao.IAccountDAO;
import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class MockAccountDAO implements IAccountDAO {
    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public Account loadAccount(long accountnumber) {
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }

}
