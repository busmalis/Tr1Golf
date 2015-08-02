package se.tr1golf;

import se.tr1golf.model.AppGameListModel;
import se.tr1golf.model.AppPlayerModel;
import se.tr1golf.singleton.Instance;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

	private AppGameListModel gameobject;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		AppPlayerModel playerobject;
		
		// Create the global singleton instance
		Instance.initInstance();
		playerobject = new AppPlayerModel("CurrentUser", 511);
		Instance.getInstance().setPlayer(playerobject);
		
		playerobject = new AppPlayerModel("Test1", 321);
		gameobject = new AppGameListModel("Hästhagen", 21);
		Instance.getInstance().addGame(gameobject);
		gameobject = new AppGameListModel("Hästhagen", 51);
		Instance.getInstance().addGame(gameobject);
		
		playerobject = new AppPlayerModel("Test2", 3321);
		Instance.getInstance().addPlayer(gameobject, playerobject);
		
		gameobject = new AppGameListModel("Hässlö", 25);
		Instance.getInstance().addGame(gameobject);
		
		playerobject = new AppPlayerModel("Test3", 322321);
		Instance.getInstance().addPlayer(gameobject, playerobject);
		
		playerobject = new AppPlayerModel("Test4", 32421);
		Instance.getInstance().addPlayer(gameobject, playerobject);		
		
		startActivity(new Intent(this, se.tr1golf.MenuActivity.class));
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}

}
