package se.tr1golf.classes;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;

@SuppressWarnings("serial")
public class Round extends Activity implements Serializable {

	private ArrayList<HoleScore> holescore;

	public Round() {
		this.holescore = new ArrayList<HoleScore>(0);
		this.add_score(0, 0); // This is to balance out the Arraylist so index 1
								// is the same as hole 1
	}

	// ****************************
	// Section for Functions
	// ****************************
	public Integer get_score() {
		int total = 0;
		for (int i = 0; i < holescore.size(); i++) {
			total += holescore.get(i).getScore();
		}
		return total;
	}

	// ****************************
	// Section for Get parameters
	// ****************************

	public int get_holes_played() {
		if (holescore.isEmpty()) {
			return 0;
		}
		return holescore.size() - 1;

	}

	public int get_hole_score(int hole) {
		int score = this.holescore.get(hole).getScore();
		if (score > 0) {
			return score;
		}
		return 0;

	}

	public ArrayList<HoleScore> get_holescore_array() {
		return this.holescore;
	}

	// ****************************
	// Section for Set parameters
	// ****************************
	public void add_score(int score, int hole) {
		holescore.add(new HoleScore(score, hole));
	}

	public void update_score(int score, int hole) {
		holescore.get(hole).setScore(score);
	}

}