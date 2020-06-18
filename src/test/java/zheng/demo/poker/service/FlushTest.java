package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

/**
 * TODO Lesson_7
 * Add more tests to ensure all use cases are covered
 *
 */
public class FlushTest extends HandTestBase {

	@Test
	public void test_flush_1() {
		hand1[0] = creatCard(0, 3);
		hand1[1] = creatCard(0, 4);
		hand1[2] = creatCard(0, 5);
		hand1[3] = creatCard(0, 6);
		hand1[4] = creatCard(0, 9);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FLUSH, pokerHandEvaluator.getResult().getRanking());

	}

	@Test
	public void test_flush_2() {
		hand1[0] = creatCard(1, 3);
		hand1[1] = creatCard(1, 4);
		hand1[2] = creatCard(1, 5);
		hand1[3] = creatCard(1, 6);
		hand1[4] = creatCard(1, 9);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FLUSH, pokerHandEvaluator.getResult().getRanking());

	}

	@Test
	public void test_flush_3() {
		hand1[0] = creatCard(2, 3);
		hand1[1] = creatCard(2, 4);
		hand1[2] = creatCard(2, 5);
		hand1[3] = creatCard(2, 6);
		hand1[4] = creatCard(2, 9);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FLUSH, pokerHandEvaluator.getResult().getRanking());
	}

	@Test
	public void test_flush_4() {
		hand1[0] = creatCard(3, 3);
		hand1[1] = creatCard(3, 4);
		hand1[2] = creatCard(3, 5);
		hand1[3] = creatCard(3, 6);
		hand1[4] = creatCard(3, 9);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.FLUSH, pokerHandEvaluator.getResult().getRanking());
	}

}
