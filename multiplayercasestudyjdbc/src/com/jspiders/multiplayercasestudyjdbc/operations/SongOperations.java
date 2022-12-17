package com.jspiders.multiplayercasestudyjdbc.operations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperations {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static Properties properties;
	private static ResultSet resultSet;
	private static int result;
	private static String filePath = "D:\\Dhananjay\\"
						+ "eclipse-workspaces\\WEJM4\\"
						+ "multiplayercasestudyjdbc\\resources\\" 
						+ "db_info.properties";
	private static Scanner scanner;
	private static int id;
	private static String name;
	private static String singer;
	private static int duration;
	private static String movie_album;
	private static String lyricist;
	private static String composer;

	private void openConnection() {
		try {
			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			scanner = new Scanner(System.in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void closeConnection() {
		try {
			if (connection != null) {

				connection.close();

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

	public void addSongs() {
		
		openConnection();
		try {
			preparedStatement = connection.prepareStatement
					(properties.getProperty("insert"));
			System.out.println("Enter the song id : ");
			id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			System.out.println("Enter the song name : ");
			name = scanner.next();
			preparedStatement.setString(2, name);
			System.out.println("Enter the song singer : ");
			singer = scanner.next();
			preparedStatement.setString(3, singer);
			System.out.println("Enter the song duration : ");
			duration = scanner.nextInt();
			preparedStatement.setInt(4, duration);
			System.out.println("Enter the song movie/album : ");
			movie_album = scanner.next();
			preparedStatement.setString(5, movie_album);
			System.out.println("Enter the song lyricist : ");
			lyricist = scanner.next();
			preparedStatement.setString(6, lyricist);
			System.out.println("Enter the song composer : ");
			composer = scanner.next();
			preparedStatement.setString(7, composer);
			result = preparedStatement.executeUpdate();
			if (result != 0) {
				System.out.println(name + " successfully added to playlist");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();

	}

	public void removeSongs() {
		// TODO Auto-generated method stub
		
	}

}
