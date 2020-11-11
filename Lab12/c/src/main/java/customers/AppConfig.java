package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public ICustomerService customerService(){
        CustomerService customerService = new CustomerService();
        customerService.setEmailSender(emailSender());
        customerService.setCustomerDAO(customerDAO());
        return customerService;
    }
    @Bean
    public IEmailSender emailSender() {
        return new EmailSender(loggerService());
    }
    @Bean
    public ICustomerDAO customerDAO() {
        return new CustomerDAO(loggerService());
    }
    @Bean
    public ILogger loggerService(){
        return new Logger();
    }
}
