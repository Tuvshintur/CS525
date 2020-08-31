package bank.factory;

import bank.dao.IAccountDAO;
import bank.dao.IEmailSender;
import bank.mock.MockAccountDAO;
import bank.mock.MockEmailSender;

public class MockFactory implements MyFactory {
    @Override
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new MockEmailSender();
    }
}
