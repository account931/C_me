package com.example.c_me;
//GUESS ME -THE 3rd LEVEL
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
//
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.*;

public class Guess3 extends Activity 
{

	//Announce
	private Button buttonStart;
	
	// Delay handler
	private Handler mHandler = new Handler();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
      //remove  title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_guess3);
        
        //Button
        buttonStart = (Button) findViewById(R.id.buttonstart);
        
      //Imageview
    	final ImageView pat1 = (ImageView) findViewById(R.id.imageViewP21);
    	final ImageView pat2 = (ImageView) findViewById(R.id.imageViewP22);
    	final ImageView pat3 = (ImageView) findViewById(R.id.imageViewP23);
    	final ImageView pat4 = (ImageView) findViewById(R.id.imageViewP24);
    	final ImageView pat5 = (ImageView) findViewById(R.id.imageViewP33);
    	final ImageView pat6 = (ImageView) findViewById(R.id.imageViewP34);
        
    	
    	//NESTED IMAGES
    	//final ImageView pat1n = (ImageView) findViewById(R.id.imageViewP1N);
    	    	
    	
        // Start Load animation
                //Appear 1 image pattern
            	pat1.setImageResource(R.drawable.arr9);
            	//Animat
            	Animation anim = AnimationUtils.loadAnimation(
            			getApplicationContext(), R.anim.fadein);
            	pat1.startAnimation(anim);
            	// End appear 1 st image pattern
             
            	
            	
            	
            	//Appear 2 image pattern
            	pat2.setImageResource(R.drawable.arr92);
            	//Animat
            	pat2.startAnimation(anim);
            	// End appear 2 st image pattern
            	
            	
            	
            	//Appear 3 image pattern
            	pat3.setImageResource(R.drawable.arr92);
            	//Animat
            	pat3.startAnimation(anim);
            	// End appear 3 st image pattern
            	
            	//Appear 4 image pattern
            	pat4.setImageResource(R.drawable.arr9);
            	//Animat
                pat4.startAnimation(anim);
            	// End appear 4 st image pattern
                
              //Appear 5 image pattern
            	pat5.setImageResource(R.drawable.arr9);
            	//Animat
                pat5.startAnimation(anim);
            	// End appear 5 st image pattern
                
              //Appear 6 image pattern
            	pat6.setImageResource(R.drawable.arr92);
            	//Animat
                pat6.startAnimation(anim);
            	// End appear 6 st image pattern
            	//END LOAD ANIMATION
            
        
            	
            	
            	
            	// Start Button click
                     buttonStart.setOnClickListener(new Button.OnClickListener() {
                     public void onClick(View v) // ���� �� ������
                     { 
                     
                    	 
                    	
                    	 
                    	 
                     
                    	 //Appear 1 image pattern
                     	pat1.setImageResource(R.drawable.arr9);
                     	//Animat
                     	Animation anim = AnimationUtils.loadAnimation(
                     			getApplicationContext(), R.anim.fadein);
                     	pat1.startAnimation(anim);
                     	// End appear 1 st image pattern
                      
                     	
                     	
                     	
                     	//Appear 2 image pattern
                     	pat2.setImageResource(R.drawable.arr9);
                     	//Animat
                         pat2.startAnimation(anim);
                     	// End appear 2 st image pattern
                     	
                     	
                     	
                     	//Appear 3 image pattern
                     	pat3.setImageResource(R.drawable.arr9);
                     	//Animat
                     	 pat3.startAnimation(anim);
                        // End appear 3 st image pattern
                     	
                     	//Appear 4 image pattern
                      	pat4.setImageResource(R.drawable.arr9);
                      	//Animat
                      	 pat4.startAnimation(anim);
                         // End appear 4 st image pattern
                      	 
                      	//Appear 5 image pattern
                       	pat5.setImageResource(R.drawable.arr9);
                       	//Animat
                       	 pat5.startAnimation(anim);
                          // End appear 5 st image pattern
                       	 
                       //Appear 6 image pattern
                       	pat6.setImageResource(R.drawable.arr9);
                       	//Animat
                       	 pat6.startAnimation(anim);
                          // End appear 6 st image pattern
                       	 
                       	 
                       	 
                       	 //
                      	Intent intent = new Intent(Guess3.this, Guesswaze.class);
           		        startActivity(intent);
           		        //
           		        
           		        
           		        
                     	
                     }
                 });
               //ENDS Button click
                 
            	
            	
            	
            	
       
      //Random start for 6digits
    	final Random random = new Random();
    	final int randomme=random.nextInt(6) + 1;
    	//END RAndom
        
    	
    	
        //-----------------------------------------------------------------------------------------------
        //1st image click
    	pat1.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    	//buttonStart.setText(randomme);
				//Click
    	    	if(randomme==2 || randomme==3 || randomme==4 || randomme==5 || randomme==6){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat1.startAnimation(anim);
                	// End animation
    	    	    
                	// LOOSE TOAST
                	LostToast();
				//CHANGE IMAGE
				pat1.setImageResource(R.drawable.arr9n);
    	    	
    	    	} 
    	    	
    	    	
    	    	
    	    	else //if(randomme==1)
    	    	{
    	    		
    	    		
    	    		pat1.setImageResource(R.drawable.arr9p);
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat1.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();
    	    		/*
    	    		Toast toastMus = Toast.makeText(getApplicationContext(), 
    						"You are right",
    						Toast.LENGTH_SHORT);
    				toastMus.setGravity(Gravity.CENTER, 0, 0);
    				toastMus.show();  
    				
    	    		*/
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
								     
	    		}
    	    	       	    	    	    	
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
    	    	if(randomme==1 || randomme==3 || randomme==4 || randomme==5 || randomme==6){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat2.startAnimation(anim);
                	// End animation
                	//LOST TOAST FUNCTION
                	LostToast();
				//CHANGE IMAGE
				pat2.setImageResource(R.drawable.arr9n);   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==2)
    	    	{
    	    		
    	    		
                    pat2.setImageResource(R.drawable.arr9p);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat2.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
    	    		
    	    		
			        
    	    	}
    	    	       	    	    	    	
    	    	//end click
    	    }
    	});
    	//2nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //3st image click
    	pat3.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    				//Click
    	    	if(randomme==1 || randomme==2 || randomme==4 || randomme==5 || randomme==6){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat3.startAnimation(anim);
                	// End animation
                	//LOST TOAST FUNCTION
                	LostToast();
				   //CHANGE IMAGE
				pat3.setImageResource(R.drawable.arr9n);   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==3)
    	    	{
    	    		
                    pat3.setImageResource(R.drawable.arr9p);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat3.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
								     }
    	    	       	    	    	    	
    	    	//end click
    	    }
    	});
    	//3nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //4st image click
    	pat4.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    				//Click
    	    	if(randomme==1 || randomme==3 || randomme==2 || randomme==5 || randomme==6){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat4.startAnimation(anim);
                	// End animation
                	//LOST TOAST FUNCTION
                	LostToast();
				   //CHANGE IMAGE
				pat4.setImageResource(R.drawable.arr9n);   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==3)
    	    	{
    	    		
                    pat4.setImageResource(R.drawable.arr9p);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat4.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
								     }
    	    	       	    	    	    	
    	    	//end click
    	    }
    	});
    	//4nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //5st image click
    	pat5.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    				//Click
    	    	if(randomme==1 || randomme==3 || randomme==4 || randomme==2 || randomme==6){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat5.startAnimation(anim);
                	// End animation
                	//LOST TOAST FUNCTION
                	LostToast();
				   //CHANGE IMAGE
				pat5.setImageResource(R.drawable.arr9n);   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==3)
    	    	{
    	    		
                    pat5.setImageResource(R.drawable.arr9p);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat5.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
								     }
    	    	       	    	    	    	
    	    	//end click
    	    }
    	});
    	//5nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	//-----------------------------------------------------------------------------------------------
        //6st image click
    	pat6.setOnClickListener(new View.OnClickListener() {
    	    @Override
    	    public void onClick(View v) {
    	    	//set randomme value
    	    				//Click
    	    	if(randomme==1 || randomme==3 || randomme==4 || randomme==2 || randomme==5){
    	    		
    	    		//Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat6.startAnimation(anim);
                	// End animation
                	//LOST TOAST FUNCTION
                	LostToast();
				   //CHANGE IMAGE
				pat6.setImageResource(R.drawable.arr9n);   } 
    	    	
    	    	
    	    	
    	    	else //if(randomme==3)
    	    	{
    	    		
                    pat6.setImageResource(R.drawable.arr9p);
                  //Animat
                	Animation anim = AnimationUtils.loadAnimation(
                			getApplicationContext(), R.anim.fadeout);
                	pat6.startAnimation(anim);
                	// End animation
    	    		
                	// Win Toast Function
                	WinToast ();  
    				
    	    		//
    				 mHandler.postDelayed(mUpdateTimeTask, 2500);
    	    		// android.os.SystemClock.sleep(2000);
    	    		//reload();
    	    		
								     }
    	    	       	    	    	    	
    	    	//end click
    	    }
    	});
    	//6nd image click
        //-----------------------------------------------------------------------------------------------
    	
    	
        
    //ENDS ON CREATE    
    }
    
    
   
    
    
    //  Delayed Start
    private Runnable mUpdateTimeTask = new Runnable() {
    	   public void run() {
    	       // do what you need to do here after the delay
    		   reload();
    	   }
    	};
    // END Delayed
    
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
	
	
	
	
	// Toast WIn FUNCTION
	public void WinToast ()  {
		Toast toastMus = Toast.makeText(getApplicationContext(), 
				"You are right",
				Toast.LENGTH_SHORT);
		toastMus.setGravity(Gravity.CENTER, 0, 0);
		toastMus.show();  
	}
	// END  Toast WIn FUNCTION
    
	
	
	
	// Toast Lost  FUNCTION
	public void LostToast(){
		Toast toastMus = Toast.makeText(getApplicationContext(), 
				"You are wrong",
				Toast.LENGTH_SHORT);
		toastMus.setGravity(Gravity.CENTER, 0, 0);
		toastMus.show();  
	}
	// END Toast Lost  FUNCTION
	
    
// END of CLASS    
}


   
