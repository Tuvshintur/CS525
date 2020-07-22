package bank.domain;

import bank.service.IAccountService;

public class WithdrawCommand implements Command {

    private IAccountService accountService;
    private long accountNumber;
    private double amount;

    public WithdrawCommand(IAccountService accountService, long accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        this.accountService.withdraw(this.accountNumber, this.amount);
    }

    @Override
    public void unExecute() {
        this.accountService.deposit(this.accountNumber, this.amount);
    }
}
