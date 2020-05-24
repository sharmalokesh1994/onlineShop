package com.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book",schema="bookstore")
public class Book implements Serializable{
	
	private static final long serialVersionUID = -5678888702523297268L;
	
	@Id
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="price")
	private int price;// we can take float or double as well
	
	@Column (name="count", columnDefinition = "int default 0")
	private int count;
	
	private Book(BookBuilder builder){
		setIsbn(builder.getIsbn());
		setTitle(builder.getTitle());
		setAuthor(builder.author);
		setPrice(builder.price);
		
	}
	// it is for hibernate object creation
	public Book(){
	}
	
	// todo:can add more elements
	
	static class BookBuilder{
		private String isbn;
		private String title;
		private String author;
		private int price;
		private int count;
		
		
		public BookBuilder(String isbn, String title, String author, int price) {
			super();
			
			// By using this we can add one more layer of Validation
			setIsbn(isbn);
			setTitle(title);
			setAuthor(author);
			setPrice(price);
		}
		
		
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
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
		public int getPrice() {
			return price;
		}
		public BookBuilder setPrice(int price) {
			this.price = price;
			return this;
		}
		
		
		
		public int getCount() {
			return count;
		}


		public void setCount(int count) {
			this.count = count;
		}


		private Book getInstance(){
			return new Book(this);
		}
		
	}
	
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
