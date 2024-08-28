package com.olbs.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olbs.entities.Book;
import com.olbs.entities.Customer;
import com.olbs.exceptions.BookException;
import com.olbs.exceptions.CustomerException;
import com.olbs.repositories.BookRepository;
import com.olbs.repositories.CustomerRepository;
import com.olbs.utils.BookModelAssembler;
import com.olbs.utils.CustomerModelAssembler;

@RestController
@RequestMapping("/resources")
public class ResourceController {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookModelAssembler bookModelAssembler;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerModelAssembler customerModelAssembler;

	@GetMapping( value = "/books", produces = { "application/json", "application/xml" })
	public CollectionModel<EntityModel<Book>> getAllBooks() throws BookException{
		List<EntityModel<Book>> books = bookRepository.findAll().stream().map(bookModelAssembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(books, linkTo(methodOn(ResourceController.class).getAllBooks()).withSelfRel());
	}

	@GetMapping( value = "/books/{id}", produces = { "application/json", "application/xml" })
	public EntityModel<Book> getBookById(@PathVariable Integer id) throws BookException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty()) {
			throw new BookException("Book does not exist.");
		}
		return bookModelAssembler.toModel(book.get());
	}

	@GetMapping( value = "/customers", produces = { "application/json", "application/xml" })
	public CollectionModel<EntityModel<Customer>> getAllCustomers() throws CustomerException{
		List<EntityModel<Customer>> customers = customerRepository.findAll().stream().map(customerModelAssembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(customers, linkTo(methodOn(ResourceController.class).getAllBooks()).withSelfRel());
	}

	@GetMapping( value = "/customers/{id}", produces = { "application/json", "application/xml" })
	public EntityModel<Customer> getCustomerById(@PathVariable Integer id) throws CustomerException {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isEmpty()) {
			throw new BookException("Customer does not exist");
		}
		return customerModelAssembler.toModel(customer.get());
	}
}
