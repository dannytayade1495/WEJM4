package com.jspiders.multiplayercasestudy.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.multiplayercasestudy.entity.Song;

public class SongOperations {

	private static List<Song> playlist = new ArrayList<Song>();
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;
	private static Song song;

	public void displayAllSongs() {
		for (int i = 0; i < playlist.size(); i++) {
			System.out.println(i + 1 + ". " + playlist.get(i).getSongName());
		}
	}

	public void addSong() {
		System.out.println("How many songs you want to add?");
		choice = scanner.nextInt();
		for (int i = 1; i <= choice; i++) {

			song = new Song();

			System.out.println("Enter the id of the song :");
			int id = scanner.nextInt();
			song.setId(id);

			System.out.println("Enter the name of the song :");
			String songName = scanner.next();
//			scanner.next();
			song.setSongName(songName);

			System.out.println("Enter the singer of the song :");
			String singer = scanner.next();
//			scanner.next();
			song.setSinger(singer);

			System.out.println("Enter the duration of the song :");
			double duration = scanner.nextDouble();
			song.setDuration(duration);

			System.out.println("Enter the movie/album of the song :");
			String movie_album = scanner.next();
//			scanner.next();
			song.setMovie_album(movie_album);

			System.out.println("Enter the lyricist of the song :");
			String lyricist = scanner.next();
//			scanner.next();
			song.setLyricist(lyricist);

			playlist.add(song);

			System.out.println(song.getSongName() + " successfully added to the playlist..!!");

		}

	}

	public void removeSong() {

		System.out.println("Select a song to remove :");
		displayAllSongs();
		choice = scanner.nextInt();
		playlist.remove(choice - 1);
	}

}
