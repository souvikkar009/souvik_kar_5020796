package com.olbs.services;



import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationForm;
import com.olbs.exceptions.CustomerException;


public interface CustomerService {
	public CustomerDto addCustomer(CustomerDto customerDto) throws CustomerException;

	public String registerCustomer(CustomerRegistrationForm form) throws CustomerException;
	
	public String updateCustomerEmail(Integer id, String email) throws CustomerException;

}
