package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;

public interface BookStoreDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public Object getObject(Class classObject,int theId);
	
	public Object getBook(Class classObject,String isbn);
	
	public void saveObject(Object object);
	public List getObjects(Class className,String propertyName, String propertyValue);

	int buyBook(String isbn);

	int increaseBook(Book book);

	void deleteObject(Object obj);
	
}
