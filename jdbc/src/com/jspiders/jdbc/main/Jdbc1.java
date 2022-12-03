package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {
	
	public static void main(String[] args) {
		
		try {
			//Step 1 : Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2 : Open connection
			Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/"
							+ "wejm4?user=root&password=root");
			
			//Step 3 : Create/Prepare Statement
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery
									("select * from students");
			
			//Step 4 : Process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | "
								+ resultSet.getString(2) + " | "
								+ resultSet.getString(3) + " | "
								+ resultSet.getLong(4) + " | "
								+ resultSet.getString(5));
			}
			
			//Step 5 : Close connections
			connection.close();
			statement.close();
			resultSet.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
