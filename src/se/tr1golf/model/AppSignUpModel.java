package se.tr1golf.model;

public class AppSignUpModel {
	String Username;
	String Password;
	Boolean Active;

	public AppSignUpModel(String username, String password) {
		this.Username = username;
		this.Password = password;
		this.Active = false;
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

}
