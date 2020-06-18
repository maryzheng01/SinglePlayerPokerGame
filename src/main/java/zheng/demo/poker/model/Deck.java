package zheng.demo.poker.model;

import java.util.Arrays;
import java.util.Random;


/**
 * Lesson_2 Random number generator, Array size and Array position, for loop
 */
public class Deck {
	private static final int SHUFFLE_EXCHANGE_TIMES = 2000;
	public static final int DECK_SIZE = 52;

	Card[] cards = new Card[DECK_SIZE];

	public Card[] drawCards(int handSize) {
		return Arrays.copyOf(cards, handSize);
	}

	public void prepareADeck() {
		createADeck();
		shuffle();
	}

	private void createADeck() {
		int counter = 0;
		for (int suit = 0; suit < Card.SUITS.length; suit++) {
			for (int value = 0; value < Card.VALUES.length; value++) {
				cards[counter] = new Card(suit, value);
				counter++;
			}
		}
	}

	public Card drawACard(int position) {
		return cards[position];
	}

	private void shuffle() {
		Random random = new Random();
		for (int x = 0; x <= SHUFFLE_EXCHANGE_TIMES; x++) {
			int number1 = random.nextInt(DECK_SIZE);
			int number2 = random.nextInt(DECK_SIZE);

			Card temp = cards[number1];
			cards[number1] = cards[number2];
			cards[number2] = temp;
		}
	}

}
