package zheng.demo.poker.model;

/*
 * Lesson 9 Inheritance
 */
public class TestBase {

	public TestBase() {
		super();
	}

	protected Card creatCard(int suit, int value) {
		return new Card(suit, value);
	}

}