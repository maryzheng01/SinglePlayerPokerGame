package zheng.demo.poker.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class Card implements Comparable<Card> {
	public static final String[] SUITS = { "Heart", "Spade", "Club", "Diamond" };
	public static final String[] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private static final Map<String, String> SUITS_ICON;

	static {
		SUITS_ICON = new HashMap<>();
		SUITS_ICON.put("Heart", "\u2665");
		SUITS_ICON.put("Spade", "\u2660");
		SUITS_ICON.put("Club", "\u2663");
		SUITS_ICON.put("Diamond", "\u2666");
	}

	private final int suitIndex;
	private final int valueIndex;

	public Card(int suitIndex, int valueIndex) {
		super();
		this.suitIndex = suitIndex;
		this.valueIndex = valueIndex;
	}

	public Card(String suit, String faceValue) {
		suitIndex = Arrays.asList(SUITS).indexOf(suit);
		valueIndex = Arrays.asList(VALUES).indexOf(faceValue);
	}

	@Override
	public int compareTo(Card o) {
		if (this.valueIndex == (o.valueIndex))
			return 0;
		else if ((this.valueIndex) > (o.valueIndex))
			return 1;
		else
			return -1;
	}

	public int getSuitIndex() {
		return suitIndex;
	}

	public int getValueIndex() {
		return valueIndex;
	}

	@Override
	public String toString() {
		return SUITS_ICON.get(SUITS[this.suitIndex]) + VALUES[this.valueIndex] + " " + SUITS[this.suitIndex];
	}

}
