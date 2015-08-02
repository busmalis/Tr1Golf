package se.tr1golf.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import se.tr1golf.GameListActivity;
import se.tr1golf.misc.converter;
import se.tr1golf.model.AppGameListModel;
import android.os.AsyncTask;

public class GetGamesList extends
		AsyncTask<Void, Integer, ArrayList<AppGameListModel>> {

	public GetGamesList(GameListActivity gameListActivity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ArrayList<AppGameListModel> doInBackground(Void... params) {
		try {
			HttpResponse response;
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(DatabaseConnection.address
					+ "/JSON/GetActiveRoundsList");
			try {
				// Routine for POSTing JSON objects to the server
				response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instream = entity.getContent();
					String result = converter.convertStreamToString(instream);
					ArrayList<AppGameListModel> a = new ArrayList<AppGameListModel>();
					JSONArray array = new JSONArray(result);
					for (int i = 0; i < array.length(); i++) {
						JSONObject row = array.getJSONObject(i);
						AppGameListModel appmodel = new AppGameListModel(
								row.getString("Coursename"),
								row.getInt("RoundID"));
						a.add(appmodel);
					}
				
					return a;
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
