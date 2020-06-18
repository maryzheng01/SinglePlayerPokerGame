package zheng.demo.poker.service;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;

import zheng.demo.poker.Constants;
import zheng.demo.poker.model.Card;
import zheng.demo.poker.model.HandResult;
import zheng.demo.poker.model.TestBase;
import zheng.demo.poker.service.HandEvaluator;

public class HandTestBase extends TestBase {

	protected Card[] hand1 = new Card[Constants.HAND_SIZE];
	HandResult hand1Result;

	protected Card[] hand2 = new Card[Constants.HAND_SIZE];
	HandResult hand2Result;

	protected HandEvaluator pokerHandEvaluator = new HandEvaluator();

	public HandTestBase() {
		super();
	}

	@AfterEach
	public void cleanup() {
		if (hand1Result != null) {
			System.out.println("Hand is " + hand1Result.toString() + " for :");
			showHandWithStream(hand1);
		}

		if (hand2Result != null) {
			System.out.println("Hand is " + hand2Result.toString() + " for :");
			showHandWithStream(hand2);
		}
	}

	private void showHandWithStream(Card[] hand) {
		Arrays.stream(hand).forEach(card -> System.out.println(card.toString()));
	}

}