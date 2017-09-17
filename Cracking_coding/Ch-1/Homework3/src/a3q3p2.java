
/**
 * @author han
 * 
 *         Date: April 3, 2017
 *
 */
public class a3q3p2 {

	/**
	 * @param nums
	 * @return the value for how many elements it needs to jump to reach end of
	 *         array
	 * 
	 */

	public static int minStep(int[] nums) {
		int prev = 0;
		int steps = 0; // how many jumps(int) needs to reach to end of array
		int max_furthest = -1; // how many jumps it can make
		int max_delta = 0; // set maximun for delta
		int delta;

		for (int i = 1; i < nums.length; i++) { // current value > prev index +
												// prev value
			if (i > nums[prev] + prev) {
				if (max_furthest == -1) {
					return -1;
				} else { // if current index value < prev element + jumps
					prev = max_furthest;
					max_furthest = -1;
					steps++;
					max_delta = 0;
				}
			}
			delta = i - prev + nums[i]; // delta = j -i
			if (delta > max_delta) {
				max_delta = delta;
				max_furthest = i;
			}
		}
		if (prev + nums[prev] >= nums.length - 1) {
			return steps + 1; // final number of jumps needs to reach to end of
								// array
		} else {
			return -1; // unable to reach the last element
		}
	}

	/**
	 * Main function to test minStep to reach at the last element
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		int[] input = { 3, 2, 1, 1, 0 };
		System.out.println(minStep(input));

	}

}
