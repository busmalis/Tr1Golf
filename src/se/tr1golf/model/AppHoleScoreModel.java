package se.tr1golf.model;

public class AppHoleScoreModel {
	int UserID;
	int CourseID;
	int HoleID;
	int Score;
	int RoundID;

	public AppHoleScoreModel(int userid, int courseid, int holeid, int score,
			int roundid) {
		this.UserID = userid;
		this.CourseID = courseid;
		this.HoleID = holeid;
		this.Score = score;
		this.RoundID = roundid;
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

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return CourseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	/**
	 * @return the holeID
	 */
	public int getHoleID() {
		return HoleID;
	}

	/**
	 * @param holeID the holeID to set
	 */
	public void setHoleID(int holeID) {
		HoleID = holeID;
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

	
}
