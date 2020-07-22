package bank.domain;

public interface Command {
    public void execute();

    public void unExecute();
}
