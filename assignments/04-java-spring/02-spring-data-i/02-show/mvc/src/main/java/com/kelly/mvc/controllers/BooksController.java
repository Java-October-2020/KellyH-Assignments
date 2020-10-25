package com.kelly.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelly.mvc.Models.Book;
import com.kelly.mvc.services.BookService;

@Controller
public class BooksController{
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable(value="index") int index) {
		Book book = bookService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}
}

