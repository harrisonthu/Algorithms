import java.util.*;

public class problem1{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		if(input.length() >128) System.exit(0);	

		boolean[] char_set = new boolean[256];

		for(int i=0; i<input.length();i++){
			//System.out.println("char_set["+ i + "]" + char_set[i]);
			char value = input.charAt(i);
			// val is the ascii value for the char	
			int val = input.charAt(i);
			if(char_set[val]==true){
				System.out.println("This is not Unique characters");
				System.exit(0);
			}
			char_set[val] = true;	
			//System.out.println("value(String): "+value+ "   val:"+ val);
		}	
		System.out.println("This is Unique !");

	}

}

