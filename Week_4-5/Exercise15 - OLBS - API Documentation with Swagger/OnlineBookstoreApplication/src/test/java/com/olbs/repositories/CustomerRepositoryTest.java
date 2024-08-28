package com.olbs.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.olbs.entities.Customer;


import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void CustomerRepository_Save_ReturnSavedCustomer() {
		Customer customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();
		Customer savedCustomer = customerRepository.save(customer);
		
		Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
	}
	
	@Test
    public void CustomerRepository_GetAll_ReturnMoreThenOneCustomer() {
        Customer customer1 = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();
        Customer customer2 = Customer.builder().name("Babai").email("souvikkar10@outlook.com").password("123456").build();
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findAll();

        Assertions.assertThat(customerList).isNotNull();
        Assertions.assertThat(customerList.size()).isEqualTo(2);
    }
	
	@Test
    public void CustomerRepository_FindById_ReturnCustomer() {
        Customer customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();

        customerRepository.save(customer);

        Customer customerList = customerRepository.findById(customer.getId()).get();

        Assertions.assertThat(customerList).isNotNull();
    }

    @Test
    public void CustomerRepository_FindByEmail_ReturnCustomerNotNull() {
        Customer customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();

        customerRepository.save(customer);

        Customer customerList = customerRepository.findByEmail(customer.getEmail()).get();

        Assertions.assertThat(customerList).isNotNull();
    }

    @Test
    public void CustomerRepository_UpdateCustomer_ReturnCustomerNotNull() {
        Customer customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();

        customerRepository.save(customer);

        Customer customerSave = customerRepository.findById(customer.getId()).get();
        customerSave.setEmail("souvikkar10@outlook.com");
        customerSave.setName("Babai");

        Customer updatedCustomer = customerRepository.save(customerSave);

        Assertions.assertThat(updatedCustomer.getName()).isNotNull();
        Assertions.assertThat(updatedCustomer.getEmail()).isNotNull();
    }

    @Test
    public void CustomerRepository_CustomerDelete_ReturnCustomerIsEmpty() {
        Customer customer = Customer.builder().name("Souvik").email("souvikkar009@gmail.com").password("1234").build();
        customerRepository.save(customer);

        customerRepository.deleteById(customer.getId());
        Optional<Customer> customerReturn = customerRepository.findById(customer.getId());

        Assertions.assertThat(customerReturn).isEmpty();
    }
}
