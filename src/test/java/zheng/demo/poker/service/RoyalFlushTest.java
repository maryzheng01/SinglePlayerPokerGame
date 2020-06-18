package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class RoyalFlushTest extends HandTestBase {

	@Test
	public void test_royalFlush_1() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(0, 9);
		hand1[2] = creatCard(0, 10);
		hand1[3] = creatCard(0, 11);
		hand1[4] = creatCard(0, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.ROYAL_FLUSH, pokerHandEvaluator.getResult().getRanking());
	}
	
	@Test
	public void test_royalFlush_2() {
		hand1[0] = creatCard(1, 8);
		hand1[1] = creatCard(1, 9);
		hand1[2] = creatCard(1, 10);
		hand1[3] = creatCard(1, 11);
		hand1[4] = creatCard(1, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.ROYAL_FLUSH, pokerHandEvaluator.getResult().getRanking());
	}
	
	@Test
	public void test_royalFlush_3() {
		hand1[0] = creatCard(2, 8);
		hand1[1] = creatCard(2, 9);
		hand1[2] = creatCard(2, 10);
		hand1[3] = creatCard(2, 11);
		hand1[4] = creatCard(0, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.ROYAL_FLUSH, pokerHandEvaluator.getResult().getRanking());
	}
	
	@Test
	public void test_royalFlush_4() {
		hand1[0] = creatCard(3, 8);
		hand1[1] = creatCard(3, 9);
		hand1[2] = creatCard(3, 10);
		hand1[3] = creatCard(3, 11);
		hand1[4] = creatCard(3, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.ROYAL_FLUSH, pokerHandEvaluator.getResult().getRanking());
	}

}
