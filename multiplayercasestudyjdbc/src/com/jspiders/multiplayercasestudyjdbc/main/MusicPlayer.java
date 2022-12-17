package com.jspiders.multiplayercasestudyjdbc.main;

import java.util.Scanner;

import com.jspiders.multiplayercasestudyjdbc.operations.SongOperations;

public class MusicPlayer {
	
	private static boolean loop = true;
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);
	private static SongOperations operations = new SongOperations();
	
	public static void main(String[] args) {
		
		musicPlayer();
		
	}
	
	private static void musicPlayer() {
		
		while (loop) {
			System.out.println("==========MENU==========");
			System.out.println("1. Add/Remove Song\n"
					+ "2. Play Song\n"
					+ "3. Edit Song\n"
					+ "4. Exit");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			
			case 1:
				System.out.println("==========MENU==========");
				System.out.println("1. Add a Song\n"
						+ "2. Remove a song\n"
						+ "3. Go Back");
				
				choice = scanner.nextInt();
				
				switch (choice) {
				case 1:
					operations.addSongs();
					break;

				case 2:
					operations.removeSongs();
					break;
					
				case 3:
					musicPlayer();
					break;
					
				default:
					System.out.println("Invalid choice. Try again...!!!");
					break;
				}
				
				break;
			
			case 2:
				System.out.println("==========MENU==========");
				System.out.println("1. Play all songs\n"
						+ "2. Select a song\n"
						+ "3. Play random song\n"
						+ "4. Go Back");
				
				choice = scanner.nextInt();
				
				switch (choice) {
				case 1:
					
					break;

				case 2:
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					musicPlayer();
					break;
					
				default:
					break;
				}
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				System.out.println("Thank you...!!!");
				loop = false;
				break;
				
			default:
				System.out.println("Invalid choice. Try again...!!!");
				break;
			}
		}
	}

}
