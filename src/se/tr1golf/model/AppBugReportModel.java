package se.tr1golf.model;

import se.tr1golf.classes.Bug;
import se.tr1golf.classes.User;

public class AppBugReportModel {
	private Bug bug;
	private User user;

	public AppBugReportModel(Builder builder) {
		this.setBug(builder.bug);
		this.user = builder.user;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public static class Builder {
		private Bug bug;
		private User user;

		public Builder setBug(Bug bug) {
			this.bug = bug;
			return this;
		}

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public AppBugReportModel build() {
			AppBugReportModel model = new AppBugReportModel(this);
			validateBuild(model);
			return model;
		}

		private void validateBuild(AppBugReportModel model) {

		}
	}
}
