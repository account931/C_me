package com.example.c_me;
//Mp3 Player
import java.io.File;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MpPlay extends ListActivity {
	/*private final*/ String MEDIA_PATH = new String("/sdcard/");//sdcard/Music/Bee/GT/     doesn't  work without last "/"
	                                                             // storage/exSdCard/Beats
																// ("/sdcard/")
																// /Music/Bee/
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	private int currentPosition = 0;
	ArrayAdapter<String> songList;

	// THREAD
	Thread myThread2;

	Button stop;
	Button next;
	Button play;
	Button prev;
	ProgressBar myProgressBar;
	public String songName;
	TextView songTitle;
	View view;
	//
	int PosMe;
	private SeekBar seekBar;// New
	private final Handler handler = new Handler();// New
	
	//Image
	ImageView ImageMp;
	

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_mp_play);
		stop = (Button) findViewById(R.id.button1);
		next = (Button) findViewById(R.id.buttonNext1);
		play = (Button) findViewById(R.id.buttonPlay);
		prev = (Button) findViewById(R.id.buttonPrev);
		songTitle=(TextView) findViewById(R.id.title);
		
		ImageMp= (ImageView)findViewById(R.id.imageMp);//Image

		// myProgressBar = (ProgressBar) findViewById(R.id.mySeekingBarR);
		//

		// New START**************
		initViews(); // FOR SEEKBAR

		// END NEW-------------------------------

		updateSongList();
		songsQuant(view);
		//ToastDisplay(songs.size()+" songs  has been found"); // Nember of  songs  found
	} // END onCreate ????????

	// HERE NEW START*************************************
	private void initViews() {

		seekBar = (SeekBar) findViewById(R.id.SeekBar01);
		// seekBar.setMax(mp.getDuration());  //Id didn't work unless was  tranferred to playsong() function
		seekBar.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				seekChange(v);
				return false;
			}
		});
	}

	// ---------
	public void startPlayProgressUpdater() {
		seekBar.setProgress(mp.getCurrentPosition());

		if (mp.isPlaying()) {
			Runnable notification = new Runnable() {
				public void run() {
					startPlayProgressUpdater();
				}
			};
			handler.postDelayed(notification, 1000);
		} else {
			mp.pause();

			seekBar.setProgress(0);
		}
	}

	// This is event handler thumb moving event
	private void seekChange(View v) {
		if (mp.isPlaying()) {
			SeekBar sb = (SeekBar) v;
			mp.seekTo(sb.getProgress());
		}
	}
	// END NEW----------------------- --------------------------
	
	
	

	// get the song list from sd-card
	public void updateSongList() {
		File home = new File(MEDIA_PATH);
		if (home.listFiles(new MyMP3Filter()).length > 0) {
			for (File file : home.listFiles(new MyMP3Filter())) {
				songs.add(file.getName());
				songName = file.getName(); // was added by me
			}
			songList = new ArrayAdapter<String>(this, R.layout.playmp_item, songs);
			setListAdapter(songList);
			// play the song from playSong method here we are passing song path
			// to play

			// playSong(MEDIA_PATH + songs.get(currentPosition)); // THIS MAKES
			// PLAY AUTOMATICALLY

			// On Item Click Listener**********
			OnItemClickListener itemListener = new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
					//Toast is  disabled  as it is  annoying
					/*Toast.makeText(getApplicationContext(),
							"Был  выбран: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();*/
					// Detected number of song and play it if click
					// it!!!!!!!!!!!!!!!!!!!!!
					// String cc=parent.getItemAtPosition(position).toString();
					int PosMe = position; // Not used so far
					currentPosition = position;
					playSong(MEDIA_PATH + songs.get(currentPosition));
					// playSong(MEDIA_PATH +songs.get(PosMe));
					// End Detect number of song
				}
			};
			getListView().setOnItemClickListener(itemListener); // Some stuff by
																// defaullt
			// End on Item Click listener-----------------------------------

		} // ?

		// STOP
		stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// myThread2.stop();
				Toast toastMus = Toast.makeText(getApplicationContext(), "Stopping", Toast.LENGTH_SHORT);
				toastMus.setGravity(Gravity.CENTER, 0, 0);
				toastMus.show();
				mp.pause();
				songTitle.setText("");
				ImageMp.setImageDrawable(null); //Remove  image
				//anim.cancel();
				/*
				 * RETURN if (mp != null) { mp.release(); mp = null; }
				 */
				// mp.stop();
				// mp.reset();
				// mp.release();

			}
		});
		//

		// Play next song
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// playSong(MEDIA_PATH + songs.get(currentPosition));
				nextSong();
			}
		});
		//

		// Play after stop
		play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				playSong(MEDIA_PATH + songs.get(currentPosition));
			}
		});
		//

		// Play after stop
		prev.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				PrevSong();
			}
		});
		//

		// OPACITY
		Drawable loginActivityBackground = findViewById(R.id.linearLayoutPlayerR).getBackground();
		loginActivityBackground.setAlpha(127);

	} // END onCreate

	
	
	
	// method play song IT PLAYS SONG!!!!!!!!!!!!!!!******************************
	private void playSong(String songPath) {
		try {
			mp.reset();
			mp.setDataSource(songPath);
			mp.prepare();
			mp.start();
			//Seekbar START
			       seekBar.setMax(mp.getDuration()); //didn't work in original function
			        startPlayProgressUpdater();// NEW!!!!!!!!!!!!!
			// SeekBar  END

			Toast toastSong = Toast.makeText(getApplicationContext(), /* songName */songPath, Toast.LENGTH_SHORT);
			toastSong.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
			toastSong.show(); // runME();
			
			songTitle.setText(/*"Track: "+*/songs.get(currentPosition)/*songPath*/); //Dispaly  thename of the  song playing

			
			
			
			//Animation
		ImageMp.setImageResource(R.drawable.soundwave6);
				   	Animation anim = AnimationUtils.loadAnimation(
	   			getApplicationContext(), R.anim.mpanim);
	   	ImageMp.startAnimation(anim);
			// End  animation
			
			
			// Setup listener so next song starts automatically
			mp.setOnCompletionListener(new OnCompletionListener() {
				public void onCompletion(MediaPlayer arg0) {
					nextSong();
				}

				//
				
				
				
				//
			});
		} catch (IOException e) {
			Log.v(getString(R.string.app_name), e.getMessage());
		}
	}
// END playSong  function------------------------------------------------------
	
	
	
	
	
	
	
	
	
	// method to play next song from the list if size is grater than current
	private void nextSong() {

		// MY THREAD
		// Thread myThread2 = new Thread(new Runnable() {
		// @Override
		// public void run() {
		//
		if (++currentPosition >= songs.size()) {
			// Last song, just reset currentPosition
			currentPosition = 0;
		} else {
			// Play next song
			playSong(MEDIA_PATH + songs.get(currentPosition));
		}
		//

		// }
		// });
		// myThread2.start();

		/*
		 * if (++currentPosition >= songs.size()) { // Last song, just reset
		 * currentPosition currentPosition = 0; } else { // Play next song
		 * playSong(MEDIA_PATH + songs.get(currentPosition)); }
		 */
	} // END FUNCTION nextsong()

	
	
	
	// Previous *************************************************
	private void PrevSong() {

		if (++currentPosition >= songs.size()) {
			// Last song, just reset currentPosition
			currentPosition = 0;
		} else {
			// Play next song
			playSong(MEDIA_PATH + songs.get(currentPosition - 1));
		}
	}

	// End Previous

	//
	
	
	
	//number of  songs found
	public  void songsQuant(View view){ToastDisplay(songs.size()+" songs  has been found");}
	
	
	

	// On DESTROY
	/*
	 * @Override public void onDestroy(){ finish(); // Очистите все ресурсы. Это
	 * касается завершения работы // потоков, закрытия соединений с базой данных
	 * и т. д. if (mp != null) { mp.release(); mp = null; }
	 */
	/*
	 * mp.stop(); mp.reset(); mp.release(); super.onDestroy(); }
	 */// END On DESTROY

	// ??????
	public void runME() {
		// mp is your MediaPlayer
		// progress is your ProgressBar

		int currentPosition = 0;
		int total = mp.getDuration();
		myProgressBar.setMax(total);
		while (mp != null && currentPosition < total/* && !_resetProgress */) {
			try {
				Thread.sleep(1000);
				currentPosition = mp.getCurrentPosition();
			} catch (InterruptedException e) {
				return;
			} catch (Exception e) {
				return;
			}
			myProgressBar.setProgress(currentPosition);
		}
	}

	// Toast Function
	public void ToastDisplay(String Mess){
		Toast.makeText(getApplicationContext(), Mess,
                Toast.LENGTH_SHORT).show();
	}
	//End  tost function
	
	
	
	

	//Menu Start
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mp_play, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_folder1) {
			
			MEDIA_PATH = new String("/mnt/extSdCard/ ");//sdcard/Music/Bee/GT/
			updateSongList();
 	}
		
		
if (id == R.id.action_folder2) {
			
			MEDIA_PATH = new String("/storage/extSdCard/ ");//sdcard/Music/Bee/GT/
			updateSongList();
 	}
		
		
		
if (id == R.id.action_folder3) {
	
	MEDIA_PATH = new String("/storage/extSdCard/Beats/ ");//sdcard/Music/Bee/GT/
	updateSongList();
}

		
		return super.onOptionsItemSelected(item);
	}
	//End menu 
	
	
	
	
	
	
	
	
	
	
	
	

} // END CLASS

/*
 * // START NEW***************** public void startPlayProgressUpdater() {
 * seekBar.setProgress(mp.getCurrentPosition());
 * 
 * if (mp.isPlaying()) { Runnable notification = new Runnable() { public void
 * run() { startPlayProgressUpdater(); } };
 * handler.postDelayed(notification,1000); }else{ mp.pause();
 * 
 * seekBar.setProgress(0); } }
 * 
 * // This is event handler thumb moving event private void seekChange(View v){
 * if(mp.isPlaying()){ SeekBar sb = (SeekBar)v; mp.seekTo(sb.getProgress()); } }
 * //END NEW-----------------------
 * 
 * 
 */







//Previus  animation***********************************************************************************************8
/*
  <?xml version="1.0" encoding="utf-8"?>

    <set xmlns:android="http://schemas.android.com/apk/res/android" >
   <!--  <translate
        android:duration="600"
        android:fromXDelta="0%"
        android:toXDelta="-100%" >
    </translate> -->
    
    
     <scale
            android:duration="1400"
           android:repeatCount="infinite"
            android:fillBefore="false"
            android:fromXScale="0.7"
            android:fromYScale="0.7"
            android:pivotX="50%"
            android:pivotY="50%"
            android:startOffset="300"
            android:toXScale="1.1"
            android:toYScale="1.1" /> <!-- android:repeatCount ="1" -->
     
     
     
       <scale
            android:duration="600"
            android:fillBefore="false"
            android:fromXScale="1.1"
            android:fromYScale="1.1"
            android:pivotX="50%"
            android:pivotY="50%"
            android:startOffset="300"
            android:toXScale="0.9"
            android:toYScale="0.9" />
     
     
     
     
     
     
      
     
     
    <!-- <rotate
            android:duration="500"
            android:fromDegrees="0"
            android:pivotX="50%"
            android:pivotY="50%"
            android:startOffset="500"
            android:toDegrees="-1800"
            android:toYScale="0.0" />  -->
            
            
            
            
            
            
            <set android:interpolator="@android:anim/decelerate_interpolator" >
             <scale
            android:duration="1600"
            android:fillBefore="false"
            android:fromXScale="1.1"
            android:fromYScale="1.1"
            android:pivotX="50%"
            android:pivotY="50%"
            android:startOffset="300"
            android:toXScale="0.9"
            android:toYScale="0.9" />
             </set>
            
            
            
            
             <set android:interpolator="@android:anim/decelerate_interpolator" >
             <scale
            android:duration="1800"
            android:fillBefore="false"
            android:fromXScale="0.8"
            android:fromYScale="0.8"
            android:pivotX="50%"
            android:pivotY="50%"
            android:startOffset="300"
            android:toXScale="1.1"
            android:toYScale="1.1" />
             </set>
            
          
     
</set> 

    
    
    
  */
