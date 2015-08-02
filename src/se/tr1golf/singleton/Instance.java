package se.tr1golf.singleton;

import java.util.ArrayList;

import se.tr1golf.classes.Game;
import se.tr1golf.classes.Round;
import se.tr1golf.model.AppGameListModel;
import se.tr1golf.model.AppPlayerModel;

public class Instance {
	 private static Instance instance;
	 	private AppPlayerModel player;
	 	private ArrayList<AppGameListModel> games;
	 	private Game game;
	 	private Round round;

		/**
		 * @return the game
		 */
		public Game getGame() {
			return game;
		}

		/**
		 * @param game the game to set
		 */
		public void setGame(Game game) {
			this.game = game;
		}

		private boolean inGame;
	 		 	
	 	/**
		 * @param join a game
		 */
		public void joinGame(AppGameListModel game) {
			games.get(games.indexOf(game)).addPlayer(player);
			inGame = true;
		}		
		
		/**
		 * @param leave a game
		 */
		public void leaveGame(AppGameListModel game) {
			games.get(games.indexOf(game)).deletePlayer(player);
			inGame = false;
		}

		/**
		 * @return the games
		 */
		public ArrayList<AppGameListModel> getGames() {
			return games;
		}

		/**
		 * @param games the games to set
		 */
		public void setGames(ArrayList<AppGameListModel> games) {
			this.games = games;
		}
		
		/**
		 * @param add game to set
		 */
		public void addGame(AppGameListModel game) {
			if(games == null)
			{
				games = new ArrayList<AppGameListModel>();
			}
			games.add(game);
		}
		
		/**
		 * @param add game to set
		 * @return 
		 */
		public AppPlayerModel getPlayer() {
			return player;
		}
		
		/**
		 * @param add game to set
		 * @return 
		 */
		public void setPlayer(AppPlayerModel player) {
			if(player == null)
			{
				player = new AppPlayerModel();
			}
			this.player = player;
		}

		// Private constructor prevents instantiation from other classes
	    private Instance() {
	    }

	    public static void initInstance()
	    {
	    	if (instance == null)
	    	{
	    		instance = new Instance();
	    	}
	    }
	    public static Instance getInstance() {
	        return instance;
	    }

		public void addPlayer(AppGameListModel gameobject, AppPlayerModel playerobject) {
			games.get(games.indexOf(gameobject)).addPlayer(playerobject);			
		}

		public boolean isinGame() {
			return inGame;
		}

		public void setinGame(boolean status) {
			this.inGame = status;
		}

}
