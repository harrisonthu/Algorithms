import java.math.BigInteger;

/**
 * Class Monitor is the program to calculate the generalized Fibonacci number for argument N 
 * It has two multithreaded mthods: PutValue, getValue to compute Fibonacci specified by the parameters a and b
 *
 * @author  Han Min Thu
 * @version 11-Sep-2016
 */

public class Monitor {
	private BigInteger[] F;
	
	  /**
	   * Creates a new Monitor object that represents the Array F
	   * @param n number of elements in the array.
	   */
	
	public Monitor(int n){
		F = new BigInteger[n+1];
	}
	
	/*
	 * Puts the given value into array element i. 
	 * It is an error if a value has already been put into array element i.
	 * @param  i      index of the BigInteger array F
	 * @param  value  the value to be inserted into BigInteger array F
	 * @return  
	 */
	public synchronized void putValue (int i, BigInteger value){
		if(F[i] != null){
			throw new RuntimeException("A value has already been in array !");
		}
		F[i]= value;
		notifyAll();		// look here ==> https://cs.rit.edu/~ark/251/module03/notes.shtml
	}
	
	/*
	 * This method returns the value stored in array element i. 
	 * This method does not return until array element i has been put.
	 * @param  i  index of the BigInteger array F
	 * @return    a value that is BigInteger type
	 */
	
	public synchronized BigInteger getValue(int i) throws InterruptedException{
		while(F[i] == null){
			wait();
		}
		return F[i];
	}
	
	
}
