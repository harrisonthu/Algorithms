import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author han Date: April 3, 2017 Evaluating Arithmetic Expression
 *
 */
public class a3q1 {

	/**
	 * Using Divide and Conquer algorithm to calculate the expression based on
	 * where parentheses to the input
	 * 
	 * @param input
	 * @return List of the
	 */
	public static List<Integer> evalAritExpr(String input) {
		List<Integer> myresult = new ArrayList<Integer>(); // store final answer
		Set<Integer> myset = new TreeSet<Integer>(); // Create set so that there
														// are no duplicates
		List<Integer> left; //
		List<Integer> right;
		if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
			myresult.add(Integer.parseInt(input));
			return myresult;
		}

		for (int i = 0; i < input.length(); i++) { // i = operator
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				left = evalAritExpr(input.substring(0, i)); // Create arithmetic
															// eqn for left side
				right = evalAritExpr(input.substring(i + 1)); // Create
																// arithmetic
																// eqn for right
																// side

				for (int l : left) {
					for (int r : right) {
						switch (input.charAt(i)) { // check what kind of
													// operator
						case '+':
							myset.add(l + r); // if plus, so combine two list
							break;
						case '*':
							myset.add(l * r); // if multiply, multiply two
												// elements in list
							break;
						case '-':
							myset.add(l - r); // if
						}
					}
				}
			}
		}

		myresult.addAll(myset);
		return myresult; // return list holding the two final result
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "1-1*1";
		System.out.println(evalAritExpr(input));

	}

}