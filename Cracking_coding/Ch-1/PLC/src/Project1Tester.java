/**
 * Author: Scott C. Johnson
 * PLC Fall 2016
 * 
 * Project 1 Tester
 * 
 * This is intended to test the functions for Project1.
 * 
 * If you notice any error or have any questions please
 * email me.
 * 
 * To use this file just place in the same directory as
 * you project file.
 * 
 * Compile your Project1.java file and this file at the
 * same time.
 * 
 * Example: javac Project1.java Project1Tester.java
 * 
 * The run the Project1Tester, you must provide a True/False
 * as the first parameter.
 * 
 * Example: java Project1Tester True
 *          this will print all tests
 *          
 *          java Project1Tester False
 *          this will only print tests that fail.
 */

import java.util.Arrays;

public class Project1Tester {

	int failed = 0;
	int passed = 0;
	int total = 0;
	boolean print_success = true;
	
	public void testMod(int x, int y, int expected){
		if(Project1.mod(x,y) == expected){
			if(print_success)
				System.out.printf(
				    "mod(%d, %d) passed!\n", x, y);
			passed++;
		}
		else{
			System.out.printf(
			    "mod(%d, %d) expected %d, but got %d!\n",
			    x,y,expected,Project1.mod(x, y));
			failed++;
		}
		total++;
	}
	
	public void testSqrt(int x, int expected){
		if(Project1.sqrt(x) == expected){
			if(print_success)
				System.out.printf(
				    "sqrt(%d) passed!\n", x);
			passed++;
		}
		else{
			System.out.printf(
			    "sqrt(%d) expected %d, but got %d!\n",
			    x,expected,Project1.sqrt(x));
			failed++;
		}
		total++;
	}
	
	public void testCbrt(int x, int expected){
		if(Project1.cbrt(x) == expected){
			if(print_success)
				System.out.printf(
				    "cbrt(%d) passed!\n", x);
			passed++;
		}
		else{
			System.out.printf(
			    "cbrt(%d) expected %d, but got %d!\n",
			    x,expected,Project1.cbrt(x));
			failed++;
		}
		total++;
	}
	
	public void testGcd(int x, int y, int expected){
		if(Project1.gcd(x,y) == expected){
			if(print_success)
				System.out.printf(
				    "gcd(%d, %d) passed!\n", x, y);
			passed++;
		}
		else{
			System.out.printf(
			    "gcd(%d, %d) expected %d, but got %d!\n",
			    x,y,expected,Project1.gcd(x, y));
			failed++;
		}
		total++;
	}
	
	public void testLcm(int x, int y, int expected){
		if(Project1.lcm(x,y) == expected){
			if(print_success)
				System.out.printf(
				    "lcm(%d, %d) passed!\n", x, y);
			passed++;
		}
		else{
			System.out.printf(
			    "lcm(%d, %d) expected %d, but got %d!\n",
			    x,y,expected,Project1.lcm(x, y));
			failed++;
		}
		total++;
	}
	
	public void testSort(int[] x, int[] expected){
		if(Arrays.equals(Project1.sort(x), expected)){
			if(print_success)
				System.out.printf(
				    "sort(%s) passed!\n", Arrays.toString(x));
			passed++;
		}
		else{
			System.out.printf(
			    "sort(%s) expected %s, but got %s!\n",
			    Arrays.toString(x),
			    Arrays.toString(expected),
			    Arrays.toString(Project1.sort(x)));
			failed++;
		}
		total++;
	}
	
	public void testMax(int[] x, int expected){
		if(Project1.max(x) ==  expected){
			if(print_success)
				System.out.printf(
				    "max(%s) passed!\n", Arrays.toString(x));
			passed++;
		}
		else{
			System.out.printf(
			    "max(%s) expected %d, but got %d!\n",
			    Arrays.toString(x),
			    expected,
			    Project1.max(x));
			failed++;
		}
		total++;
	}
	
	public void testMin(int[] x, int expected){
		if(Project1.min(x) ==  expected){
			if(print_success)
				System.out.printf(
				    "min(%s) passed!\n", Arrays.toString(x));
			passed++;
		}
		else{
			System.out.printf(
			    "min(%s) expected %d, but got %d!\n",
			    Arrays.toString(x),
			    expected,
			    Project1.min(x));
			failed++;
		}
		total++;
	}
	
	public void testInList(int[] x, int y, int expected){
		if(Project1.inList(x, y) ==  expected){
			if(print_success)
				System.out.printf(
				    "inList(%s, %d) passed!\n", 
				    Arrays.toString(x),
				    y);
			passed++;
		}
		else{
			System.out.printf(
			    "inList(%s, %d) expected %d, but got %d!\n",
			    Arrays.toString(x),
			    y,
			    expected,
			    Project1.inList(x, y));
			failed++;
		}
		total++;
	}
	
	public void testAvgList(int[] x, int expected){
		if(Project1.avgList(x) ==  expected){
			if(print_success)
				System.out.printf(
				    "avgList(%s) passed!\n", Arrays.toString(x));
			passed++;
		}
		else{
			System.out.printf(
			    "avgList(%s) expected %d, but got %d!\n",
			    Arrays.toString(x),
			    expected,
			    Project1.avgList(x));
			failed++;
		}
		total++;
	}
	
	public void testMedList(int[] x, int expected){
		if(Project1.medList(x) ==  expected){
			if(print_success)
				System.out.printf(
				    "medList(%s) passed!\n", Arrays.toString(x));
			passed++;
		}
		else{
			System.out.printf(
			    "medList(%s) expected %d, but got %d!\n",
			    Arrays.toString(x),
			    expected,
			    Project1.medList(x));
			failed++;
		}
		total++;
	}
	
	public static void main(String[] args) {
		Project1Tester p = new Project1Tester();
		 if(args[0].equals("True")){
			 p.print_success = true;
		 }
		 else{
			 p.print_success = false;
		 }
		
		//testing the mod function
		p.testMod(2, 1, 0);
		p.testMod(4, 3, 1);
		p.testMod(100, 5, 0);
		p.testMod(100, 9, 1);
		p.testMod(25, 7, 4);
		p.testMod(44, 8, 4);
		
		//testing sqrt function
		p.testSqrt(0, 0);
		p.testSqrt(1, 1);
		p.testSqrt(2, 1);
		p.testSqrt(4, 2);
		p.testSqrt(8, 2);
		p.testSqrt(9, 3);
		p.testSqrt(99, 9);
		p.testSqrt(100, 10);
		
		//test cbrt function
		p.testCbrt(1, 1);
		p.testCbrt(-1, -1);
		p.testCbrt(2, 1);
		p.testCbrt(-2, -1);
		p.testCbrt(7, 1);
		p.testCbrt(-7, -1);
		p.testCbrt(8, 2);
		p.testCbrt(-8, -2);
		p.testCbrt(26, 2);
		p.testCbrt(27, 3);
		p.testCbrt(-27, -3);
		
		//test the gcd function
		p.testGcd(8, 6, 2);
		p.testGcd(5, 3, 1);
		p.testGcd(100, 50, 50);
		p.testGcd(99, 6, 3);
		p.testGcd(1024, 64, 64);
		p.testGcd(1001, 55, 11);
		p.testGcd(45, 18, 9);
		
		//testing lcm function
		p.testLcm(3, 5, 15);
		p.testLcm(3, 16, 48);
		p.testLcm(6, 3, 6);
		p.testLcm(11, 55, 55);
		p.testLcm(1001, 54, 54054);
		p.testLcm(200, 201, 40200);
		
		//testing the sort function
		p.testSort(new int[]{1,2,3,4}, new int[]{1,2,3,4});
		p.testSort(new int[]{4,3,2,1}, new int[]{1,2,3,4});
		p.testSort(new int[]{4,1,2,3}, new int[]{1,2,3,4});
		p.testSort(new int[]{1,3,4,1}, new int[]{1,1,3,4});
		p.testSort(new int[]{5,6,3,2,8,6}, new int[]{2,3,5,6,6,8});
		p.testSort(new int[]{1}, new int[]{1});
		
		//testing the max function
		p.testMax(new int[]{1,2,3,4}, 4);
		p.testMax(new int[]{4,3,2,1}, 4);
		p.testMax(new int[]{4,1,2,3}, 4);
		p.testMax(new int[]{1,3,4,1}, 4);
		p.testMax(new int[]{5,6,3,2,8,6}, 8);
		p.testMax(new int[]{1}, 1);
		p.testMax(new int[]{1,5,6,-5}, 6);
		p.testMax(new int[]{-1,-5,-6}, -1);
		
		//testing the min function
		p.testMin(new int[]{1,2,3,4}, 1);
		p.testMin(new int[]{4,3,2,1}, 1);
		p.testMin(new int[]{4,1,2,3}, 1);
		p.testMin(new int[]{1,3,4,1}, 1);
		p.testMin(new int[]{5,6,3,2,8,6}, 2);
		p.testMin(new int[]{1}, 1);
		p.testMin(new int[]{1,5,6,-5}, -5);
		p.testMin(new int[]{-1,-5,-6}, -6);
		
		//testing inList function
		p.testInList(new int[]{1,2,3,4}, 1, 1);
		p.testInList(new int[]{4,3,2,1}, 0, 0);
		p.testInList(new int[]{4,1,2,3}, 1, 1);
		p.testInList(new int[]{1,3,4,1}, 5, 0);
		p.testInList(new int[]{5,6,3,2,8,6}, 8, 1);
		p.testInList(new int[]{1}, 1, 1);
		p.testInList(new int[]{1,5,6,-5}, 2, 0);
		p.testInList(new int[]{-1,-5,-6}, -6, 1);
		
		//testing avgList function
		p.testAvgList(new int[]{10,2,3,4}, 4);
		p.testAvgList(new int[]{6,3,8,1}, 4);
		p.testAvgList(new int[]{40,10,22,3}, 18);
		p.testAvgList(new int[]{21,31,44,100}, 49);
		p.testAvgList(new int[]{5,6,3,2,8,6}, 5);
		p.testAvgList(new int[]{1}, 1);
		p.testAvgList(new int[]{1,5,6,-5}, 1);
		p.testAvgList(new int[]{-1,-5,-6}, -4);
		
		//testing medList function
		p.testMedList(new int[]{10,2,3,4}, 3);
		p.testMedList(new int[]{6,3,8,1}, 4);
		p.testMedList(new int[]{40,10,22,3}, 16);
		p.testMedList(new int[]{21,31,44,100}, 37);
		p.testMedList(new int[]{5,6,3,2,8,6}, 5);
		p.testMedList(new int[]{1}, 1);
		p.testMedList(new int[]{1,5,6,-5}, 3);
		p.testMedList(new int[]{-1,-5,-6}, -5);
		
		
		if(p.passed == p.total){
			System.out.printf(
			    "\nCongrats! All %d Tests Passed!",
			    p.total);
		}
		else{
            System.out.printf(
                "\nUtoh! %d of %d tests failed!",
                p.failed, p.total);
		}
	}

}
