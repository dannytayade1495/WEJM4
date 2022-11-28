package com.jspiders.filehandling.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteRead {

	public static void main(String[] args) {

		File file = new File("byte_file.txt");

		if (file.exists()) {
			System.out.println(file.getName() + " already exists");
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(file.getName() + " is created.");
		}

		try {

			FileInputStream fileInputStream = new FileInputStream(file);
			int read = fileInputStream.read();
			System.out.println(read);
			System.out.println("Data read from file successfully.");
			fileInputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
