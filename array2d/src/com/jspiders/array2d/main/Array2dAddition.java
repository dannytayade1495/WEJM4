package com.jspiders.array2d.main;

public class Array2dAddition {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] b = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] res = new int[3][3];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				res[i][j] = a[i][j] + b[i][j];
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}
}
