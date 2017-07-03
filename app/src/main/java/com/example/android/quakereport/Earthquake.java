package com.example.android.quakereport;

/**
 * Created by Kontrol on 3/6/2017.
 */

public class Earthquake {

    private double magnitude;
    private String locationName;
    private long dateTime;
    private String url;

    public Earthquake(double mag, String loc, long dt, String link){
        magnitude = mag;
        locationName = loc;
        dateTime = dt;
        url = link;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getLocationName(){
        return locationName;
    }

    public long getDateTime(){
        return dateTime;
    }

    public String getUrl(){
        return url;
    }

    public String toString(){
        return magnitude + " " + locationName + " " + dateTime;
    }
}
