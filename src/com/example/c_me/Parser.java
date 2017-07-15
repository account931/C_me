package com.example.c_me;


//uses/DELETE  WeatherHttpClient +JSONWeatherParser +model/weather+model/Location
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.c_me.model.Location;
import com.example.c_me.model.Weather;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class Parser extends Activity {
	
	//Mine
	//EditText ed1; //  Changed to AutoCompleteTextView
	
	// Autocomplete
	AutoCompleteTextView  ed1;
	String[] languages={"London","Tokio","Kyiv","Zhitomir","Yakutsk","Paris","Lviv","Omsk",
			"Oslo","Honolulu","KualaLumpur","CapeTown","Dubai","Anchorage","Amsterdam","Reykjavík","Rome","HongKong","Jerusalem","RiodeJaneiro","Venice","Athens","Cairo","Pekin"};
	// End  AutoComplete
	
	Button b1; Context context;//public String city;
	RelativeLayout layy;public String cond;ImageView imgWeathBottom;

	
	private TextView cityText;
	private TextView condDescr;
	private TextView temp;
	private TextView press;
	private TextView windSpeed;
	private TextView windDeg;
	
	private TextView hum;
	private ImageView imgView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parser);
		
		//Mine
		//ed1=(EditText)findViewById(R.id.editInput); // Chaged to  Autocomplete
		
	             // Autocomplete  START
		ed1=(AutoCompleteTextView)findViewById(R.id.editInput);// Autocomplete  field
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
	     ed1.setAdapter(adapter);
	     ed1.setThreshold(1);
		        // END Autocomplete
		 b1=(Button)findViewById(R.id.buttonRR);
		 imgWeathBottom=(ImageView) findViewById(R.id.WeathBottom);
		 
		String city = "Ukraine";
		//String city = "London,UK";
		
		cityText = (TextView) findViewById(R.id.cityText);
		condDescr = (TextView) findViewById(R.id.condDescr);
		temp = (TextView) findViewById(R.id.temp);
		hum = (TextView) findViewById(R.id.hum);
		press = (TextView) findViewById(R.id.press);
		windSpeed = (TextView) findViewById(R.id.windSpeed);
		windDeg = (TextView) findViewById(R.id.windDeg);
		imgView = (ImageView) findViewById(R.id.condIcon);
		
		
		//Mine*****************************************************
		b1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	        	 //Func
	        	 String city =ed1.getText().toString();
	        	 //Check if !Empty
	        	 if(TextUtils.isEmpty(ed1.getText())) {toastMake("No city entered");}
	        	 else{
	        		 //Check Inet and run if OK
	        		 isNetworkConnected();
	        		     if(isNetworkConnected()==true){
	        	            JSONWeatherTask task = new JSONWeatherTask();
	     		            task.execute(new String[]{city});
	     		            toastMake ("set for"+" "+city); //Toast Function
	     		           changeImageF();
	        	 
	           		//START HIDE KEYBOARD
	    				InputMethodManager imm = (InputMethodManager)getSystemService(
	    					      Context.INPUT_METHOD_SERVICE);
	    					imm.hideSoftInputFromWindow(ed1.getWindowToken(), 0);
	    				//END HIDE KEYBOARD
	        	
	        	 } // End if(isNetworkConnected()==true)
	        		     else {toastMake ("No Internet connection");}//End else  isNetworkConnected()==true)
	        	     } // End Else if(TextUtils.isEmpty
	        	
	        	         //End  funct
	                   }
	                      });
	        
		//End  mine------------------------------------------------
		
		
		
		
		
	// Inet check	and Run  getting info
	checkInetAndRun(); 
		/*isNetworkConnected();
		if(isNetworkConnected()==true){toastMake ("Internet is OK");getInfo();} 
		else {toastMake ("No Internet connection");}*/
		
// End Inet check		
		
		
		
		//JSONWeatherTask task = new JSONWeatherTask();
		//task.execute(new String[]{city});
	}
	
	
	
//Create  usual menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.parser, menu);
		return true;
	}

	//
	 @Override
	   public boolean onOptionsItemSelected(MenuItem item) {
	      // Handle action bar item clicks here. The action bar will
	      // automatically handle clicks on the Home/Up button, so long
	      // as you specify a parent activity in AndroidManifest.xml.
	      
	      int id = item.getItemId();
	      
	      //noinspection SimplifiableIfStatement
	      if (id == R.id.action_parser1) {
	    	  weatherRELOAD();
	         return true;
	      }
	      return super.onOptionsItemSelected(item);
	   } 
	
	
	
	
	
	
	
	
	private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {
		
		@Override
		protected Weather doInBackground(String... params) {
			Weather weather = new Weather();
			String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

			try {
				weather = JSONWeatherParser.getWeather(data);
				
				// Let's retrieve the icon
				weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));
				
			} catch (JSONException e) {				
				e.printStackTrace();
			}
			return weather;
		
	}
		
		
		
		
	@Override
		protected void onPostExecute(Weather weather) {			
			super.onPostExecute(weather);
			
			if (weather.iconData != null && weather.iconData.length > 0) {
				Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length); 
				imgView.setImageBitmap(img);
			}
			
			
			
			
			cond=weather.currentCondition.getCondition();
			
			cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
			condDescr.setText(weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescr() + ")");
			temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "°C");
			hum.setText("" +":"+ weather.currentCondition.getHumidity() + "%");
			press.setText("" + ":"+weather.currentCondition.getPressure() + " hPa");
			windSpeed.setText("" +":"+ weather.wind.getSpeed() + " mps");
			windDeg.setText("" +":"+ weather.wind.getDeg() + "°");
			
			changeImageF();
			
			
		}



	
		


	
  } // End onCreate
	
	
// Universal tost function
	public void toastMake (String tt){
		Toast toastSong = Toast.makeText(getApplicationContext(), 
           		tt ,Toast.LENGTH_SHORT);
       			toastSong.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
       			toastSong.show();}
	
	
	
	
	//Inet function check
	private boolean isNetworkConnected() {
		  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo ni = cm.getActiveNetworkInfo();
		  if (ni == null) {
		   // There are no active networks.
		   return false;
		  } else
		   return true;
		 }
	// End Inet
	
	
	
	
	
	
	// START Run getInfo() if Inet is OK
	public void checkInetAndRun(){
		isNetworkConnected();
		if(isNetworkConnected()==true){toastMake ("Internet is OK"); getInfo();    }  
		else {toastMake ("No Internet connection\n  Check Connection ");}  }
// End START Run getInfo() if Inet is OK
	
	
	
	// Fucnction-start Json request
	public void getInfo(){
		//try{
		String city = "Ukraine";
		JSONWeatherTask task = new JSONWeatherTask();
		
		task.execute(new String[]{city}); //  } catch(Throwable e){toastMake("Failed");}
		
	}// end  fuction
		
	    
	
	
	
	
// Start  function change weather picture (on rain)
	public void changeImageF(){
		//Change image
		//String w=cond;
		String search  = "rain" ;
		layy= (RelativeLayout) findViewById(R.id.layouttt);
		if (cond.toLowerCase().indexOf(search.toLowerCase()) != -1 ) //if found keyword
		
		{layy.setBackgroundResource(R.drawable.weatherrain);
		imgWeathBottom.setImageDrawable(null);}
		else
		{layy.setBackgroundResource(R.drawable.weather1);}
		
		}
		//End Change image
	
	
	
	//REload  function
	public void weatherRELOAD(){
		 Intent intent = getIntent();
		    overridePendingTransition(0, 0);
		    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		    finish();

		    overridePendingTransition(0, 0);
		    startActivity(intent);
	}
	
	
	
} //End Class













































/*
//Uses HandleXML.java

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Parser extends ActionBarActivity {
	// Uses HandleXML.java

	EditText ed1,ed2,ed3,ed4,ed5;
	   
	   private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
	   private String url2 = "&mode=xml";
	   private HandleXML obj;
	   Button b1;
	   
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_parser);
	      b1=(Button)findViewById(R.id.button);
	      
	      ed1=(EditText)findViewById(R.id.editText);
	      ed2=(EditText)findViewById(R.id.editText2);
	      ed3=(EditText)findViewById(R.id.editText3);
	      ed4=(EditText)findViewById(R.id.editText4);
	      ed5=(EditText)findViewById(R.id.editText5);
	      
	      b1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            String url = ed1.getText().toString();
	            String finalUrl = url1 + url + url2;
	            ed2.setText(finalUrl);
	            
	            obj = new HandleXML(finalUrl);
	            obj.fetchXML();
	            
	            while(obj.parsingComplete);
	            ed2.setText(obj.getCountry());
	            ed3.setText(obj.getTemperature());
	            ed4.setText(obj.getHumidity());
	            ed5.setText(obj.getPressure());
	         }
	      });
	   } */
	   
	/*   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.menu_main, menu);
	      return true;
	   }
	   
	   @Override
	   public boolean onOptionsItemSelected(MenuItem item) {
	      // Handle action bar item clicks here. The action bar will
	      // automatically handle clicks on the Home/Up button, so long
	      // as you specify a parent activity in AndroidManifest.xml.
	      
	      int id = item.getItemId();
	      
	      //noinspection SimplifiableIfStatement
	      if (id == R.id.action_settings) {
	         return true;
	      }
	      return super.onOptionsItemSelected(item);
	   }  */
	// RETURN   } 