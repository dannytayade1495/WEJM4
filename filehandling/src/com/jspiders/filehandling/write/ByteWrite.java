package com.jspiders.filehandling.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWrite {
	
	public static void main(String[] args) {
		
		File file = new File("byte_file.txt");
		
		if(file.exists()) {
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
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(45);
			System.out.println("Data written to file successfully.");
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}