package bank.Observer;

import bank.domain.Account;

public abstract class Observer {
    abstract void update(Account account);
}
