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
        if(mType == "Arrest") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Arson") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Assault") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Burglary") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Robbery") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Shooting") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Theft") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else if(mType == "Vandalism") {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        } else {
            return BitmapDescriptorFactory.fromResource(R.drawable.criminal28);
        }
    }
}
