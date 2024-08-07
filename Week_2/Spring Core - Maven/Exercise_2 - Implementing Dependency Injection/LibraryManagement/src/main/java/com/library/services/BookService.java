package com.library.services;

import com.library.repository.BookRepository;

public class BookService {
	
	BookRepository bookRepository;

	public BookService() {
		System.out.println("BookService instance initiated");
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		System.out.println("BookRepository instance is embbeded in BookService.");
		this.bookRepository = bookRepository;
	}
	
}
