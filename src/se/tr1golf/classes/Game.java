package se.tr1golf.classes;

import java.util.ArrayList;

public class Game {
	public static ArrayList<HoleScore> scorelist = new ArrayList<HoleScore>();
	public static ArrayList<Integer> parlist = new ArrayList<Integer>();
	public int userid;
	public int courseid;
	public int roundid;
	public int plusminus;
	public boolean running;
	static public boolean done;
	public boolean uploadrunning;
	public String coursename;
	private int totalScore;
	
	public static void addScore(HoleScore hs)
	{
		scorelist.add(hs);
	}
	/**
	 * @return the scorelist
	 */
	public static ArrayList<HoleScore> getScorelist() {
		return scorelist;
	}
	/**
	 * @param scorelist the scorelist to set
	 */
	public static void setScorelist(ArrayList<HoleScore> scorelist) {
		Game.scorelist = scorelist;
	}
	/**
	 * @return the parlist
	 */
	public static ArrayList<Integer> getParlist() {
		return parlist;
	}
	/**
	 * @param parlist the parlist to set
	 */
	public static void setParlist(ArrayList<Integer> parlist) {
		Game.parlist = parlist;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
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
	 * @return the roundid
	 */
	public int getRoundid() {
		return roundid;
	}
	/**
	 * @param roundid the roundid to set
	 */
	public void setRoundid(int roundid) {
		this.roundid = roundid;
	}
	/**
	 * @return the plusminus
	 */
	public int getPlusminus() {
		return plusminus;
	}
	/**
	 * @param plusminus the plusminus to set
	 */
	public void setPlusminus(int plusminus) {
		this.plusminus = plusminus;
	}
	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * @return the done
	 */
	public static boolean isDone() {
		return done;
	}
	/**
	 * @param done the done to set
	 */
	public static void setDone(boolean done) {
		Game.done = done;
	}
	/**
	 * @return the uploadrunning
	 */
	public boolean isUploadrunning() {
		return uploadrunning;
	}
	/**
	 * @param uploadrunning the uploadrunning to set
	 */
	public void setUploadrunning(boolean uploadrunning) {
		this.uploadrunning = uploadrunning;
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
	public int getPair(int hole_count) {
		if(hole_count < 1)
			return parlist.get(0);
		else
		return parlist.get(hole_count - 1);
	}
	
	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}
	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getHolePlayed() {
		return scorelist.size();
	}
}
