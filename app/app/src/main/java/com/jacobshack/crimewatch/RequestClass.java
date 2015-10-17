package com.jacobshack.crimewatch;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RequestClass extends AsyncTask<Void, Integer, String> {
    private final String LOG_TAG = "REQUEST_CLASS";
    private GoogleMap mMap;
    private LatLng mCurrentLocation;

    RequestClass(GoogleMap map, LatLng currentLocation) {
        mMap = map;
        mCurrentLocation = currentLocation;
    }

    protected String doInBackground(Void... params) {
        String result = "";
        try {
            result += new ApiClass().getCrimesFromApi(mCurrentLocation.latitude, mCurrentLocation.longitude);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    protected void onPostExecute(String result) {
        try {
            JSONArray crimes = new JSONObject(result).getJSONArray("crimes");
            Log.i(LOG_TAG, "Crimes found: " + Integer.toString(crimes.length()));

            for(int i = 0; i < crimes.length(); i++) {

                JSONObject jo = crimes.getJSONObject(i);
                JSONArray ja = jo.getJSONObject("geometry").getJSONArray("coordinates");
                JSONObject properties = jo.getJSONObject("properties");

                CrimeClass crime = new CrimeClass(Double.parseDouble(ja.get(0).toString()), Double.parseDouble(ja.get(1).toString()), properties.getString("type"), properties.getString("details"));

                LatLng position = new LatLng(crime.getLat(), crime.getLng());
                mMap.addMarker(new MarkerOptions().position(position).title(crime.getType()).snippet(crime.getDetails()).icon(crime.getIcon()));
            }
        } catch(JSONException je) {
            je.printStackTrace();
        }
    }
}
