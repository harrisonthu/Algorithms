/*
 * Assignment 0
 * Name : Han Min Thu
 * Problem 1: Takes as input a string and outputs the string reversed.
 */



public class a0q2p1 {

	/*
	 * Reverse the input String 
	 */
	public static String reverseStr(String str){
		String output = null;
		if(str.isEmpty()){
			System.out.println("Input String is empty");
			System.exit(0);
		}
		else{
			int lenn = str.length()-1;	// Find last index of the array
			char temp;
			char[] charArray = str.toCharArray();

			for(int i=0;i<str.length()/2;i++){
				temp = charArray[i];
				charArray[i] = charArray[lenn-i];
				charArray[lenn-i] = temp;
			}
//			for(char i: charArray){
//				System.out.println(i);
//			}
			output = new String(charArray);
		}
		return output;
	}
	
	// Main Function to test reverseStr function
	public static void main(String[] args) {
		String input = "CSCI-261";
		System.out.println(reverseStr(input));
	}

}
