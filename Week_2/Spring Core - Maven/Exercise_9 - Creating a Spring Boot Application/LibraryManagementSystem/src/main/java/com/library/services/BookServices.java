package com.library.services;

import java.util.List;

import com.library.models.Book;

public interface BookServices {
	public Book addBook(Book book);
	public String deleteBook(int bookId);
	public Book updateBookSheftNo(Book book);
	public Book getBookDetails(int bookId);
	public List<Book> getAllBookDetails();
}
