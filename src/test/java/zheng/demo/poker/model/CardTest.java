package zheng.demo.poker.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Lesson_1 TODO create your own test to create a new card and compare them
 * 
 * Unit Test, Junit 5. Set up the data, execute the program, and validate the
 * result How to debug and step through the code and inspect the variable value
 * during the run-time Compile time and Run time, Java Virtual Machine
 *
 */
public class CardTest extends TestBase {

	@Test
	public void test_createCard() {
		Card card = creatCard("Diamond" , "9");
		assertEquals(7, card.getValueIndex());
		assertEquals(3, card.getSuitIndex());
		System.out.println(card.toString());
	}

	@Test
	public void test_compareCard_1() {
		Card card1 = creatCard("Diamond" , "9");
		Card card2 = creatCard("Diamond" , "10");
		assertEquals(-1, card1.compareTo(card2));
		assertEquals(1, card2.compareTo(card1));
	}

	@Test
	public void test_compareCard_2() {
		Card card1 = creatCard("Diamond" , "9");
		Card card2 = creatCard("Club" , "9");
		assertEquals(0, card1.compareTo(card2));
		assertEquals(0, card2.compareTo(card1));
	}

	@Test
	public void test() {
		String[] searchValues = { "A", "B" };

		Set<String> listOfSearchValues = new LinkedHashSet<String>();
		searchValues = listOfSearchValues.toArray(searchValues);
		System.out.println(listOfSearchValues);
	}

}
