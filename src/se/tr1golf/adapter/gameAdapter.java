package se.tr1golf.adapter;

import java.util.ArrayList;

import se.tr1golf.R;
import se.tr1golf.classes.User;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class gameAdapter extends ArrayAdapter<User> {

	private final Activity context;
	private final ArrayList<User> players;

	public gameAdapter(Activity context, ArrayList<User> players) {
		super(context, R.id.bMenuLogout, players);
		this.context = context;
		this.players = players;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.game_activity_pager_page, null, true);
		
		TextView txtPlayerName = (TextView) rowView
				.findViewById(R.id.game_activity_pager_page_playername);
		Spinner sprThrows = (Spinner) rowView
				.findViewById(R.id.game_activity_pager_page_throwsspinner);

		txtPlayerName.setText(players.get(position).getUserName());
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				context, R.array.throws_count,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sprThrows.setAdapter(adapter);

		return rowView;

	};

}
