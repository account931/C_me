package com.example.c_me;

// Insert massages to SQL DB at resound.esy.es/androidinsert.php

// No  additional classes are used
//
import android.support.v7.app.ActionBarActivity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import android.support.v7.app.ActionBarActivity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class ChatInsertM extends ActionBarActivity {
	
	
	//
	String name;
	String id;
	InputStream is=null;
	String result=null;
	String line=null;
	int code; 
	//


	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_insert_m);
		
		//Announce
		Button LoadPref=(Button) findViewById(R.id.buttonLoadPref);
		Button Clear=(Button) findViewById(R.id.buttonClear);
		
		
		
		// Load Preferances Click
		LoadPref.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//
				final EditText e_id=(EditText) findViewById(R.id.editUser);
				//e_id.setText(pref.getString("autoSave", ""));
				  // SharedPreferences userDetails = this.getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
				SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ChatInsertM.this);
				    String tempName = pref.getString("autoSave","");  // (key, default) //Was Name
				    e_id.setText(tempName);
				//
			}
		});
		//End Load Pref
		
		
		
		
		
		// Button-Clear eddittexts
		Clear.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final EditText e_id=(EditText) findViewById(R.id.editUser);
						e_id.setText("");
						final EditText e_name=(EditText) findViewById(R.id.editMessage);
						e_name.setText("");
					}
				});
				//End Clear
		
		
		
		
	
		
		// strict policy
				if (android.os.Build.VERSION.SDK_INT > 9) {
					   StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
					   StrictMode.setThreadPolicy(policy);
					}
				// end strict policy
				
		
		
		//----INSERT  *************************************************************
		 final EditText e_id=(EditText) findViewById(R.id.editUser);
	        final EditText e_name=(EditText) findViewById(R.id.editMessage);
	        Button insert=(Button) findViewById(R.id.buttonInsert);
	        
	        insert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					
				id = e_id.getText().toString();
				name = e_name.getText().toString();
				
				insert();
				// Function Save Preferances
				preferanceSave();
				
				//
				Toast.makeText(getBaseContext(), "Inserted Successfully",
						Toast.LENGTH_SHORT).show();
				//
			}
			
// START FUNCTION prefranceSave******************************
			private void preferanceSave() {
				// TODO Auto-generated method stub
				// Preferences
		    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ChatInsertM.this);
		        pref.edit().putString("autoSave", /*message.getText().toString()*/id).commit(); 
				// END PREFERANCES}
			}
	// END FUNCTION prefranceSave		
			
			
			
		});
	    }
	 
	    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
		@SuppressLint("NewApi")
		public void insert()
	    {
	    	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	 
	   	nameValuePairs.add(new BasicNameValuePair("id",id));
	   	nameValuePairs.add(new BasicNameValuePair("name",name));
	    	
	    	try
	    	{
			HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://resound.esy.es/androidinsert.php");
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        HttpResponse response = httpclient.execute(httppost); 
		        HttpEntity entity = response.getEntity();
		        is = entity.getContent();
		        Log.e("pass 1", "connection success ");
		}
	        catch(Exception e)
		{
	        	Log.e("Fail 1", e.toString());
		    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
				Toast.LENGTH_LONG).show();
		}     
	        
	        try
	        {
	            BufferedReader reader = new BufferedReader
				(new InputStreamReader(is,"iso-8859-1"),8);
	            StringBuilder sb = new StringBuilder();
	            while ((line = reader.readLine()) != null)
		    {
	                sb.append(line + "\n");
	            }
	            is.close();
	            result = sb.toString();
		    Log.e("pass 2", "connection success ");
		}
	        catch(Exception e)
		{
	            Log.e("Fail 2", e.toString());
		}     
	       
		try
		{
	            JSONObject json_data = new JSONObject(result);
	            code=(json_data.getInt("code"));
				
	            if(code==1)
	            {
			Toast.makeText(getBaseContext(), "Inserted Successfully",
				Toast.LENGTH_SHORT).show();
	            }
	            else
	            {
			 Toast.makeText(getBaseContext(), "Sorry, Try Again",
				Toast.LENGTH_LONG).show();
	            }
		}
		catch(Exception e)
		{
	            Log.e("Fail 3", e.toString());      
		} //
		
	
		
		//THERE WAS STRICT
		
		
	    }   //end Insert ()
	    
	    
	    
	   
	    
	    
	    
	  
	}