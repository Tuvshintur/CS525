package counter;

public abstract class Observer extends javax.swing.JFrame {
    protected Counter counter;
    public Observer(Counter counter) {
        this.counter = counter;
    }
    abstract void update();
}
