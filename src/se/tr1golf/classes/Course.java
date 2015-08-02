package se.tr1golf.classes;

public class Course {
	private int courseid;
	private String coursename;

	public Course(int courseid, String coursename) {
		this.courseid = courseid;
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

}
