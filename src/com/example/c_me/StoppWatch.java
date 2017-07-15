package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoppWatch extends Activity {
	
	
	//Timer Editext
    public EditText TimetText;
    public Button TimerSet;
    public Button TimerStop;
    MediaPlayer mediaPlayer1;
   
    
    public int y;


	  private static final int MILLIS_PER_SECOND = 1000;
	  private /*static  final*/ int SECONDS_TO_COUNTDOWN /*= 30*/;
	  private TextView     countdownDisplay;
	  private CountDownTimer timer;
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_stoppwatch);
	    
	    //Timer start
	   TimerSet=(Button) findViewById(R.id.buttonSetTimer);
	    TimetText= (EditText) findViewById(R.id.editTextTimer);
	    TimerStop=(Button) findViewById(R.id.stoptbutton);
	   
	    
		
		// button click SET
	    TimerSet.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	setTime();
		 
		    }
		});     
		/* END CALL button click*/
	    	    //  END TIMER    
	    
	    
	    
	    
	    
	    
	    
	 // button click STOP
	    TimerStop.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	if(timer != null) { timer.cancel(); }   
		    	Toast toastSong = Toast.makeText(getApplicationContext(), 
                		"stopped ",Toast.LENGTH_SHORT);
            			toastSong.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
            			toastSong.show();
            			 countdownDisplay.setText("Time");
		    }
		});     
		/* END STOP*/
	    	    //  END TIMER  
	    
	    
	    
	    
	        
	    countdownDisplay = (TextView) findViewById(R.id.time_display_box);
	    Button startButton = (Button) findViewById(R.id.startbutton);
	    
	    //START BUTTON
	    startButton.setOnClickListener(new View.OnClickListener() {
	      public void onClick(View view) {
	        try {
	          showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
	        } catch (NumberFormatException e) {
	          // method ignores invalid (non-integer) input and waits
	          // for something it can use
	        }
	      }
// END START BUTTON
	      
	      
	      
	    // Main function-starts counting  
		public void showTimer(int countdownMillis) {
			// TODO Auto-generated method stub
			setTime();
			if(timer != null) { timer.cancel(); }
			  timer = new CountDownTimer(countdownMillis, MILLIS_PER_SECOND) {
			  @Override
			  public void onTick(long millisUntilFinished) {
			    countdownDisplay.setText(": " +
			    millisUntilFinished / MILLIS_PER_SECOND);
			  }
			  @Override
			    public void onFinish() {
			      countdownDisplay.setText("DONE!"); // playmp();
			    }
			  }.start();
			//
		}
	    });
	  }
	// END  Main function-starts counting 
	  
	  
	  // function when click SET Button-------------------
	  public void setTime(){
		 // TimetText.setText("");
		//START HIDE KEYBOARD
			InputMethodManager imm = (InputMethodManager)getSystemService(
				      Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(TimetText.getWindowToken(), 0);
			//END HIDE KEYBOARD
	        
	 		 String timeValue = TimetText.getText().toString();
	 		 int y;
	 		 if(timeValue.trim().equals("")){y=9; }
	 		 else{
	 			 
	 		
	    	y = Integer.parseInt(timeValue ); }
	 		 
	    	SECONDS_TO_COUNTDOWN =y;
	    	//showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
	    	 Toast toastSong = Toast.makeText(getApplicationContext(), 
              		"set for "+y,Toast.LENGTH_SHORT);
          			toastSong.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
          			toastSong.show();
          			TimetText.setText("");
        	  }  // END function when click SET Button
	  
	  
	  
	  // Play sound
	  public void playmp(){
		  if (mediaPlayer1 != null) {
			  mediaPlayer1.release();
			  mediaPlayer1 = null;
		    }
		    try {
		    	mediaPlayer1 = MediaPlayer.create(this, R.raw.win);
			  	 mediaPlayer1.start();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		  
	  } //End Play
	  
	  
	  
	  
	  
	  
	  
	} // END CLASS