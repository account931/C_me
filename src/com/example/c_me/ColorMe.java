package com.example.c_me;

import android.support.v7.app.ActionBarActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.Matrix;

public class ColorMe extends /*ActionBar*/Activity {
	
	
	//LinearLayout mainLayout = (LinearLayout)findViewById(R.id.mainlayout);
	LinearLayout Linear1;
	LinearLayout Linear2;
	LinearLayout Linear3;
	LinearLayout Linear4;
	
	
	// Handler  for  timer  every  second
	 Handler handler = new Handler();public int count=0;
	 Handler handler2 = new Handler();public int count2=0;
	 Handler handler3 = new Handler();public int count3=0;
	 Handler handler4 = new Handler();public int count4=0;
	 
	 public AlertDialog builder;
	 
	 public int anDuration=5000; // duration of  animation  CHANGED IN MENU ONLY
	 public int countSec=5; // how many  secons  to  count  to  fail  CHANGED IN MENU ONLY

	 
	 
	// Delay handler -for  delaying start when u press  Menu  start  button
	 Handler mHandler2 = new Handler();
	 Handler mHandler3 = new Handler();
	 Handler mHandler4 = new Handler();
	 
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_me);
		
		
		Linear1 = (LinearLayout)findViewById(R.id.Linear1);
		Linear2 = (LinearLayout)findViewById(R.id.Linear2);
		Linear3 = (LinearLayout)findViewById(R.id.Linear3);
		Linear4 = (LinearLayout)findViewById(R.id.Linear4);
		
		
		
		
		
		// Start Linear1 click
		Linear1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            //
	        	 /*handler.removeCallbacks(this);*/ //handler.removeMessages(0);handler.removeCallbacksAndMessages(null);
	        	 Colorme(Linear1); 
	        	 ViewAnimation cc = new ViewAnimation(); //cc.cancel();cc.reset();
	        	 Linear1.startAnimation(cc);
	        	timerCountt();
	        	
	        	
	      	  }
	      });
		// End Linear1 click
		
		
		
		
		
		// Start Linear2 click
				Linear2.setOnClickListener(new View.OnClickListener() {
			         @Override
			         public void onClick(View v) {
			            //
			        	 Colorme(Linear2);
			        	 Linear2.startAnimation(new ViewAnimation());
			        	 timerCountt2();
			      	  }
		         });
				// End Linear2 click
				
				
				
				
				
				
				// Start Linear3 click
				Linear3.setOnClickListener(new View.OnClickListener() {
			         @Override
			         public void onClick(View v) {
			            //
			        	 Colorme(Linear3);
			        	 Linear3.startAnimation(new ViewAnimation());
			        	 timerCountt3();
			      	  }
			      });
				// End Linear1 click
		
		
		
		
		
				
				
				
				
				

				// Start Linear4 click
				Linear4.setOnClickListener(new View.OnClickListener() {
			         @Override
			         public void onClick(View v) {
			            //
			        	 Colorme(Linear4);
			        	 Linear4.startAnimation(new ViewAnimation());
			        	 timerCountt4();
			      	  }
			      });
				// End Linear1 click
				
				
				
				
				
				
				
				
				
				 //Was attempted  to make  an animationListener
//				
			    /*Linear1.setLayoutAnimationListener(new AnimationListener() {

		            @Override
		            public void onAnimationStart(Animation animation) {
		            	Toast.makeText(getApplicationContext(),
								"one1" , Toast.LENGTH_SHORT).show();
		            }

		            @Override
		            public void onAnimationRepeat(Animation animation) {}

		            @Override
		            public void onAnimationEnd(Animation animation) {
		            	Toast.makeText(getApplicationContext(),
								"one" , Toast.LENGTH_SHORT).show();
		            }
		        });*/
			    //
			   
				
				
				
				
				
				
				
		
	} //End onCreate

	
	
	
	
	
	
	
	
	
	
	// Fuction to  change  color
	public  void Colorme(LinearLayout v){
		 Random rnd = new Random(); 
    	 int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));  
    	 //add Toast to track  digits and  comapre
    	 v.setBackgroundColor(color);
	}
	//End  Function change  color
	
	
	
	
	
	
	
	





//  Class   to  stretch
	public class ViewAnimation extends Animation {
		
		
		int centerX, centerY;
		
		@Override
		public void initialize(int width, int height, int parentWidth,
				int parentHeight) {
			super.initialize(width, height, parentWidth, parentHeight);
			setDuration(anDuration);//5000
			setFillAfter(true);
			setInterpolator(new LinearInterpolator());
			centerX = width / 2;
			centerY = height / 2;
		}
	    @Override
	    protected void applyTransformation(float interpolatedTime,
	      Transformation t) {
	        final Matrix matrix = t.getMatrix();
	        matrix.setScale(interpolatedTime, interpolatedTime);
	    }
	    //
	    
	    
	    
	}
// END   Class   to  stretch





	
	// Timer Function Start************************************************************
	public void timerCountt(){
		
		
	//http://stackoverflow.com/questions/16748438/java-how-to-increment-an-int-1-every-second-until-it-gets-to-15	
		
		count=0;
		handler.removeCallbacksAndMessages(null);

		//Working
		handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            	
                if (++count < countSec/*5*/) {
                    handler.postDelayed(this, 1000L);
                    return;
                } 
                checkFail();
               // else if( (count == 5)||(count2 == 5) ) {show();}

                handler.removeCallbacks(this);
            }
        }, 1000L);

	  
		
	        
	        
	        
	        
	        
	        //Original
	        /* Handler handler = new Handler();


    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (++counter < 15) {
                    handler.postDelayed(this, 1000L);
                    return;
                }

                handler.removeCallbacks(this);
            }
        }, 1000L);

   }*/
	        // End Original
	        
	        
	        
	        
	        
	        
	        
	        
		
		
		//*****************
		/*final Handler handler = new Handler();
	    final Thread r = new Thread() {
	        public void run() {
	            // DO WORK
	          
	        	//
	        	if (++count < 5) {
                    handler.postDelayed(this, 1000L);
                    return;
                }
                else {
                handler.removeCallbacks(this);show();}
	        	//
	        	
	            // Call function.
	            handler.postDelayed(this, 1000L); //1000000
	        }
	    };
	    r.start(); // THIS IS DIFFERENT
		   
		   */
		
		//-------------------
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	        
	       
	        
	        
	        
	        
		
		
		/*int delay = 0; // delay for 5 sec. 5000
		int period = 1000; // repeat every sec.
		count = 0;
		    Timer timer = new Timer();
		    timer.scheduleAtFixedRate(new TimerTask()
		        {
		            public void run()
		            {
		               // Your code

		                count++;
		               
    		            }
		            
		        }, delay, period);*/
		    
		   
	}
	// End timer Function ---------------------------------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Timer2 Function Start************************************************************
		public void timerCountt2(){
		
			count2=0;
			handler2.removeCallbacksAndMessages(null);

			//Working
			handler2.postDelayed(new Runnable() {
	            @Override
	            public void run() {
	            	
	                if (++count2 < countSec/*5*/) {
	                    handler2.postDelayed(this, 1000L);
	                    return;
	                }  
	                checkFail();
	               // else if (count2 == 5)   {show();}

	                handler2.removeCallbacks(this);
	            }
	        }, 1000L);  }
		// END Timer2 Function Start************************************************************
	
	
	
	
	
	
	
	
		
		
		
		
		

		// Timer3 Function Start************************************************************
			public void timerCountt3(){
			
				count3=0;
				handler3.removeCallbacksAndMessages(null);

				//Working
				handler3.postDelayed(new Runnable() {
		            @Override
		            public void run() {
		            	
		                if (++count3 < countSec/*5*/) {
		                    handler3.postDelayed(this, 1000L);
		                    return;
		                } 
		                checkFail();
		                //else if (count3 == 5)   {show();}

		                handler3.removeCallbacks(this);
		            }
		        }, 1000L);  }
			// END Timer2 Function Start************************************************************
		
			
			
			
			
			
			
			
			
			
			
			// Timer4 Function Start************************************************************
						public void timerCountt4(){
						
							count4=0;
							handler4.removeCallbacksAndMessages(null);

							//Working
							handler4.postDelayed(new Runnable() {
					            @Override
					            public void run() {
					            	
					                if (++count4 < countSec/*5*/) {
					                    handler4.postDelayed(this, 1000L);
					                    return;
					                }  
					                checkFail();
					               // else if (count4 == 5)   {show();}

					                handler4.removeCallbacks(this);
					            }
					        }, 1000L);  }
						// END Timer2 Function Start************************************************************
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
public void show(){
	
	if( builder != null && builder.isShowing() ) {return;} else{
	//Toast.makeText(getApplicationContext(),"one" , Toast.LENGTH_SHORT).show();
	AlertDialog.Builder builder = new AlertDialog.Builder(ColorMe.this);
	
	
	builder.setTitle(" U screwed it!!!!!!!")
	.setMessage("   Fail ")
	.setIcon(R.drawable.mailr3)
	.setCancelable(false)
	.setNegativeButton("ÎÊ",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel(); reload();
				}
			});
	

	
	
AlertDialog alert = builder.create();
alert.show();  // END ALERT
	} //end if showing
    
}
// End Show












//Start  Reload  Func
public void reload(){
	Intent intent = getIntent();
    overridePendingTransition(0, 0);
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
    finish();

    overridePendingTransition(0, 0);
    startActivity(intent);
}
//End





//Check  fails**************************************************************
public void  checkFail(){
	
	if( (count == countSec/*5*/)||(count2 ==countSec/* 5*/) ||(count3 ==countSec/* 5*/) ||(count4 ==countSec/* 5*/) ){
		 count=0;count2=0;count3=0;count4=0;
		 handler.removeCallbacksAndMessages(null);handler2.removeCallbacksAndMessages(null);handler3.removeCallbacksAndMessages(null);handler4.removeCallbacksAndMessages(null);
		show();}
	
}//End if















//function start game****************************************
public void  startGame(){
	//start 1
	 Colorme(Linear1); 
	 ViewAnimation cc = new ViewAnimation(); //cc.cancel();cc.reset();
	 Linear1.startAnimation(cc);
	timerCountt();
	// end  start 1
	
	
	// start 2
	mHandler2.postDelayed(mUpdateTimeTask2, 1800);
	// End  start 2
	
	// start 3
		mHandler3.postDelayed(mUpdateTimeTask3, 1200);
		// End  start 3
		
		
		// start 4
				mHandler4.postDelayed(mUpdateTimeTask4, 500);
				// End  start 4
	
}
// End   function start game---------------------------------------









// START DELAYED  ALL  RUNNABLE specified in startGame()************************************************************************
//Delayed Start  3
private Runnable mUpdateTimeTask2 = new Runnable() {
	   public void run() {
	       // do what you need to do here after the delay
		   Colorme(Linear2); 
			 ViewAnimation cc = new ViewAnimation(); //cc.cancel();cc.reset();
			 Linear2.startAnimation(cc);
			timerCountt();
	   }
	};
// END Delayed 2





	//Delayed Start 3 -New Runnable  specified  in startGame()
	private Runnable mUpdateTimeTask3 = new Runnable() {
		   public void run() {
		       // do what you need to do here after the delay
			   Colorme(Linear3); 
				 ViewAnimation cc = new ViewAnimation(); //cc.cancel();cc.reset();
				 Linear3.startAnimation(cc);
				timerCountt();
		   }
		};
	// END Delayed 3
		
		
		
		//Delayed Start 4 -New Runnable  specified  in startGame()
		private Runnable mUpdateTimeTask4 = new Runnable() {
			   public void run() {
			       // do what you need to do here after the delay
				   Colorme(Linear4); 
					 ViewAnimation cc = new ViewAnimation(); //cc.cancel();cc.reset();
					 Linear4.startAnimation(cc);
					timerCountt();
			   }
			};
		// END Delayed 4

		// END START ALL DELAYED RUNNABLE specified in startGame()--------------------------------------













	//Menu Start
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_me, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_speed1) {
			anDuration=1000;
			countSec=1;
			//return true;
		}
		
		if (id == R.id.action_speed2) {
			anDuration=5000;
			countSec=5;
			//return true;
		}
		
		if (id == R.id.action_speed3) {
			anDuration=2000;
			countSec=2;
			//return true;
		}
		
		
		if (id == R.id.action_start) {
			startGame();
					}
		
		
		return super.onOptionsItemSelected(item);
	}
	//End menu 
	
	
} // End Class

