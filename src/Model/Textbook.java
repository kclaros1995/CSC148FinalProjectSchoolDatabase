package Model;

import java.io.Serializable;

public class Textbook implements Serializable{
	private String title;
	private Name author;
	private String publisher;
	private String isbn;
	private double price;
	public Textbook(String title, Name author, String publisher, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.price = price;
	}
	public Textbook(Textbook textbook) {
		this.title = textbook.getTitle();
		this.author = textbook.getAuthor();
		this.publisher = textbook.getPublisher();
		this.isbn = textbook.getIsbn();
		this.price = textbook.getPrice();
	}
	public Textbook() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Name getAuthor() {
		return author;
	}
	public void setAuthor(String fName, char mInitial, String lName) {
		this.author = new Name(fName, mInitial, lName);
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Textbook Title = " + title + " Author = " + author + "\n Publisher = " + publisher + ", isbn=" + isbn
				+ ", price=" + price + "\n";
	}
	
	
	
	
	
	

}
