package bank.Observer;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    Collection<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observer != null)
            observers.remove(observer);
    }

    public void onNotify(Account account) {
        for (Observer observer : observers) {
            observer.update(account);
        }
    }
}
