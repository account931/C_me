package com.example.c_me;

// USES GPSTracker.java

import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class GPSTOOL extends Activity { //Main Class
	
	
	
	//Class
	// GPSTracker class
    GPSTracker gps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_gpstool);
		
		
		
		
		//
		// Create class object
        gps = new GPSTracker(GPSTOOL.this);

        // Check if GPS enabled
        if(gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            
                     //set text with latitude and longitude
            TextView t = (TextView)findViewById(R.id.gpstext); 
            //t.setBackgroundColor(Color.RED);
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,26);
            t.setText("Your Location is - \nLat: " + latitude + "\nLong: " + longitude);
                     //end  set text with latitude and longitude
            
            //set text fot  Google maps
            TextView googlemaps = (TextView)findViewById(R.id.googlemaps);
            //Underline
            googlemaps.setPaintFlags(googlemaps.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
            googlemaps.setText("Open the map");
            //END set text fot  Google maps
            
            
            
            // Preferences
	    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(GPSTOOL.this);
	        
			//pref.edit().putInt("gpsSaved", /*message.getText().toString()*/latitude ,longitude).commit(); 
	    	//pref.putLong("Latitude", Double.doubleToLongBits(gps.getLatitude()));
	    	//Most working
	    	
	    	//pref.putString("Latitude", Double.valueOf(gps.getLatitude()).toString());
	    	
	    	
	    	//pref.putFloat(mylatitude, (float) gps.getLatitude());
	    	
	    	//Start get Pref
	    	//Then, to call the value
	    	String latitudeString = pref.getString("Latitude", "0");
	    	double latitudePref = Double.parseDouble(latitudeString);
	    	// End  get Pref
			// END PREFERANCES
            
            
            
         // Click to open Google maps
            //TextView googlemaps = (TextView)findViewById(R.id.googlemaps);
            googlemaps.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                        //GMaps Intent
                	double latitude = gps.getLatitude();
                	double longitude = gps.getLongitude();
                	String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                	/*context.*/startActivity(intent);
                	    // End Gmaps Intent

                }
            });
         // END Click to open Google maps     
            
            
            
            
            
        } else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
        	//Mine
        	Toast.makeText(getApplicationContext(), "Checking " , Toast.LENGTH_LONG).show();
        	//END Mine
            gps.showSettingsAlert();
        }
	//}
		//
		
		
	
     
        //Click Image to reload
        ImageView imgFavorite = (ImageView) findViewById(R.id.imageView1);
        imgFavorite.setClickable(true);
        imgFavorite.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //RESTART
                    	Intent intent = getIntent();
                	    overridePendingTransition(0, 0);
                	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                	    finish();

                	    overridePendingTransition(0, 0);
                	    startActivity(intent);
                    	//END RESTART
                    }
                });
        
		
		
	}  // End onCreate ????
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gpstool, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
