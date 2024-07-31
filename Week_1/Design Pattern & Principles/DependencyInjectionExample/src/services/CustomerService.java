package services;


import models.Customer;
import repositories.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}
