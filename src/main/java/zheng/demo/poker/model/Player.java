package zheng.demo.poker.model;

/**
 * Lesson_3 TODO create a Junit test Can be enrich later based save the game
 * player track the winning percentage, etc
 *
 */
public class Player {

	private String name;
	private int gamePlayed = 0;
	private int gameImproved = 0;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}

	public int getGameImproved() {
		return gameImproved;
	}

	public void setGameImproved(int gameImproved) {
		this.gameImproved = gameImproved;
	}

	public void showReport() {
		float rate = (float) 100 * gameImproved / gamePlayed;
		System.out.printf("\n%s! You played %d games and improved %d with redrawing. Improved Percertage = %.2f", name,
				gamePlayed, gameImproved, rate);
	}
}
