package zheng.demo.poker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Lesson_8 TODO I copied this from
 * https://www.codeproject.com/Articles/38821/Make-a-poker-hand-evalutator-in-Java
 * can you see if there any bug or improvement can be made
 *
 */
public class DeckTest {

	private Deck deck = new Deck();

	@Test
	public void test_prepareADeck() {
		deck.prepareADeck();

		Card[] hand1 = deck.drawCards(52);
		assertEquals(52, hand1.length);
		for (int i = 0; i < hand1.length; i++) {
			System.out.println(i + " " + hand1[i].toString());
		}

		Card[] hand = deck.drawCards(5);
		assertEquals(5, hand.length);
	}

}
