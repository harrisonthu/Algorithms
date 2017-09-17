
/**
 * Finding Loyal Lions problem 
 * @author han
 * 
 * Date: April 19, 2017
 */
public class Solution4 {
	
	/** Method to find minimum amount of money that can win the game
	 * 
	 * @param n - guess answer
	 * @param m - Correct answer
	 * @return minimum amount of money
	 */
	public static int playOrNotPlay(int n, int m){
		int[][] mymatrix = new int[n][m];
		
		int min = 1;
		int sum = 0;
		
		// Iterate it until we find the minimum
		// number that can satisfy to win the game
		while( min!=n){
			int mid = (min+n)/2; // Using Binary Search Tree
			sum += mid;	
			min = mid+1;
		}
		return sum <= m ? 1:0;
	}

	/** Main function to find the minimum amount of money
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(playOrNotPlay(3, 1));
	}

}
