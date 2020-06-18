package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class FourOfKindTest extends HandTestBase {

	@Test
	public void test_fourofKind_1() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(1, 12);
		hand1[2] = creatCard(2, 12);
		hand1[3] = creatCard(3, 12);
		hand1[4] = creatCard(2, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		hand1Result = pokerHandEvaluator.getResult();
		assertEquals(HandRanking.FOUR_OF_KIND, hand1Result.getRanking());
		System.out.println(pokerHandEvaluator.getResult().toString());

		hand2[0] = creatCard(0, 8);
		hand2[1] = creatCard(1, 11);
		hand2[2] = creatCard(2, 11);
		hand2[3] = creatCard(3, 11);
		hand2[4] = creatCard(2, 11);

		pokerHandEvaluator.setHand(hand2);
		pokerHandEvaluator.evaluate();
		hand2Result = pokerHandEvaluator.getResult();
		assertEquals(HandRanking.FOUR_OF_KIND, hand2Result.getRanking());
		System.out.println(pokerHandEvaluator.getResult().toString());

		assertEquals(1, hand1Result.compareTo(hand2Result));

	}
}
