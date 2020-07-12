package bank.Observer;

import bank.domain.Account;

public class Logger extends Observer {

    public void log(String str) {
        System.out.println(str);
    }
    @Override
    void update(Account account) {
        String logStr = "LOG:Account Number:" + account.getAccountnumber() + " Balance:" + account.getBalance();
        log(logStr);
    }
}
