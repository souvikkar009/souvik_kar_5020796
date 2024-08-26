package com.olbs.services.implementations;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olbs.dtos.BookDto;
import com.olbs.entities.Book;
import com.olbs.exceptions.BookException;
import com.olbs.repositories.BookRepository;
import com.olbs.services.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImplements implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Book addBook(BookDto bookDto) throws BookException {
		Optional<Book> isSameIsbnBook = bookRepository.findByIsbn(bookDto.getIsbn());
		if (isSameIsbnBook.isPresent()) {
			throw new BookException("ISBN number exists!");
		}
		Book book = convertToEntity(bookDto);
		bookRepository.save(book);
		return book;

	}

	@Override
	public String deleteBookById(Integer id) throws BookException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty()) {
			throw new BookException("Book with Id: " + id + " does not exist");
		}
		bookRepository.deleteById(id);
		return "Book with Id: " + id + " deleted";
	}

	@Override
	@Transactional
	public String updateBookPrice(Integer id, Integer price) throws BookException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty()) {
			throw new BookException("Book with Id: " + id + " does not exist");
		}
		Integer oldPrice = book.get().getPrice();
		book.get().setPrice(price);
		bookRepository.save(book.get());
		return "Book(Id: " + book.get().getId() + ") price changed from " + oldPrice + " to " + price;
	}

	@Override
	public Book getBookById(Integer id) throws BookException {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isEmpty()) {
			throw new BookException("Book with Id: " + id + " does not exist");
		}
		return book.get();
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws BookException {
		Optional<List<Book>> books = bookRepository.findByTitle(title);
		if (books.isEmpty()) {
			throw new BookException("Book with Title: " + title + " does not exist");
		}
		return books.get();
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookException {
		Optional<List<Book>> books = bookRepository.findByAuthor(author);
		if (books.isEmpty()) {
			throw new BookException("Book with Author: " + author + " does not exist");
		}
		return books.get();
	}

	@Override
	public Book getBookByISBN(String isbn) {
		Optional<Book> book = bookRepository.findByIsbn(isbn);
		if (book.isEmpty()) {
			throw new BookException("Book with ISBN: " + isbn + " does not exist");
		}
		return book.get();
	}

	@Override
	public List<Book> getAllBooks() throws BookException {
		List<Book> books = bookRepository.findAll();
		if (books.isEmpty()) {
			throw new BookException("No book exists");
		}
		return books;
	}

	@Override
	public String addMultipleBooks2(List<BookDto> bookDtos) throws BookException {
		int cnt = 0;
		for (BookDto bookDto : bookDtos) {
			Optional<Book> isSameIsbnBook = bookRepository.findByIsbn(bookDto.getIsbn());
			if (isSameIsbnBook.isPresent()) {
				continue;
			}
			Book book = convertToEntity(bookDto);
			bookRepository.save(book);
			cnt++;
		}
		return "Successful book addition: " + cnt + "\nUnsuccessful : " + (bookDtos.size() - cnt);
	}

	public Book convertToEntity(BookDto bookDto) {
		return modelMapper.map(bookDto, Book.class);
	}

}
