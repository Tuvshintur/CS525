package bank.mock;

import bank.dao.IEmailSender;

public class MockEmailSender implements IEmailSender {
    @Override
    public void sendEmail() {
        System.out.println("MOCK: Sending email");
    }
}