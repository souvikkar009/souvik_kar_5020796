package com.library.services;

import java.util.Iterator;

import com.library.repository.BookRepository;

public class BookService {

	BookRepository bookRepository;

	public BookService() {
		System.out.println("BookService instance created");
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		System.out.println("BookRepository instance is embedded in BookService");
		this.bookRepository = bookRepository;
	}

	public void bookServiceMethod() {
		// using nested loop to delay the completion method
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {

			}
		}
		System.out.println("Book service method");
	}

}
