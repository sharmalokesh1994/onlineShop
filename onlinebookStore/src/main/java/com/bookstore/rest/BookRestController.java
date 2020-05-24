package com.bookstore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.entity.Order;
import com.bookstore.rest.exception.ObjNotFoundException;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
	
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/isbn/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		
		return bookService.getBookByIsbn(isbn);
		
	}
	
	@GetMapping("/title/{title}")
	public List<Book> getBookByTitle(@PathVariable String title) {
		
		return bookService.getBookByTitle(title);
		
	}
	
	@GetMapping("/author/{author}")
	public List<Book> getBookByAuther(@PathVariable String author) {
		
		return bookService.getBookByAuther(author);
		
	}
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book  ) {
		//customerService.saveCustomer(theCustomer);
		bookService.saveBooks(book);
		
		return book;
	}
	
	// for update
	@PutMapping("/increasecount")
	public Book increaseBook(@RequestBody Book book  ) {
		bookService.increaseBook(book);
		return book;
		
	}
	
	
	@PostMapping("/buy")
	public Order orderBook(@RequestBody Order order  ) {
		// We have to set it null so hibernate can create new id
		order.setId(0);
		bookService.makeOrder(order);
		
		return order;
		
	}
	
	
	@DeleteMapping("/remove/{isbn}")
	public String removeBooks(@PathVariable String isbn) {
		
		Book book = bookService.getBookByIsbn(isbn);
		if(book==null){
			throw new ObjNotFoundException("Book not found");
		}
		
		return book.toString()+" removed";
		
	}
	
	

}
