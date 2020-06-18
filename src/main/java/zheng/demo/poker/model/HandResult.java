package zheng.demo.poker.model;


/**
 * Lesson_4 TODO there is a bug on compare one pair, two pair try to figure out and correct
 *  if..else, StringBuilder
 *
 */
public class HandResult implements Comparable<HandResult> {
	private int primaryValuePos = -1;
	private HandRanking ranking;
	private int secondaryValuePos = -1;
	private int tertiaryValuePos = -1;

	private int checkPrimary(HandResult o) {
		if (this.primaryValuePos == (o.primaryValuePos)) {
			return checkSecondary(o);
		} else if ((this.primaryValuePos) > (o.primaryValuePos)) {
			return 1;
		} else {
			return -1;
		}
	}

	private int checkSecondary(HandResult o) {
		if (this.secondaryValuePos == (o.secondaryValuePos))
			return checkTeritary(o);
		else if ((this.secondaryValuePos) > (o.secondaryValuePos))
			return 1;
		else
			return -1;
	}

	private int checkTeritary(HandResult o) {
		if (this.tertiaryValuePos == (o.tertiaryValuePos))
			return 0;
		else if ((this.tertiaryValuePos) > (o.tertiaryValuePos))
			return 1;
		else
			return -1;
	}

	@Override
	public int compareTo(HandResult o) {
		if (this.ranking.getRank() == o.ranking.getRank()) {
			return checkPrimary(o);
		} else if ((this.ranking.getRank()) > (o.ranking.getRank())) {
			return 1;
		} else {
			return -1;
		}
	}

	public int getPrimaryValuePos() {
		return primaryValuePos;
	}

	public HandRanking getRanking() {
		return ranking;
	}

	public int getSecondaryValuePos() {
		return secondaryValuePos;
	}

	public int getTertiaryValuePos() {
		return tertiaryValuePos;
	}

	public void setPrimaryValuePos(int primaryValue) {
		this.primaryValuePos = primaryValue;
	}

	public void setRanking(HandRanking ranking) {
		this.ranking = ranking;
	}

	public void setSecondaryValuePos(int secondaryValue) {
		this.secondaryValuePos = secondaryValue;
	}

	public void setTertiaryValuePos(int tertiaryValue) {
		this.tertiaryValuePos = tertiaryValue;
	}

	public String showResults() {
		StringBuilder sb = new StringBuilder();
		sb.append(ranking.getName());
		sb.append(" [");
		if (primaryValuePos > -1) {
			sb.append("  primaryValue = " + Card.VALUES[primaryValuePos]);
		}

		if (secondaryValuePos > -1) {
			sb.append(" secondaryValue = " + Card.VALUES[secondaryValuePos]);
		}
		
		if (tertiaryValuePos > -1) {
			sb.append(" tertiaryValue = " + Card.VALUES[tertiaryValuePos]);
		}

		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		return "HandResult [primaryValuePos=" + primaryValuePos + ", ranking=" + ranking + ", secondaryValuePos="
				+ secondaryValuePos + ", tertiaryValuePos=" + tertiaryValuePos + "]";
	}

}
