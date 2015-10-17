package yoloteam.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by spejs on 17/10/15.
 */
public class LocationListener extends Service implements android.location.LocationListener{

    private final Context mContext;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    Location location;
    double latitude;
    double longtitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1;
    private static final long MIN_TIME_BW_UPDATES = (1000*60)/10;
    protected LocationManager locationManager;

    public LocationListener(Context context){
        this.mContext = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if (!isGPSEnabled && !isNetworkEnabled) {

            }else{
                    this.canGetLocation = true;
                    if (isNetworkEnabled) {
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("Network", "Network");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longtitude = location.getLongitude();
                                Toast.makeText(getApplicationContext(), "Your location is - " + getLatitude() + " " + getLongtitude(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (isGPSEnabled) {
                        if (location == null) {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                            Log.d("GPS Enabled", "GPS Enabled");
                            if (locationManager != null) {
                                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                if (location != null) {
                                    latitude = location.getLatitude();
                                    longtitude = location.getLongitude();
                                    Toast.makeText(getApplicationContext(), "Your location is - " + getLatitude() + " " + getLongtitude(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }



    @Override
    public void onLocationChanged(Location location) {
        getLocation();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        getLocation();

    }

    @Override
    public void onProviderEnabled(String provider) {
        getLocation();

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public double getLongtitude(){
        if(location != null){
            longtitude = location.getLongitude();
        }
        return longtitude;
    }


}
