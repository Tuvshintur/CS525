package counter;

public class DecrementCommand implements Command{

    private Counter counter;

    public DecrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        this.counter.decrement();
    }

    @Override
    public void unExecute() {
        this.counter.increment();
    }
}
