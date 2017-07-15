package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class GuessWazeShoot extends Activity {
	
	
	
	// Delay handler  // If set after serContentView (onCreate)-DOESNOT WORK
				private Handler mHandler = new Handler();
				
				
				MediaPlayer mediaPlayer;
				MediaPlayer mediaPlayer2;
				String str;
				Thread myThread;
				
				Rect rc1;
				Rect rc2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//remove  title -DO NOT LOCATE AFTER setContentView!!!!!!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_guess_waze_shoot);
		
		
		
		//Imageview Waze
    	final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
    	final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
    	final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
		
		
    	// ImageView Tanks
    	final  ImageView tank1 = (ImageView) findViewById(R.id.imageTank1);
    	final ImageView tank2 = (ImageView) findViewById(R.id.imageTank2);
    	final ImageView tank3 = (ImageView) findViewById(R.id.imageTank3);
    	// End Tanks
    	
    	
    	
		
    	
    	
    	
    	// COLLISION
    			 Rect rc1 = new Rect();
    			 pat1.getDrawingRect(rc1);
    			 Rect rc2 = new Rect();
    			 tank1.getDrawingRect(rc2);
    			 if (Rect.intersects(rc1, rc2) )
    					 {
    				 Toast toastMus = Toast.makeText(getApplicationContext(), 
    							"You are CRASHED",
    							Toast.LENGTH_SHORT);
    					toastMus.setGravity(Gravity.CENTER, 0, 0);
    					toastMus.show();  

    			   // intersection is detected
    			   // here is your method call
    			 }
    	 	   // END COLLINSION
    	
    	
    	
    	
    	
    	//Animat------------------------------------------------------------------------
    	
    	//Appear 1 image pattern
    	pat1.setImageResource(R.drawable.wanim);
    	//Animat
    	Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flyshoot);
    	pat1.startAnimation(anim2);
    	// End appear 1 st image pattern
    	
    	
    	//Appear 2 image pattern
    	pat2.setImageResource(R.drawable.wanim);
    	//Animat
    	Animation anim22 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flyshoot2);
    	pat2.startAnimation(anim22);
    	// End appear 2 st image pattern
    	
    	//Appear 3 image pattern
    	pat3.setImageResource(R.drawable.wanim);
    	//Animat
    	pat3.startAnimation(anim2);
    	// End appear 3 st image pattern
    	
    	//END ANIMATE-------------------------------------------------------------------------------
		
		
    	
    	
    	
    	
    	
    	
    	
    	//Tanks  Firing--------------------------------------------------------------------
    	
    	//1st Tank Cick
    	tank1.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	
    	    	tank1.setImageResource(R.drawable.tankfire);
    			//tank1.setImageResource(R.drawable.tank);
    			tank2.setImageResource(android.R.color.transparent);
    			tank3.setImageResource(android.R.color.transparent);
    			
    			
    			pat1.setImageResource(R.drawable.wanimblank);
    			//Handler delay
    			 mHandler.postDelayed(mUpdateTimeTask, 200);  //2500
    			 
    			 //Get Sound  menu option
    			 SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0); 
    		    	String str = mPrefs.getString("keySound", "");
    			 if(str=="ON"){shootsound();}  // NO THREAD
    	    	//end click
    	    }
    	});
    	// END 1st Tank Cick
    	
    	
    	
    	//2st Tank Cick  3 IN REAL!!!!
    	tank3.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	
    	    	 tank3.setImageResource(R.drawable.tankfire);
    			//tank3.setImageResource(R.drawable.tank);
    			tank2.setImageResource(android.R.color.transparent);
    			tank1.setImageResource(android.R.color.transparent);
    			
    			pat3.setImageResource(R.drawable.wanimblank);
    			//Handler delay
    			 mHandler.postDelayed(mUpdateTimeTask2, 200);  //2500
    	  	   
    			//Get Sound  menu option
    			 SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0); 
    		    	String str = mPrefs.getString("keySound", "");
    			 if(str=="ON"){shootsound();}
    	    	//end click
    	    }
    	});
    	// END 2st Tank Cick
    	
    	
    	
    	
    	

    	//3st Tank Cick  2nd IN REAL
    	tank2.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	
    	    	 tank2.setImageResource(R.drawable.tankfire);
    			//tank2.setImageResource(R.drawable.tank);
    			tank1.setImageResource(android.R.color.transparent);
    			tank3.setImageResource(android.R.color.transparent);
    			
    			pat2.setImageResource(R.drawable.wanimblank);
    			//Handler delay
    			 mHandler.postDelayed(mUpdateTimeTask3, 200);  //2500
    			 
    			 
    			//Get Sound  menu option
    			 SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0); 
    		    	String str = mPrefs.getString("keySound", "");
    			 if(str=="ON"){shootsound();}
    	    	//end click
    	    }
    	});
    	// END 2st Tank Cick
    	
    	
    	
    	//END Tanks  Firing--------------------------------------------------------------------
    	
    	
    	
    	
    	// STARTING SOUND (1st getting  value  from another activity)
    	SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0); 
    	String str = mPrefs.getString("keySound", ""); 
    	if(str=="ON")
    	/*{mediaPlayer = MediaPlayer.create(this, R.raw.bomber);
    	 mediaPlayer.setLooping(true);
         mediaPlayer.start();}*/
    	
    	//New Threat
    	{bgr();} // End Threat
    	
    	
    	
	}  // END onCREATE

	
	
	
	
	// New Thread function  for  background  music**************************************
	public void bgr(){
		Thread myThread = new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	       //
    	    	playbgrmusic();
    	      	       	   }
    	});  
    	myThread.start();
    	
			}
	
	
	// Play background music in Background THREAD
	public void playbgrmusic()
	{
	//
		 if (mediaPlayer != null) {
			  mediaPlayer.release();
			  mediaPlayer = null;
		    }
		    try {
		    	mediaPlayer = MediaPlayer.create(this, R.raw.bomber);
		   	 mediaPlayer.setLooping(true);
		        mediaPlayer.start();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		//

     }
	// END  New Thread function  for  background  music------------
	
	
	
	
	
	// Sound  when Tank fires**********
	public void shootsound()
	{
			//
		  if (mediaPlayer2 != null) {
			  mediaPlayer2.release();
			  mediaPlayer2 = null;
		    }
		    try {
		    	mediaPlayer2 = MediaPlayer.create(this, R.raw.gunshotshort);
			  	 mediaPlayer2.start();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		//
    	   }
    	//END  Sound  when Tank fires
	
	
	
//  Delayed Start -Shift Waze png to flash effect**************************************************************************
	// 1st Image START
    private Runnable mUpdateTimeTask = new Runnable() {
    	   public void run() {
    		   final  ImageView tank1 = (ImageView) findViewById(R.id.imageTank1);
    		   tank1.setImageResource(R.drawable.tank);
    		   final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
    		   pat1.setImageResource(R.drawable.wanimblank22);
    		   
    	// 
    		  // Lanching  changing FLASH png to Waze png
    		   mHandler.postDelayed(mUpdateTimeTaskSH, 2500);  //  WAS 1500
    		// END Lanching  changing FLASH png to Waze png
    	     	   }
    	};
    // END Delayed
	
	
    	
    //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
        private Runnable mUpdateTimeTaskSH = new Runnable() {
        	   public void run() {
        		   final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
        		   pat1.setImageResource(R.drawable.wanim);
        		  
        	   }
        	};
        // END Delayed 1 st Image
        	
        	
        	
        	
        	
        	
        	// 2st Image START   3RD IN REAL
            private Runnable mUpdateTimeTask2 = new Runnable() {
            	   public void run() {
            		   final  ImageView tank3 = (ImageView) findViewById(R.id.imageTank3);
            		   tank3.setImageResource(R.drawable.tank);
            		   
            		   final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
            		   pat3.setImageResource(R.drawable.wanimblank22);
            		   
            	// 
            		  // Lanching  changing FLASH png to Waze png
            		   mHandler.postDelayed(mUpdateTimeTaskSH2,  2500);  //  WAS 1500 
            		// END Lanching  changing FLASH png to Waze png
            	     	   }
            	};
            // END Delayed
        	
        	
            	
            //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
                private Runnable mUpdateTimeTaskSH2 = new Runnable() {
                	   public void run() {
                		  // final  ImageView tank2 = (ImageView) findViewById(R.id.imageTank2);
                		  // tank2.setImageResource(R.drawable.tank);
                		   
                		   final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
                		   pat3.setImageResource(R.drawable.wanim);
                		  
                	   }
                	};
                // END Delayed 2 st Image
            	
        	
        	
                	
                	
                	
                	// 3st Image START
                    private Runnable mUpdateTimeTask3 = new Runnable() {
                    	   public void run() {
                    		   
                    		   final  ImageView tank2 = (ImageView) findViewById(R.id.imageTank2);
                    		   tank2.setImageResource(R.drawable.tank);
                    		   
                    		   final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
                    		   pat2.setImageResource(R.drawable.wanimblank22);
                    		   
                    	// 
                    		  // Lanching  changing FLASH png to Waze png
                    		   mHandler.postDelayed(mUpdateTimeTaskSH3, 2500);  //  WAS 1500 
                    		// END Lanching  changing FLASH png to Waze png
                    	     	   }
                    	};
                    // END Delayed
                	
                	
                    	
                    //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
                        private Runnable mUpdateTimeTaskSH3 = new Runnable() {
                        	   public void run() {
                        		   final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
                        		   pat2.setImageResource(R.drawable.wanim);
                        		   
                        		
                        		  
                        	   }
                        	};
                        // END Delayed 3 st Image
                    	
        	
    	
        	
        	//  END   image  Delayed runnable- ---------------------------------------------------------------------------
	
	
        	
        	
        // END  Delayed Start -Shift Waze png to flash effect-----------------------------------------------------------------------------      	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guess_waze_shoot, menu);
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
	
	
	// On DESTROY
	 @Override
	    public void onDestroy(){
	        // Очистите все ресурсы. Это касается завершения работы
	        // потоков, закрытия соединений с базой данных и т. д.
		   mediaPlayer.stop();
		   mediaPlayer.reset();
		   mediaPlayer.release();
		   
		   mediaPlayer2.stop();
		   mediaPlayer2.reset();
		   mediaPlayer2.release();
		   
		  
		   
		   if (mediaPlayer != null) {
				  mediaPlayer.release();
				  mediaPlayer = null;
			    }
		   
		   
		   
		   if (myThread != null)
		    {
			   myThread = null;
		    }
		   
		
	        super.onDestroy();
	    } // END On DESTROY
	
	
} // CLASS ENDS
