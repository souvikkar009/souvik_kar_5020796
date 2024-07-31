package repositoryImplement;

import models.Customer;
import repositories.CustomerRepository;


public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        return new Customer("Souvik Kar", id);
    }
}
