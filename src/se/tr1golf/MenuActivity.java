package se.tr1golf;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
	
	// Play Button
	public void clickPlay(View view) {
		Log.i("INFO", "clickPlay");
		//startActivity(new Intent("android.intent.action.GAMES"));
		startActivity(new Intent(this, GameListActivity.class));
	}
	// Settings button
	public void clickSettings(View view) {
		Log.i("INFO", "clickSettings");
	//	startActivity(new Intent("android.intent.action.SETTINGS"));
	}

	// Stats button
	public void clickStats(View view) {
		Log.i("INFO", "clickStats");
	//	startActivity(new Intent("android.intent.action.STATS"));
	}

	// Logout button
	public void clickLogout(View view) {
		Log.i("INFO", "clickLogout");
	//	startActivity(new Intent("android.intent.action.LOGIN"));
		finish();
	}

}
