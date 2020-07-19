package customers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public Iterator<Customer> ageIterator(Comparator<Customer> comparator) {
		return new AgeIterator<>(customers, comparator);
	}

	public Iterator<Customer> filterIterator(Predicate<Customer> predicate) {
		return new FilterIterator<>(customers, predicate);
	}

	public SkipIterator<Customer> skipIterator() {
		return new SkipIterator<>(customers);
	}

}
