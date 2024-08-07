package com.library.controllers;

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

import com.library.models.Book;
import com.library.services.BookServices;


@RestController
@RequestMapping("/api/library")
public class BookController {
	@Autowired
	private BookServices bookServices;
	
	@PostMapping("/addBook")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		return new ResponseEntity<>(bookServices.addBook(book), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> deletBook(@PathVariable("id") int bookId){
		return new ResponseEntity<>(bookServices.deleteBook(bookId), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Book> updateBookShelfNo(@PathVariable("id") int id, @RequestBody Book book) {
		return new ResponseEntity<Book>(bookServices.updateBookSheftNo(book), HttpStatus.OK);
	}
	
	
	@GetMapping("/book/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Book> bookDetails(@PathVariable("id") int id) {
		return new ResponseEntity<>(bookServices.getBookDetails(id), HttpStatus.OK);

	}
	
	@GetMapping("/book/all")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Book>> allBooksDetails(){
		return new ResponseEntity<List<Book>>(bookServices.getAllBookDetails(), HttpStatus.OK);
	}
}
