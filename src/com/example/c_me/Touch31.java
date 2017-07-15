package com.example.c_me;

// Uses Custom View = AnimationViewGame.java (declared in activity_touch31.xml  ONLY)
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

// U touch and  coordinates  are shown
public class Touch31 extends Activity {
	
	//mine
	RelativeLayout topRL;
	
  float xAxis = 0f;
   float yAxis = 0f;
   
   float lastXAxis = 0f;
   float lastYAxis = 0f;
   
   EditText ed1, ed2, ed3, ed4;
   TextView tv1;
  MediaPlayer mediaPlayer2;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_touch31);
     
      //Mine
      RelativeLayout topRL = (RelativeLayout)findViewById(R.id.Xlllay);
      
      ed1 = (EditText) findViewById(R.id.editText);
      ed2 = (EditText) findViewById(R.id.editText2);
      ed3 = (EditText) findViewById(R.id.editText3);
      ed4 = (EditText) findViewById(R.id.editText4);

    //  tv1=(TextView)findViewById(R.id.textView2);  // Touch me  TextView  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      //PREV WORKING
      
     topRL.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
            final int actionPeformed = event.getAction();
            
            switch(actionPeformed){
               case MotionEvent.ACTION_DOWN:{
                  final float x = event.getX();
                  final float y = event.getY();
                  
                  lastXAxis = x;
                  lastYAxis = y;
                  
                  ed1.setText(Float.toString(lastXAxis));
                  ed2.setText(Float.toString(lastYAxis));
                  //shootsound();
                  break;
               }
               
               case MotionEvent.ACTION_MOVE:{
                  final float x = event.getX();
                  final float y = event.getY();
                  
                  final float dx = x - lastXAxis;
                  final float dy = y - lastYAxis;
                  
                  xAxis += dx;
                  yAxis += dy;
                  
                  ed3.setText(Float.toString(xAxis));
                  ed4.setText(Float.toString(yAxis));
                  break;
               }
            }
            return true;
         }
      });
      
      
      
      
      
      
      //Check  Collision  function
      checkCollision();
     
	 
      
      
   }// END onCreate ???
  
 
   
   
   
   //Start  Colision  function***********
   public  void checkCollision(){
	   
	   if(xAxis==5){
		 // Make  piggy sound
		   ToastDisplay("Hit!!!");
	   }
	   
   }
   //End  Collision function-------------------------
   
   
   
   
   
   
   
   
// Toast Function
	public void ToastDisplay(String Mess){
		Toast.makeText(getApplicationContext(), Mess,
                Toast.LENGTH_SHORT).show();
	}
	//End  tost function
   
   
   
	
	
	
	
	

	// Sound  **********
	public void shootsound()
	{
			//
		  if (mediaPlayer2 != null) {
			  mediaPlayer2.release();
			  mediaPlayer2 = null;
		    }
		    try {
		    	mediaPlayer2 = MediaPlayer.create(this, R.raw.crowbar_impact1);
			  	 mediaPlayer2.start();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		//
    	   }
    	//END  Sound --------------------------------------
	
	
	
	
	
	
	
	
	
	
   
   
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.touch31, menu);
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
   }
   
   
   
} // END CLASS