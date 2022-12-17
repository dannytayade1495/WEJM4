package com.jspiders.jdbc.main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc3 {
	
	public static void main(String[] args) {

		try {
			// Step 1 : Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Loading the db_info file in FileReader object
			FileReader fileReader = 
					new FileReader("D:\\Dhananjay\\"
							+ "eclipse-workspaces\\WEJM4\\"
							+ "jdbc\\resources\\"
							+ "db_info.properties");

			//Loading the file as properties of jdbc
			Properties properties = new Properties();
			properties.load(fileReader);
			
			// Step 2 : Open connection
			Connection connection = DriverManager.
					getConnection("jdbc:mysql://"
							+ "localhost:3306/wejm4",
							properties);

			// Step 3 : Create/Prepare Statement
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery("select * from students");

			// Step 4 : Process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " | " 
						+ resultSet.getString(2) + " | " 
						+ resultSet.getString(3) + " | " 
						+ resultSet.getLong(4) + " | " 
						+ resultSet.getString(5));
			}

			// Step 5 : Close connections
			connection.close();
			statement.close();
			resultSet.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
