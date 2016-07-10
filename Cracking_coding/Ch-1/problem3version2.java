package Chapter1;

import java.util.Arrays;

public class problem3version2 {
	

	public static String sort(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static boolean permutation(String str1, String str2){
		if(str1.length()!=str2.length()){
			return false;
		}
		int[] letters = new int[256];
		
		char[] s_array = str1.toCharArray();
		
		for(char c:s_array){
			letters[c]++;
		}
		
		for(int i=0;i<str2.length();i++){
			int c= (int) str2.charAt(i);
			if(--letters[c]<0){
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		
		
		
	}

}
