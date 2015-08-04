package se.tr1golf.DAO;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import se.tr1golf.misc.converter;
import android.content.Context;
import android.os.AsyncTask;

public class DAOBase<T> extends AsyncTask<Void, Integer, String> {

	private T object;
	private String typeCall;
	private JSONObject data;

	public DAOBase(Context context, String typeCall, JSONObject data) {
		this.setTypeCall(typeCall);
		this.setData(data);
	}

	@Override
	protected String doInBackground(Void... params) {
		try {

			HttpResponse response;
			HttpClient httpclient = new DefaultHttpClient();

			HttpPost httppost = new HttpPost(DatabaseConnection.address
					+ "/JSON/" + this.getTypeCall());

			httppost.setEntity(new ByteArrayEntity(data.toString().getBytes(
					"UTF8")));
			httppost.addHeader("Content-Type",
					"application/json; charset=utf-8");
			httppost.setHeader("json", data.toString());
			try {
				response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream instream = entity.getContent();
					String result = converter.convertStreamToString(instream);
					return result;
				}
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
	
	public String getTypeCall() {
		return typeCall;
	}

	public void setTypeCall(String typeCall) {
		this.typeCall = typeCall;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
