package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class TwoPairTest extends HandTestBase {

	@Test
	public void test_twoPair_1() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(1, 8);
		hand1[2] = creatCard(1, 10);
		hand1[3] = creatCard(2, 10);
		hand1[4] = creatCard(2, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();

		hand1Result = pokerHandEvaluator.getResult();
		assertEquals(HandRanking.TWO_PAIR, hand1Result.getRanking());
		assertEquals(10, hand1Result.getPrimaryValuePos());
		assertEquals(8, hand1Result.getSecondaryValuePos());
	}

	@Test
	public void test_twoPair_2() {
		hand1[0] = creatCard(0, 7);
		hand1[1] = creatCard(1, 8);
		hand1[2] = creatCard(1, 8);
		hand1[3] = creatCard(2, 10);
		hand1[4] = creatCard(3, 10);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		hand1Result = pokerHandEvaluator.getResult();
		assertEquals(HandRanking.TWO_PAIR, hand1Result.getRanking());
	}

	@Test
	public void test_twoPair_3() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(1, 8);
		hand1[2] = creatCard(1, 10);
		hand1[3] = creatCard(3, 12);
		hand1[4] = creatCard(2, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		hand1Result = pokerHandEvaluator.getResult();
		assertEquals(HandRanking.TWO_PAIR, hand1Result.getRanking());
	}
	
}
