package com.olbs.services;

import java.util.List;

import com.olbs.dtos.BookDto;
import com.olbs.entities.Book;
import com.olbs.exceptions.BookException;

public interface BookService {
	public Book addBook(BookDto bookDto) throws BookException;

	public String deleteBookById(Integer id) throws BookException;

	public String updateBookPrice(Integer id, Integer price) throws BookException;

	public Book getBookById(Integer id) throws BookException;

	public List<Book> getBooksByTitle(String title) throws BookException;

	public List<Book> getBooksByAuthor(String author) throws BookException;

	public Book getBookByISBN(String isbn);

	public List<Book> getAllBooks() throws BookException;

	public String addMultipleBooks2(List<BookDto> booksDtos) throws BookException;

}
