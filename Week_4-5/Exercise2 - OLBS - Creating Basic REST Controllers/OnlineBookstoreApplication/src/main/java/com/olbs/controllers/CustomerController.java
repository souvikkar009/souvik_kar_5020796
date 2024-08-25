package com.olbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.olbs.dtos.CustomerDto;
import com.olbs.dtos.CustomerRegistrationForm;
import com.olbs.exceptions.CustomerException;
import com.olbs.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) throws CustomerException {
		return new ResponseEntity<>(customerService.addCustomer(customerDto), HttpStatus.CREATED);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerRegistrationForm form)
			throws CustomerException {
		return new ResponseEntity<>(customerService.registerCustomer(form), HttpStatus.CREATED);
	}

	@PutMapping("/updateEmail/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateCustomerEmail(@PathVariable("id") Integer id, @RequestBody String email)
			throws CustomerException {
		return new ResponseEntity<String>(customerService.updateCustomerEmail(id, email), HttpStatus.OK);
	}
}
