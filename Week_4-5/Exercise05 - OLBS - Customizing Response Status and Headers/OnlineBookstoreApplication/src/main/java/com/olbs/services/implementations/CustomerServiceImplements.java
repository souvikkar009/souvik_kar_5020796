package com.olbs.services.implementations;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationForm;
import com.olbs.entities.Customer;
import com.olbs.exceptions.BookException;
import com.olbs.exceptions.CustomerException;
import com.olbs.repositories.CustomerRepository;
import com.olbs.services.CustomerService;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

@Service
public class CustomerServiceImplements implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Customer addCustomer(CustomerDto customerDto) throws CustomerException {
		Optional<Customer> customer = customerRepository.findByEmail(customerDto.getEmail());
		if (customer.isPresent()) {
			throw new CustomerException("Customer Already Exists");
		}
		Customer newCustomer = modelMapper.map(customerDto, Customer.class);
		customerRepository.save(newCustomer);

		return newCustomer;
	}

	@Override
	public String registerCustomer(CustomerRegistrationForm form) throws CustomerException {

		Optional<Customer> customer = customerRepository.findByEmail(form.getEmail());
		if (customer.isPresent()) {
			throw new CustomerException("Customer Already Exists");
		}

		try {
			Customer newCustomer = modelMapper.map(form, Customer.class);
			customerRepository.save(newCustomer);
			return "Customer Registration Successfull";
		} catch (ConstraintViolationException e) {
			throw new CustomerException("Validation Error");
		} catch (Exception e) {
			throw new CustomerException("Server Error");
		}
	}

	@Override
	@Transactional
	public String updateCustomerEmail(Integer id, String email) throws CustomerException {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isEmpty()) {
			throw new CustomerException("Customer does not exist");
		}
		customer.get().setEmail(email);
		customerRepository.save(customer.get());
		return "Email Updated";
	}

	@Override
	public String deleteCustomerById(Integer id) throws CustomerException {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isEmpty()) {
			throw new BookException("Customer does not exist");
		}
		customerRepository.deleteById(id);
		return "Customer deletion successful";
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty()) {
			throw new BookException("No customer exists");
		}
		return customers;
	}
}
