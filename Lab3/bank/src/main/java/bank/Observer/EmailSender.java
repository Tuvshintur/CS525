package bank.Observer;

import bank.domain.Account;

public class EmailSender extends Observer {

    public void send(String str) {
        System.out.println(str);
    }

    @Override
    void update(Account account) {
        String sendStr = "EMAIL:Account Number:" + account.getAccountnumber() + " Balance:" + account.getBalance();
        send(sendStr);
    }
}
