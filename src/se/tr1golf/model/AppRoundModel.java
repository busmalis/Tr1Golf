package se.tr1golf.model;

public class AppRoundModel {
	String Coursename;
	String Date;
	int CourseID;
	int HoleID;
	int RoundID;

	public AppRoundModel() {
		this.Coursename = "";
		this.Date = "";
		this.CourseID = 0;
		this.HoleID = 0;
		this.RoundID = 0;
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
	 * @return the date
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		Date = date;
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
