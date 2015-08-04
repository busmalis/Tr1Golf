package se.tr1golf.model;

import se.tr1golf.classes.Course;
import se.tr1golf.classes.Round;
import se.tr1golf.classes.User;

public class AppHoleScoreModel {
	private User user;
	private Course course;
	private Round round;

	public AppHoleScoreModel(Builder builder) {
		this.user = builder.user;
		this.course = builder.course;
		this.round = builder.round;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public static class Builder {
		private User user;
		private Course course;
		private Round round;

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public Builder setCourse(Course course) {
			this.course = course;
			return this;
		}

		public Builder setRound(Round round) {
			this.round = round;
			return this;
		}

		public AppHoleScoreModel build() {
			AppHoleScoreModel model = new AppHoleScoreModel(this);
			validateModel(model);
			return model;
		}

		private void validateModel(AppHoleScoreModel model) {

		}
	}
}
