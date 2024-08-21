package com.olbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olbs.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
