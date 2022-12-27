package com.jspiders.jdbctask.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcOperations {

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static int result;
	private static String query;
	private static String driverPath;
	private static String dburl;
	private static String user;
	private static String password;
	private static Scanner scanner;

	private static void openConnection() {
		try {
			driverPath = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverPath);
			dburl = "jdbc:mysql://localhost:3306/wejm4";
			user = "root";
			password = "root";
			connection = DriverManager.getConnection(dburl, user, password);
			statement = connection.createStatement();
			scanner = new Scanner(System.in);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (scanner != null) {
				scanner.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			openConnection();

			// Create table using static query
			query = "create table emp1 " 
					+ "(empno int(4) primary key, " 
					+ "ename varchar(50), " 
					+ "job varchar(20), "
					+ "sal decimal(7,2))";
			statement.executeUpdate(query);
			System.out.println("Table created");

			// inserting 5 records dynamic query in loop
			System.out.println("Inserting records");
			for (int i = 1; i <= 5; i++) {
				query = "insert into emp1 " 
						+ "values (?,?,?,?)";
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Enter employee number : ");
				int empno = scanner.nextInt();
				preparedStatement.setInt(1, empno);
				System.out.println("Enter employee name : ");
				String ename = scanner.next();
				preparedStatement.setString(2, ename);
				System.out.println("Enter employee job : ");
				String job = scanner.next();
				preparedStatement.setString(3, job);
				System.out.println("Enter employee salary : ");
				double sal = scanner.nextDouble();
				preparedStatement.setDouble(4, sal);
				result = preparedStatement.executeUpdate();
				System.out.println(result + " row(s) affected");
			}

			// Display all records using static query
			query = "select * from emp1";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | " 
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | " 
						+ resultSet.getDouble(4));
			}

			// updating 2 records using dynamic query
			query = "update emp1 " 
					+ "set job = ? " 
					+ "where empno > 3";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter the updated value : ");
			String job = scanner.next();
			preparedStatement.setString(1, job);
			result = preparedStatement.executeUpdate();
			System.out.println(result + " row(s) affected");

			// Display all records using static query
			query = "select * from emp1";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | " 
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | " 
						+ resultSet.getDouble(4));
			}

			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
