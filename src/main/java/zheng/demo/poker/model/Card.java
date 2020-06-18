package zheng.demo.poker.model;

import zheng.demo.poker.Constants;


public class Card implements Comparable<Card> {
	public static final String[] SUITS = { "Heart", "Spade", "Club", "Diamond" };
	public static final String[] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	private int suitIndex;
	private int valueIndex;
	
	public Card(int suitIndex, int valueIndex) {
		super();
		this.suitIndex = suitIndex;
		this.valueIndex = valueIndex;
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
		return Constants.SUITS_ICON.get(SUITS[this.suitIndex]) + VALUES[this.valueIndex]
				+ " " + SUITS[this.suitIndex];
	}

}
