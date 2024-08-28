package com.olbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationDto;
import com.olbs.entities.Customer;
import com.olbs.exceptions.BookException;
import com.olbs.exceptions.CustomerException;
import com.olbs.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping(produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto customerDto) throws CustomerException {
		return new ResponseEntity<>(customerService.addCustomer(customerDto), HttpStatus.CREATED);
	}

	@PostMapping(value = "/register", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationDto form) throws CustomerException {
		return new ResponseEntity<>(customerService.registerCustomer(form), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}/update/email", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") Integer id,
			@RequestBody CustomerDto customerDto) throws CustomerException {
		return new ResponseEntity<String>(customerService.updateCustomerEmail(id, customerDto.getEmail()),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(customerService.deleteCustomerById(id), HttpStatus.ACCEPTED);
	}

	@GetMapping(produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Customer>> getAllCustomers() throws BookException {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws BookException {
		return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
	}
}
