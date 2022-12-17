package com.jspiders.jdbc.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInsert2 {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filePath;
	
	public static void main(String[] args) {
		try {
			
			filePath = "D:\\Dhananjay\\eclipse-workspaces\\"
					+ "WEJM4\\jdbc\\resources\\"
					+ "db_info.properties";
			
			fileReader = new FileReader(filePath);
			
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.
					getConnection(properties.
							getProperty("dburl"), properties);
			
			statement = connection.createStatement();
			
			result = statement.executeUpdate(properties.
									getProperty("query1"));
			
			System.out.println(result + " row(s) affected");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
