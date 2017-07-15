//OPENCV
package com.example.c_me;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import android.app.Activity;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import org.opencv.imgproc.*;
import org.opencv.objdetect.HOGDescriptor;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;





public class OpenCV extends Activity {
	//announce buttons
		private Button btn1;
		private Button btn2;
		private Button btnDef;
		private Button btnCV;
	//END announce

		
		/*USUAL Menu*/
		public static final int IDM_NEW=101;
		public static final int IDM_OPEN=102;
		public static final int IDM_SAVE=103;
		/*END USUAL Menu*/
		
		/*Context menu*/
		public static final int IDM_RESTORE=201;
		public static final int IDM_PAUSE=202;
		public static final int IDM_GO=203;
		public static final int IDM_TEL=204;
		public static final int IDM_BEATS=205;
		public static final int IDM_SOME=206;
		public static final int IDM_Draw=207;
		public static final int IDM_Draw2=208;
		public static final int IDM_Boofcv=209;
		public static final int IDM_Canvas=210;
		public static final int IDM_Gallery=211;
		public static final int IDM_Chat=212;
		public static final int IDM_Facebook=213;
		public static final int IDM_ObjAnimator=214;
		public static final int IDM_Gps=215;
		public static final int IDM_Generated=216;
		public static final int IDM_MP3PLAYER=217;
		public static final int IDM_WEBPARSE=218;
		public static final int IDM_LISTVIEW=219;
		public static final int IDM_STOPWATCH=220;
		public static final int IDM_BATTERY=221;
		public static final int IDM_Touch=222; //show  coordinates
		public static final int IDM_Wifi=223;
		public static final int IDM_Speech=224;
		public static final int IDM_Color=225;
		public static final int IDM_Draggg=226;
		/*END Context menu*/
		protected static final int CV_FILLED = 0;
		
		
		//TEL Manager
		TelephonyManager tm;
		//END TEL Manager
		
		
		//Beats
		MediaPlayer mediaPlayer;
		//final String DATA_SD = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
			   //   + "/music.mp3";
		//END BEATS
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	//remove  title
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	setContentView(R.layout.activity_open_cv);

	
	//Context
	final LinearLayout game=(LinearLayout) findViewById(R.id.Main);
	registerForContextMenu(game);
	//END CONTEXT
	
	
   //animate  may kill it!!!!
	final ImageView imageAn = (ImageView) findViewById(R.id.imageView1);
	//END animate
	
	

	//find buttons
	btn1 = (Button) findViewById(R.id.firstPic);
	btn2 = (Button) findViewById(R.id.secondPic);
	btnDef = (Button) findViewById(R.id.btnDef);
	btnCV = (Button) findViewById(R.id.goCV);


	//End find buttons




	/* 1 button click*/
	btn1.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
	        final ImageView image= (ImageView) findViewById (R.id.imageView1);
	        image.setImageResource(R.drawable.cv1);   
	    }
	});     
	/* END 1 button click*/
	
	
	
	
	
	/* 2 button click*/
	btn2.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
	        final ImageView image= (ImageView) findViewById (R.id.imageView1);
	        image.setImageResource(R.drawable.cv55);
	    }
	});     
	/* END 2 button click*/

	
	
	
	/* DEF button click*/
	btnDef.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
	        final ImageView image= (ImageView) findViewById (R.id.imageView1);
	        image.setImageResource(R.drawable.butt);
	    }
	});     
	/* END DEF button click*/
	
	
	
	
	
	
	
	/* CVOpen click*/
	btnCV.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
	        //TRY
	    	
	    	
	    	
	    	try {
	    //Callback 
	    	
	    	/*BaseLoaderCallback mOpenCVCallBack = new BaseLoaderCallback() {
	    	    @Override
	    	    public void onManagerConnected(int status) {
	    	        Bitmap mResult;
					switch (status) {
	    	        case LoaderCallbackInterface.SUCCESS:
	    	            //DO YOUR WORK/STUFF HERE 
	    	        	//First convert Bitmap to Mat
	    	        	Bitmap image = BitmapFactory.decodeResource(getResources(),R.drawable.cv1);
	    	        	Mat ImageMat = new Mat ( image.getHeight(), image.getWidth(), CvType.CV_8U, new Scalar(4));
	    	        	
	    	        	Bitmap myBitmap32 = image.copy(Bitmap.Config.ARGB_8888, true);
	    	        	Utils.bitmapToMat(myBitmap32, ImageMat);
	    	        	
	    	        	
	    	        	
	    	        	
	    	        	//ORIG
	    	        	List<MatOfPoint> contours = new ArrayList<MatOfPoint>();    

	    		         Imgproc.findContours(ImageMat, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
	    		         for(int i=0; i< contours.size();i++){
	    		             if (Imgproc.contourArea(contours.get(i)) > 50 ){
	    		                 Rect rect = Imgproc.boundingRect(contours.get(i));
	    		                 if (rect.height > 28){
	    		                     Mat image = null;
	    							Core.rectangle(image, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
	    		                    // Mat ROI = image.submat(rect.x, rect.x + rect.heigth, rect.x, rect.x + rect.width);
	    		                     Mat ROI = image.submat(rect.y, rect.y + rect.height, rect.x, rect.x + rect.width);

	    		                     Highgui.imwrite("/mnt/sdcard/myImages/test4.png",ROI);

	    	        	//END ORIGINAL
	    	        	
	    	        	//Then convert the processed Mat to Bitmap
	    	        	Bitmap resultBitmap = Bitmap.createBitmap(ImageMat.cols(),  ImageMat.rows(),Bitmap.Config.ARGB_8888);;
	    	        	Utils.matToBitmap(ImageMat, resultBitmap);
	    	        	//Set member to the Result Bitmap. This member is displayed in an ImageView
	    	              mResult = resultBitmap;
	    	        	final ImageView image22= (ImageView) findViewById (R.id.imageView1);
	    	        	image22.setImageBitmap(mResult);
	    	       
	    		        //image22.setImageResource(R.drawable.butt);
	    	        	//END DO YOUR WORK/STUFF HERE
	    	            break;
	    	        default:
	    	            super.onManagerConnected(status);
	    	            break;
	    	        }
	    	    }
	    	};  */
	    	
	    	//END CALLBACK
	    		
	    		//Vibrate
		    	// Get instance of Vibrator from current Context
		    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		    	// Vibrate for 400 milliseconds
		    	v.vibrate(400);
		    	 //End Vibrate
		   
		    	 Toast toast = Toast.makeText(getApplicationContext(), 
				"SCREW YOU    -    OPENCV Does not  work-! -(((",
				Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();   
					} //this END TRY!!!!
					catch (Exception e) {
						//Vibrate
				    	// Get instance of Vibrator from current Context
				    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				    	// Vibrate for 400 milliseconds
				    	v.vibrate(400);
				    	 //End Vibrate
				    	
			            
				    	 Toast toast = Toast.makeText(getApplicationContext(), 
						"SCREW YOU    -    OPENCV Doesn not  work-!  ",
						Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();   
				} //this the END CATCH!!!!!
					
	    	
	    	
	    	

	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
	    	
	    	

	    	} 
	    	//END TRY END OF  public void onClick(View view
	    	
	    	
	 // RETURN BACK ME  !!!!!!!!!!!!           }
	});     
	/* END OpenCV click*/
	
	
	
	
	
	
	
	
	

	
	//END onCreate 
	}
	

//CREATE usual MENU !!! Should add onClick actioner
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(Menu.NONE, IDM_NEW, Menu.NONE,"NEW");
		menu.add(Menu.NONE, IDM_OPEN, Menu.NONE,"Open me");
		menu.add(Menu.NONE, IDM_SAVE, Menu.NONE,"Save me");
		return (super.onCreateOptionsMenu(menu));       }
	//END CREATE usual MENU

	
	

	//CREATE CONTEXT !!! Should add onClick actioner
	@Override
	public void  onCreateContextMenu (ContextMenu menu ,View v,ContextMenuInfo info){
		super.onCreateContextMenu(menu, v, info);
		menu.add(Menu.NONE, IDM_RESTORE, Menu.NONE,"Go to OpenCV");
		menu.add(Menu.NONE, IDM_Boofcv, Menu.NONE,"BoofCV");
		menu.add(Menu.NONE, IDM_PAUSE, Menu.NONE,"Try it harder(Animate)");
		menu.add(Menu.NONE, IDM_TEL, Menu.NONE,"Номер Телефона/BlueTooth");
		menu.add(Menu.NONE, IDM_BEATS, Menu.NONE,"Play Sound");
		menu.add(Menu.NONE, IDM_SOME, Menu.NONE,"Go play the game");
		menu.add(Menu.NONE, IDM_Draw, Menu.NONE,"WAZE HUNT");
		menu.add(Menu.NONE, IDM_Draw2, Menu.NONE,"Int Me ");
		menu.add(Menu.NONE, IDM_Canvas, Menu.NONE,"Canvas ");
		menu.add(Menu.NONE, IDM_Gallery, Menu.NONE,"Gallery ");
		menu.add(Menu.NONE, IDM_Chat, Menu.NONE,"On-line Chat ");
		menu.add(Menu.NONE, IDM_Gps, Menu.NONE,"GPS Tool ");
		menu.add(Menu.NONE, IDM_Facebook, Menu.NONE,"Facebook API ");
		menu.add(Menu.NONE, IDM_ObjAnimator, Menu.NONE,"Object Animator ");
		menu.add(Menu.NONE, IDM_Generated, Menu.NONE,"Phrase Generator");
		menu.add(Menu.NONE, IDM_LISTVIEW, Menu.NONE,"ListView");
		menu.add(Menu.NONE, IDM_MP3PLAYER, Menu.NONE,"MP3 Player");
		menu.add(Menu.NONE, IDM_STOPWATCH, Menu.NONE,"StopWatch");
		menu.add(Menu.NONE, IDM_BATTERY, Menu.NONE,"Battery&Assault");
		menu.add(Menu.NONE, IDM_WEBPARSE, Menu.NONE,"Weather Parser");
		menu.add(Menu.NONE, IDM_Touch, Menu.NONE,"Touch");
		menu.add(Menu.NONE, IDM_Wifi, Menu.NONE,"Wi-fi  Scan");
		menu.add(Menu.NONE, IDM_Speech, Menu.NONE,"Speak up");
		menu.add(Menu.NONE, IDM_Color, Menu.NONE,"Colorize impact");
		menu.add(Menu.NONE, IDM_Draggg, Menu.NONE,"Landing");
		menu.add(Menu.NONE, IDM_GO, Menu.NONE,"EXIT");
		
	}
	//END CREATE CONTEXT
	

	
	
	// Context Menu onClick actioner
	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{
		
		switch (item.getItemId()) 
		{
		    case IDM_RESTORE:
		    	Toast toast = Toast.makeText(this, "PROCESSING OPENCV ", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				//Move to CvFinal activity
			    	Intent intent = new Intent(OpenCV.this, CvFinal.class);
			        startActivity(intent); 
			        break;
			        
			        
			        
			        //Boofcv
		    case IDM_Boofcv:
		    	    //Move to BoofCv activity
			    	Intent intentBoof = new Intent(OpenCV.this, BoofCv.class);
			        startActivity(intentBoof); 
			        break;
			        //
			    
			   //Animate 
		    case IDM_PAUSE:
		    	final ImageView imageAn = (ImageView) findViewById(R.id.imageView1);
		    	Animation anim = AnimationUtils.loadAnimation(
            			getApplicationContext(), R.anim.anme);
            	imageAn.startAnimation(anim);
				    break;   //END ANIMATE
				    
			//Show phone number	    
		    case IDM_TEL:
		    	tm=(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		    	Toast toastTel = Toast.makeText(getApplicationContext(), 
						"ВАШ НОМЕР "+ tm.getLine1Number() +" " /*tm.getSimSerialNumber()*/ + tm.getNetworkOperator()/*tm.getLine1Number()*/,
						Toast.LENGTH_LONG);
				toastTel.setGravity(Gravity.CENTER, 0, 0);
				toastTel.show();   
			    break;
			    //END Show Telephone
			    
			   //Beats 
		    case IDM_BEATS:
		    	Toast toastMus = Toast.makeText(getApplicationContext(), 
						"Sound is ON",
						Toast.LENGTH_LONG);
				toastMus.setGravity(Gravity.CENTER, 0, 0);
				toastMus.show();   
		    	mediaPlayer = MediaPlayer.create(this, R.raw.gunshot);
		        mediaPlayer.start();
			    break; //END BEATS
			    
			// Move to Game activity    
		    case IDM_SOME:
		    	//Move to Xzero activity
		    	Intent intentZero = new Intent(OpenCV.this, Xzero.class);
		        startActivity(intentZero); 
			    break;
			    //END
			    
		    case IDM_Draw:
		    	//Move to Waze Shoot
		    	Intent intentSHOOT = new Intent(OpenCV.this, Guesswaze.class);
   		        startActivity(intentSHOOT);
				    break;
				    
		    case IDM_Draw2:
		    	//Move to GAME 222
		    	Intent intentWeth = new Intent(OpenCV.this, Weather.class);
		        startActivity(intentWeth); 
			    break;
			    
		    case IDM_GO:
			   finish();
			    break;
			    
		    case  IDM_Gallery:
		    	Intent intentGall = new Intent(OpenCV.this, Gallery.class);
		        startActivity(intentGall); 
				    break;
				    
		    case  IDM_Canvas:
		    	Intent intentCanvas = new Intent(OpenCV.this, Drawcanvas.class);
		        startActivity(intentCanvas); 
				    break;
				    
		    case  IDM_Chat:
		    	Intent intentChat = new Intent(OpenCV.this, Chat.class);
		        startActivity(intentChat); 
				    break;
				    
				    
		    case  IDM_Facebook:
		    	/*Intent intentFace = new Intent(OpenCV.this, Facebook.class);
		        startActivity(intentFace); */
				    break;
				    
				    
		    case  IDM_ObjAnimator:
		    	startActivity(new Intent(OpenCV.this, ObjAnimator.class));
	            overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
				    break;
			   
				    
		    case  IDM_Gps:
		    	//Intent intentGPS = new Intent(OpenCV.this, GPSTOOL.class);
		        //startActivity(intentGPS); 
		    	startActivity(new Intent(OpenCV.this, GPSTOOL.class));
	            overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
			    break;
			    
			    
		
		    case  IDM_Generated:
		    	//Intent intentGPS = new Intent(OpenCV.this, GPSTOOL.class);
		        //startActivity(intentGPS); 
		    	startActivity(new Intent(OpenCV.this, Generated33.class));
	            overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
			    break;
			    
				  
		    
		    case  IDM_MP3PLAYER:
		    	startActivity(new Intent(OpenCV.this, MpPlay.class));
	            overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
			    break;
		   
			    
               case  IDM_LISTVIEW:
            	   startActivity(new Intent(OpenCV.this, ListViewRR.class));
   	               overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
			    break;
			    
			    
               case  IDM_WEBPARSE:
            	   startActivity(new Intent(OpenCV.this, Parser.class));
   	               overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
			    break;
			    
			    
			    
               case  IDM_STOPWATCH:
            	   startActivity(new Intent(OpenCV.this, StoppWatch.class));
   	               overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
   			    break;
			    
   			    
               case  IDM_BATTERY:
            	   startActivity(new Intent(OpenCV.this, Battery1.class));
   	               overridePendingTransition(R.anim.intern_enter, R.anim.intent_exit);
   			    break;
   			    
   			    
   			    
               case  IDM_Touch:
            	   Intent intent31 = new Intent(OpenCV.this, Touch31.class);
   		        startActivity(intent31); 
   			    break;
   			    
   			    
               case  IDM_Wifi:
            	   Intent intentWifi = new Intent(OpenCV.this, WifiScan.class);
   		        startActivity(intentWifi); 
   			    break;
   			    
               case  IDM_Speech:
            	   Intent intentSpeech= new Intent(OpenCV.this, Speech.class);
   		        startActivity(intentSpeech); 
   			    break;
   			    
   			    
   			    
               case  IDM_Color:
            	   Intent intentColor= new Intent(OpenCV.this, ColorMe.class);
   		        startActivity(intentColor); 
   			    break;
   			    
   			    
               case  IDM_Draggg:
            	   Intent intentDrGGG= new Intent(OpenCV.this, DragSplash.class);
   		        startActivity(intentDrGGG); 
   			    break;
			    
		    default:
			    return super.onContextItemSelected(item);
		}
		
		return true;
	}
	// END Menu onClick actioner
	
	
	
	

//INITIALIZE OPENCV
	/*@Override
    protected void onResume() {
        super.onResume();
        Object mOpenCVCallBack = null;
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_8, this,
                mOpenCVCallBack);
    } */
	//END INITIALIZE
	
	

//END CLASS
}




	
	
	
	
	
	
	
	
	





