package with.templatemethod;

public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Frank Brown", "fbrown@gmail.com");
		VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
		PaymentProcessor paymentProcessor1 = new VisaPayment(customer1, visaCard);
		paymentProcessor1.proccessPayment(125.75, "USD");
		
		System.out.println("------------------------------------");
		
		Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
		PaymentProcessor paymentProcessor2 = new PaypalPayment("jdoe@gmail.com", customer2);
		paymentProcessor2.proccessPayment(175000.0, "INR");

	}
}
