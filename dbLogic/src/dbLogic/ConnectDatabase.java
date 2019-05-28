/*Database access layer
•	Ensure that the constructor accepts connection string
•	Create an API for Customers data
•	Create an API for Customers count 
•	Create methods to return the number of customers and a list of customer names.
•	Create a database object that also returns the number of customers and a list of customer last names.
•	The object must have a constructor that accepts a connection string.
*/
package dbLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDatabase {

	
	//Creates and returns database connection 
	public static Connection dbConnect(String dbName, String dbUser, String dbPassword){
		Connection conn = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbName, dbUser, dbPassword);
			System.out.println("Database Connection has been made!");			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//Uses the string argument to query the connected database, returns the column number associated with the number
	public static void singleQueryDB(Connection conn, String query, int column){
		try {
			Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	           System.out.println(rs.getString(column));
	        	        }
	        statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Uses the string argument to query the connected database, returns the column number associated with the number
	public static String getCount(Connection conn, String query){
		String count = "";
		try {
			Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	           count = rs.getString(1);
	        	        }
	        statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//Uses the string argument to query the connected database, returns the column based on the column name
	public static void singleQueryDB(Connection conn, String query, String column){
		try {
			Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	           System.out.println(rs.getString(column));
	        	        }
	        statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Gets the last names of the customers table
	public static ArrayList getCustomerLastNames(Connection conn, String query, String column){
		ArrayList lastNames = new ArrayList();
		String name = "";
		try {
			Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	           lastNames.add(rs.getString(column).split("\\s+")[1]);
	        	        }
	        statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastNames;
	}
	
	//Gets all the column headers of the table in the select statement
	public static void getColumnLabels(Connection conn, String query){
		try {
			Statement statement = conn.createStatement();
	        ResultSet rs = statement.executeQuery(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        System.out.println(rsmd.getColumnCount());
	        for (int i = 1; i < rsmd.getColumnCount() + 1; i++){
	        	System.out.print(rsmd.getColumnName(i) + " ");
	        }
	        statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//Closes the database connection to keep things nice and tighty
	public static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Successfully closed database connection!");
	}
	
	public static void main(String[] args){
		Connection conn = dbConnect("jdbc:sqlserver://69.174.152.246:20653","ch2","password");
		getColumnLabels(conn, "Use Northwind; SELECT * FROM Customers");
		System.out.println("\nUsers in database: ");
		getCustomerLastNames(conn, "Use Northwind; SELECT * FROM Customers","ContactName");
		System.out.print("\nNumber of users in database: ");
		singleQueryDB(conn, "Use Northwind; SELECT COUNT(*) FROM Customers",1);
		closeConnection(conn);
		
	}
	
}

class database{
	String username;
	String password;
	String server;
	Connection conn;
	
	private void connectDB(){
		conn = ConnectDatabase.dbConnect(server, username, password);
	}
	
	private void disconnectDB() throws SQLException{
		conn.close();
	}
	
}

//Should I create a class for the query?
//Should I add some methods to the database class?
