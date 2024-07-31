package repositories;

import models.Customer;

public interface CustomerRepository {
    public Customer findCustomerById(int id);
}
