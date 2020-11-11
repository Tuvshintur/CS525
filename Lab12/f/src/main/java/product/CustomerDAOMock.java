package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
public class CustomerDAOMock implements ICustomerDAO {

	private ILogger logger;

	@Autowired
	public CustomerDAOMock(ILogger logger){
		this.logger = logger;
	}

	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAOMock: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB(Mock): "+ customer.getName() );
	}

}
