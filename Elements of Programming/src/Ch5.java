
public class Ch5 {


	public static void main(String[] args) {
		System.out.println(stringToInt("-358a"));
	}

	public static int stringToInt(String s) {
		boolean isNeg = false;
		int i = 0;
		if (s.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		int sum = 0;
		for (; i < s.length(); i++) {
			//System.out.println("i: "+i);
			System.out.println("s.charAt(" + i + ")::::"+ (s.charAt(i) - '0')) ;
			sum = sum * 10 + (s.charAt(i) - '0');
		}
		if (isNeg)
			sum *= -1;
		return sum;
	}

}
