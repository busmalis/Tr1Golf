package se.tr1golf.model;

import java.io.Serializable;

public class AppPlayerModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Username;
	int UserID;

	public AppPlayerModel(String username, int userid) {
		this.Username = username;
		this.UserID = userid;
	}

	public AppPlayerModel() {
		this.Username = "";
		this.UserID = 0;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
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
