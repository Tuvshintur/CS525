package bank.Observer;

import bank.domain.Account;

public class SMSSender extends Observer {

    public void send(String str) {
        System.out.println(str);
    }

    @Override
    void update(Account account) {
        String sendStr = "SMS:Account Number:" + account.getAccountnumber() + " Balance:" + account.getBalance();
        send(sendStr);
    }
}
