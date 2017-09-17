import java.util.ArrayList;

/*
 * Assignment 0
 * Name : Han Min Thu
 * Problem 3: Iterative way to solve the candy problems
 */


public class a0q3p2 {
	
	
	/*
	 * Iterative function that calculates the number of
	 * ways in which you can eat all the candies
	 */
	public static String candyIterative(int n){
		ArrayList<Integer> myarray = new ArrayList<Integer>();	// Arraylist that can store the possible num of ways
		myarray.add(n);
		int total =0;
		int curval = 0;
		while(myarray.size() !=0){	// if array list size is not zero the loop continues
			curval = myarray.remove(0);
			if(curval <=1){	
				total++;
			}
			else{
				myarray.add(curval-1);	// add n-1 to the next index in the arraylist
				myarray.add(curval-2);   // add n-1 to the next index in the arraylist
			}
		}
		return total+"";
		
	}
	
	/*
	 * Main function to solve Candy problems by using Iterative way
	 */
	public static void main(String[] args) {
		System.out.println(candyIterative(0));
	}

}
