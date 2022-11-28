package com.jspiders.serialization.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.jspiders.serialization.object.Student;

public class Deserialization {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fileInStr = new FileInputStream("student.txt");
			
			ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
			Student student = (Student) objInStr.readObject();
			
			System.out.println(student);
			
			objInStr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
