package se.tr1golf.classes;

public class Round {
	private int roundId;

	public Round(Builder builder) {
		this.setRoundId(builder.roundId);
	}

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	public static class Builder {
		private int roundId;

		public Builder setRoundId(int roundId) {
			this.roundId = roundId;
			return this;
		}

		public Round build() {
			Round round = new Round(this);
			validate(round);
			return round;
		}

		private void validate(Round round) {
			// TODO Auto-generated method stub

		}
	}

}
