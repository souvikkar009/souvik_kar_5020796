package com.library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String bookShelfNo;

	public Book() {
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getBookShelfNo() {
		return bookShelfNo;
	}

	public void setBookShelfNo(String bookShelfNo) {
		this.bookShelfNo = bookShelfNo;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", bookShelfNo=" + bookShelfNo
				+ "]";
	}

	

}
