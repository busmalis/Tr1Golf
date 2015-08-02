package se.tr1golf.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import se.tr1golf.misc.converter;
import se.tr1golf.model.AppRoundListModel;

import android.content.Context;
import android.os.AsyncTask;

public class GetRoundList extends AsyncTask<Void, Integer, ArrayList<AppRoundListModel>>{
	ArrayList<AppRoundListModel> a;
	AppRoundListModel model;
    public GetRoundList(Context context, AppRoundListModel roundmodel){
    	model = roundmodel;
    }
	@Override
	protected ArrayList<AppRoundListModel> doInBackground(Void... params){
		try{
			HttpResponse response;
	    	HttpClient httpclient = new DefaultHttpClient();
	    	HttpPost httppost = new HttpPost(DatabaseConnection.address + "/JSON/GetRoundList");
	    	JSONObject data = new JSONObject();
			data.put("RoundID", model.getRoundID());
			data.put("Score", model.getScore());
			data.put("UserID", model.getUserID());
			data.put("Coursename", model.getCoursename());
			
			httppost.setEntity(new ByteArrayEntity(data.toString().getBytes("UTF8")));
			httppost.addHeader("Content-Type", "application/json; charset=utf-8");
			httppost.setHeader("json", data.toString());
			try {
				// Routine for POSTing JSON objects to the server	
				response = httpclient.execute(httppost);	
		    	HttpEntity entity = response.getEntity();
		    	if (entity != null) {              
			        InputStream instream = entity.getContent();
			        String result = converter.convertStreamToString(instream);
			        ArrayList<AppRoundListModel> a = new ArrayList<AppRoundListModel>();
			        JSONArray array = new JSONArray(result);
			        for (int i = 0; i < array.length(); i++) {
			            JSONObject row = array.getJSONObject(i);
			            AppRoundListModel appmodel = new AppRoundListModel(row.getString("Coursename"), row.getInt("RoundID"), row.getInt("Score"), 0);
			            a.add(appmodel);
			        }		               
			        return a;	                
			        }		        	    	 
				} 
	    	catch (JSONException e) {
	    		e.printStackTrace();
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
