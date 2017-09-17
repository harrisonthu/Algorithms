import java.util.ArrayList;

/*
 * Assignment 0
 * Name : Han Min Thu
 * Problem 3: Recursive and Iterative to find candy problems
 */


public class a0q3p1 {

	
	/*
	 * Recursive function that calculates the number of
	 * ways in which you can eat all the candies
	 */
	public static String candyRecursive(int n){
		int total =0;
		if(n<=1){	// base case
			return 1+"";	// convert to string from integer type
		}
		else{
			total += Integer.parseInt(candyRecursive(n-1))+ Integer.parseInt(candyRecursive(n-2));	// counter ++;
		}
		
		return total+ "";	// return the total number of way u can eat the candies
	}
	
	
	/*
	 * Main Function to test Candy problem with Recursive function
	 */
	public static void main(String[] args) {
		System.out.println(candyRecursive(0));

		
		
	}

}
