package Chapter1;

import java.util.Scanner;

public class problem4version2 {
	
	
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength,i;

        for(i = 0; i < length; i++) {
            if (str[i] == ' '){
                spaceCount++;
            }
        }
        
        newLength = length + (spaceCount * 2);
        //str[newLength] = '\0';
        for(i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(str);
    }

	public static void main(String[] args) {
        problem4version2 tst = new problem4version2();
        char[] ch = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h'};
        int length = 13;
        replaceSpaces(ch, length); 


	}

}
