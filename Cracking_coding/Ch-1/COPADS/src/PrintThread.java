
/**
 * 
 * PrintThread class that implements Runnable.  Plus, the thread class that prints the final output.
 * Thread synchronization is done by a monitor.
 */
public class PrintThread implements Runnable{
	int n;
	Monitor mymonitor;
	
	
	  /**
	   * Creates a new PrintThread object that print the final output
	   * 
	   * @param n number of elements in the array.
	   * @param mymonitor  Create mymonitor instance.
	   */
	
	public PrintThread(int n,Monitor mymonitor){
	this.n = n;
	this.mymonitor = mymonitor;
	}

	/*
	 * run method to be called in that separately executing thread.
	 * Print out after all of the calculation is done.
	 */
	public void run(){	 
		 try {
			System.out.println(mymonitor.getValue(n));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }

}
