package com.olbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.olbs.dtos.BookDto;
import com.olbs.entities.Book;
import com.olbs.exceptions.BookException;
import com.olbs.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping(produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) throws BookException {
		return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.CREATED);
	}

	@PostMapping(value = "/addMany", consumes = "application/json", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> addMultipleBook(@RequestBody List<BookDto> bookDtos) throws BookException {
		System.out.println(bookDtos.size());
		return new ResponseEntity<>(bookService.addMultipleBooks2(bookDtos), HttpStatus.CREATED);
	}

	@GetMapping(produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Book>> getAllBooks() throws BookException {
		return ResponseEntity.ok().body(bookService.getAllBooks());
	}

	@GetMapping(value =  "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws BookException {
		return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
	}

	@PutMapping(value =  "/{id}/update/price", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateBookPrice(@PathVariable("id") Integer id, @RequestBody Integer price) {
		return new ResponseEntity<String>(bookService.updateBookPrice(id, price), HttpStatus.OK);
	}

	@DeleteMapping(value =  "/{id}", produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteBookById(@PathVariable("id") Integer id) {
		return new ResponseEntity<String>(bookService.deleteBookById(id), HttpStatus.ACCEPTED);
	}

}
