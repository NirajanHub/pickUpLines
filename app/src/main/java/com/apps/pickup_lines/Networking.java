package com.apps.pickup_lines;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Networking extends AsyncTask<Void, Void, String> {
    String url = "http://pebble-pickup.herokuapp.com/tweets";
    OnResponse onResponse;

    Networking(OnResponse onResponse) {
        this.onResponse = onResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... voids) {
        String response = null;
        try {
            response = Constant.sendHTTPData(url);
            Log.d("nirajan", "response : " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        ArrayList<Model> arrayList = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if ( jsonObject.has("tweet") ) {
                    Model model = new Model();
                    model.setId(jsonObject.getString("_id"));
                    model.setTweet(jsonObject.getString("tweet"));
                    model.setUsername(jsonObject.getString("username"));
                    arrayList.add(model);
                }
            }
            onResponse.gotResponse(arrayList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
