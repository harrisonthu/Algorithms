import java.util.Scanner;

public class TowerOfHanoi {
	static int counter =0;
	
	public static int hanoi(int nDisks, int fromPeg, int toPeg){

	 	int helpPeg;
	 	int Sol1;
		int Sol2;
		String MyStep, mySol;   // Contains moves

	 	if ( nDisks == 1 ){
	 		counter++;
	 		return counter;
	 	}else{
	 		
	 	    helpPeg = 6 - fromPeg - toPeg;    // Because fromPeg + helpPeg + toPeg = 6    
	 	    Sol1 = (int) hanoi(nDisks-1, fromPeg, helpPeg);    
	 	    MyStep = fromPeg + " -> " + toPeg + "\n";      
	 	    Sol2 = (int) hanoi(nDisks-1, helpPeg, toPeg);      
		    mySol = Sol1 + MyStep + Sol2;     // + = String concatenation !
		 	counter++;
	 	    return counter;
 	  }
	}

	public static void main(String[] args){
		
		   int n, from, to;
	       //TowerOfHanoi towersOfHanoi = new TowerOfHanoi();
	       Scanner sc = new Scanner(System.in);
	       String line;
	       String[] lineVector;

	       line = sc.nextLine(); //read 1,2,3

	       lineVector = line.split(",");

	       n=Integer.parseInt(lineVector[0]);
	       from=Integer.parseInt(lineVector[1]);
	       to=Integer.parseInt(lineVector[2]);
	       
	       System.out.println("n: "+n);
	       System.out.println("from: "+from);
	       System.out.println("to: "+to);
	       
	       System.out.println(hanoi(n,from,to));
	   }
		
	}