package se.tr1golf.classes;

public class Bug {
	private String text;

	public Bug(Builder builder) {
		this.setText(builder.text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static class Builder {
		private String text;

		public Builder setText(String text) {
			this.text = text;
			return this;
		}

		public Bug build() {
			Bug bug = new Bug(this);
			validate(bug);
			return bug;
		}

		private void validate(Bug bug) {
			// TODO Auto-generated method stub

		}
	}

}
