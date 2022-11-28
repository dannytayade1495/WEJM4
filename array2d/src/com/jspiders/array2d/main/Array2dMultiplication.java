package com.jspiders.array2d.main;

import java.util.Scanner;

public class Array2dMultiplication {

	public static void main(String[] args) {

		int[][] matrix1 = new int[3][3];
		int[][] matrix2 = new int[3][3];
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the values for 1st matrix");

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1.length; j++) {
				System.out.println("Enter the value for row " + (i + 1) + " and column " + (j + 1));
				matrix1[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Enter the values for 2nd matrix");

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				System.out.println("Enter the value for row " + (i + 1) + " and column " + (j + 1));
				matrix2[i][j] = scanner.nextInt();
			}
		}

		int[][] res = new int[3][3];

		System.out.println("Product of both arrays is :");

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				res[i][j] = matrix1[i][j] * matrix2[i][j];
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}

}
