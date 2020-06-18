package zheng.demo.poker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import zheng.demo.poker.model.HandRanking;

public class StraightTest extends HandTestBase {

	
	@Test
	public void test_straight_1() {
		hand1[0] = creatCard(0, 3);
		hand1[1] = creatCard(0, 4);
		hand1[2] = creatCard(0, 5);
		hand1[3] = creatCard(1, 6);
		hand1[4] = creatCard(0, 7);

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.STRAIGHT, pokerHandEvaluator.getResult().getRanking());
	}
	

	@Disabled("disable it until we handle the special case")
	@Test
	public void test_straight_2() {
		hand1[0] = creatCard(0, 0);
		hand1[1] = creatCard(0, 1);
		hand1[2] = creatCard(0, 2);
		hand1[3] = creatCard(1, 3);
		hand1[4] = creatCard(0, 12);
		//this is a special case of A, 2, 3, 4, 5

		Arrays.stream(hand1).forEach(card -> System.out.println(card.toString()));

		pokerHandEvaluator.setHand(hand1);
		pokerHandEvaluator.evaluate();
		assertEquals(HandRanking.STRAIGHT, pokerHandEvaluator.getResult().getRanking());
	 
	}


}
