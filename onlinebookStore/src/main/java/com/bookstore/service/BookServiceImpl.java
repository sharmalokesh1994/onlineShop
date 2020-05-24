package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookstore.dao.BookStoreDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Order;
import com.bookstore.rest.exception.ObjNotFoundException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookStoreDAO bookStoreDAO;
	
	
	@Override
	@Transactional
	public Book getBookByIsbn(@PathVariable String isbn){
		Book book = (Book)bookStoreDAO.getBook(Book.class, isbn);
		return book;
	}
	
	@Override
	@Transactional
	public void saveBooks(Book book) {

		bookStoreDAO.saveObject(book);
	}
	
	@Override
	@Transactional
	public List<Book> getBookByTitle(String title){
		
		List<Book> list =  bookStoreDAO.getObjects(Book.class, "title", title);
		
		return list;
		
	}
	
	@Override
	@Transactional
	public List<Book> getBookByAuther(String author){
		
		List<Book> list =  bookStoreDAO.getObjects(Book.class, "author", author);
		
		return list;
		
	}
	
	@Override
	@Transactional
	public boolean makeOrder(Order order){
		
		int t = order.getCustomer().getId();
		
		Customer customer = bookStoreDAO.getCustomer(t);
		
		if(customer==null){
			throw new ObjNotFoundException("Customer not found");
		}
		
		Book book = getBookByIsbn( order.getBook().getIsbn() );
		
		if(book==null){
			throw new ObjNotFoundException("Book not found in the shop");
		}
		
		int  val = bookStoreDAO.buyBook(book.getIsbn());
		
		
		if(val==0){
			// todo:send notification to the staff
			throw new ObjNotFoundException("Book is not available");
		}
		
		bookStoreDAO.saveObject(order);
		
		return true;
		
	}
	
	@Override
	@Transactional
	public boolean increaseBook(Book book){
		
		int  val = bookStoreDAO.increaseBook(book);
		if(val==0){
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public void removeBook(Book book){
		bookStoreDAO.deleteObject(book);
	}
}
