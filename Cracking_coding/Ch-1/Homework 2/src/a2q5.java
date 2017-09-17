

/*
 * Function  that  takes  as  input  a  sorted  array  of  integers  (in  ascending  order)
 * but rotated at some point (only once), and outputs the smallest element. 
 * 
 * Author: Han Min Thu
 */

public class a2q5 {

	// Find smallest element in an array
	static int findSmallest(int arr[]) {

		int high = arr.length - 1;
		int low = 0;
		int mid;

		// While loop to which side of array {left, right} to find the smallest element
		while (high >= low) {
			// Find mid
			mid = (low + high) / 2;

			// Check if element (mid+1) is minimum element. Consider
			// the cases like {3, 4, 5, 1, 2}
			if (mid < arr.length - 1 && arr[mid + 1] < arr[mid])
				return arr[mid + 1];

			// Check if mid itself is minimum element
			if (mid > 0 && arr[mid] < arr[mid - 1])
				return arr[mid];

			// Decide whether we need to go to left half or right half
			if (arr[high] > arr[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return arr[low];
	}

	// Main Function
	public static void main(String[] args) {


		// Test case 1
		//int arr1[] = {1, 2, 0};
		
		// Test case 2
		int arr1[] = { 4, 5, 0, 1, 2, 3 };
		// int n1 = arr1.length;
		System.out.println("Output: " + findSmallest(arr1));
	}

}
