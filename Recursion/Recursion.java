public final class Recursion{

	private Recursion(){}

	/* Preconditions: A number from 1 to infinity that represents
	 * the specific index of the fibonnaci sequence
	 *
	 * Postconditions: The fibonnaci sequence's number at that index
	 *
	 */
	public static final int fib(int index){
		if (index == 0)
			return 0;
		else if (index == 1)
			return 1;
		else
			return fib(index - 1) + fib(index - 2);
	}

	/* Preconditions: Same as fib
	 *
	 * Postconditions: Same as fib
	 *
	 */
	public static final int iterfib(int index){
		int a = 1;
		int b = 1;
		int c = 0;
		if (index <= 2){
			return 1;
		}
		for (int i = 0; i < index - 2; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	/* Preconditions: Takes a base and an exponent
	 *
	 * Postconditions: Returns the integer value of the exponent.
	 */
	public static final int exponent(int base, int num){
		if (num == 0)
			return 1;
		else
			return base * exponent(base, num - 1);
	}

	/* Preconditions: Same as exponent
	 *
	 * Postconditions: Same as exponent
	 */
	public static final int iterexponent(int base, int num){
		int x = 1;
		for (int i = 0; i < num; i++)
			x *= base;
		return x;
	}

	/* Preconditions: Takes in a base number and how many times it is added
	 *
	 * Postconditions: Returns the sum of base number and times it is added
	 */
	public static final int sum(int num){
		if (num == 0)
			return 0;
		else
			return num + sum(num - 1);
	}

	/* Preconditions: Same as sum
	 *
	 * Postconditions: Same as sum
	 */
	public static final int itersum(int num){
		int sum = 0;
		for (int i = 0; i <= num; i++)
			sum += i;
		return sum;
	}

	/* Preconditions: Takes in a word that you want backwards
	 *
	 * Postconditions: Returns a string that was reversed
	 */
	public static final String backwards(String word){
		String remaining = word.substring(0, word.length() - 1);
		String last = word.substring(word.length() - 1, word.length());
		if (word.length() == 1)
			return word;
		else
			return last + backwards(remaining);
	}

	public static final String iterbackwards(String word){
		String x = "";
		for (int i = word.length() - 1; i >= 0; i--){
			x += word.substring(i, i + 1);
		}
		return x;
	}

	/* Preconditions: Takes in a word that you want checked as a palindrome
	 *
	 * Postconditions: Returns true if the word is same backwards and forwards
	 * else false
	 */
	public static final boolean palindrome(String word){
		String first = word.substring(0,1);
		String last = word.substring(word.length() - 1, word.length());
		if (word.length() == 1)
			return true;
		else if (word.length() == 2)
			return first.equals(last);
		else if (first.equals(last))
			return palindrome(word.substring(1, word.length() - 1));
		else
			return false;
	}

	public static final boolean iterpalindrome(String word){
		return word.equals(iterbackwards(word));
	}

	public static final double binary(String binnum){
		if (binnum.length() == 0)
			return 0;
		else if (binnum.substring(0 , 1).equals("1"))
			return Math.pow(2, binnum.length() - 1) + binary(binnum.substring(1, binnum.length()));
		else
			return binary(binnum.substring(1, binnum.length()));
	}

	public static final double iterbinary(String binnum){
		double x = 0;
		for (int i = 0; i < binnum.length(); i++){
			if (binnum.substring(i, i + 1).equals("1"))
				x += Math.pow(2, binnum.length() - 1 - i);
		}
		return x;
	}

	public static final String toBinary(int num){
		if (num == 0)
			return "";
		else
			return toBinary(num / 2) + Integer.toString(num % 2);
	}

	public static final String itertoBinary(int num){
		String x = "";
		int curr = num;
		while (curr > 0){
			x += Integer.toString(curr % 2);
			curr /= 2;
		}
		return iterbackwards(x);	
	}

}
