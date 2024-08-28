package com.olbs.services;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.olbs.dtos.BookDto;
import com.olbs.entities.Book;
import com.olbs.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	public void BookService_CreateBook_ReturnsBook() {
		BookDto bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		Book book = modelMapper.map(bookDto, Book.class);

		when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

		Book savedBook = bookService.addBook(bookDto);

		Assertions.assertThat(savedBook).isNotNull();
	}

	@Test
	public void BookService_GetAllBook_ReturnsResponseDto() {
		@SuppressWarnings("unchecked")
		Page<Book> books = Mockito.mock(Page.class);

		when(bookRepository.findAll(Mockito.any(Pageable.class))).thenReturn(books);

		List<Book> allBooks = bookService.getAllBooks();

		Assertions.assertThat(allBooks).isNotNull();
	}

	@Test
	public void BookService_FindById_ReturnBookDto() {
		int bookId = 1;
		BookDto bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		Book book = modelMapper.map(bookDto, Book.class);
		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));

		Book returnBook = bookService.getBookById(bookId);

		Assertions.assertThat(returnBook).isNotNull();
	}
	@Test
	public void BookService_FindByTitle_ReturnBookDto() {
		int bookId = 1;
		String bookTitle = "My Book";
		BookDto bookDto = BookDto.builder().title(bookTitle).author("Souvik").price(150).isbn("A12345").build();
		
		Book book = modelMapper.map(bookDto, Book.class);
		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));
		
		List<Book> bookList = bookService.getBooksByTitle(bookTitle);
		
		Assertions.assertThat(bookList).isNotNull();
	}
	@Test
	public void BookService_FindByAuthor_ReturnBookDto() {
		int bookId = 1;
		String bookAuthor = "Souvik";
		BookDto bookDto = BookDto.builder().title("MyBook").author(bookAuthor).price(150).isbn("A12345").build();
		
		Book book = modelMapper.map(bookDto, Book.class);
		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));
		
		List<Book> bookList = bookService.getBooksByAuthor(bookAuthor);
		
		Assertions.assertThat(bookList).isNotNull();
	}
	@Test
	public void BookService_FindByIsbn_ReturnBookDto() {
		int bookId = 1;
		String isbn = "A12345";
		BookDto bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn(isbn).build();
		
		Book book = modelMapper.map(bookDto, Book.class);
		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));
		
		Book returnBook = bookService.getBookByISBN(isbn);
		
		Assertions.assertThat(returnBook).isNotNull();
	}

	@Test
	public void BookService_UpdateBookPrice_ReturnResponse() {
		int bookId = 1;
		int updatedBookPrice = 999;
		BookDto bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		Book book = modelMapper.map(bookDto, Book.class);

		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));
		when(bookRepository.save(book)).thenReturn(book);

		String response = bookService.updateBookPrice(bookId, updatedBookPrice);

		Assertions.assertThat(response).asString();
	}

	@Test
	public void BookService_DeleteBookById_ReturnVoid() {
		int bookId = 1;
		BookDto bookDto = BookDto.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		Book book = modelMapper.map(bookDto, Book.class);

		when(bookRepository.findById(bookId)).thenReturn(Optional.ofNullable(book));
		doNothing().when(bookRepository).delete(book);

		String response = bookService.deleteBookById(bookId);

		Assertions.assertThat(response).asString();
	}
}

