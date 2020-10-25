package com.kelly.mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kelly.mvc.Models.Book;
import com.kelly.mvc.services.BookService;

@RestController
public class BooksApi{
	private final BookService bookService;
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/api/books")
	public String index() {
		return bookService.allBooks().toString(); //added toString because allBooks returns List obj
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create (@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numberOfPages) {
		Book book = new Book(title, description, lang, numberOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
}