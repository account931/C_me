package com.example.c_me;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Guesswaze extends Activity {

	
	
	

	/*USUAL Menu*/
	public static final int IDM_NEW=101;
	public static final int IDM_OPEN=102;
	public static final int IDM_SAVE=103;
	/*END USUAL Menu*/
	
	
	
	
	// Delay handler  // If set after serContentView-DOESNOT WORK
			private Handler mHandler = new Handler();
			
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//remove  title -DO NOT LOCATE AFTER setContentView!!!!!!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		setContentView(R.layout.activity_guesswaze);
		
	
		
		//Imageview
    	final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
    	final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
    	final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
    	
    	// Start Load animation
    	//--------------------------------------------
        //Appear 1 image pattern
    	pat1.setImageResource(R.drawable.wanim);
    	//Animat
    	Animation anim = AnimationUtils.loadAnimation(
    			getApplicationContext(), R.anim.fly);
    	
    	
    	
    	/*
    	anim.setRepeatCount(Animation.INFINITE);
    	anim.setRepeatMode(Animation.RESTART);
    	anim.setInterpolator(new LinearInterpolator());*/
    	//
    	//anim.setRepeatCount(Animation.INFINITE);
    	
    	pat1.startAnimation(anim);
    	// End appear 1 st image pattern
     
    	
    	//----------------------------------------------------------------------------
    	 //Appear 2 image pattern
    	pat2.setImageResource(R.drawable.wanim);
    	//Animat
    	Animation anim2 = AnimationUtils.loadAnimation(
    			getApplicationContext(), R.anim.fly2);

    	pat2.startAnimation(anim2);
    	// End appear 2 st image pattern
    	
    	
    	
//--------------------------------------------------------------------------------------
   	 //Appear 3 image pattern
   	pat3.setImageResource(R.drawable.wanim);
   	//Animat
   Animation anim3 = AnimationUtils.loadAnimation(
   			getApplicationContext(), R.anim.fly3);

   	pat3.startAnimation(anim3);
   	// End appear 2 st image pattern
    	
    	
   	
   	
   	
    //Random start for 3digits
  	final Random random = new Random();
  	final int randomme=random.nextInt(3) + 1;
  	//END RAndom
   	
    //-----------------------------------------------------------------------------------------------
    //1st image click
	pat1.setOnClickListener(new View.OnClickListener() {
	    @Override
	    public void onClick(View v) {
	    	
	    	
			pat1.setImageResource(R.drawable.wanimblank);
			//Handler delay
			 mHandler.postDelayed(mUpdateTimeTask, 200);  //2500
	    	
	  	   
	    	//end click
	    }
	});
	//1nd image click
    //-----------------------------------------------------------------------------------------------
	
	
	
	//2st image click
		pat2.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	
				pat2.setImageResource(R.drawable.wanimblank);
				//Handler delay
				 mHandler.postDelayed(mUpdateTimeTask2, 200);
		  	   
		    	//end click
		    }
		});
		//2nd image click
	    //----------------------------------
    	
		
		
		

		//3st image click
			pat3.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
			    	
			    	
					pat3.setImageResource(R.drawable.wanimblank);
					//Handler delay
					 mHandler.postDelayed(mUpdateTimeTask3, 200);
			  	   
			    	//end click
			    }
			});
			//3nd image click
		    //----------------------------------
    	
			
			
			
			
			//POSITION FIX
			//pat3.setOnClickListener(new OnClickListener() { @Override public void onClick(View view) { Toast.makeText(play_1.this, "Translation Can Click Now!", Toast.LENGTH_SHORT).show(); } }); 
			//END POSITION
			
			
			
    	
	}//ENDS OnCreate---------------------------------------------------------------------------
	
	
	
	
	

	//CREATE usual MENU !!! Should add onClick actioner
		@Override
		public boolean onCreateOptionsMenu (Menu menu){
			menu.add(Menu.NONE, IDM_NEW, Menu.NONE,"NEW GAME");
			menu.add(Menu.NONE, IDM_OPEN, Menu.NONE,"Turn Sound ON");
			menu.add(Menu.NONE, IDM_SAVE, Menu.NONE,"Save me");
			return (super.onCreateOptionsMenu(menu));       }
		//END CREATE usual MENU

	
		//Menu actioner
		@SuppressLint("NewApi")
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    // Handle action bar item clicks here. The action bar will
		    // automatically handle clicks on the Home/Up button, so long
		    // as you specify a parent activity in AndroidManifest.xml.
		    int id = item.getItemId();

		    //noinspection SimplifiableIfStatement
		    if (id == IDM_NEW) {
		    	Intent intent = new Intent(Guesswaze.this, GuessWazeShoot.class);
   		        startActivity(intent);
		    }
		    
		    //second 
		    if (id == IDM_OPEN) {
		    	
		    	 if(item.getTitle().equals("Turn Sound ON")){
	                   item.setTitle("Turn Sound OFF");
	                   
	                // PUT Preferences
	                   SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0);    
	              	    SharedPreferences.Editor editor = mPrefs.edit();  
	              	    editor.putString("keySound", "ON");
	              	    editor.commit();
	   		        
	   				// END PREFERANCES
	                   
	               }else{
	                   item.setTitle("Turn Sound ON");
	                // PUT Preferences
	                   SharedPreferences mPrefs = getSharedPreferences("SoundSetting", 0);    
	              	    SharedPreferences.Editor editor = mPrefs.edit();  
	              	    editor.putString("keySound", "OFF");
	              	  editor.commit();
				 }
		    	
		    	
		    }
		    
		    //Third menu  item =Round image //
		    if (id == IDM_SAVE) {
		 	
		    }
		    
		  
		    return super.onOptionsItemSelected(item);
		}
		//End menu actioner
	
	
	
	
	
// 1st image  Delayed runnable-------------------------------------------------------------------------------------------
	
//  Delayed Start -Shift Waze png to flash effect-------------------------------------------------------------
    private Runnable mUpdateTimeTask = new Runnable() {
    	   public void run() {
    		   final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
    		   pat1.setImageResource(R.drawable.wanimblank22);
    		   
    	// 
    		  // Lanching  changing FLASH png to Waze png
    		   mHandler.postDelayed(mUpdateTimeTaskSH, 1500); 
    		// END Lanching  changing FLASH png to Waze png
    		   
    		   
    	       // do what you need to do here after the delay
    		   //reload();
    	   }
    	};
    // END Delayed
    	
    	
    	
    	
    	
    	
    	
    	
    	
    //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
        private Runnable mUpdateTimeTaskSH = new Runnable() {
        	   public void run() {
        		   final ImageView pat1 = (ImageView) findViewById(R.id.imageViewWaze);
        		   pat1.setImageResource(R.drawable.wanim);
        		   
        	// 
        		  
        	   }
        	};
        // END Delayed--------------------------------------------------------------------------------------------------------
    	
        	
        	//  END  111111st image  Delayed runnable- -----------------------------------------------------------------------------------
        	
    	
    	
        	
        	
        	
        	
        	
        	
        	
        	// 2st image  Delayed runnable-------------------------------------------------------------------------------------------
        	
        //  Delayed Start -Shift Waze png to flash effect-------------------------------------------------------------
            private Runnable mUpdateTimeTask2 = new Runnable() {
            	   public void run() {
            		   final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
            		   pat2.setImageResource(R.drawable.wanimblank22);
            		   
            	// 
            		  // Lanching  changing FLASH png to Waze png
            		   mHandler.postDelayed(mUpdateTimeTaskSH2, 1500); 
            		// END Lanching  changing FLASH png to Waze png
            		   
            		   
            	       // do what you need to do here after the delay
            		   //reload();
            	   }
            	};
            // END Delayed
            	
            	
            	
            	
            	
            	
            	
            	
            	
            //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
                private Runnable mUpdateTimeTaskSH2 = new Runnable() {
                	   public void run() {
                		   final ImageView pat2 = (ImageView) findViewById(R.id.imageViewWaze2);
                		   pat2.setImageResource(R.drawable.wanim);
                		   
                	// 
                		  
                	   }
                	};
                // END Delayed--------------------------------------------------------------------------------------------------------
            	
                	
 //  END  2st image  Delayed runnable- -----------------------------------------------------------------------------------
                	
                	
                	
                	
                	
                	
                	
                	
                	// 3st image  Delayed runnable-------------------------------------------------------------------------------------------
                	
                    //  Delayed Start -Shift Waze png to flash effect-------------------------------------------------------------
                        private Runnable mUpdateTimeTask3 = new Runnable() {
                        	   public void run() {
                        		   final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
                        		   pat3.setImageResource(R.drawable.wanimblank22);
                        		   
                        	// 
                        		  // Lanching  changing FLASH png to Waze png
                        		   mHandler.postDelayed(mUpdateTimeTaskSH3, 1500); 
                        		// END Lanching  changing FLASH png to Waze png
                        		   
                        		   
                        	       // do what you need to do here after the delay
                        		   //reload();
                        	   }
                        	};
                        // END Delayed
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                        //  mUpdateTimeTaskSH- -Shift  flash effect to WAZE LOGO again // Lauched from  mUpdateTimeTask-------------------------------------------------------------
                            private Runnable mUpdateTimeTaskSH3 = new Runnable() {
                            	   public void run() {
                            		   final ImageView pat3 = (ImageView) findViewById(R.id.imageViewWaze3);
                            		   pat3.setImageResource(R.drawable.wanim);
                            		   
                            	// 
                            		  
                            	   }
                            	};
                            // END Delayed--------------------------------------------------------------------------------------------------------
                        	
                            	
                            	//  END  3st image  Delayed runnable- -----------------------------------------------------------------------------------
                            	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
        	
        	
        	
        	
	

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guesswaze, menu);
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
	}  */
}
