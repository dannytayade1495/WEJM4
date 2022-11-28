package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate {

	public static void main(String[] args) {

		File file = new File("demo.txt");

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
