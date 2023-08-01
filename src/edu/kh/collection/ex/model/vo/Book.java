package edu.kh.collection.ex.model.vo;

public class Book {

	// 필드
	
	private int bookNum;
	private String bookName; 
	private String author; 
	private int price; 
	private String publisher;
	
	public Book() {}
	

	
	public Book(int bookNum, String bookName, String author, int price, String publisher) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}



	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	@Override
	public String toString() {
		return "Book [bookNum=" + bookNum + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
