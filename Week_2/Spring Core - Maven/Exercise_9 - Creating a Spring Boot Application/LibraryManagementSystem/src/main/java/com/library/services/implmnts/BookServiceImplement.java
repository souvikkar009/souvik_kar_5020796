package com.library.services.implmnts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.Book;
import com.library.repositories.BookRepository;
import com.library.services.BookServices;

@Service
public class BookServiceImplement implements BookServices {
	@Autowired
	private BookRepository bookRepository;

	public BookServiceImplement(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public BookRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public String deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
		return "Book with bookId: " + bookId + " deleted";
	}

	@Override
	public Book updateBookSheftNo(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public Book getBookDetails(int bookId) {
		return bookRepository.findById(bookId).get();

	}

	@Override
	public List<Book> getAllBookDetails() {
		List<Book> allBooks = new ArrayList<>();
		bookRepository.findAll().forEach(book -> allBooks.add(book));
		return allBooks;

	}
}
