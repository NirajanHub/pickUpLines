package com.apps.pickup_lines;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Constant {
    public static String sendHTTPData(String urlpath) throws Exception {
        String TAG = "dinesh";
        MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(75, TimeUnit.SECONDS)
                .writeTimeout(75, TimeUnit.SECONDS)
                .readTimeout(75, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(urlpath)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
