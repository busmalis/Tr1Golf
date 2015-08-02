package se.tr1golf.classes;

public class GamelistItem {
	private String coursename;
	private int courseid;

	public GamelistItem(String s) {
		this.coursename = s;
	}

	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return coursename;
	}

	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	/**
	 * @return the courseid
	 */
	public int getCourseid() {
		return courseid;
	}

	/**
	 * @param courseid the courseid to set
	 */
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	
}
