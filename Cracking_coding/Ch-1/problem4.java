package Chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class problem4 {
	
	public static String replaceSpaces(char[] str, int length){
		System.out.println("str: "+str);
		System.out.println("length: "+length);
		int spaceCounter =0;
		for(int i=0;i<length;i++){
			if(str[i] == ' '){
				spaceCounter++;
			}
		}
		char a = '0';
		char b = '2';
		char c = '%';
		int k  = spaceCounter*2;
		int newLength = k + length;
		char[] newarray = new char[newLength]; 	//17
		int j =length-1;
		for(int i=length-1;i>=0;i--){
			if(str[j] ==' '){
				newarray[newLength-1]=a;
				newarray[newLength-2]=b;
				newarray[newLength-3]=c;
				if(i-3==0){
					break;
				}
				newLength=newLength-3;
				j--;
			}
			else{
				newarray[newLength-1]=str[j];
				newLength--;
				j--;
			}
		}
		String temp = new String(newarray);
		System.out.println("here");
		System.out.println(temp);
		System.out.println("I am here");
		return String.copyValueOf(newarray);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] str = input.split(",");
		String strinput = str[0].trim();

		char[] charArray = strinput.toCharArray();
		int length = Integer.parseInt(str[1]);
		replaceSpaces(charArray,length);


		sc.close();
	}
	
}
