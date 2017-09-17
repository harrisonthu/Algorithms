
/**
 * Exploring a Matrix with Pits
 * @author han
 *
 * Date: April 19, 2017
 */
public class Solution2 {

	/**
	 *  Method to find the path from entrace to exit
	 *  in a matrix with 0s and 1s(pits)
	 * @param matrix - 2D matrix
	 * @return int for how many paths can reach to exit
	 */
	public static int exploreMatrixWithPits(int[][] matrix) {
		int result[][] = new int[matrix.length][matrix[0].length];
		result[0][0] = 1;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				
				// Base Case (entrance)
				if (i == 0 && j == 0)
					continue;
				// Check upper cell and left cell of current cell
				int up = i > 0 ? result[i - 1][j] : 0;
				int left = j > 0 ? result[i][j - 1] : 0;

				result[i][j] = matrix[i][j] == 0 ? up + left : 0;
			}
		}
		return result[matrix.length - 1][matrix.length - 1];
	}

	/** Main function to explore a matrix with Pits
	 *  0 - empty spaces
	 *  1 - representing pits
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(exploreMatrixWithPits(new int[][] { { 0, 1 }, { 0, 0 } }));
	}

}
