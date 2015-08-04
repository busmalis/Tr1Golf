package se.tr1golf.model;

import se.tr1golf.classes.User;

public class AppSignUpModel {
	private User user;

	public AppSignUpModel(Builder builder) {
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

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public AppSignUpModel build() {
			AppSignUpModel model = new AppSignUpModel(this);
			validateModel(model);
			return model;
		}

		private void validateModel(AppSignUpModel model) {

		}
	}
}
