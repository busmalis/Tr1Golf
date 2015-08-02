package se.tr1golf.adapter;
import java.util.ArrayList;

import se.tr1golf.model.AppGameListModel;
import se.tr1golf.singleton.Instance;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class gameListAdapter extends BaseExpandableListAdapter {
	private Context context;
	static private ArrayList<AppGameListModel> parentlist = Instance
			.getInstance().getGames();

	public gameListAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
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
		if (parentlist.get(groupPosition).getPlayers().size() > 0) {
			tv.setText(parentlist.get(groupPosition).getPlayers()
					.get(childPosition).getUsername());
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
		return parentlist.get(groupPosition).getPlayers().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parentlist.size();
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
		tv.setText("Course: " + parentlist.get(groupPosition).getCoursename()
				+ "\nRound: " + parentlist.get(groupPosition).getRoundID());
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
