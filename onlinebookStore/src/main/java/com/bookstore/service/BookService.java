package com.bookstore.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;

public interface BookService {
	
	public Book getBookByIsbn(@PathVariable String isbn);
	
	public void saveBooks(Book book);

	List<Book> getBookByTitle(String title);

	List<Book> getBookByAuther(String author);

	boolean makeOrder(Order order);

	boolean increaseBook(Book book);

	void removeBook(Book book);
	
}
