package se.tr1golf.model;

public class AppBugReportModel {
	String Date;
	String BugText;
	int UserID;

	public AppBugReportModel(String date, String bugtext, int userid) {
		this.Date = date;
		this.BugText = bugtext;
		this.UserID = userid;
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
	 * @return the bugText
	 */
	public String getBugText() {
		return BugText;
	}

	/**
	 * @param bugText the bugText to set
	 */
	public void setBugText(String bugText) {
		BugText = bugText;
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
