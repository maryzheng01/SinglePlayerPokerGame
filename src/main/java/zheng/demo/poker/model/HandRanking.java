package zheng.demo.poker.model;

/**
 * Lesson_3 Enum a special class*
 */
public enum HandRanking {
	FLUSH("Flush", 6), FOUR_OF_KIND("Four of kind", 8), FULL_HOUSE("Full House", 7), HIGH_CARD("High card", 1),
	ONE_PAIR("One pair", 2), ROYAL_FLUSH("Royal Flush", 10), STAIGHT_FLUSH("Straight flush", 9),
	STRAIGHT("Straight", 5), THREE_OF_KIND("Three of Kind", 4), TWO_PAIR("Two Pair", 3);

	private final String name;
	private final int rank;

	private HandRanking(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

}
