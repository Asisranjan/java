import java.util.Arrays;

public class NQueenProblem {

	static int n = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] q = {
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0}
		};
		
		
		if (solveNQueenProblem(q, 0) == true) {
			printSolution(q);
		}
		else {
			System.out.println("solution not exist");
		}
	}
	private static void printSolution(int[][] q) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(q));
	}
	private static boolean solveNQueenProblem(int[][] q, int col) {
		// TODO Auto-generated method stub
		
		if (n <= col) {
			return true;
		}
		
		for (int i = 0; i < n; i++) {
			if (canQueenbePlaced(q, i, col)) {
				q[i][col] = 1;
				if (solveNQueenProblem(q, col + 1) == true) {
					return true;
				}
				q[i][col] = 0;
			}
		}
		
		return false;
	}
	private static boolean canQueenbePlaced(int[][] q, int row, int col) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < col; i++ ) {
			if (q[row][i] == 1) {
				return false;
			}
		}
		
		for (int i = row, j = col; i < n && j >= 0; i ++, j-- ) {
			if (q[i][j] == 1)
				return false;
		}
		
		for (int i = row, j = col; i >= 0 && j >=0; i --, j-- ) {
			if (q[i][j] == 1)
				return false;
		}
		
		return true;
	}

}
