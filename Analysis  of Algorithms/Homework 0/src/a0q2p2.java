
/*
 * Assignment 0
 * Name : Han Min Thu
 * Problem 2: Takes as input a string and outputs the string reversed.
 */


public class a0q2p2 {

	/*
	 * Function that takes as input an integer and outputs the integer reverse
	 */
	public static int reverseInt(int i){
		int output = 0;
		if(i< -20000 || i > 20000){
			System.out.println("Input integer is not in the range[-20000, 20000]");
			System.exit(0);
		}
		else{
			String str = "" + i;
//			System.out.println(str);

			int lenn = str.length()-1;	// Find last index of the array
			char temp;
			char[] charArray = str.toCharArray();
//			
//			for(char a: charArray){
//				System.out.println(a);
//			}


			for(int j=0;j<str.length()/2;j++){
				temp = charArray[j];
				charArray[j] = charArray[lenn-j];
				charArray[lenn-j] = temp;
			}
			
			String outputstr = String.valueOf(charArray);
			output = Integer.parseInt(outputstr);
			}
		
		if(output< -20000 || output > 20000){
			System.out.println("0");
			System.exit(0);
		}
		
		return output;
	}
	
	
	/*
	 * Main function to test Integer inverse.
	 */
	public static void main(String[] args) {
		int input = 0;
		System.out.println(reverseInt(input));
		
	}

}
