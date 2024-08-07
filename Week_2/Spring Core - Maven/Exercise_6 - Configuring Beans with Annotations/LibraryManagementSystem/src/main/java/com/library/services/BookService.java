package com.library.services;

import org.springframework.stereotype.Service;

import com.library.repositories.BookRepository;

@Service
public class BookService {
	BookRepository bookRepository;

	public BookService() {
		System.out.println("BookService instance creatded");
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void bookServiceMethod() {
		System.out.println("This a method of BookService class");
	}
	
}
