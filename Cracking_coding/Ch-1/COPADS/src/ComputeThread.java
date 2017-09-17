import java.math.BigInteger;
import java.util.concurrent.SynchronousQueue;

/**
 * A thread class that computes one and only one array element and stores it in the monitor.
 * There is a separate instance of this thread for each array element, including
 * array elements 0 and 1.
 */

public class ComputeThread implements Runnable {	// 
	int index;
	Monitor mymonitor;
	BigInteger a;
	BigInteger b;
	
	
	/*
	 * Constructor class for Compute Thread
	 * @param  index		index number for the array
	 * @param  mymonitor	create monitor instance
	 * @return a			BigInteger type value a
	 * @return b			BigInteger tyep value b
	 */
	public ComputeThread(int index, Monitor mymonitor, BigInteger a, BigInteger b){
		this.index = index;
		this.mymonitor = mymonitor;
		this.a = a;
		this.b = b;
	}


	@Override
	/*
	 * run method to be called in that separately executing thread.
	 * If user type in n == 0, return just value a.
	 * If user type in n == 1, return just value b.
	 * If user type in 
	 */
	public void run() {
		if(index == 0){	
			mymonitor.putValue(index, a);
		}else if(index == 1){
			mymonitor.putValue(index, b);
		}else{
			try {
				mymonitor.putValue(index, mymonitor.getValue(index-1).add(mymonitor.getValue(index-2)));
			} catch (InterruptedException e) {
				e.printStackTrace();
		}

		
	}
	
	}
}
