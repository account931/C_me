package com.example.c_me;

// CHAT USES TWO Additional Class 
// 1. GetDataFromDB.java – Gets value from DB in the form of JSON.
// 2. Users.java _ Class which holds the one row table object. 

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Chat extends ActionBarActivity {
	
	
	/*USUAL Menu*/
	public static final int IDM_RELOAD=101;
	public static final int IDM_INSERT=102;
	public static final int IDM_SAVE=103;
	/*END USUAL Menu*/
	/*Context menu*/
	//public static final int IDM_ChatLoad=501;
    /*END Context menu*/
	
	
	//Added
	String data = "";
	TableLayout tl;
	TableRow tr;
	TextView label;
	//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		//Context
		/*final LinearLayout game=(LinearLayout) findViewById(R.id.LChat);
		registerForContextMenu(game);*/
		//END CONTEXT

		
		
		//CHAT-----------------------------------------------------------------------
		tl = (TableLayout) findViewById(R.id.maintable);

		final GetDataFromDB getdb = new GetDataFromDB();
		new Thread(new Runnable() {
			public void run() {
				data = getdb.getDataFromDB();
				System.out.println(data);
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						ArrayList<Users> users = parseJSON(data);//ArrayList<Users> users = parseJSON(data);
						addData(users);	//addData(users);						
					}
				});
				
			}
		}).start();
	}

	public ArrayList<Users> parseJSON(String result) {
		ArrayList<Users> users = new ArrayList<Users>();
		try {
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json_data = jArray.getJSONObject(i);
				Users user = new Users();
				user.setId(json_data.getInt("mess_id"));
				user.setName(json_data.getString("mess_uname"));
				user.setPlace(json_data.getString("mess_mess"));//setPlace
				users.add(user);
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());  
		}
		return users;
	}

	void addHeader(){
		/** Create a TableRow dynamically **/
		tr = new TableRow(this);

		/** Creating a TextView to add to the row **/
		label = new TextView(this);
		label.setText("User");//label.setText("User");
		label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		label.setPadding(5, 5, 5, 5);
		label.setBackgroundColor(Color.RED);
		LinearLayout Ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(5, 5, 5, 5);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(label,params);
		tr.addView((View)Ll); // Adding textView to tablerow.

		/** Creating Qty Button **/
		TextView place = new TextView(this);
		place.setText("Message");//place.setText("Place");
		place.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		place.setPadding(5, 5, 5, 5);
		place.setBackgroundColor(Color.RED);
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 5, 5, 5);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(place,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		 // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
	}
	
	@SuppressWarnings({ "rawtypes" })
	public void addData(ArrayList<Users> users) {

		addHeader();
		
		for (Iterator i = users.iterator(); i.hasNext();) {

			Users p = (Users) i.next();

			/** Create a TableRow dynamically **/
			tr = new TableRow(this);

			/** Creating a TextView to add to the row **/
			label = new TextView(this);
			label.setText(p.getName());
			label.setId(p.getId());
			label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			label.setPadding(5, 5, 5, 5);
			label.setBackgroundColor(Color.GREEN);
			LinearLayout Ll = new LinearLayout(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(label,params);
			tr.addView((View)Ll); // Adding textView to tablerow.

			/** Creating Qty Button **/
			TextView place = new TextView(this);
			place.setText(p.getPlace());
			place.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			place.setPadding(5, 5, 5, 5);
			place.setBackgroundColor(Color.GRAY);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT); // FILL_PARENT
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(place,params);
			tr.addView((View)Ll); // Adding textview to tablerow.

			 // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
		}
		
		// ADDED TOST
		Toast.makeText(getApplicationContext(), "Messages are loaded",
				Toast.LENGTH_LONG).show();
		//
		
		
		
		
		
	
		
		
	} // End onCreate
	
	
	
	
	//CREATE usual MENU !!! Should add onClick actioner ***************************************
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(Menu.NONE, IDM_RELOAD, Menu.NONE,"RELOAD");
		menu.add(Menu.NONE, IDM_INSERT, Menu.NONE,"SAY");
		menu.add(Menu.NONE, IDM_SAVE, Menu.NONE,"Save me");
		return (super.onCreateOptionsMenu(menu));       }
	//END CREATE usual MENU
	
	
	
	
	
	
	// USUAL MENU  ACTION*************************************************************
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle action bar item clicks here. The action bar will
	    // automatically handle clicks on the Home/Up button, so long
	    // as you specify a parent activity in AndroidManifest.xml.
	    int id = item.getItemId();

	    //noinspection SimplifiableIfStatement
	    if (id == IDM_RELOAD) {
	    	//
	    	reload();
	    }
	    
	    //second 
	    if (id == IDM_INSERT) {
	    	//
	    	//Move to ChatInsert
	    	Intent intentInsert = new Intent(Chat.this, ChatInsertM.class);
	        startActivity(intentInsert); 
		   // break;
		    //END
	    }
	    
	    //Third menu  item = //
	    if (id == IDM_SAVE) {
	 		//
	    //END round  
	    }
	    
	    
	   
	    
	    
	    
	    return super.onOptionsItemSelected(item);
	}
	//End menu actioner
	
	
	
	//Reload fuct
	public void reload() {

	    Intent intent = getIntent();
	    overridePendingTransition(0, 0);
	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	    finish();

	    overridePendingTransition(0, 0);
	    startActivity(intent);
	}
	//END RELOAD
	
	
	
	
	//CREATE CONTEXT !!! Should add onClick actioner
	/*@Override
	public void  onCreateContextMenu (ContextMenu menu ,View v,ContextMenuInfo info){
		super.onCreateContextMenu(menu, v, info);
		menu.add(Menu.NONE, IDM_ChatLoad, Menu.NONE,"Load Chat");
	
	}*/
	//END CREATE CONTEXT

	
	
	
} //End Class


		//END CHAT -------------------------------------------------------------

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
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
	}*/
