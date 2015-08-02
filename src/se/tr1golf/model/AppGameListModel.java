package se.tr1golf.model;

import java.io.Serializable;
import java.util.ArrayList;


public class AppGameListModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Coursename;
	int RoundID;
	ArrayList<AppPlayerModel> players;
	
	public AppGameListModel(String coursename, int roundid) {
		this.Coursename = coursename;
		this.RoundID = roundid;
		players = new ArrayList<AppPlayerModel>();
	}

	/**
	 * @return the players
	 */
	public ArrayList<AppPlayerModel> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<AppPlayerModel> players) {
		this.players = players;
	}
	
	/**
	 * @param add player to the game
	 */
	public void addPlayer(AppPlayerModel player) {
		this.players.add(player);
	}

	/**
	 * @return the coursename
	 */
	public String getCoursename() {
		return Coursename;
	}

	/**
	 * @param coursename the coursename to set
	 */
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}

	/**
	 * @return the roundID
	 */
	public int getRoundID() {
		return RoundID;
	}

	/**
	 * @param roundID the roundID to set
	 */
	public void setRoundID(int roundID) {
		RoundID = roundID;
	}

	public void deletePlayer(AppPlayerModel player) {
		// TODO Auto-generated method stub
		this.players.remove(player);
		
	}
	
}
