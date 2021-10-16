package main;

public class Logic {
	public static boolean checkWin(int r, int c, int[][] board, int numToWin) {
		int val = board[r][c];
		//Num pieces on both sides of a line through the middle + piece in middle at least the number required to win
		return goRHoriz(val, r, c, board, numToWin) + goLHoriz(val, r, c, board, numToWin) >= numToWin - 1
				|| goDVert(val, r, c, board, numToWin) >= numToWin - 1 //no pieces above places piece
				|| goLDiagU(val, r, c, board, numToWin) + goRDiagD(val, r, c, board, numToWin) >= numToWin - 1
				|| goRDiagU(val, r, c, board, numToWin) + goLDiagD(val, r, c, board, numToWin) >= numToWin - 1;
	}

	private static int goRHoriz(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = c + 1; i < c + numToWin; i++) {
			if (i < board.length && (board[r][i] == val)) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

	private static int goLHoriz(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = c - 1; i > c - numToWin; i--) {
			if (i > -1 && board[r][i] == val) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

	private static int goDVert(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = r + 1; i < r + numToWin; i++) {
			if (i < board.length && board[i][c] == val) {
				count++;
			} else {
				return 0;
			}
		}
		return count;
	}

	private static int goLDiagU(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = 1; i < numToWin; i++) {
			if (r - i > -1 && c - i > -1 && board[r - i][c - i] == val) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

	private static int goRDiagD(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = 1; i < numToWin; i++) {
			if (r + i < board.length && c + i < board[0].length && board[r + i][c + i] == val) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

	private static int goRDiagU(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = 1; i < numToWin; i++) {
			if (r - i > -1 && c + i < board[0].length && board[r - i][c + i] == val) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}

	private static int goLDiagD(int val, int r, int c, int[][] board, int numToWin) {
		int count = 0;
		for (int i = 1; i < numToWin; i++) {
			if (r + i < board.length && c - i > -1 && board[r + i][c - i] == val) {
				count++;
			} else {
				return count;
			}
		}
		return count;
	}
}