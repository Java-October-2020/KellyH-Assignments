package com.kelly.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String findBookByIndex(Model model, @PathVariable(value="index") Long index) {
		Book book = bookService.findBook(index);
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
			this.bookService.createBook(book);
			return "redirect:/books";
		}
	}
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		if (book != null) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}

	@PostMapping("/books/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
			//@PathVariable("title") String title, @PathVariable("language") String language, @PathVariable("pages") int pages, @PathVariable("description") String description, BindingResult result ) {
	    if (result.hasErrors()) {
	    	return "editBook.jsp";
	    }
	    else {
	    	String title = book.getTitle();
	    	String description = book.getDescription();
	    	String language = book.getLanguage();
	    	Integer pages = book.getNumberOfPages();
		bookService.bookUpdate(id, title, description, language, pages);
		System.out.println(title + description + language + pages);
		return "redirect:/books";
	    }
	}
	
	@RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}

