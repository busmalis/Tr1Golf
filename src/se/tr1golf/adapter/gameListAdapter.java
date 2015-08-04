package se.tr1golf.adapter;
import java.util.ArrayList;

import se.tr1golf.model.AppGameModel;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class gameListAdapter extends BaseExpandableListAdapter {
	private Context context;
	private ArrayList<AppGameModel> gameListData = new ArrayList<AppGameModel>();

	public gameListAdapter(Context context, ArrayList<AppGameModel> gameListData) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.gameListData = gameListData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tv = new TextView(context);
		if (gameListData.get(groupPosition).getPlayers().size() > 0) {
			tv.setText(gameListData.get(groupPosition).getPlayers()
					.get(childPosition).getUserName());
			tv.setPadding(70, 5, 0, 5);
		} else {
			tv.setText("Empty");
			tv.setPadding(70, 5, 0, 5);
		}
		return tv;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return gameListData.get(groupPosition).getPlayers().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return gameListData.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tv = new TextView(context);
		tv.setText("Course: " + gameListData.get(groupPosition).getCourse().getCourseName());
		tv.setPadding(60, 5, 0, 5);

		return tv;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
