package se.tr1golf;

import java.util.ArrayList;

import se.tr1golf.classes.Game;
import se.tr1golf.classes.HoleScore;
import se.tr1golf.classes.Round;
import se.tr1golf.model.AppRoundModel;
import se.tr1golf.singleton.Instance;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class GameActivity extends Activity {

	// Initiate
	
	private Round newround;
	private HoleScore hs;
	private TextView total;
	private TextView hole;
	private Button next_tee;
	private Button previous_tee;
	private TextView par;
	private Spinner throwspinner;
	private AlertDialog alert;
	private int hole_count;
	private ArrayList<Integer> parlist;
	private AppRoundModel parmodel = new AppRoundModel();
	private Game CurrentGame;
	private int plusminus;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		// Initiate data
		total = (TextView) findViewById(R.id.Game_Bottom_Total);
		hole = (TextView) findViewById(R.id.Game_Bottom_HoleCount);
		next_tee = (Button) findViewById(R.id.gamebNexttee);
		previous_tee = (Button) findViewById(R.id.gamebPrevioustee);
		par = (TextView) findViewById(R.id.gametxtpair);
		init();
		setValues();
	}

	private void init() {
		try {
			// Throw Spinner
			throwspinner = (Spinner) findViewById(R.id.Game_Center_Spinner);
			ArrayAdapter<CharSequence> adapter = ArrayAdapter
					.createFromResource(this, R.array.throws_count,
							android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			throwspinner.setAdapter(adapter);

			// Exit round messagebox
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you want to end this round?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									//CurrentGame.setDone(true);
									//CurrentGame.setRunning(false);	
									startActivity(new Intent(
											"android.intent.action.MENU"));
									finish();
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			alert = builder.create();

			//CurrentGame.done = false;// .setDone(false);
			//CurrentGame.setRunning(true);		
			
			// Get RoundID
			/*JSONObject roundrow = new JSONObject(
					DatabaseReader.get_unique_roundid(roundmodel));*/
			
			parlist = new ArrayList<Integer>();
			parlist.add(2);
			parlist.add(3);
			parlist.add(4);
			parlist.add(2);
			parlist.add(4);
			parlist.add(3);
			parlist.add(2);
			parlist.add(5);
			parlist.add(4);
			parlist.add(3);
			parlist.add(3);
			parlist.add(2);
			parlist.add(3);
			parlist.add(4);
			parlist.add(3);
			parlist.add(3);
			parlist.add(2);
			parlist.add(3);				
			
			/*ArrayList<Integer> parlist = DatabaseReader.get_parlist(parmodel);
			for (int i = 0; i < parlist.size(); i++) {
				dump.add_par(parlist.get(i));
			}*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void setValues() {
		CurrentGame = Instance.getInstance().getGame();
		total.setText(String.valueOf(0));
		CurrentGame.setTotalScore(0);
		hole.setText(String.valueOf(hole_count));
		throwspinner.setSelection(2);
		setTitle(CurrentGame.getCoursename());
		//parmodel.setCourseID(CurrentGame.getCourseid());
		Game.setParlist(parlist);
		par.setText(String.valueOf(CurrentGame.getPair(hole_count)));
	}

	public void clickNextTee(View view) {
		try {
			set_score();
			if (endofgame() == true) {
				// PARSE OBJECTS TO ENDGAME ENTITY
				Intent intent = new Intent(
						"android.intent.action.ENDGAME");
				intent.putExtra("holescore",
						newround.get_holescore_array());
				startActivity(intent);
				finish();
			}
			// If the service isn't running, start it
			if (CurrentGame.isRunning() == false) {
				// startService(new Intent(Game.this, MyService.class));
				start_service();
			}
			String ext = "";
			if (CurrentGame.getPlusminus() > 0) {
				ext = "+";
			}
			total.setText(String.valueOf(CurrentGame.getTotalScore()) + "(" + ext
					+ CurrentGame.getPlusminus() + ")");
			hole_count++;
			set_spinner_value();
			par.setText(String.valueOf(CurrentGame.getPair(hole_count)));
			hole.setText(String.valueOf(hole_count));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickPreviousTee(View view) {
		try {
			if (hole_count != 1) {
				hole_count--;
				set_spinner_value();
				par.setText(String.valueOf(CurrentGame.getPair(hole_count)));
				hole.setText(String.valueOf(hole_count));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean endofgame() {
		if (hole_count > 18) {
			return true;
		}
		return false;
	}

	public void upload_score() {
		int score = Integer.decode(throwspinner.getSelectedItem().toString());
		// Only upload score that either is new or modified
		hs = new HoleScore(score, hole_count);

		if (CurrentGame.getHolePlayed() >= hole_count) {
			if (this.newround.get_hole_score(hole_count) == score) {
				// Do Nothing
				// Toast.makeText(Game.this, "Nothing has been modified",
				// Toast.LENGTH_LONG).show();
			} else {
				Game.addScore(hs);
			}
		} else {
			Game.addScore(hs);
		}

	}

	public void set_score() {
		int oldscore = 0;
		// Add HoleScore to the dummylist
		upload_score();

		int score = Integer.decode(throwspinner.getSelectedItem().toString());
		if (this.newround.get_holes_played() < hole_count) {
			// Toast.makeText(game.this, "You have created a new record",
			// Toast.LENGTH_LONG).show();
			this.newround.add_score(score, hole_count);
		} else {
			oldscore = this.newround.get_hole_score(hole_count);
			// Toast.makeText(game.this, "You have updated a record",
			// Toast.LENGTH_LONG).show();
			this.newround.update_score(score, hole_count);
		}

		// Set the PlusMinus text
		int index = Integer.valueOf(par.getText().toString());
		// Calculate the old +- value
		if (oldscore > 0) {
			
		}
		plusminus += score - index;
		CurrentGame.setPlusminus(plusminus);

	}

	public void start_service() {
		Log.d("MyService", "onClick: starting service");
		/*startService(new Intent(Game.this, MyService.class));
		dump.uploadrunning = true;*/
	}

	public void set_spinner_value() {
		// If the hole already been played, set the spinner to it's value
		if (newround.get_holes_played() >= hole_count) {
			// Because the arraylist starts at 0 (Zero) we need to check hole
			// minus 1
			throwspinner.setSelection(newround.get_hole_score(hole_count) - 1);
		}
		// Else set the spinner value to default "3" throws
		else {
			throwspinner.setSelection(2);
		}
	}

	// ****************************
	// Section for key events
	// ****************************
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			alert.show();
		}

		else if (keyCode == KeyEvent.KEYCODE_MENU) {
			// Do Nothing yet
		}

		return true;
	}

}