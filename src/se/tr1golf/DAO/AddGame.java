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

public class AddGame extends AsyncTask<Void, Integer, String>{
	//AppRoundModel model;
    public AddGame(Context context, int model){
    	//this.model = model;
    }
    
	@Override
	protected String doInBackground(Void... params){
		try{
			HttpResponse response;
	    	HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(DatabaseConnection.address
					+ "/JSON/CreateRound");
	    	
	    	JSONObject data = new JSONObject();
			//data.put("CourseID", model.getCourseID());
			httppost.setEntity(new ByteArrayEntity(data.toString().getBytes("UTF8")));
			httppost.addHeader("Content-Type", "application/json; charset=utf-8");
			httppost.setHeader("json", data.toString());
	    	try {
				response = httpclient.execute(httppost);		
		    	HttpEntity entity = response.getEntity();
			    	if (entity != null) {              
		                InputStream instream = entity.getContent();
		                String result = converter.convertStreamToString(instream);	
		                return result;
			    	}	    	 
				} 
			catch (ClientProtocolException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
	}
}
