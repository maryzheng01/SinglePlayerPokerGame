package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class FullHouseTest extends HandTestBase {

	@Test
	public void test_fullhouse_1() {
		hand1[0] = creatCard(0, 2);
		hand1[1] = creatCard(1, 2);
		hand1[2] = creatCard(2, 8);
		hand1[3] = creatCard(3, 8);
		hand1[4] = creatCard(2, 8);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FULL_HOUSE, pokerHandEvaluator.getResult().getRanking());

	}

	@Test
	public void test_fullhouse_2() {
		hand1[0] = creatCard(0, 2);
		hand1[1] = creatCard(1, 2);
		hand1[2] = creatCard(2, 2);
		hand1[3] = creatCard(3, 8);
		hand1[4] = creatCard(2, 8);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FULL_HOUSE, pokerHandEvaluator.getResult().getRanking());

	}
}
