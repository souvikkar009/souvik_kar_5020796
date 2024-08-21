package com.olbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.olbs.entities.Customer;
import com.olbs.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(savedCustomer);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public ResponseEntity<Customer> registerCustomer(@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String address) {

		Customer customer = new Customer();
		customer.setName(name);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setAddress(address);
		Customer savedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(savedCustomer);
	}
}
