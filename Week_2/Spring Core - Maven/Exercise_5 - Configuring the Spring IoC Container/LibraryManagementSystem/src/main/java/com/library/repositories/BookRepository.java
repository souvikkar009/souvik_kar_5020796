package com.library.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	public BookRepository() {
		System.out.println("BookRepository instance created");
	}

}
