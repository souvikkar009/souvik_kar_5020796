package com.olbs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.olbs.entities.Book;

import jakarta.persistence.LockModeType;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@SuppressWarnings("unchecked")
	@Override
    @Lock(value = LockModeType.OPTIMISTIC)
    public Book save(Book book);
	
	public Optional<List<Book>> findByAuthor(String author);

	public Optional<Book> findByIsbn(String isbn);

	public Optional<List<Book>> findByTitle(String title);
}