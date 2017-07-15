package com.example.c_me;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Locale;

import android.widget.Toast;

public class Speech extends Activity {
	
	
	// Delay handler  // If set after serContentView (onCreate)-DOESNOT WORK
	// Currently not used (was intended to  change image in 200mlsec)
	private Handler mHandler = new Handler();
	
	
   TextToSpeech t1;
   EditText ed1;
   Button b1; //speech button
   Button random;
   Button clear;
   ImageView Speechimage;
   
   
   
// array with random phrases
  // final String[] wordListOne = {"Good morning","Hello","Screw you","I love you"};
   //final int oneLength = wordListOne.length;
   //public int rand1;
   
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_speech);
      ed1=(EditText)findViewById(R.id.editText);
      b1=(Button)findViewById(R.id.buttonSpeech);
      random=(Button)findViewById(R.id.buttonRandom);
      clear=(Button)findViewById(R.id.buttonClear);
      Speechimage = (ImageView)findViewById(R.id.imageViewSpeech);
      
    
      
   // array with random phrases
      final String[] wordListOne = {"Good morning","Hello","Screw you","I love you","See you tomorrow","Let us get  drunk","I gonna  miss  you","don't you love  me  any more?","Buckle up","Don't blow it","Don't  worry be  happy","Let us  roll","Come on  baby","Sun is still shining","You are cute","Give me  some  money"};
      final int oneLength = wordListOne.length;
     // public int rand1;
      
      
      
      
      t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
         @Override
         public void onInit(int status) {
        	 t1.setLanguage(Locale.UK);
            if(status != TextToSpeech.ERROR) {
               t1.setLanguage(Locale.UK);
            }
         }
      });
      
      
   
      
      
      // START  Speech button click
      b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String toSpeak = ed1.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            animateImageSpeech();
          //Handler delay
            // Temporary  disabled  but  works
			// mHandler.postDelayed(mUpdateTimeTask, 1400);  //2500
         }
      });
  
// END   Speech button click---------------------------------------
   
   
      
      
      
      
      //Start Random Click**********************************
      random.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
        	int randl = (int) (Math.random() * oneLength) ; 
        	 ed1.setText(wordListOne[randl]);
        	 
          }
      });
      //End  Random Click-----------------------------------
      
      
      
      
      
      
      
    //Start Clear Click**********************************
      clear.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
        	  ed1.setText("");
          }
      });
      //End  Clear Click-----------------------------------
 
      
      
      
      
      
      
      //Start Image Click**********************************
      Speechimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	animateImageSpeech();
            }
        });
        //End  Image Click-----------------------------------
      
   
   }
  // ENd onCreate  ?
   
   
   
   
   
   
   //Function animating image
   public  void animateImageSpeech(){
	   Speechimage.setImageResource(R.drawable.soundwave);
		//Animat
   	Animation anim = AnimationUtils.loadAnimation(
   			getApplicationContext(), R.anim.speechanim);
   	Speechimage.startAnimation(anim);
   	
   	//Changing image  back to  original
   	//Speechimage.setImageResource(R.drawable.soundwave);
   }
   //End  Fuction
   
   
   
   
   
   
   
   
   
   //Delayed  changing  bach  to original  image
   private Runnable mUpdateTimeTask = new Runnable() {
	   public void run() {
		   Speechimage.setImageResource(R.drawable.soundwave);
		  // Lanching  changing FLASH png to Waze png
		 //  mHandler.postDelayed(mUpdateTimeTaskSH, 2500);  //  WAS 1500
		     	   }
	};
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void onPause(){
      if(t1 !=null){
         t1.stop();
         t1.shutdown();
      }
      super.onPause();
   }
   
   
   
   
   
   
   
   
 
   
   
   
   
   
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.speech, menu);
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
   
   
   
   
   
} //END Class
