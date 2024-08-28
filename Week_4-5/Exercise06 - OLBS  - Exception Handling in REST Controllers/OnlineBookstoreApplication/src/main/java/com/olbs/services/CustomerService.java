package com.olbs.services;

import java.util.List;

import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationForm;
import com.olbs.entities.Customer;
import com.olbs.exceptions.CustomerException;

public interface CustomerService {
	public Customer addCustomer(CustomerDto customerDto) throws CustomerException;

	public String registerCustomer(CustomerRegistrationForm form) throws CustomerException;

	public String updateCustomerEmail(Integer id, String email) throws CustomerException;

	public String deleteCustomerById(Integer id) throws CustomerException;

	public List<Customer> getAllCustomers() throws CustomerException;

}
