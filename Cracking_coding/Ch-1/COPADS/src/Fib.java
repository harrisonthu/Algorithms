import java.math.BigInteger;


/**
 * Class Fib is the main program for the Generalized Fibonacci Number. 
 * It is a multithreaded Java program to compute Fibonacci number specified by the parameters a and b and the argument n, 
 * using the array-based (F). The program gets the parameters from the command line.
 *
 * @author  Han Min Thu
 * @version 11-Sep-2016
 */

public class Fib {
	/*
	 * A main program. 
	 * The main program must start the threads in this order: first the output printing thread, 
	 * then the thread that computes the last array element, then the thread that computes the next-to-last array element,
	 * and so on backwards through the array elements. The main program must not wait for the threads to terminate
	 */
	
	public static void main(String[] args)throws Throwable{
		BigInteger a = null;
		BigInteger b = null;
		
	      if (args.length != 3){
	    	  usage();
	      }
	      else{
		      try{
			      a = new BigInteger(args[0]);
		      }
		      catch(NumberFormatException f){
		    	  System.err.println( f + "<a> =  illegal");
		    	  usage();
		      }
		      catch(IllegalArgumentException e){
		    	  System.err.println(e);
		    	  usage();
		      }
		      catch(Exception e){
		    	  usage();
		      }
		      
		      try{
			      b = new BigInteger(args[1]); 
		      }
		      catch(NumberFormatException f){
		    	  System.err.println( f + " <b> = illegal");
		    	  usage();
		      }
		      catch(IllegalArgumentException e){
		    	  System.err.println(e);
		    	  usage();
		      }
		      catch(Exception e){
		    	  usage();
		      }  
		      
		      
		      int N = Integer.parseInt(args[2]);
		      if(N<0){
		    	  System.err.println ("N must be an integer greater than 0");
		    	  usage();
		      }
		      Monitor mymonitor  = new Monitor(N);
		      PrintThread myprintthread = new PrintThread(N,mymonitor);
		      Thread newthread = new Thread(myprintthread);
		      newthread.start();
		      for(int i=N;i>=0;i--){
		    	  ComputeThread mycomputethread = new ComputeThread(i, mymonitor, a, b);
		    	  Thread cthread = new Thread(mycomputethread);
		    	  cthread.start();
		      }
	      }
	}
	
	private static void usage(){
		System.err.println ("Usage: java Fib <a> <b> <n>");
        System.exit (0);
	}
	
}
