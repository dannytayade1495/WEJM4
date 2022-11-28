package com.jspiders.filehandling.info;

import java.io.File;
import java.io.IOException;

public class FileInfo {

	public static void main(String[] args) {

		File file = new File("file_info.txt");

		if (file.exists()) {
			System.out.println(file.getName() + " file already exists");
			System.out.println(file.getAbsolutePath() + " is the file path");
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(file.getName() + " file created");
			System.out.println(file.getAbsolutePath() + " is the file path");
		}
		if (file.canRead()) {
			System.out.println("File is readable.");
		} else {
			System.out.println("File is not readable.");
		}
		if (file.canWrite()) {
			System.out.println("File is writable.");
		} else {
			System.out.println("File is not writable.");
		}
		if (file.canExecute()) {
			System.out.println("File is executable.");
		} else {
			System.out.println("File is not executable.");
		}

	}

}
