package com.kelly.mvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kelly.mvc.Models.Book;
import com.kelly.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
   private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private List<Book> books = new ArrayList<Book>(Arrays.asList( //initializing with this list
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
    
 
    
   //  returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
//        
//    public List<Book> allBooks()
//    {
//    	return books;
//    }
    // retrieves a book from list
    public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
    
    // creates a book from DB
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book from DB
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }//updates a book in the list
    public void updateBook(int id, Book book) {
    	if (id < books.size()) {
    		books.set(id, book);
    	}
    }
    //Deletes a book in the list
    public void destroyBook(int id) {
        if (id < books.size()){
            books.remove(id);
        }
    }
    
    public Book bookUpdate(Long id, String title, String description, String language, Integer pages) {
    	if (id < 10000000) { // dummy statement for the time being
    		Optional<Book> b = bookRepository.findById(id);
    		Book book = b.get();
    		book.setTitle(title);
    		book.setDescription(description);
    		book.setLanguage(language);
    		book.setNumberOfPages(pages);
    		bookRepository.save(book);
    		return book;
    	}
    	else {
    		return null;
    	}
    	
    	
    }
    public void deleteBook(Long id) {
    		bookRepository.deleteById(id);
    
    }
}
