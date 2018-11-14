package bte423;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class Hotel {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Hotel DB Query Console");
		System.out.println("Establishing A Connection...");
		Connection conn = getConnection();
		menu(conn);  //passes connection to menu as to use same connection throughout queries 
		
		
	}
	
	private static void menu(Connection conn) throws Exception {

		//int x = 0; 
		Scanner reader = new Scanner(System.in);  
		//while (x != 4) {
			System.out.println("Main Menu");
			System.out.println("--------------");
			System.out.println("1. Query Question 2a ");
			System.out.println("2. Query Question 2b");
			System.out.println("3. Query Question 2c");
			System.out.println("4. Query Question 3a");
			System.out.println("5. Query Question 3b");
			System.out.println("6. Query Question 3c");
			System.out.println("7. Query Question 3d");
			System.out.println("8. Query Question 3e");
			System.out.println("9. Querinedy Question 3f");
			System.out.println("10. Query Question 3g");
			System.out.println("11. Query Question 7.14a");
			System.out.println("12. Query Question 7.14b");
			System.out.println("13. Query Question 7.14c  ");
			System.out.println("14. Query Question 7.14d  ");
			System.out.println("15. Query Question 7.14e ");
			System.out.println("16. INSERT NEW HOTEL INTO DATABATE ");
			System.out.println("17. INSERT NEW ROOM INTO DATABATE ");
			System.out.println("18. QUIT");
			System.out.println("--------------");
			System.out.println("What would you like to do?........");
			
			int option = reader.nextInt();
			
			switch(option) {
				case 1: 
					System.out.println("Question 2a SELECTED");
					select(conn, "SELECT * FROM Hotel");
					break; 
				case 2: 
					System.out.println("Question 2b SELECTED");
					select(conn, "SELECT * FROM Hotel WHERE city = 'London'");
					break;
				case 3: 
					System.out.println("Question 2c SELECTED");
					select(conn, "SELECT guestName, guestAddress\n" + 
							"FROM Guest\n" + 
							"WHERE guestAddress LIKE '%london'\n" + 
							"ORDER BY guestName;");
					break; 
				case 4: 
					System.out.println("Question 3a SELECTED");
					select(conn, "SELECT AVG(price) FROM Room;");
					break;
				case 5: 
					System.out.println("Question 3b SELECTED");
					select(conn, "SELECT price, type FROM Room\n" + 
							" WHERE hotelNo = (\n" + 
							"	SELECT hotelNo FROM Hotel WHERE hotelName = \"Grosvenor Hotel\"\n" + 
							"    );");
					break;	
				case 6: 
					System.out.println("Question 3c SELECTED");
					select(conn, "SELECT SUM(price) FROM Room\n" + 
							" WHERE hotelNo = (\n" + 
							"	SELECT hotelNo FROM Hotel WHERE hotelName = \"Grosvenor Hotel\"\n" + 
							"    );");
					break;
				case 7: 
					System.out.println("Question 3d SELECTED");
					select(conn, "SELECT h.hotelName, h.city, COUNT(*) AS Rooms\n" + 
							"FROM Hotel h, Room r\n" + 
							"WHERE city = \"London\" AND h.hotelNo = r.hotelNo\n" + 
							"GROUP BY r.hotelNo, h.hotelName, h.city; ");
					break;	
				case 8: 
					System.out.println("Question 3e SELECTED");
					select(conn, "select h.hotelName, h.city, b.roomNo\n" + 
							"from Hotel h, Booking b\n" + 
							"where h.hotelNo = b.hotelNo and city = 'London'; ");
					break;
				case 9: 
					System.out.println("Question 3f SELECTED");
					select(conn, "SELECT AVG(price) FROM Room;");
					break;
				case 10: 
					System.out.println("Question 3g SELECTED");
					select(conn, "select h.hotelName,  MIN(r.price) as CheapestPrice\n" + 
							"from Hotel h, Booking b, Room r\n" + 
							"where h.hotelNo = b.hotelNo and b.hotelNo = r.hotelNo\n" + 
							"group by h.hotelName\n" + 
							"order by CheapestPrice asc;");
					break;
				case 11: 
					System.out.println("Question 7.16a SELECTED");
					select(conn, "SELECT * \n" + 
							"FROM HotelBookingCount; ");
					break;
				case 12: 
					System.out.println("Question 7.16b SELECTED");
					select(conn, "SELECT hotelNo \n" + 
							"					FROM HotelBookingCount\n" + 
							"					WHERE hotelNo = 'H001'; ");
					break;
				case 13: 
					System.out.println("Question 7.16c SELECTED");
					select(conn, "SELECT MIN(bookingCount)\n" + 
							"FROM HotelBookingCount;");
					break;
				case 14: 
					System.out.println("Question 7.16d SELECTED");
					select(conn, "SELECT COUNT(*) \n" + 
							"FROM HotelBookingCount;");
					break;
				case 15: 
					System.out.println("Question 7.16e SELECTED");
					select(conn, "SELECT hotelNo \n" + 
							"					FROM HotelBookingCount\n" + 
							"					WHERE bookingCount > 1; "); //adjusted for small db size
					break;
				case 16: 
					System.out.println("Insertion Selected..."); 
					insertInfoHotel(conn); 
					break;
				case 17: 
					System.out.println("Insertion Selected..."); 
					insertInfoRoom(conn); 
					break;
				case 18: 
					System.out.println("Exiting...");
					break;
				default: 
					System.out.println("NON-VALID OPTION");
			
					menu(conn);
					break; 
		//	}	
		}
		reader.close();	
	}

	private static void insertInfoRoom(Connection conn) throws Exception {
		 
		int roomNo, hotelNo, price;
		String type; 
		Scanner reader = new Scanner(System.in); 
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter Room Number of Room to be inserted...");
		roomNo = reader.nextInt();
		System.out.println("Enter Hotel Number of Hotel to be inserted...");
		hotelNo = reader.nextInt();
		System.out.println("Enter Price of Room to be inserted...");
		price = reader.nextInt();
		System.out.println("Enter Type of Roome to be inserted...");
		type = scan.nextLine();
		String query = "INSERT INTO `HomeWork2`.`Room` (`roomNo`, `hotelNo`, `type`, `price`) VALUES ('" + roomNo + "', '" + hotelNo + "', '" + type + "', '" + price + "');";
		post(conn, query);
	}

	private static void insertInfoHotel(Connection conn) throws Exception {
		
		Scanner reader = new Scanner(System.in); 
		String name, city; 
		System.out.println("Enter name of new hotel to be inserted...");
		name = reader.nextLine();
		System.out.println("Enter city of new hotel to be inserted...");
		city = reader.nextLine();
		String query = "INSERT INTO `Hotel` (`hotelName`, `city`) VALUES ('" + name + "', '" + city + "');";
		post(conn, query);
	}

	public static void post(Connection conn, String query) throws Exception{
		Scanner reader = new Scanner(System.in); 
		try {
			PreparedStatement posted = conn.prepareStatement(query);
			posted.executeUpdate(); 
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert Complete.");
		}
		System.out.println("Press One (1) and enter to continue..");
		if( reader.nextInt() == 1) {
			menu(conn);
		}
	}
	
	
	
	private static void select(Connection conn, String string) throws Exception {
		try {
		
			PreparedStatement statement = conn.prepareStatement(string);
			
			ResultSet result = statement.executeQuery();
			java.sql.ResultSetMetaData meta = result.getMetaData();
		
			int col = meta.getColumnCount(); 
			System.out.println("---------------------");
			for(int i = 1; i <= col; i++) {
				System.out.print(meta.getColumnName(i));
				System.out.print(" |");
			}
			System.out.println("\n---------------------");
			while(result.next()) {
				for(int i = 1; i <= col; i++) {
					System.out.printf(result.getString(i));
					System.out.print(" |");
				}
				System.out.println();
			}
			System.out.println("---------------------");
			System.out.println("All records have been selected.");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Enter One (1) to continue..."); 
		Scanner read = new Scanner(System.in);  
		if( read.nextInt() == 1) {
			menu(conn);
		}
	}

	public static Connection getConnection() throws Exception{
	
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://35.232.18.156:3306/HomeWork2";
			String username = "harry";
			String password = "pass";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTION SUCCESSFUL!");
			return conn; 
		} catch(Exception e) {
				System.out.println(e);
		} 
		return null;
	}
}
