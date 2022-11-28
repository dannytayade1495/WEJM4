package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate1 {
	
	public static void main(String[] args) {

		File file = new File("C:\\Users\\Qspiders Wakad\\Desktop\\demo.txt");

		try {
			if (file.exists()) {
				System.out.println("File already exists..!!");
			} else {
				file.createNewFile();
				System.out.println("New file created..!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
