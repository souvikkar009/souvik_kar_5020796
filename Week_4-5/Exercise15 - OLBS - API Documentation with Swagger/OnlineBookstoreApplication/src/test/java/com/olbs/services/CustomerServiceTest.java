package com.olbs.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.olbs.dtos.CustomerRegistrationDto;
import com.olbs.entities.Customer;
import com.olbs.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	public void CustomerService_CreateCustomer_ReturnsCustomer() {
		CustomerRegistrationDto customerDto = CustomerRegistrationDto.builder().name("Souvik")
				.email("souvikkar009@gmail.com").password("1234").build();

		Customer customer = modelMapper.map(customerDto, Customer.class);

		when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

		String savedCustomer = customerService.registerCustomer(customerDto);

		Assertions.assertThat(savedCustomer).asString();
	}

	@Test
	public void CustomerService_GetAllCustomer_ReturnsResponseDto() {
		@SuppressWarnings("unchecked")
		Page<Customer> customers = Mockito.mock(Page.class);

		when(customerRepository.findAll(Mockito.any(Pageable.class))).thenReturn(customers);

		List<Customer> allCustomers = customerService.getAllCustomers();

		Assertions.assertThat(allCustomers).isNotNull();
	}

	@Test
	public void CustomerService_FindById_ReturnCustomerDto() {
		int customerId = 1;
		CustomerRegistrationDto customerDto = CustomerRegistrationDto.builder().name("Souvik")
				.email("souvikkar009@gmail.com").password("1234").build();

		Customer customer = modelMapper.map(customerDto, Customer.class);
		when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(customer));

		Customer returnCustomer = customerService.getCustomerById(customerId);

		Assertions.assertThat(returnCustomer).isNotNull();
	}

	@Test
	public void CustomerService_UpdateCustomerEmail_ReturnResponse() {
		int customerId = 1;
		String updatedEmail = "souvikkar10@outlook.com";
		CustomerRegistrationDto customerDto = CustomerRegistrationDto.builder().name("Souvik")
				.email("souvikkar009@gmail.com").password("1234").build();

		Customer customer = modelMapper.map(customerDto, Customer.class);

		when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(customer));
		when(customerRepository.save(customer)).thenReturn(customer);

		String response = customerService.updateCustomerEmail(customerId, updatedEmail);

		Assertions.assertThat(response).asString();
	}

	@Test
	public void CustomerService_DeleteCustomerById_ReturnVoid() {
		int customerId = 1;
		CustomerRegistrationDto customerDto = CustomerRegistrationDto.builder().name("Souvik")
				.email("souvikkar009@gmail.com").password("1234").build();

		Customer customer = modelMapper.map(customerDto, Customer.class);

		when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(customer));
		doNothing().when(customerRepository).delete(customer);

		String response = customerService.deleteCustomerById(customerId);

		Assertions.assertThat(response).asString();
	}
}
