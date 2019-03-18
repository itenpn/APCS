/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card x = new Card("K", "Spades", 13);
		Card y = new Card("K", "Spades", 13);
		System.out.println(x.matches(y));
		System.out.println(x.toString());
	}
}
