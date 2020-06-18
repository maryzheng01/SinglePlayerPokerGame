package zheng.demo.poker;

import java.util.Arrays;
import java.util.Scanner;

import zheng.demo.poker.model.Card;
import zheng.demo.poker.model.Deck;
import zheng.demo.poker.model.HandResult;
import zheng.demo.poker.model.Player;
import zheng.demo.poker.service.HandEvaluator;

/**
 * This is the main user interaction flow.
 * while loop, syserm.in to read from keyboard input, invoking deck
 * Lesson_9
 * 
 *
 */
public class PokerGame {

	private Deck deck = new Deck();

	private HandEvaluator handEvaluator = new HandEvaluator();

	private Scanner scan = new Scanner(System.in, "UTF-8");

	public void play() {
		int again = 1;

		System.out.print("\nPlease enter your name to play!");
		Player player = new Player(scan.nextLine());

		while (again == 1) {
			deck.prepareADeck();
			System.out.println("\nHello " + player.getName() + "! Here are 5 cards sorted for you: ");
			
			Card[] dealedCards = deck.drawCards(Constants.HAND_SIZE);

			handEvaluator.setHand(dealedCards);
			showHand(handEvaluator.getHand());
			handEvaluator.evaluate();
			HandResult first = handEvaluator.getResult();
			System.out.println("\n\nThe current hand ranked as: " + first.showResults());

			reDraw();
			System.out.println("\nHere is new hand after redrawing:");
			showHand(handEvaluator.getHand());
			handEvaluator.evaluate();
			HandResult second = handEvaluator.getResult();
			System.out.printf("\n\n%s, your final hand ranked as %s: ", player.getName(), second.showResults());
			
			if (second.compareTo(first) == 1) {
				player.setGameImproved(player.getGameImproved() + 1);
				System.out.println("\n\nCongratulation! you made a better choice!");
			} else if (second.compareTo(first) == -1) {
				System.out.println("\n\nOOPS!");
			}
			
			player.setGamePlayed(player.getGameImproved() + 1);
		
			System.out.print("\nPlay a New Game? (1 for yes, 0 for no)");
			if (scan.hasNextInt()) {
				again = scan.nextInt();
			}
		}

		player.showReport();
		System.out.println("\nThanks for playing! Bye! ");
		scan.close();
	}

	// asks if player wants to redraw
	private void reDraw() {
		int redrawCount = 0;
		for (int counter = 0; counter < Constants.HAND_SIZE; counter++) {
			System.out.println("Redraw card " + (counter + 1) + "?" + " (1 for yes, 0 for no)");
			if (scan.hasNextInt()) {
				int answer = scan.nextInt();
				
				if (answer == 1) {
					int redrawPosition = Constants.HAND_SIZE + redrawCount++ ;
					handEvaluator.getHand()[counter] = deck.drawACard(redrawPosition);
				}
			}
		}

		Arrays.sort(handEvaluator.getHand());
		

	}
	
	private void showHand(Card[] cards) {
		for (int handCounter = 0; handCounter < cards.length; handCounter++) {
			System.out.print(" " + cards[handCounter].toString());
		}
	}
}
