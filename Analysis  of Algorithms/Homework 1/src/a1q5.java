
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




/*
 * Author: Han Min Thu
 * 
 * Finding K Loyal Matching problem
 * 
 *  Using heap to sort and insert items into the heap so that it can run k log k run time.
 */
public class a1q5 {

	static List<String[]> findKLoyalMatching(int[] mLRisks, int[] fLRisks, int k) {
		if (k > mLRisks.length * fLRisks.length)
			return null;

		// create array to store m1, fi rk
		List<String[]> myarray = new ArrayList<>();

		int[][] heap = new int[mLRisks.length][];

		// ---------------------------------------------
		// Male 	| 0 			| 1 | 2 | 3   ...  |
		// Female	| 0 			| 0 | 0 | 0   ...  |
		// Risk 	| f[0] + m[0] 	|	               |
		// ---------------------------------------------

		// create 2D arrays with Male Female and Risks
		for (int i = 0; i < mLRisks.length; i++) { // create column
			int[] j = { i, 0, fLRisks[0] + mLRisks[i] };
			heap[i] = j;
		}

		// Update the heap and insert item into the heap
		for (int i = 0; i < k; i++) {
			myarray.add(new String[] { "m" + heap[0][0] + "f" + heap[0][1] });
			heap[0][1]++;

				// Check the left and right length is less than total calculation times.
			if (heap[0][1] < fLRisks.length)
				heap[0][2] = fLRisks[heap[0][1]] + mLRisks[heap[0][0]];
			else
				heap[0][2] = Integer.MAX_VALUE;
			int j = 0;

			while (true) {
				int left_subheap = 2 * j + 1;
				int right_subheap = 2 * j + 2;
				if (left_subheap >= heap.length)
					break;
				if (right_subheap >= heap.length || heap[left_subheap][2] < heap[right_subheap][2]) {
					if (heap[left_subheap][2] >= heap[j][2])
						break;
					else {
						int[] temp = heap[j];
						heap[j] = heap[left_subheap];
						heap[left_subheap] = heap[j];
						j = left_subheap;
					}
				} else {
					if (heap[right_subheap][2] >= heap[j][2])
						break;
					else {
						int[] temp = heap[j];
						heap[j] = heap[right_subheap];
						heap[right_subheap] = heap[j];
						j = right_subheap;
					}
				}

			}

		}
		return myarray;	// just returning array since I do not know how testcases are gonna run.
		
	}
//
	public static void main(String[] args) {
		int[] mLRisks= new int [3];
		mLRisks[0]=1;//initialization.
		mLRisks[1]=3;
		mLRisks[2]=9;
		

		int[] fLRisks= new int [2];
		fLRisks[0]=2;
		fLRisks[1]=6;
		
		List<String[]> answer = findKLoyalMatching(mLRisks,fLRisks,3);
		System.out.print("[");
		boolean first = true;
		for(String[] a : answer){
			if(!first)System.out.print(",");
			System.out.print(Arrays.toString(a));
			first = false;
		}
		System.out.print("]");
		
	}

}
