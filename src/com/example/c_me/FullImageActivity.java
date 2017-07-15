// DISPLAY FULL  SIZE IMAGE ON CLICK IN GRID GALERY
package com.example.c_me;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FullImageActivity extends Activity /*implements OnClickListener*/ {
	
	//Random images
	// references to our images
		public	Integer[] mThumbIds = { R.drawable.gal1, R.drawable.gal2,
				R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
				R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
				R.drawable.gal9, R.drawable.gal10, R.drawable.gal11,
				R.drawable.gal12,R.drawable.gal13,R.drawable.gal14,R.drawable.gal15,R.drawable.gal16,R.drawable.gal17};
		
	
	//animation transition _NOT USED and  forwarded to FRAME ANIMATIONM
	private TransitionDrawable trans;
	
	//frame animation
	AnimationDrawable mframeAnimation = null;
	
	//public ImageView image;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_full_image);
		
		//animation frames
		final BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal1);
		final BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal2);
		final BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal3);
		final BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal4);
		final BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal5);
		final BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal6);
		final BitmapDrawable frame7 = (BitmapDrawable) getResources().getDrawable(
	            R.drawable.gal7);
		//End animation Frames
		
		
		// START animation transition 
		 final ImageView image = (ImageView) findViewById(R.id.full_image_view);
		//image.setOnClickListener((android.view.View.OnClickListener) this);
		Resources res=this.getResources();
		trans=(TransitionDrawable) res.getDrawable(R.drawable.gallery_transition);
		// SEND animation transition 

		// get intent data
		Intent i = getIntent();

		// Selected image id
		int position = i.getExtras().getInt("id");
		ImageAdapter imageAdapter = new ImageAdapter(this);

		final ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
		imageView.setImageResource(imageAdapter.mThumbIds[position]);
		
		
		// Animation from !!!! DRAWABLE/.gallery_transition
		/*m   Resources res = getApplicationContext().getResources();
        TransitionDrawable transition = (TransitionDrawable) res.getDrawable(R.drawable.gallery_transition);
        //ImageView image = (ImageView) findViewById(R.id.toggle_image);
        imageView.setImageDrawable(transition);
 
        transition.startTransition(5000);*/
		// END Animation Transition
		
		
		
		
		//
		//ImageView image = (ImageView) findViewById(R.id.full_image_view);
		image.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	
		    	//TWEET ANIAMTION
		    	/*image.setImageDrawable(trans);
				trans.startTransition(1000);*/
		    	//End TWEET
		    	
		    	
		    	
		    	
		    	//Random Images
		    	// Random images
				// Get a random between 0 and images.length-1
				 int imageId = (int)(Math.random() * mThumbIds.length);
				 // Set the image
				 imageView.setImageResource(mThumbIds[imageId]);
				 //image.setBackgroundResource(mThumbIds[imageId]);
				  //End  Random Images 
				//Animat
			    	Animation anim = AnimationUtils.loadAnimation(
			    			getApplicationContext(), R.anim.gallery_anim);
			    	image.startAnimation(anim);
		    	//End Random Images
		    	
		    	
		    	
		    	
		    	
		    	//FRAME ANIM
		    	/*int reasonableDuration = 1500;
		        mframeAnimation = new AnimationDrawable();
		        mframeAnimation.setOneShot(false);
		        mframeAnimation.addFrame(frame1, reasonableDuration);
		        mframeAnimation.addFrame(frame2, reasonableDuration);
		        mframeAnimation.addFrame(frame3, reasonableDuration);
		        mframeAnimation.addFrame(frame4, reasonableDuration);
		        mframeAnimation.addFrame(frame5, reasonableDuration);
		        mframeAnimation.addFrame(frame6, reasonableDuration);
		        mframeAnimation.addFrame(frame7, reasonableDuration);

		        
		         image.setImageDrawable(mframeAnimation);

		        mframeAnimation.setVisible(true, true);
		        //If this line is inside onClick(...) method of a button, animation works!!
		        mframeAnimation.start(); */
		    	// END FRAME ANIM
		        
		    }
		});
		//
		
		
		
		
		
	} //END onCREATE
	
	
	// Animation transition Click
	/*public void onClick(View v){
		
		image.setDrawable(trans);
		trans.startTransition(1000);
	} */
	// END Animation transition Click
	
}//END CLASS
