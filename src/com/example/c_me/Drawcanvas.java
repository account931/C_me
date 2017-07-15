package com.example.c_me;




// START DRAW FINGER  VERSION_2 With Speed BAR------------------------------------------------

// USES AnimationView.java CLASS
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.os.Bundle;

public class Drawcanvas extends ActionBarActivity {
 
 AnimationView animationView;
 SeekBar speedBar;
 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_drawcanvas);

  animationView = (AnimationView)findViewById(R.id.animationview);
  speedBar = (SeekBar)findViewById(R.id.speedbar);
  speedBar.setOnSeekBarChangeListener(speedBarOnSeekBarChangeListener);
  animationView.setSpeed(speedBar.getProgress()); //set default speed
 }
 
 
 
 OnSeekBarChangeListener speedBarOnSeekBarChangeListener = 
  new OnSeekBarChangeListener(){

   @Override
   public void onProgressChanged(SeekBar seekBar, int progress,
     boolean fromUser) {
    //offset from SeekBar 0~19 to step 1~10
    animationView.setSpeed(progress);
   }

   @Override
   public void onStartTrackingTouch(SeekBar seekBar) {}

   @Override
   public void onStopTrackingTouch(SeekBar seekBar) {}
   
 };  // END onCreate
   
   
   
   
   //Menu
   @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drawcanvas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settingsCanvas) {
			
			// flagCanvas=2;
			//Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.com);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
   //End menu
   
   
   
   

}   // END  CLASS


//END DRAW FINGER VERSION_2  With Speed BAR--------------------------------------------














// DRAWING FINGER  1st Variant ----NO SPEED BAR
/*

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Drawcanvas extends ActionBarActivity {
	public int flagCanvas;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawcanvas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drawcanvas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settingsCanvas) {
			
			 flagCanvas=2;
			//Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.com);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
*/
// END DRAWING FINGER  1st Variant ----NO SPEED BAR