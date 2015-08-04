package se.tr1golf.classes;

import se.tr1golf.model.AppGameModel;

public class User {
	private int userId;
	private String userName;
	private AppGameModel currentGame;
	private int score = 0;

	public User(Builder builder) {
		this.userId = builder.userId;
		this.userName = builder.userName;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static class Builder
	{
		private int userId;
		private String userName;
		
		public Builder setUserId(int userId){
			this.userId = userId;
			return this;
		}
		
		public Builder setUserName(String userName){
			this.userName = userName;
			return this;
		}
		
		public User build(){
			User user = new User(this);
			validate(user);
			return user;
		}

		private void validate(User user) {
			// TODO Auto-generated method stub
			
		}
	}	

	public AppGameModel getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(AppGameModel currentGame) {
		this.currentGame = currentGame;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
