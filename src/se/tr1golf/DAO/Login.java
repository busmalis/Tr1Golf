package se.tr1golf.DAO;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import se.tr1golf.misc.converter;
import se.tr1golf.model.AppLoginModel;

import android.content.Context;
import android.os.AsyncTask;

public class Login extends AsyncTask<Void, Integer, String> {
	AppLoginModel model;

	public Login(Context context, AppLoginModel loginmodel) {
		model = loginmodel;
	}

	@Override
	protected String doInBackground(Void... params) {
		try {
			HttpResponse response;
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(DatabaseConnection.address
					+ "/JSON/AppLogin");

			JSONObject data = new JSONObject();
			//data.put("Username", model.get_username());
			//data.put("Password", model.get_password());
			httppost.setEntity(new ByteArrayEntity(data.toString().getBytes(
					"UTF8")));
			httppost.addHeader("Content-Type",
					"application/json; charset=utf-8");
			httppost.setHeader("json", data.toString());

			response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = converter.convertStreamToString(instream);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
