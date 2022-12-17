package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {
	
	private static Connection connection;
	private static Statement statement;
	private static int output;
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wejm4?user=root&password=root");
			statement = connection.createStatement();
			output = statement.executeUpdate("update students set city = 'Delhi' where id = 4");
			System.out.println(output + " row(s) affected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
