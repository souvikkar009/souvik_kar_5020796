import models.Customer;
import repositories.CustomerRepository;
import repositoryImplement.CustomerRepositoryImpl;
import services.CustomerService;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        Customer customer = customerService.findCustomerById(123);
        System.out.println(customer);
    }
}