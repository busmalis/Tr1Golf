package se.tr1golf.model;

public class AppRoundListModel {
	String Coursename;
	int RoundID;
	int Score;
	int UserID;

	public AppRoundListModel(String coursename, int roundid, int score,
			int userid) {
		this.Coursename = coursename;
		this.RoundID = roundid;
		this.Score = score;
		this.UserID = userid;
	}

	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return Coursename;
	}

	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}

	/**
	 * @return the roundID
	 */
	public int getRoundID() {
		return RoundID;
	}

	/**
	 * @param roundID the roundID to set
	 */
	public void setRoundID(int roundID) {
		RoundID = roundID;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return Score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		Score = score;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return UserID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		UserID = userID;
	}

	
}
