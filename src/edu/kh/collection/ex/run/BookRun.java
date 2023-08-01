package edu.kh.collection.ex.run;

import edu.kh.collection.ex.model.service.BookService;

public class BookRun {
	
	public static void main(String[] args) {
		
		BookService service = new BookService();
		
		
		service.displayMenu();
		
	}
	
	

}
