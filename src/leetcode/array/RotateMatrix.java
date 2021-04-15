package leetcode.array;

public class RotateMatrix {

	// You are given an n x n 2D matrix representing an image, rotate the image by
	// 90 degrees (clockwise).
	// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
	// Output: [[7,4,1],[8,5,2],[9,6,3]]
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// System.out.println(matrix.length);//3
		transpose(matrix);
		reflect(matrix);
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j);
			}
		}

	}

	private static void reflect(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = tmp;
			}
		}
	}

	// 0 1 2
	// 0 1 2 3
	// 1 4 5 6
	// 2 7 8 9
	public static void transpose(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

}
