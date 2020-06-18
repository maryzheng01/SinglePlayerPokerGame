package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class StraightFlushTest extends HandTestBase {

	@Test
	public void test_straightFlush() {
		hand1[0] = creatCard(0, 3);
		hand1[1] = creatCard(0, 4);
		hand1[2] = creatCard(0, 5);
		hand1[3] = creatCard(0, 6);
		hand1[4] = creatCard(0, 7);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.STAIGHT_FLUSH, pokerHandEvaluator.getResult().getRanking());

	}

}
