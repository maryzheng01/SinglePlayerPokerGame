package zheng.demo.poker.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Lesson_1 TODO
 * create your own test to create a new card and compare them
 * 
 * Unit Test,  Junit 5. Set up the data, execute the program, and validate the result
 * How to debug and step through the code and inspect the variable value during the run-time
 * Compile time and Run time, Java Virtual Machine
 *
 */
public class CardTest extends TestBase {

	@Test
	public void test_createCard() {
		Card card = creatCard(3, 7);
		assertEquals(7, card.getValueIndex());
		assertEquals(3, card.getSuitIndex());
		System.out.println(card.toString());
	}

	@Test
	public void test_compareCard_1() {
		Card card1 = creatCard(3, 7);
		Card card2 = creatCard(3, 8);
		assertEquals(-1, card1.compareTo(card2));
		assertEquals(1, card2.compareTo(card1));
	}

	@Test
	public void test_compareCard_2() {
		Card card1 = creatCard(3, 7);
		Card card2 = creatCard(2, 7);
		assertEquals(0, card1.compareTo(card2));
		assertEquals(0, card2.compareTo(card1));
	}

}
