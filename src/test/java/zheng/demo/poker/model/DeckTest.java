package zheng.demo.poker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Lesson_8 TODO
 * I copied this from https://www.codeproject.com/Articles/38821/Make-a-poker-hand-evalutator-in-Java
 * can you see if there any bug or improvement can be made
 *
 */
public class DeckTest {

	private Deck deck = new Deck();

	private Set<Card> convertToSet(Card[] cardArray) {
		Set<Card> cards = new HashSet<>();
		for (Card c : cardArray) {
			cards.add(c);
		}
		return cards;
	}

	@Test
	public void test_prepareADeck() {
		deck.prepareADeck();

		assertEquals(52, deck.cards.length);
		//TODO print out the desk
		int i = 0;
		for (Card card: deck.cards) {
			i++;
			System.out.println(i +  " " + card.toString());
		}

		Set<Card> cards = convertToSet(deck.cards);

		assertEquals(52, cards.size());

		Card[] hand = deck.drawCards(5);
		assertEquals(5, hand.length);
		assertEquals(5, convertToSet(hand).size());
		
		Card newCard = deck.drawACard(6);
		assertFalse(Arrays.stream(hand).anyMatch(newCard::equals));
	}

}
