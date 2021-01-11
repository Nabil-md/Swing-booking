package project.sqljava;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


public class MySQL {
	
	

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root123";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("connected to the database");
			
			String sql = "INSERT INTO users VALUES (?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "U188571");
			statement.setString(2, "nabil1");
			statement.setString(3, "test123");
			
			int rows = statement.executeUpdate();
			if (rows > 0) {
				System.out.println("a row has been inserted");
			}
			
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
