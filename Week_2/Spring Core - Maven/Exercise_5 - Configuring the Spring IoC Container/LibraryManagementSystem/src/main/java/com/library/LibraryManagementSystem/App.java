package com.library.LibraryManagementSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.services.BookService;


public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookService = context.getBean("bookService", BookService.class);
		bookService.bookServiceMethod();
	}
}
