package with.templatemethod;

public class VisaPayment extends PaymentProcessor {
    private VisaCard visaCard;
    private Customer customer;

    public VisaPayment(Customer customer, VisaCard visaCard) {
        this.customer=customer;
        this.visaCard=visaCard;
    }
    @Override
    protected boolean validate() {
        // logic to validate visa card
        System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
    }

    @Override
    protected void pay(double dollarAmount) {
        // logic to perform payment visa card
        System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
                + " and amount $" + dollarAmount);

        // logic to notify customer
        System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
                + " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
    }

    public VisaCard getVisaCard() {
        return visaCard;
    }

    public void setVisaCard(VisaCard visaCard) {
        this.visaCard = visaCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
