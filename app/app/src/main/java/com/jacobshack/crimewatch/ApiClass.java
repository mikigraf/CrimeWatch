package com.jacobshack.crimewatch;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ApiClass {
    private final String LOG_TAG = "API_CLASS";
    private static final String API_URL = "http://jh2015.deneb.uberspace.de/api.php";
    private OkHttpClient client = new OkHttpClient();

    private String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String getCrimesFromApi(Double lat, Double lng) throws IOException {
        Log.i(LOG_TAG, API_URL + "?lat=" + lat + "&lng=" + lng);
        // FIXME: 17.10.2015
        return doGetRequest(API_URL + "?lng=" + lat + "&lat=" + lng);
    }
}
