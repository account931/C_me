package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WifiScan extends Activity  {
   protected static final String LOG_TAG = null;
ListView lv;
   WifiManager wifi;
   String wifis[];
   String  wifiSSID[]; //SSID names
   WifiScanReceiver wifiReciever;
   //Mine
   WifiInfo info;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_wifi_scan);
      lv=(ListView)findViewById(R.id.listViewWW);
      
      wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);
      wifiReciever = new WifiScanReceiver();
      wifi.startScan();
      /*wifiInfo info = wifi.getConnectionInfo ();
        info.getBSSID ();*/
      
      
      
      
    //Restart   by cicking the image******
      //Click Image to reload
      ImageView imgWiFI = (ImageView) findViewById(R.id.imageViewWiFi);
      imgWiFI.setClickable(true);
      imgWiFI.setOnClickListener(new OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      //RESTART
                  	Intent intent = getIntent();
              	    overridePendingTransition(0, 0);
              	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
              	    finish();

              	    overridePendingTransition(0, 0);
              	    startActivity(intent);
              	          //Toast with Object  create
              	         toastMake("Running Wi-Fi check-up");
              	          //End  Toast
                  	//END RESTART
                  }
              });
      //End  Restart by clicking the image---------
      
      
      
      
      
      
      
      
      
      
      // Listview click on ITEM
      lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, /*View view*/View itemClicked,
              int position, long id) {
        	
        	  //Get the  context of  clicked item
        	TextView textView = (TextView) itemClicked;
      		String zig = textView.getText().toString();
      		    //End Get the  context of  clicked  item
      		
      		                 // Just  an example  how  to  run an activity after click
      		                          /*if(strText.equalsIgnoreCase(getResources().getString(R.string.name1))) {
    		                          // Start any activity
    			                      startActivity(new Intent(this, BarsikActivity.class));
    		                          }*/
      		                 // End  Just an  example
      				
        	  toastMake("U've  selected"+id+" "+position+zig);
            //Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
        	  
        	              // Getting the name SSID, but it  shows the name of  1st item
        	               info = wifi.getConnectionInfo ();
                           String xW=info.getSSID ();  //getBSSID
                            toastMake("Yhe name of netWork is:"+xW);
        	               // End  get name   SSID
          }
        });
      // End  ListView Click on ITEM
      
      
      
      
      
      
      
      
      
      
      
   } // END onCreate---------------------------------------------
   
   
// Universal tost function
	public void toastMake (String tt){
		Toast toastSong = Toast.makeText(getApplicationContext(), 
           		tt ,Toast.LENGTH_SHORT);
       			toastSong.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
       			toastSong.show();}
	// END
	
	
	
	
   
   
   
   
   
   protected void onPause() {
      unregisterReceiver(wifiReciever);
      super.onPause();
   }
   
   protected void onResume() {
      registerReceiver(wifiReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
      super.onResume();
   }
   
  /* @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.wifi_scan, menu);
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
   } */
   
   
   
   
   
   
   
   
   
   
   
   
   
   private class WifiScanReceiver extends BroadcastReceiver{
      public void onReceive(Context c, Intent intent) {
         List<ScanResult> wifiScanList = wifi.getScanResults();
         wifis = new String[wifiScanList.size()];
         
        
         
         
       //Mine BRED
       /*  info = wifi.getConnectionInfo ();
         info.getBSSID ();
         List<ScanResult> wifiScanListSS =(List<ScanResult>) wifi.getConnectionInfo ();
                   //to get names  SSID,try here like
                    wifiSSID = new String[wifiScanListSS.size()];
                    for(int j = 0; j < wifiScanListSS.size(); j++){
        	        wifiSSID[j] = ((wifiScanListSS.get(j)).toString());
                    }*/
                    //END BRED
                    
                    
                    
         
         for(int i = 0; i < wifiScanList.size(); i++){
            wifis[i] = ((wifiScanList.get(i)).toString());
         }
         
                   //Check if no wi-fi  avilable
                       if(wifis!=null && wifis.length>0){} else{toastMake("Nothing  Found");}
                   //End  check if  no wi-fi
         
         lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,wifis));
         
        
      }
   }
}