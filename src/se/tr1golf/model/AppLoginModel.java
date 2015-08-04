package se.tr1golf.model;

import se.tr1golf.classes.User;

public class AppLoginModel {
	private User user;

	public AppLoginModel(Builder builder) {
		this.setUser(builder.user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public static class Builder {
		private User user;
		
		public Builder setUser(User user){
			this.user = user;
			return this;
		}
		
		public AppLoginModel build(){
			AppLoginModel model = new AppLoginModel(this);
			validateModel(model);
			return model;
		}

		private void validateModel(AppLoginModel model) {
			
		}
	}
}
