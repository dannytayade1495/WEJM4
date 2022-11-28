package com.jspiders.serialization.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jspiders.serialization.object.Student;

public class Serialization {

	public static void main(String[] args) {

		try {

			File file = new File("student.txt");
			file.createNewFile();

			FileOutputStream fileOutStr = new FileOutputStream("student.txt");

			Student student = new Student();
			student.setId(1);
			student.setName("Arjun");
			student.setEmail("arjun@gmail.com");
			student.setAddress("Pune");

			ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
			objOutStr.writeObject(student);
			System.out.println("Object written to file successfully.");

			objOutStr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
