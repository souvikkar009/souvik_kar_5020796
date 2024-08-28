package com.olbs.repositories;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.olbs.entities.Book;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void BookRepository_Save_ReturnSavedBook() {
		Book book = Book.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();
		Book savedBook = bookRepository.save(book);

		Assertions.assertThat(savedBook).isNotNull();
		Assertions.assertThat(savedBook.getId()).isGreaterThan(0);
	}

	@Test
	public void BookRepository_GetAll_ReturnMoreThenOneBook() {
		Book book1 = Book.builder().title("My Book1").author("Souvik").price(150).isbn("A12345").build();
		Book book2 = Book.builder().title("My Book2").author("Babai").price(250).isbn("B12345").build();
		bookRepository.save(book1);
		bookRepository.save(book2); 

		List<Book> bookList = bookRepository.findAll();

		Assertions.assertThat(bookList).isNotNull();
		Assertions.assertThat(bookList.size()).isEqualTo(2);
	}

	@Test
	public void BookRepository_FindById_ReturnBook() {
		Book book = Book.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		bookRepository.save(book);

		Book bookList = bookRepository.findById(book.getId()).get();

		Assertions.assertThat(bookList).isNotNull();
	}

	@Test
	public void BookRepository_FindByIsbn_ReturnBookNotNull() {
		Book book = Book.builder().title("My Book1").author("Souvik").price(150).isbn("A12345").build();
		
		bookRepository.save(book);

		Book bookList = bookRepository.findByIsbn(book.getIsbn()).get();

		Assertions.assertThat(bookList).isNotNull();
	}

	@Test
	public void BookRepository_FindByTitle_ReturnBooksNotNull() {
		Book book1 = Book.builder().title("My Book1").author("Souvik").price(150).isbn("A12345").build();
		Book book2 = Book.builder().title("My Book2").author("Babai").price(150).isbn("B12345").build();
		Book book3 = Book.builder().title("My Book2").author("Anish").price(300).isbn("C12345").build();
		

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		List<Book> bookList = bookRepository.findByTitle("My Book2").get();

		Assertions.assertThat(bookList).isNotNull();
	}

	@Test
	public void BookRepository_FindByAuthor_ReturnBooksNotNull() {
		Book book1 = Book.builder().title("My Book1").author("Souvik").price(150).isbn("A12345").build();
		Book book2 = Book.builder().title("My Book2").author("Souvik").price(200).isbn("B12345").build();
		Book book3 = Book.builder().title("My Book3").author("Babai").price(300).isbn("C12345").build();
		

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		List<Book> bookList = bookRepository.findByAuthor("Souvik").get();

		Assertions.assertThat(bookList).isNotNull();
	}

	@Test
	public void BookRepository_UpdateBookPrice_ReturnBookNotNull() {
		Book book = Book.builder().title("My Book").author("Souvik").price(150).isbn("A12345").build();

		bookRepository.save(book);

		Book bookSave = bookRepository.findById(book.getId()).get();
		bookSave.setPrice(200);

		Book updatedBook = bookRepository.save(bookSave);

		Assertions.assertThat(updatedBook.getPrice()).isNotNull();
	}

	@Test
	public void BookRepository_BookDelete_ReturnBookIsEmpty() {
		Book book1 = Book.builder().title("My Book1").author("Souvik").price(150).isbn("A12345").build();
		Book book2 = Book.builder().title("My Book2").author("Souvik").price(200).isbn("B12345").build();
		Book book3 = Book.builder().title("My Book3").author("Babai").price(300).isbn("C12345").build();
		

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);

		bookRepository.deleteById(book2.getId());
		
		Optional<Book> bookReturn = bookRepository.findById(book2.getId());

		Assertions.assertThat(bookReturn).isEmpty();
	}
}
