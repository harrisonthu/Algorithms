
/**
 * @author han
 * 
 *         Date: April 3, 2017
 * 
 */
public class a3q3p1 {

	/**
	 * @param nums
	 * @return true or false true - if reach to the end of the array false - not
	 *         able to reach to the end of the array
	 */

	public static boolean validArray(int[] nums) {
		int prev = 0;
		int steps = 0;
		int max_furthest = -1; // how many jumps it can make
		int max_delta = 0; // delta = j -i
		int delta;

		for (int i = 1; i < nums.length; i++) {
			if (i > nums[prev] + prev) { // current value > prev index + prev
											// value
				if (max_furthest == -1) {
					return false;
				} else { // if current index value < prev element + jumps
					prev = max_furthest;
					max_furthest = -1;
					steps++;
					max_delta = 0;
				}
			}
			delta = i - prev + nums[i]; // delta = first index value + jumps
										// value
			if (delta > max_delta) {
				max_delta = delta;
				max_furthest = i;
			}
		}
		if (prev + nums[prev] >= nums.length - 1) {
			return true; // no way to reach last element
		} else {
			return false; // able to reach it
		}
	}

	/**
	 * Main function to test whether it can reach to the last element
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 3, 2, 1, 0, 0 };
		System.out.println(validArray(input));

	}

}
