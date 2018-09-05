package lab03;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.text.ParseException;
//import java.util.ArrayList;
import java.util.GregorianCalendar;
//import java.util.Scanner;


public class LibraryBook extends Book {
	
	private String holder; 
	private GregorianCalendar dueDate; 
	
	public LibraryBook(long isbn, String author, String title){
		super(isbn, author, title);
		this.holder = null; 
		this.dueDate = null; 
	}
	public String getHolder() {
		return this.holder;
	}
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	public void checkin() {
		this.holder = null;
		this.dueDate = null; 
	}
	public void checkout(String holder, GregorianCalendar dueDate) {
		this.holder = holder; 
		this.dueDate = dueDate; 
	}

	
}