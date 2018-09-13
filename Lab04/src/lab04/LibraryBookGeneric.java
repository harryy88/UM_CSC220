package lab04;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.text.ParseException;
//import java.util.ArrayList;
import java.util.GregorianCalendar;
//import java.util.Scanner;


public class LibraryBookGeneric<Type> extends Book {
	
	private Type holder; 
	private GregorianCalendar dueDate; 
	
	public LibraryBookGeneric(long isbn, String author, String title){
		super(isbn, author, title);
		this.holder = null; 
		this.dueDate = null; 
	}
	public Type getHolder() {
		return this.holder;
	}
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	public void checkin() {
		this.holder = null;
		this.dueDate = null; 
	}
	public void checkout(Type holder, GregorianCalendar dueDate) {
		this.holder = holder; 
		this.dueDate = dueDate; 
	}

	
}