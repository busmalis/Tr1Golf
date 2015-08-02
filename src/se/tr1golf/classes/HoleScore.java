package se.tr1golf.classes;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HoleScore implements Serializable {
	private int score;
	private int hole;

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the hole
	 */
	public int getHole() {
		return hole;
	}

	/**
	 * @param hole the hole to set
	 */
	public void setHole(int hole) {
		this.hole = hole;
	}

	public HoleScore(int score, int hole) {
		this.score = score;
		this.hole = hole;
	}

	
}
