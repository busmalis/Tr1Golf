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

import se.tr1golf.misc.converter;
import se.tr1golf.model.AppBugReportModel;

import android.os.AsyncTask;

public class GetHoleScores extends AsyncTask<Void, Integer, ArrayList<Integer>> {
	ArrayList<Integer> a;
	AppBugReportModel model;

	@Override
	protected ArrayList<Integer> doInBackground(Void... params) {
		HttpResponse response;
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(DatabaseConnection.address
				+ "/JSON/GetHoleScores");
		try {
			// Routine for POSTing JSON objects to the server
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = converter.convertStreamToString(instream);
				ArrayList<Integer> a = new ArrayList<Integer>();
				JSONArray array = new JSONArray(result);
				for (int i = 0; i < array.length(); i++) {
					JSONObject row = array.getJSONObject(i);
					a.add(row.getInt("Score"));
				}
				return a;
			}
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
