package com.example.c_me;
//GUESS ME
import android.support.v7.app.ActionBarActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.annotation.SuppressLint;
//
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.*;

public class Weather extends Activity 
{


	/*USUAL Menu*/
	public static final int IDM_NEW=101;
	public static final int IDM_OPEN=102;
	public static final int IDM_SOUND=103;
	//public static final int IDM_SAVE=103;
	/*END USUAL Menu*/
	
	
	
	//Announce
	private Button buttonStart;
	
	// Delay handler
	private Handler mHandler = new Handler();
	
	//Sound
			MediaPlayer mediaPlayer;
			 public String one;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
     
        
        
        setContentView(R.layout.activity_weather);
        
        //Button
        buttonStart = (Button) findViewById(R.id.buttonstart);
        
      //Imageview
    	final ImageView pat1 = (ImageView) findViewById(R.id.imageViewP1);
    	final ImageView pat2 = (ImageView) findViewById(R.id.imageViewP2);
    	final ImageView pat3 = (ImageView) findViewById(R.id.imageViewP3);
        
    	
    	//NESTED IMAGES
    	//final ImageView pat1n = (ImageView) findViewById(R.id.imageViewP1N);
    	    	
    	//Music on the background
    	/*mediaPlayer = MediaPlayer.create(this, R.raw.stones);
    	mediaPlayer.setVolume(0, 3);
    	mediaPlayer.setLooping(true);
        mediaPlayer.start();*/
    	
    	
        // Start Load animation
                //Appear 1 image pattern
            	pat1.setImageResource(R.drawable.gms1);
            	//Animat
            	Animation anim = AnimationUtils.loadAnimation(
            			getApplicationContext(), R.anim.fadein);
            	pat1.startAnimation(anim);
            	// End appear 1 st image pattern
             
            	
            	
            	
            	//Appear 2 image pattern
            	pat2.setImageResource(R.drawable.gms1);
            	//Animat
            	Animation anim2 = AnimationUtils.loadAnimation(
            			getApplicationContext(), R.anim.fadein);
            	pat2.startAnimation(anim2);
            	// End appear 2 st image pattern
            	
            	
            	
            	//Appear 3 image pattern
            	pat3.setImageResource(R.drawable.gms1);
            	//Animat
            	//Animation anim2 = AnimationUtils.loadAnimation(
            			//getApplicationContext(), R.anim.fadein);
            	pat3.startAnimation(anim2);
            	// End appear 3 st image pattern
            	//END LOAD ANIMATION
            
        
            	
            	
            	
            	// Start Button click
                     buttonStart.setOnClickListener(new Button.OnClickListener() {
                     public void onClick(View v) // ÍÎËÍ Ì‡ ÍÌÓÔÍÛ
                     { 
                     
                    	 // Temporary disabled Move to Gueess2
                    	 /*Intent intentLevel2 = new Intent(Weather.this, Guess2.class);
     			        startActivity(intentLevel2);*/
                    	 //   
                    	 
                     	//Appear 1 image pattern
                     	pat1.setImageResource(R.drawable.gms1);
                     	//Animat
                     	Animation anim = AnimationUtils.loadAnimation(
                     			getApplicationContext(), R.anim.fadein);
                     	pat1.startAnimation(anim);
                     	// End appear 1 st image pattern
                      
                     	
                     	
                     	
                     	//Appear 2 image pattern
                     	pat2.setImageResource(R.drawable.gms1);
                     	//Animat
                     	Animation anim2 = AnimationUtils.loadAnimation(
                     			getApplicationContext(), R.anim.fadein);
                     	pat2.startAnimation(anim2);
                     	// End appear 2 st image pattern
                     	
                     	
                     	
                     	//Appear 3 image pattern
                     	pat3.setImageResource(R.drawable.gms1);
                     	//Animat
                     	//Animation anim2 = AnimationUtils.loadAnimation(
                     			//getApplicationContext(), R.anim.fadein);
                     	pat3.startAnimation(anim2);
                     	// End appear 3 st image pattern
                     	
                     	
                     }
                 });
               //ENDS Button click
                 
            	
            	
            	
            	
       
      //Random start
    	final Random random = new Random();
    	final int randomme=random.nextInt(3) + 1;
    	//END RAndom
        
    	
    	
        //-----------------------------------------------------------------------------------------------
        //1st image click
    	pat1.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    	//buttonStart.setText(randomme);
				//Click
    	    	if(randomme==2 || randomme==3){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat1.startAnimation(anim);
                	// End animation
    	    	Toast toastMus = Toast.makeText(getApplicationContext(), 
						"You are wrong",
						Toast.LENGTH_SHORT);
				toastMus.setGravity(Gravity.CENTER, 0, 0);
				toastMus.show();  
				//CHANGE IMAGE
				pat1.setImageResource(R.drawable.gms1rej2);
				gunshot(); //Play sound if  u loose
    	    	
    	    	} 
    	    	
    	    	
    	    	
    	    	else //if(randomme==1)
    	    	{
    	    		/*Toast toastMus = Toast.makeText(getApplicationContext(), 
    						"You are right.1",
    						Toast.LENGTH_SHORT);
    				toastMus.setGravity(Gravity.CENTER, 0, 0);
    				toastMus.show();  
    				Intent intentWeth = new Intent(Weather.this, Weather.class);
			        startActivity(intentWeth); */
    	    	
    	    		/*AlertDialog.Builder builder = new AlertDialog.Builder(Weather.this);
		    		builder.setTitle(" You are right")
					.setMessage("     It is  1  ")
					.setCancelable(false)
					.setNegativeButton("Œkay",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
									Intent intentWeth = new Intent(Weather.this, Weather.class);
							        startActivity(intentWeth);
								}
							});
			AlertDialog alert = builder.create();
			alert.show(); */
    	    		
    	    		pat1.setImageResource(R.drawable.gms1aprrwin);
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat1.startAnimation(anim);
                	// End animation
    	    		
    	    		//
    	    		Toast toastMus = Toast.makeText(getApplicationContext(), 
    						"You are right",
    						Toast.LENGTH_SHORT);
    				toastMus.setGravity(Gravity.CENTER, 0, 0);
    				toastMus.show();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    				 winSound();
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
								     
	    		}
    	    	 //Playing sound  Shared PreFerenace.WORKS .Sting one is  also working
    	    	/*RETURN   SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Weather.this);
			    String tempNameS = pref.getString("SoundPref",""); 
			    //String Sample="SoundON";
			    //if (tempNameS=="SoundON")         if (tempNameS.equals(Sample))
			   // if (one=="ON")
			    if (tempNameS=="SoundON")
			    { gunshot(); }*/
    	    	//end click
			  
    	    }
    	});
    	//1nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //2st image click
    	pat2.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    	//buttonStart.setText(randomme);
				//Click
    	    	if(randomme==1 || randomme==3){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat2.startAnimation(anim);
                	// End animation
    	    	Toast toastMus = Toast.makeText(getApplicationContext(), 
						"You are wrong",
						Toast.LENGTH_SHORT);
				toastMus.setGravity(Gravity.CENTER, 0, 0);
				toastMus.show();
				//CHANGE IMAGE
				pat2.setImageResource(R.drawable.gms1rej2);
				gunshot();   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==2)
    	    	{
    	    		/*AlertDialog.Builder builder = new AlertDialog.Builder(Weather.this);
		    		builder.setTitle(" You are right")
					.setMessage("    It is  2  ")
					.setCancelable(false)
					.setNegativeButton("Œkay",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
									Intent intentWeth = new Intent(Weather.this, Weather.class);
							        startActivity(intentWeth);
								}
							});
			AlertDialog alert = builder.create();
			alert.show(); */
    	    		
    	    		
                    pat2.setImageResource(R.drawable.gms1aprrwin);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat2.startAnimation(anim);
                	// End animation
    	    		
    	    		//
    	    		Toast toastMus = Toast.makeText(getApplicationContext(), 
    						"You are right",
    						Toast.LENGTH_SHORT);
    				toastMus.setGravity(Gravity.CENTER, 0, 0);
    				toastMus.show();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    				 winSound();
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    	 
    	    	} // END IF ELSE
    	    	
    	    	
    	    	
    	    	
    	    }
    	});//end click
    	//2nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //3st image click
    	pat3.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    	//buttonStart.setText(randomme);
				//Click
    	    	if(randomme==2 || randomme==1){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat3.startAnimation(anim);
                	// End animation
    	    	Toast toastMus = Toast.makeText(getApplicationContext(), 
						"You are wrong",
						Toast.LENGTH_SHORT);
				toastMus.setGravity(Gravity.CENTER, 0, 0);
				toastMus.show();   //CHANGE IMAGE
				pat3.setImageResource(R.drawable.gms1rej2); 
				gunshot(); } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==3)
    	    	{
    	    		/*AlertDialog.Builder builder = new AlertDialog.Builder(Weather.this);
		    		builder.setTitle(" You are right")
					.setMessage("    It is 3  ")
					.setCancelable(false)
					.setNegativeButton("Œkay",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
									Intent intentWeth = new Intent(Weather.this, Weather.class);
							        startActivity(intentWeth);
								}
							});
			AlertDialog alert = builder.create();
			alert.show();  */
    	    		
    	    		
    	    		
                    pat3.setImageResource(R.drawable.gms1aprrwin);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat3.startAnimation(anim);
                	// End animation
    	    		
    	    		//
    	    		Toast toastMus = Toast.makeText(getApplicationContext(), 
    						"You are right",
    						Toast.LENGTH_SHORT);
    				toastMus.setGravity(Gravity.CENTER, 0, 0);
    				toastMus.show();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    				 winSound();
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
								     } //END IF ELSE
    	    	     	    	    	    	
    	    	
    	    }
    	}); //end click
    	//3nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
    //ENDS ON CREATE    
    }
    
    
   
    
    
    
    

	//CREATE usual MENU !!! Should add onClick actioner
		@Override
		public boolean onCreateOptionsMenu (Menu menu){
			menu.add(Menu.NONE, IDM_OPEN, Menu.NONE,"Change B-ground");
			menu.add(Menu.NONE, IDM_NEW, Menu.NONE,"Default");
			menu.add(Menu.NONE, IDM_SOUND, Menu.NONE,"Turn Sound on");
		//menu.add(Menu.NONE, IDM_SAVE, Menu.NONE,"Save me");
			return (super.onCreateOptionsMenu(menu));       }
		//END CREATE usual MENU

	
		//Menu actioner
		//@SuppressLint("NewApi")
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    // Handle action bar item clicks here. The action bar will
		    // automatically handle clicks on the Home/Up button, so long
		    // as you specify a parent activity in AndroidManifest.xml.
		    int id = item.getItemId();

		    
		    //Change  background
		    //noinspection SimplifiableIfStatement
		    if (id == IDM_NEW) {
		    	 LinearLayout mainLayoutGuess = (LinearLayout)findViewById(R.id.relativeLayoutGuess);
		    	mainLayoutGuess.setBackgroundResource(0);      }
		    
		    //second   Change  to default background
		   if (id == IDM_OPEN) {
			   LinearLayout mainLayoutGuess = (LinearLayout)findViewById(R.id.relativeLayoutGuess);
			   mainLayoutGuess.setBackgroundResource(R.drawable.pattern);   }
		   
		   
		 //3rd   Sound On
		   if (id == IDM_SOUND) {
			   //Change Text  and  set FLAG STRING
			   if(item.getTitle().equals("Turn Sound on")){
                   item.setTitle("Turn Sound OFF");one="ON";
                   
                // Preferences
   		    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Weather.this);
   		        pref.edit().putString("SoundPref", "SoundON").commit(); 
   		        
   				// END PREFERANCES
                   
               }else{
                   item.setTitle("Turn Sound on");one="OFF";
			// Preferences
  		    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Weather.this);
  		        pref.edit().putString("SoundPref", "SoundOFF").commit(); }
  		        
  				// END PREFERANCES
			   // End Chage text
			   
			   
			   
			     }
		    // END 3rd 
		   
		   
		   
		    //Third menu  item =Round image //   temporary deactivated as no need
		   /* if (id == IDM_SAVE) {
		 	
		    } */
		    
		  
		    return super.onOptionsItemSelected(item);
		}
		//End menu actioner
	
    
    
    
    
    
    
    
    
    //  Delayed Start
    private Runnable mUpdateTimeTask = new Runnable() {
    	   public void run() {
    	       // do what you need to do here after the delay
    		   
    		   //INSERTED FOR TEST
    		   //
          	 Intent intentLevel2 = new Intent(Weather.this, Guess2.class);
		        startActivity(intentLevel2);
    		   //
    		  // RELOAD FUNCTION IS TEMPORARY DISABLED
		        //reload();
    	   }
    	};
    // END Delayed
    
  //Reload fuction***************************************************
	public void reload() {

	    Intent intent = getIntent();
	    overridePendingTransition(0, 0);
	    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	    finish();

	    overridePendingTransition(0, 0);
	    startActivity(intent);
	}
	//END RELOAD
    
    
	// Fuction Plays  sounnd if you loose**********************************
	public  void gunshot(){
	//Playing sound  Shared PreFerenace.WORKS .Sting one is  also working
	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Weather.this);
    String tempNameS = pref.getString("SoundPref",""); 
 	 if (tempNameS=="SoundON") {
	//

 if (mediaPlayer != null) {
	  mediaPlayer.release();
	  mediaPlayer = null;
    }
    try {
    	mediaPlayer = MediaPlayer.create(this, R.raw.slash);
	  	 mediaPlayer.start();
    } catch (Exception e) {
        e.printStackTrace();
    }   }  // END if (tempNameS=="SoundON")
 	}
// END Sound if  loose

	
	
	
	
	
	// START Sound if  you win*************************************
	public void winSound(){
		//Playing sound  Shared PreFerenace.WORKS .Sting one is  also working
    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(Weather.this);
	    String tempNameS = pref.getString("SoundPref",""); 
	 	 if (tempNameS=="SoundON") {
		//
	
	 if (mediaPlayer != null) {
		  mediaPlayer.release();
		  mediaPlayer = null;
	    }
	    try {
	    	mediaPlayer = MediaPlayer.create(this, R.raw.win);
		  	 mediaPlayer.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }   }  // END if (tempNameS=="SoundON")
	 	}
	// END Sound if  you win
	
	
	
	
	
	
	
	
	
	
	
// END of CLASS    
}


   
