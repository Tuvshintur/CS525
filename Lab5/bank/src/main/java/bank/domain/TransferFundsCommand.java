package bank.domain;

import bank.service.IAccountService;

public class TransferFundsCommand implements Command {

    private IAccountService accountService;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private String description;

    public TransferFundsCommand(IAccountService accountService, long fromAccountNumber, long toAccountNumber, double amount, String description) {
        this.accountService = accountService;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        this.accountService.transferFunds(this.fromAccountNumber, this.toAccountNumber, this.amount, this.description);
    }

    @Override
    public void unExecute() {
        this.accountService.transferFunds(this.toAccountNumber, this.fromAccountNumber, this.amount, this.description + "undo action");
    }
}
