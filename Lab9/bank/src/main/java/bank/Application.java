package bank;

import bank.dao.ConnectionPool;
import bank.dao.IAccountDAO;
import bank.dao.IEmailSender;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.factory.DAOFactory;
import bank.factory.MyFactory;
import bank.service.AccountService;
import bank.service.IAccountService;

import java.util.Collection;


public class Application {
	public static void main(String[] args) {
		DAOFactory daoFactory = new DAOFactory();
		MyFactory myFactory = daoFactory.getFactoryInstance();
		IAccountDAO iAccountDAO = myFactory.getAccountDAO();
		IEmailSender iEmailSender = myFactory.getEmailSender();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ConnectionPool instance1 = ConnectionPool.getPool();
				System.out.println("Instance 1 hash:" + instance1.hashCode());
			}
		});

		t1.start();


		IAccountService accountService = new AccountService(iAccountDAO);
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		iEmailSender.sendEmail();
		accountService.deposit(1263862, 529);
		iEmailSender.sendEmail();
		accountService.withdraw(1263862, 230);
		iEmailSender.sendEmail();
		//use account 2;
		accountService.deposit(4253892, 12450);
		iEmailSender.sendEmail();
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		iEmailSender.sendEmail();
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


