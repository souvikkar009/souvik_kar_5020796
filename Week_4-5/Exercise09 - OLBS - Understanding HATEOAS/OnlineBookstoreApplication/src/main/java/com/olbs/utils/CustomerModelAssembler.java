package com.olbs.utils;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import com.olbs.controllers.BookController;
import com.olbs.entities.Book;
import com.olbs.entities.Customer;



@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

	@Override
	public EntityModel<Customer> toModel(Customer customer) {
		return EntityModel.of(customer, linkTo(methodOn(BookController.class).getBookById(customer.getId())).withSelfRel(),
				linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
	}

}
