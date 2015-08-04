package se.tr1golf.DAO;

import org.json.JSONObject;

import se.tr1golf.model.AppGameModel;
import android.content.Context;

public class GetGamesList extends DAOBase<AppGameModel>{

	public GetGamesList(Context context, String typeCall, JSONObject data) {
		super(context, typeCall, data);
		// TODO Auto-generated constructor stub
	}
}
