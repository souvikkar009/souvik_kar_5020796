package com.olbs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olbs.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTitleContainingIgnoreCase(String title);

	List<Book> findByAuthorContainingIgnoreCase(String author);

	List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);
}
