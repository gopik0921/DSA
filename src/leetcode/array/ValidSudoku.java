package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

//	Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//  Each row must contain the digits 1-9 without repetition.
//	Each column must contain the digits 1-9 without repetition.
//	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

	public static void main(String[] args) {
		// char[][] board=new char[9][9];
		// isValidSudoku(board)
	}

	// **formula to calculate sub box = (row/3) * 3+ column/3;
	@SuppressWarnings("unchecked")
	public static boolean isValidSudoku(char[][] board) {
		Set<Integer>[] rows = new HashSet[9];
		Set<Integer>[] columns = new HashSet[9];
		Set<Integer>[] boxes = new HashSet[9];

		for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>();
			columns[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char cnum = board[i][j];
				if (cnum != '.') {
					int num = (int) cnum;
					int boxIndex = (i / 3) * 3 + j / 3;
					if (!rows[i].add(num) || !columns[j].add(num) || !boxes[boxIndex].add(num)) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
