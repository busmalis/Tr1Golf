package se.tr1golf.fragment;

import java.util.ArrayList;

import se.tr1golf.R;
import se.tr1golf.adapter.gameAdapter;
import se.tr1golf.classes.User;
import se.tr1golf.singleton.Instance;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivityPagerPage extends Fragment {

	ArrayList<User> players = Instance.getInstance().getGame().getPlayers();
	private int holeNumber = 0;
	
	public GameActivityPagerPage(int position) {
		this.holeNumber = position;
	}

	@Override	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.game_activity_pager_page_score_list, container, false);

		TextView parText = (TextView) rootView.findViewById(R.id.game_activity_pager_page_score_list_par);
		parText.setText(String.valueOf(holeNumber));
		
		ListView dataList = (ListView) rootView.findViewById(R.id.game_activity_pager_page_score_list_listview);
		dataList.setAdapter(new gameAdapter(getActivity(), players));
		
		return rootView;
	}
}
