package se.tr1golf;

import se.tr1golf.fragment.GameActivityPagerPage;
import se.tr1golf.singleton.Instance;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

public class GameActivity extends FragmentActivity {

	// Initiate	
	private static final int NUM_PAGES = 5;
	private AlertDialog alert;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_pager_container);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
	
        init();
	}
	
	private void init() {
		try {
			
			// Exit round messagebox
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure you want to end this round?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*public void upload_score() {
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
	/*}

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
	*/

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
	
	/**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new GameActivityPagerPage(position + 1);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}