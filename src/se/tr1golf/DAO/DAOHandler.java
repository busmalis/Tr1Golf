package se.tr1golf.DAO;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import se.tr1golf.classes.Course;
import se.tr1golf.classes.User;
import se.tr1golf.model.AppGameModel;

public class DAOHandler {

	private String returnValue = "";
	
	public ArrayList<AppGameModel> getGameList(Context context, JSONObject data) {
		Log.i("INFO", "DAOHandler getGameList");
		ArrayList<AppGameModel> gameListData = new ArrayList<AppGameModel>();
		
		// MOCK
		Course courseMock = new Course.Builder().setCourseId(1).setCourseName("Course 1").build();
        ArrayList<User> playersMock = new ArrayList<User>();
		playersMock.add(new User.Builder().setUserId(1).setUserName("Player 1").build());
        gameListData.add(new AppGameModel.Builder().setCourse(courseMock).setPlayers(playersMock).build());
		
        courseMock = new Course.Builder().setCourseId(1).setCourseName("Course 2").build();
        playersMock = new ArrayList<User>();
        playersMock.clear();
		playersMock.add(new User.Builder().setUserId(1).setUserName("Player 2").build());
		playersMock.add(new User.Builder().setUserId(1).setUserName("Player 3").build());
		playersMock.add(new User.Builder().setUserId(1).setUserName("Player 4").build());
        gameListData.add(new AppGameModel.Builder().setCourse(courseMock).setPlayers(playersMock).build());
		 
        Log.i("INFO", "DAOHandler getGameList returns " + String.valueOf(gameListData.size()));
        
        return gameListData;
        
		/*try {
			DAOBase<AppGameListModel> dao = new DAOBase<AppGameListModel>(
					context, "GetActiveRoundsList", data);
			dao.execute();			
			
			JSONArray array = new JSONArray(dao.get());
	        for (int i = 0; i < array.length(); i++) {
	            JSONObject row = array.getJSONObject(i);
	            Course course = new Course.Builder().setCourseId(1).setCourseName("temp").build();
	            ArrayList<User> players = new ArrayList<User>();
	            players.add(new User.Builder().setUserId(1).setUserName("tempName").build());
	            AppGameListModel model = new AppGameListModel.Builder().setCourse(course).setPlayers(players).build();
	            gameListData.add(model);
	        }
		} catch (Exception e) {
			Log.e("ERROR", e.getMessage());
		}
		
		return gameListData;*/
	}

	public void removePlayerFromGame(Context context, JSONObject data) {
		// TODO Auto-generated method stub
		Log.i("INFO", "DAOHandler removePlayerFromGame");
		
	}
}
