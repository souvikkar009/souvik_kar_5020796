package com.olbs.utils;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import com.olbs.controllers.BookController;
import com.olbs.entities.Book;



@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {

	@Override
	public EntityModel<Book> toModel(Book book) {
		return EntityModel.of(book, linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
				linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
	}

}
