package se.tr1golf;

import java.util.ArrayList;

import se.tr1golf.adapter.gameListAdapter;
import se.tr1golf.classes.Game;
import se.tr1golf.model.AppGameListModel;
import se.tr1golf.model.AppPlayerModel;
import se.tr1golf.singleton.Instance;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;

public class GameListActivity extends Activity {

	private Dialog dialog;
	private AppGameListModel game;
	private ExpandableListView expand;	
	
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
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.submenuStart:
			Game thisGame = new Game();
			thisGame.setCoursename(game.getCoursename());
			thisGame.setPlusminus(0);
			thisGame.setRoundid(game.getRoundID());
			thisGame.setRunning(true);
			thisGame.setUserid(Instance.getInstance().getPlayer().getUserID());
			Instance.getInstance().setGame(thisGame);
			startActivity(new Intent(this, GameActivity.class));
			finish();
			return true;
			
		}
		return super.onOptionsItemSelected(item);
	}


	public void initList() {
		try {

			// GetGamesList task = new GetGamesList(this);
			// task.execute();
			// games = task.get();

			expand = (ExpandableListView) findViewById(R.id.gameListExpListView);
			expand.setAdapter(new gameListAdapter(this));
			expand.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent,
						View view, int groupposition, long childposition) {
					AppPlayerModel player = Instance.getInstance().getPlayer();
					ArrayList<AppGameListModel> a = Instance.getInstance().getGames();
					if(groupposition >= a.size())
					{
						groupposition = a.size() - 1;
					}
					game = Instance.getInstance().getGames()
							.get(groupposition);

					if (game.getPlayers().contains(player)) {
						boxJoinLeave(false);
					} else {
						if (!Instance.getInstance().isinGame()) {
							boxJoinLeave(true);
						}
					}

					return false;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void boxJoinLeave(boolean joining) {
		try {
			Toast.makeText(this, "Te", Toast.LENGTH_LONG);
			dialog = new Dialog(this);
			Button bJoin;
			Button bLeave;
			
			dialog.setContentView(R.layout.simplebox);
			dialog.setTitle("Make your choice!");
			TextView text = (TextView) dialog
					.findViewById(R.id.simpleboxtext);
			ImageView image = (ImageView) dialog
					.findViewById(R.id.simpleboximage);
			image.setImageResource(R.drawable.ic_launcher);
			
			Button bCancel = (Button) dialog.findViewById(R.id.simpleboxbright);
			bCancel.setText("Close");
			bCancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					dialog.hide();
				}
			});
			
			if(joining)
			{
				text.setText("Do you want to join?\n" + game.getCoursename());
				bJoin = (Button) dialog.findViewById(R.id.simpleboxbleft);
				bJoin.setText("Join");
				bJoin.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Instance.getInstance().joinGame(game);
						dialog.hide();
					}
				});
			}
			else
			{
				text.setText("Do you want to leave?\n" + game.getCoursename());
				bLeave = (Button) dialog.findViewById(R.id.simpleboxbleft);
				bLeave.setText("Leave");
				bLeave.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Instance.getInstance().leaveGame(game);
						
						dialog.hide();
					}
				});
			}
			
			dialog.show();
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}
}
