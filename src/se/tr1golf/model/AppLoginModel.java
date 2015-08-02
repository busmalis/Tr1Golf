package se.tr1golf.model;

public class AppLoginModel {
	String Username;
	String Password;
	Boolean Active;
	int UserID;

	public AppLoginModel(String username, String password) {
		this.Username = username;
		this.Password = password;
		this.Active = false;
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
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return Active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		Active = active;
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

	public void set_username(String username) {
		this.Username = username;
	}

	public void set_password(String password) {
		this.Password = password;
	}

	public String get_username() {
		return this.Username;
	}

	public String get_password() {
		return this.Password;
	}
}
