package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kontrol on 3/14/2017.
 */

public class EarthquakerLoader extends AsyncTaskLoader<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakerLoader.class.getName();


    private List<Earthquake> earthquakes;
    private String url;

    public EarthquakerLoader(Context context, String url){
        super(context);
        Log.v(LOG_TAG, "In Earthquake Loader constructor");
        earthquakes = new ArrayList<Earthquake>();
        this.url = url;
    }

    protected void onStartLoading(){
        Log.v(LOG_TAG, "On Start loader");
        forceLoad();
    }

    public List<Earthquake> loadInBackground(){
        Log.v(LOG_TAG, "In LoadInbackground");
        if(url.length() < 1 || url == null){
            return null;
        }

         earthquakes = QueryUtils.extractEarthquakes(url);


        return earthquakes;
    }
}
