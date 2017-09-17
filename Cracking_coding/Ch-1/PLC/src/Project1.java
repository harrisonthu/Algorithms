

/*
 * Project 1: Java
 * Author: Han Min Thu
 * Date: September 01, 2016
 * Professor: Scott Johnson
 * 	
 * Description: implementing various functions (such as mod, gcd, lcm, sqrt) in a limited Java
 * 				programming language(not using %, ^, &&, ||). The goal for this project
 *  			to understand how to create various functions in a limited environment
 */


public class Project1 {
	
	/*
	 * Modulus function
	 * 
	 * @param dividend  a number to be divided by another number
	 * @param divisor   a number by which another number is to be divided.
	 * @return result   remainder
	 */
	public static int mod(int dividend, int divisor){
		int quotient = dividend/divisor;
		int temp = quotient*divisor;
		int result = dividend - temp;
		return result; 
	}
	
	/*
	 * Square Root function
	 * 
	 * @param value:   value to find the squared root
	 * @return result: square root of the value 
	 */
	
	public static int sqrt(int value){
		if (value ==1){
			return 1;
		}
		else if(value == 0){
			return 0;
		}
		int temp = 1;
		int s1,s2,s3;
		int result=0;
		while(temp<value){
			s1 = temp*temp; 	 // s1 is left side of s2 <= value < (s+1)^2
			s2 = temp+1;	
			s3 = s2*s2;			 // s3 is right side of the equation above
			if(s1<=value){
				if(s3>value){		//  if(s1<=value && s3>value){
					result = temp;	
					break;
				}
			}
			temp++;
		}
		return result;
	}
	
	/*
	 * Cube Root function
	 * 
	 * @param value:   value to find the Cubed root
	 * @return result: cube root of the value 
	 */
	
	public static int cbrt(int value){
		int pos = value*(-1);
		int temp = 1;
		int s1,s2,s3,n;
		int negative = 0; 				// 0 - False    1 - True
		if(value<0){
			negative = 1;
		}else{
			negative = 0;
		}
		if(negative == 1){		// value is negative
			n = -value;
		}else{					// value is positive
			n = value;
		}
		if(negative ==0){
			while(temp<=value){
				s1 = temp*temp*temp; 	 // s1 is left side of s2 <= value < (s+1)^2
				s2 = temp+1;	
				s3 = s2*s2*s2;			 // s3 is right side of the equation above
				if(s1<=n){
					if(s3>n){		// if(s1<=n && s3>n){
						return temp;
					}
				}
				temp++;
			}
		}
		while(temp<=pos){
			s1 = temp*temp*temp; 	 // s1 is left side of s2 <= value < (s+1)^2
			s2 = temp+1;	
			s3 = s2*s2*s2;			 // s3 is right side of the equation above
			if(s1<=n){			//if(s1<=n && s3>n){
				if(s3>n){
					return temp*(-1);
				}
			}
			temp++;
		}
		return 0;		// TODO: check with professor (if not found situation)
	}
	
		/*
	 * Greatest Common Divisor function
	 * 
	 * Use reference from
	 * http://stackoverflow.com/questions/13673600/how-to-write-a-simple-java-program-that-finds-the-greatest-common-divisor-betwee
	 * http://stackoverflow.com/questions/4009198/java-get-greatest-common-divisor
	 * 
	 * @param a:   first value to compare in Greatest Common Divisor
	 * @param b:   second value to compare in Greatest Common Divisor
	 * @return result: cube root of the value 
	 * TODO: Check with Professor
	 */
	
	public static int gcd(int a, int b){
		int max =1000000;
		if (b==0){
			return a;
		}else if(a ==0){
		   return b;
		}
		
	    if(b>a){
	        for(int i = b; i >=1; i--){
	            if(mod(b,i)==0){			// if(mod(b,i)==0 && mod(a,i) ==0){
	            	if(mod(a,i) ==0){
		            	if(i<max){
		            		max = i;
		            	}
		            	return i;
	            	}
	            }
	        }
	    }
	    else{
	        for(int j = a; j >=1; j--){
	            if(a%j==0){		// if(a%j==0 && b% j==0){
	            	if(b% j==0){
		                if (j>max){
		                	max = j;
		                }
		                return j;
	            	}
	            }
	        }
	    }   
	    return max;
	}
	
	/*
	 * Least Common Multiple Root function
	 * @param a:   first value to compare in Least Common Divisor
	 * @param b:   second value to compare in Least Common Divisor
	 * 
	 * @return lest Common Multiple value
	 */
	
	public static int  lcm(int a, int b){
		int greatestcd = gcd(a,b);
		return a *(b/greatestcd);
	}
	
	
	/*
	 * Sorting algorithm using Bubble sort function
	 * @param ints: integer array to be sorted
	 * 
	 * @return ints: return sorted integer array
	 */
	
	// Use reference from
	// http://crunchify.com/java-bubble-sort-algorithm-ascending-order-sample/
	
	public static int[] sort(int[] ints){
		int temp;
		int lenn = ints.length;
		
		for(int i=0;i<lenn-1;i++){
			for(int j=i+1;j<lenn;j++){
				 if(ints[i] > ints[j]){
					 temp=ints[i];
					 ints[i]= ints[j];
					 ints[j] = temp;
				 }
			}
		}
		return ints;
	}
	

	/*
	 * Find maximum number in array 
	 * @param ints: integer array
	 * 
	 * @return maximum: maximum value in the integer array
	 */
	
	// Use reference from
	// http://crunchify.com/java-bubble-sort-algorithm-ascending-order-sample/
	
	public static int max(int[] ints){
		int maximum = -10000;
		
		for(int i=0;i<ints.length;i++){
			if(ints[i]>maximum){
				maximum = ints[i];
			}
		}
		return maximum;
	}
	
	/*
	 * Find minimum number in array 
	 * @param ints: integer array
	 * 
	 * @return minimum: minimum value in the integer array
	 */
	
	public static int min(int[] ints){
		int minimum = 10000000;
		
		for(int i=0;i<ints.length;i++){
			if(ints[i]<minimum){
				minimum = ints[i];
			}
		}
		return minimum;
	}
	

	/*
	 * Find exist in list 
	 *
	 * @param ints: integer array
	 * @param value: the value to look for in the array
	 * 
	 * @return 0 if the value is not found in the list
	 * 		   1 if the value is found in the list
	 */
	
	public static int inList(int[] ints, int value){
		int isin = 0;		// 0 === false;
		
		for(int i=0;i< ints.length;i++){
			if(ints[i]== value){
				isin = 1; // return 1;
			}
		}
		return isin;
	}
	
	/*
	 * Find average list in the int array
	 *
	 * @param ints: integer array
	 * 
	 * @return average int in the list
	 */
	
	public static int avgList(int[] ints){
		int elements=0;
		int total=0;
		int result;
		
		for(int i=0;i<ints.length;i++){
			total += ints[i];
			elements++;
		}
		result = total/elements;
		return result;	
	}
	
	
	/*
	 * Find middle element list in the int array
	 *
	 * @param ints: integer array
	 * 
	 * @return middle element list in the list
	 */
	
	public static int medList(int[] ints){
		int[] sorted = sort(ints);
		int lenn = ints.length;
		int middle = 0;
		int result = 0;
		if(mod(lenn,2)==0){		// even
			int midindex = lenn/2;
			middle = ints[midindex] + ints[midindex-1];
			result = (int)middle/2;
		}else{
			int midindex = (lenn-1)/2;
			result = (int) ints[midindex];
		}
		return result;
	}
	

	public static void main(String [] args){
		int a = 0;
		int b = 4;
		int c = -5;
		System.out.println(gcd(a,b));
		System.out.println(gcd(b,c));
		System.out.println(gcd(a,c));
		System.out.println(gcd(b,a));
		System.out.println(lcm(a,b));
		System.out.println(lcm(b,c));
		System.out.println(lcm(a,c));
		System.out.println(lcm(b,a));
		
	}
	
	
	
}
