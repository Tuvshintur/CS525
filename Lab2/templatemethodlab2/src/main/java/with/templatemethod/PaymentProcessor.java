package with.templatemethod;

public abstract class PaymentProcessor {

    protected void proccessPayment(double amount, String currency) {
        double dollarAmount = convert(amount, currency);
        boolean validation = validate();
        if(validation) {
            pay(dollarAmount);
        }
    }

    private double convert(double amount, String currency) {
        double dollarAmount = amount;

        if (currency.contentEquals("EUR")) { // European Euro
            dollarAmount = amount * 1.1;
            System.out.println("Convert " + amount + " " + currency + " to US dollars");

        }
        if (currency.contentEquals("INR")) { // Indian Rupee
            dollarAmount = amount * 0.014;
            System.out.println("Convert " + amount + " " + currency + " to US dollars");

        }
        return dollarAmount;
    }

    protected abstract boolean validate();

    protected abstract void pay(double dollarAmount);

}
