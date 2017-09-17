package chapter1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class problem3 {

	
	
	public static String sort(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static boolean permutation(String str1, String str2){
		if(str1.length()!=str2.length()){
			return false;
		}
		else{
			return sort(str1).equals(sort(str2));
		}
	}
	
	
	public static boolean permutation2(String str1, String str2){
		if(str1.length()!=str2.length()){
			return false;
		}
		int[] letters = new int[256];
		char[] s_array = str1.toCharArray();
		for(char c:s_array){
//			System.out.println("lettes["+ c + "]: "+ letters[c]);
			letters[c]++;
		}
//		for(int i=0;i<256;i++){
//			System.out.println("i("+ i + "): "+letters[i]);
//		}
		
		for(int i=0;i<str2.length();i++){
			int c = (int) str2.charAt(i);
			System.out.println("c: "+c);
			if(--letters[c]<0){
				int counter =0;
				System.out.println(counter);
				counter++;
				return false;
			}
		}
		return true;
}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
	
		if(permutation2(str1,str2)){
			System.out.println("One is permutation of the other");
			System.exit(0);
		}
		System.out.println("It is not a permutation of the other");
		
	}
}
