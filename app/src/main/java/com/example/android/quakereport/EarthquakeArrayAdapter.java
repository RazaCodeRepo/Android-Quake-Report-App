package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kontrol on 3/6/2017.
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public static final String LOG_TAG = EarthquakeArrayAdapter.class.getName();



    public EarthquakeArrayAdapter(Activity context, List<Earthquake> earthquakesList){

        super(context, 0, earthquakesList);
        Log.v(LOG_TAG, "In Earthquake Array Adapter Constructor");
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Log.v(LOG_TAG, "In Earthquake Array Adapter getView method");
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView magTextView = (TextView)listItemView.findViewById(R.id.mag_id);


        double mag = earthquake.getMagnitude();


        GradientDrawable magnitudeCircle = (GradientDrawable)magTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(mag);
        magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String formattedMag = formatter.format(mag);

        magTextView.setText(formattedMag);

        ArrayList<String> twoParts = twoPartsOfLoc(earthquake.getLocationName());


        TextView locOneView = (TextView)listItemView.findViewById(R.id.loc_partone_id);
        locOneView.setText(twoParts.get(0));

        TextView locTwoView = (TextView)listItemView.findViewById(R.id.loc_parttwo_id);
        locTwoView.setText(twoParts.get(1));

        TextView dateView = (TextView)listItemView.findViewById(R.id.date_id);
        Date dateObject = new Date(earthquake.getDateTime());
        dateView.setText(formatDate(dateObject));

        TextView timeView = (TextView)listItemView.findViewById(R.id.time_id);
        timeView.setText(formatTime(dateObject));

        Log.v(LOG_TAG, "In Earthquake Array Adapter getView method returning list item view");

        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
        return dateFormatter.format(dateObject);
    }

    private ArrayList<String> twoPartsOfLoc(String loc){
        ArrayList<String> twoParts = new ArrayList<String>();

        if(loc.contains(" of ")){
            int index1 = loc.indexOf(" of ");
            String partOne = loc.substring(0,index1+4);

            twoParts.add(partOne);
            String partTwo = loc.substring(index1+4, loc.length());
            twoParts.add(partTwo);

        }
        else{
            twoParts.add("Near the ");
            twoParts.add(loc);

        }
        return twoParts;
    }

    private int getMagnitudeColor(double mag){
        int magnitudeColor = 0;

        switch((int)Math.floor(mag)){
            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;

            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;

            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;

            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;

            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;

        }

        return magnitudeColor;
    }
}
