package bank.domain;

public class CheckingInterest implements InterestType {

    @Override
    public double calculateInterest(double balance) {
        if (balance > 1000) {
            return balance * 0.025;
        } else {
            return balance * 0.015;
        }
    }
}
