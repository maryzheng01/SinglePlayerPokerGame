package zheng.demo.poker.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import zheng.demo.poker.Constants;
import zheng.demo.poker.model.Card;
import zheng.demo.poker.model.HandRanking;
import zheng.demo.poker.model.HandResult;

/**
 * Lesson_5_6 TODO there is a bug on compare one pair and two pair logic. 
 * each function may require a workshop, some can be simplified
 *
 */
public class HandEvaluator {

	private static final int POS_ONE = 1;

	private Card[] hand;

	private HandResult result;

	public HandResult evaluate() {
		result = new HandResult();
		HandRanking ranking;

		if (royalFlush() == 1) {
			ranking = HandRanking.ROYAL_FLUSH;
		} else if (straightFlush() == 1) {
			ranking = HandRanking.STAIGHT_FLUSH;
		} else if (fourOfaKind() == 1) {
			ranking = HandRanking.FOUR_OF_KIND;
		} else if (fullHouse() == 1) {
			ranking = HandRanking.FULL_HOUSE;
		} else if (flush() == 1) {
			ranking = HandRanking.FLUSH;
		} else if (straight() == 1) {
			ranking = HandRanking.STRAIGHT;
		} else if (threeOfKind() == 1) {
			ranking = HandRanking.THREE_OF_KIND;
		} else if (twoPairs() == 1) {
			ranking = HandRanking.TWO_PAIR;
		} else if (onePair() == 1) {
			ranking = HandRanking.ONE_PAIR;
		} else {
			highCard();
			ranking = HandRanking.HIGH_CARD;
		}

		result.setRanking(ranking);
		return result;
	}

	// checks for flush
	private int flush() {
		for (int counter = 1; counter < Constants.HAND_SIZE; counter++) {
			if (hand[0].getSuitIndex() != hand[counter].getSuitIndex()) {
				return 0;
			}
		}

		result.setPrimaryValuePos(hand[4].getValueIndex());
		return 1;
	}

	// checks for four of a kind
	private int fourOfaKind() {
		if (hand[1].getValueIndex() == hand[2].getValueIndex() && hand[2].getValueIndex() == hand[3].getValueIndex()) {
			if (hand[0].getValueIndex() == hand[1].getValueIndex()
					|| hand[4].getValueIndex() == hand[3].getValueIndex()) {
				result.setPrimaryValuePos(hand[3].getValueIndex());
				
				if( result.getPrimaryValuePos() == hand[4].getValueIndex()) {
					result.setSecondaryValuePos(hand[0].getValueIndex());
				}
				else {
					result.setSecondaryValuePos(hand[4].getValueIndex());
				}
				return 1;
			}
			return 0;
		} else {
			return 0;
		}
	}

	private int fullHouse() {
		int comparison = 0;
		for (int counter = POS_ONE; counter < Constants.HAND_SIZE; counter++) {
			if (hand[counter - 1].getValueIndex() == hand[counter].getValueIndex()) {
				comparison++;
			}
		}
		if (comparison == 3) {
			result.setPrimaryValuePos(hand[2].getValueIndex());
			if (hand[0].getValueIndex() != hand[2].getValueIndex()) {
				result.setSecondaryValuePos(hand[0].getValueIndex());
			} else {
				result.setSecondaryValuePos(hand[4].getValueIndex());
			}
			return 1;
		} else {
			return 0;
		}
	}

	public HandResult getResult() {
		return result;
	}

	// find highest card for non-sorted hand
	private int highCard() {
		int highCard = 0;
		for (int counter = 0; counter < Constants.HAND_SIZE; counter++) {
			if (hand[counter].getValueIndex() > highCard) {
				highCard = hand[counter].getValueIndex();
			}
		}
		result.setPrimaryValuePos(highCard);
		return highCard;
	}

	// check for pair
	private int onePair() {
		int check = 0;
		for (int counter = 1; counter < Constants.HAND_SIZE; counter++) {
			if (hand[counter - 1].getValueIndex() == hand[counter].getValueIndex()) {
				result.setPrimaryValuePos(hand[counter].getValueIndex());
				check++;
			}
		}
		if (check == 1) {
			if ( result.getPrimaryValuePos() == hand[4].getValueIndex()) {
				result.setSecondaryValuePos( hand[2].getValueIndex());
			}
			else {
				result.setSecondaryValuePos( hand[4].getValueIndex());
			}
			return 1;
		} else {
			return 0;
		}
	}

	// checks for a royal flush
	private int royalFlush() {
		if (hand[0].getValueIndex() == 8 && hand[1].getValueIndex() == 9 && hand[2].getValueIndex() == 10
				&& hand[3].getValueIndex() == 11 && hand[4].getValueIndex() == 12) {
			return 1;
		} else {
			return 0;
		}
	}

	public void setHand(Card[] hand) {
		this.hand = Arrays.copyOf(hand, hand.length);
		Arrays.sort(this.hand);
		 
	}

	private int straight() {
		for (int counter = POS_ONE; counter < Constants.HAND_SIZE; counter++) {
			if (hand[counter - 1].getValueIndex() != (hand[counter].getValueIndex() - 1)) {
				return 0;
			}

		}
		result.setPrimaryValuePos(hand[4].getValueIndex());
		return 1;
	}

	private int straightFlush() {
		for (int counter = POS_ONE; counter < Constants.HAND_SIZE; counter++) {
			if (hand[0].getSuitIndex() != hand[counter].getSuitIndex()) {
				return 0;
			}
		}

		for (int counter2 = POS_ONE; counter2 < Constants.HAND_SIZE; counter2++) {
			if (hand[counter2 - 1].getValueIndex() != (hand[counter2].getValueIndex() - 1)) {
				return 0;
			}

		}

		result.setPrimaryValuePos(hand[4].getValueIndex());
		return 1;

	}

	private int threeOfKind() {
		if (hand[0].getValueIndex() == hand[2].getValueIndex() || hand[1].getValueIndex() == hand[3].getValueIndex()
				|| hand[2].getValueIndex() == hand[4].getValueIndex()) {
			result.setPrimaryValuePos(hand[2].getValueIndex());
			if( result.getPrimaryValuePos() == hand[4].getValueIndex()) {
				result.setSecondaryValuePos(hand[1].getValueIndex());
				result.setTertiaryValuePos(hand[0].getValueIndex());
			}
			else {
				result.setSecondaryValuePos(hand[4].getValueIndex());
				result.setTertiaryValuePos(hand[3].getValueIndex());
			}
			return 1;
		}
		return 0;
	}

	// checks for two pairs
	private int twoPairs() {
		int check = 0;
		int[] pairPos = new int[2];
		for (int counter = POS_ONE; counter < Constants.HAND_SIZE; counter++) {
			if (hand[counter - 1].getValueIndex() == hand[counter].getValueIndex()) {
				pairPos[check] = counter;
				check++;
			}
		}
		if (check == 2) {
			result.setPrimaryValuePos(hand[pairPos[1]].getValueIndex());
			result.setSecondaryValuePos(hand[pairPos[0]].getValueIndex());
			List<Card> tertiaryValue = Arrays.stream(hand)
					.filter(card -> card.getValueIndex() != hand[pairPos[0]].getValueIndex())
					.filter(card -> card.getValueIndex() != hand[pairPos[1]].getValueIndex())
					.collect(Collectors.toList());
			result.setTertiaryValuePos(tertiaryValue.get(0).getValueIndex());
			return 1;
		} else {
			return 0;
		}
	}

	public Card[] getHand() {
		return hand;
	}

}
