package com.practise.pick_up_lines;

import android.os.AsyncTask;

public class Networking extends AsyncTask<Void, Void, Void> {
    String url = "http://pebble-pickup.herokuapp.com//tweets";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        Constant.sendHTTPData(url);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
