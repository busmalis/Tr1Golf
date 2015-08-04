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

import se.tr1golf.classes.Course;
import se.tr1golf.misc.converter;

import android.os.AsyncTask;

public class GetCourses extends AsyncTask<Void, Integer, ArrayList<Course>> {
	ArrayList<Course> a;

	@Override
	protected ArrayList<Course> doInBackground(Void... params) {
		HttpResponse response;
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(DatabaseConnection.address
				+ "/JSON/GetCourses");
		try{
			// Routine for POSTing JSON objects to the server
			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = converter.convertStreamToString(instream);
				ArrayList<Course> a = new ArrayList<Course>();
				JSONArray array = new JSONArray(result);
				for (int i = 0; i < array.length(); i++) {
					JSONObject row = array.getJSONObject(i);
					/*Course course = new Course(row.getInt("Id"),
							row.getString("Name"));
					a.add(course);*/
				}
				return a;
			}
		}catch (JSONException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
