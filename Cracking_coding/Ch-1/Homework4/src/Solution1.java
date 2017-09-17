
/**
 * Exploring a Matrix
 * @author han
 *
 * Date: April 19, 2017
 */
public class Solution1 {

	/** Helper function for find path form entrace to the exit
	 * @param arrA - 2D matrix array
	 * @return int - how many path does it have to reach to destination
	 */
	public static int countDP(int[][] arrA) {
		int result[][] = new int[arrA.length][arrA.length];
		result[0][0] = 1;
		for (int i = 0; i < result.length; i++) {
			result[0][i] = 1;
		}
		for (int i = 0; i < result.length; i++) {
			result[i][0] = 1;
		}
		// Check left and up of current cell
		for (int i = 1; i < result.length; i++) {
			for (int j = 1; j < result.length; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		return result[arrA.length - 1][arrA.length - 1];
	}

	/** Method to find the way to move from entrace to exit
	 * @param m - num of row of the matrix
	 * @param n - num of column of the matrix
	 * @return int how many paths
	 */
	public static int exploreMatrix(int m, int n) {
		int[][] mymatrix = new int[m][n];
		int result;
		result = countDP(mymatrix);

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(exploreMatrix(2, 2));
	}

}
