package com.jacobshack.crimewatch;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class CrimeClass {
    private double mLng;
    private double mLat;
    private String mType;
    private String mDetails;

    CrimeClass(double lng, double lat, String type, String details) {
        mLng = lng;
        mLat = lat;
        mType = type;
        mDetails = details;
    }

    public double getLng() {
        return mLng;
    }

    public double getLat() {
        return mLat;
    }

    public String getType() {
        return mType;
    }

    public String getDetails() {
        return mDetails;
    }

    public BitmapDescriptor getIcon() {
        if(mType.equals("Arrest")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.arrest);
        } else if(mType.equals("Arson")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.arson);
        } else if(mType.equals("Assault")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.assault);
        } else if(mType.equals("Burglary")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.burglary);
        } else if(mType.equals("Robbery")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.robbery);
        } else if(mType.equals("Shooting")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.shooting);
        } else if(mType.equals("Theft")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.theft);
        } else if(mType.equals("Vandalism")) {
            return BitmapDescriptorFactory.fromResource(R.drawable.vandalism);
        } else {
            return BitmapDescriptorFactory.fromResource(R.drawable.other);
        }
    }
}
