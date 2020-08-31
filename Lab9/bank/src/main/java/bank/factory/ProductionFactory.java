package bank.factory;

import bank.dao.*;

public class ProductionFactory implements MyFactory {
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountLoggerDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return new EmailSender();
    }
}
