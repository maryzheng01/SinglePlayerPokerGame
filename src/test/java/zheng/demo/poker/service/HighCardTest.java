package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class HighCardTest extends HandTestBase {

	@Test
	public void test_highcard() {
		hand1[0] = creatCard(0, 2);
		hand1[1] = creatCard(1, 3);
		hand1[2] = creatCard(2, 5);
		hand1[3] = creatCard(3, 8);
		hand1[4] = creatCard(2, 10);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.HIGH_CARD, pokerHandEvaluator.getResult().getRanking());
		 
	}

}
