package se.tr1golf;

import java.util.ArrayList;

import org.json.JSONObject;

import se.tr1golf.DAO.DAOHandler;
import se.tr1golf.adapter.gameListAdapter;
import se.tr1golf.classes.Course;
import se.tr1golf.classes.Round;
import se.tr1golf.model.AppGameModel;
import se.tr1golf.singleton.Instance;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;

public class GameListActivity extends Activity {

	private AppGameModel selectedGame;
	private ExpandableListView gameList;
	private ArrayList<AppGameModel> gameListData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_list);
		setupActionBar();
		initList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.submenu, menu);
		return true;
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			Log.i("INFO", "submenuHome");
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.submenuStart:
			Log.i("INFO", "submenuStart");
			Instance.getInstance().setGame(selectedGame);
			startActivity(new Intent(this, GameActivity.class));
			finish();
			return true;
			
		case R.id.submenuCreate:
			// Mock
			Log.i("INFO", "submenuCreate");
			Course course = new Course.Builder().setCourseId(2).setCourseName("Course 3").build();
			Round round = new Round.Builder().setRoundId(2).build();
			gameListData.add(new AppGameModel.Builder().setCourse(course).setPlayers(null).setRound(round).build());
			
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}

	public void initList() {
		try {
			Log.i("INFO", "initList");
			// GetGamesList task = new GetGamesList(this);
			// task.execute();
			// games = task.get();

			Log.i("INFO", "creating gameList(Expandable)");
			gameListData = getGames();
			gameList = (ExpandableListView) findViewById(R.id.gameListExpListView);
			gameList.setAdapter(new gameListAdapter(this, gameListData));
			gameList.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent,
						View view, int groupposition, long childposition) {
					Log.i("INFO", "gameList OnItemLongClick "
							+ gameListData.get(groupposition).getCourse()
									.getCourseName());
					selectedGame = gameListData.get(groupposition);
					if (selectedGame.getPlayers().contains(
							Instance.getInstance().getPlayer()))
						joinOrLeave(false);
					else
						joinOrLeave(true);

					return false;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void joinOrLeave(boolean joining) {
		Log.i("INFO", "boxJoinLeave");

		if (joining) {
			selectedGame.addPlayer(Instance.getInstance().getPlayer());
		} else {
			selectedGame.removePlayer(Instance.getInstance().getPlayer());
		}
	}

	private ArrayList<AppGameModel> getGames() {
		Log.i("INFO", "getGames");
		DAOHandler daoHandler = new DAOHandler();
		JSONObject data = new JSONObject();
		return daoHandler.getGameList(this, data);
	}
}
