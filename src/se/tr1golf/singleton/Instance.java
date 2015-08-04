package se.tr1golf.singleton;

import se.tr1golf.classes.User;
import se.tr1golf.model.AppGameModel;

public class Instance {
	private User player;
	private AppGameModel game;
	private static Instance instance;

	public static Instance getInstance() {
		if (instance == null) {
			// Create the instance
			instance = new Instance();
		}
		
		// Return the instance
		return instance;
	}

	public void setPlayer(User thisPlayer) {
		this.player = thisPlayer;
	}

	public User getPlayer() {
		return this.player;
	}

	public void setGame(AppGameModel thisGame) {
		this.game = thisGame;
	}
	
	public AppGameModel getGame() {
		return game;
	}

}
