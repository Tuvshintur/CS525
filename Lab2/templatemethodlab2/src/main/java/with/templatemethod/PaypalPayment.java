package with.templatemethod;

public class PaypalPayment extends PaymentProcessor {

    private String paypalAddress;
    private Customer customer;

    public PaypalPayment(String paypalAddress, Customer customer) {
        this.paypalAddress = paypalAddress;
        this.customer = customer;
    }

    @Override
    protected boolean validate() {
        // logic to validate paypal address
        System.out.println("Validate paypal address " + paypalAddress);
        return true;
    }

    @Override
    protected void pay(double dollarAmount) {
        // logic to perform paypal payment
        System.out.println("Perform payment with paypal address " + paypalAddress + " and amount $" + dollarAmount);

        // logic to notify customer
        System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail() + " about paypal payment to address " + paypalAddress);
    }

    public String getPaypalAddress() {
        return paypalAddress;
    }

    public void setPaypalAddress(String paypalAddress) {
        this.paypalAddress = paypalAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
