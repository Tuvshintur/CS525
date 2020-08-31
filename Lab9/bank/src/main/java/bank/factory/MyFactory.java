package bank.factory;

import bank.dao.IAccountDAO;
import bank.dao.IEmailSender;

public interface MyFactory {
    public IAccountDAO getAccountDAO();
    public IEmailSender getEmailSender();
}
