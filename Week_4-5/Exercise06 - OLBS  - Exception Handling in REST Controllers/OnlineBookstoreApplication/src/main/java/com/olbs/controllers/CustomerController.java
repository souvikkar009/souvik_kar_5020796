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
import com.olbs.dtos.CustomerRegistrationForm;
import com.olbs.entities.Customer;
import com.olbs.exceptions.BookException;
import com.olbs.exceptions.CustomerException;
import com.olbs.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto customerDto) throws CustomerException {
		return new ResponseEntity<>(customerService.addCustomer(customerDto), HttpStatus.CREATED);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationForm form)
			throws CustomerException {
		return new ResponseEntity<>(customerService.registerCustomer(form), HttpStatus.CREATED);
	}

	@PutMapping("/{id}/update/email")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") Integer id, @RequestBody CustomerDto customerDto)
			throws CustomerException {
		return new ResponseEntity<String>(customerService.updateCustomerEmail(id, customerDto.getEmail()), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(customerService.deleteCustomerById(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Customer>> getAllBooks() throws BookException {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
}
