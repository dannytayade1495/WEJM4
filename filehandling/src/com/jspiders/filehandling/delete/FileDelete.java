package com.jspiders.filehandling.delete;

import java.io.File;

public class FileDelete {
	
	public static void main(String[] args) {
		
		File file = new File("demo.txt");
		
		if (file.exists()) {
			file.delete();
			System.out.println("File is deleted..!!");
		} else {
			System.out.println("File does not exist..!!");
		}
	}

}
