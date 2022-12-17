package com.jspiders.jdbc1.dynamicupdate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JdbcUpdate {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;
	private static String filePath = "C:\\Dhananjay\\"
			+ "eclipse-workspaces\\WEJM4\\jdbc1\\resources\\"
			+ "db_info.properties";
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			
			fileReader = new FileReader(filePath);
			
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"),
							properties);
			
			preparedStatement = connection.prepareStatement
					(properties.getProperty("query2"));
			
			System.out.println("Enter the student id : ");
			int id = scanner.nextInt();
			preparedStatement.setInt(2, id);
			
			System.out.println("Enter the student contact : ");
			long contact = scanner.nextLong();
			preparedStatement.setLong(1, contact);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println(result + " row(s) affected");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
