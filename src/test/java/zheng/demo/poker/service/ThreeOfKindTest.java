package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;
import zheng.demo.poker.service.HandEvaluator;

public class ThreeOfKindTest extends HandTestBase {

	@Test
	public void test_threeOfKind_1() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(1, 11);
		hand1[2] = creatCard(2, 12);
		hand1[3] = creatCard(3, 12);
		hand1[4] = creatCard(1, 12);
		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.THREE_OF_KIND, pokerHandEvaluator.getResult().getRanking());

	}

	@Test
	public void test_threeOfKind_2() {
		hand1[0] = creatCard(0, 0);
		hand1[1] = creatCard(1, 0);
		hand1[2] = creatCard(2, 0);
		hand1[3] = creatCard(0, 4);
		hand1[4] = creatCard(0, 5);

		HandEvaluator servie = new HandEvaluator();
		servie.setHand(hand1);

		servie.evaluate();
		assertEquals(HandRanking.THREE_OF_KIND, servie.getResult().getRanking());

	}

	@Test
	public void test_threeOfKind_3() {
		hand1[0] = creatCard(0, 8);
		hand1[1] = creatCard(1, 11);
		hand1[2] = creatCard(2, 11);
		hand1[3] = creatCard(3, 11);
		hand1[4] = creatCard(1, 12);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.THREE_OF_KIND, pokerHandEvaluator.getResult().getRanking());

	}

}
