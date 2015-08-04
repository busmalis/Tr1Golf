package se.tr1golf.model;

import java.util.ArrayList;

import android.util.Log;
import se.tr1golf.classes.Course;
import se.tr1golf.classes.Round;
import se.tr1golf.classes.User;

public class AppGameModel {
	private ArrayList<User> players;
	private Course course;
	private Round round;
	
	public ArrayList<User> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<User> players) {
		this.players = players;
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
	
	public AppGameModel(Builder builder){
		this.players = builder.players;
		this.course = builder.course;
		this.round = builder.round;
	}
	
	public static class Builder{
		private ArrayList<User> players;
		private Course course;
		private Round round;
		
		public Builder setPlayers(ArrayList<User> players){
			this.players = players;
			return this;
		}
		
		public Builder setCourse(Course course){
			this.course = course;
			return this;
		}
		
		public Builder setRound(Round round){
			this.round = round;
			return this;
		}
		
		public AppGameModel build(){
			AppGameModel model = new AppGameModel(this);
			validate(model);
			return model;
		}

		private void validate(AppGameModel model) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public void addPlayer(User player) {
		Log.i("INFO", "addPlayer");
		//DAOHandler daoHandler = new DAOHandler();
		//JSONObject data = new JSONObject();
		players.add(player);
		//daoHandler.removePlayerFromGame(context, data);
	}

	public void removePlayer(User player) {
		Log.i("INFO", "removePlayer");
		//DAOHandler daoHandler = new DAOHandler();
		//JSONObject data = new JSONObject();
		players.remove(player);
	}
	
	public void submitScore(User player, int score){
		Log.i("INFO", "submitScore");
		
	}
}
