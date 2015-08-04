package se.tr1golf;

import se.tr1golf.classes.User;
import se.tr1golf.singleton.Instance;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		Log.i("INFO", "Create Player");
		// Create the global singleton instance
		User player = new User.Builder().setUserName("TEMP").setUserId(1).build();

		Log.i("INFO", "setPlayer");
		Instance.getInstance().setPlayer(player);
				
		Log.i("INFO", "StartActivity");
		startActivity(new Intent(this, MenuActivity.class));

		Log.i("INFO", "SplashFinish");
		finish();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}

}
