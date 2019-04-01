/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits = {"S", "C", "D", "H"};
		int[] vals = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		Deck d = new Deck(ranks, suits, vals);
		Card c = d.deal();
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(d.isEmpty());
		System.out.println(d.size());
	}
}
