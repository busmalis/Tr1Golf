package se.tr1golf.DAO;

import se.tr1golf.model.AppBugReportModel;

import android.content.Context;
import android.os.AsyncTask;

public class JoinGame extends AsyncTask<Void, Integer, AppBugReportModel> {
	// ArrayList<ItemModel> a;
	AppBugReportModel model;

	public JoinGame(Context context, AppBugReportModel bugmodel) {
		model = bugmodel;
	}

	@Override
	protected AppBugReportModel doInBackground(Void... params) {
		//HttpResponse response;
		//HttpClient httpclient = new DefaultHttpClient();

		return null;
	}

}
