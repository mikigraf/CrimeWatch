package com.jacobshack.crimewatch;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

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
    private Context mCtx;
    private int mNotificationId;

    RequestClass(GoogleMap map, LatLng currentLocation, Context ctx) {
        mMap = map;
        mCurrentLocation = currentLocation;
        mCtx = ctx;
        mNotificationId = 0;
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
            JSONArray crimes = new JSONObject(result).getJSONArray("features");
            Log.i(LOG_TAG, "Crimes found: " + Integer.toString(crimes.length()));

            int numCrimes = crimes.length();

            for(int i = 0; i < numCrimes; i++) {
                JSONObject jo = crimes.getJSONObject(i);
                JSONArray ja = jo.getJSONObject("geometry").getJSONArray("coordinates");
                JSONObject properties = jo.getJSONObject("properties");

                CrimeClass crime = new CrimeClass(Double.parseDouble(ja.get(0).toString()), Double.parseDouble(ja.get(1).toString()), properties.getString("type"), properties.getString("details"));

                Log.d(LOG_TAG, crime.getLat() + ", " + crime.getLng());

                LatLng position = new LatLng(crime.getLat(), crime.getLng());
                mMap.addMarker(new MarkerOptions().position(position).title(crime.getType()).snippet(crime.getDetails()).icon(crime.getIcon()));
            }

            mNotificationId++;
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx).setSmallIcon(R.drawable.arrest).setContentTitle("In the radius of 5 miles").setContentText("there have been "  + numCrimes + " crimes found.");
            Intent resultIntent = new Intent(mCtx, MapsActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(mCtx).addParentStack(MapsActivity.class).addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(mNotificationId, mBuilder.build());

            Toast.makeText(mCtx, "Watch out! " + numCrimes + " crimes happened here lately!", Toast.LENGTH_LONG).show();
        } catch(JSONException je) {
            je.printStackTrace();
        }
    }
}
