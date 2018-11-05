package bte423;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner; 

public class Hotel {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Hotel DB Query Console");
		System.out.println("Establishing A Connection...");
		getConnection();
		
		int x = 0; 
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		while (x != 4) {
			System.out.println("Main Menu");
			System.out.println("--------------");
			System.out.println("1. QUERY QUESTION 1");
			System.out.println("2. QUERY QUESTION 2");
			System.out.println("3. QUERY QUESTION 3");
			System.out.println("4. QUIT");
			System.out.println("--------------");
			System.out.println("What would you like to do?........");
			
		
			int option = reader.nextInt(); 
			
		
			
			switch(option) {
				case 1: 
					System.out.println("NUM 1 SELECTED");
					x = 0; 
					break; 
				case 2: 
					System.out.println("NUM 2 SELECTED");
					x = 0; 
					break; 
				case 3: 
					System.out.println("NUM 3 SELECTED");
					x = 0; 
					break; 
				case 4: 
					x = 4; 
					break; 
				default: 
					System.out.println("NON-VALID OPTION");
					x = 0; 
					break; 
			}
			
			
		}
		reader.close();

	}

	
	
	public static Connection getConnection() throws Exception{
	
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://35.232.18.156:3306/HomeWork2";
			String username = "harry";
			String password = "pass";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTION SUCCESSFUL!!!!!!! :)");
			return conn; 
		} catch(Exception e) {
				System.out.println(e);
		} 
		return null;
	}
}
