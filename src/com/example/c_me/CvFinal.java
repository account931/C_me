package com.example.c_me;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

//public class CvFinal extends ActionBarActivity 
public class CvFinal extends Activity 
{
	
	
	

	//ONRESUME CV INITIATE
	 @Override
	    public void onResume()
	    {
	        super.onResume();
	        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_6, this, mLoaderCallback);
	    }
	//END ONRESUME CV INITIATE
	

	//OPENCV INIT START
		private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                	
                	//MY CODE
                	try{
                		
                		//OPCV3333 START
                		Bitmap bitm = BitmapFactory.decodeResource(getResources(), R.drawable.cv1);
                		Mat ImageMat= new Mat(bitm.getHeight(), bitm.getWidth(), CVType.CV_8UC3);
                		 //convert Bitmap to Mat
                        //Mat ImageMat = new Mat ( imgbitmap.getHeight(), imgbitmap.getWidth(), CvType.CV_8U, new Scalar(4));
                       // Bitmap myBitmap32 = imgbitmap.copy(Bitmap.Config.ARGB_8888, true);
                       // Utils.bitmapToMat(myBitmap32, ImageMat);

                		
                        Mat mat = null;
						//convert to grayscale
                        Imgproc.cvtColor(ImageMat, mat, Imgproc.COLOR_RGB2GRAY,4);
                        List<MatOfPoint> contours = null;
						Imgproc.drawContours(mat, contours, -1, new Scalar(200,200,0), 2);
                        displayMat(mat);
                        
                        Toast toast = Toast.makeText(getApplicationContext(), 
            					"CV ’Œ◊≈“ –¿¡Œ“¿“‹!!",
            					Toast.LENGTH_LONG);
            			toast.setGravity(Gravity.CENTER, 0, 0);
            			toast.show();   
                       
                		}
                		//END TRY
                		
                		//OPCV333 END
                		
                		
                		
                		//catch
                	 catch (Throwable e) {
                		 Toast toast = Toast.makeText(getApplicationContext(), 
                					"CV Õ≈ ’Œ◊≈“ –¿¡Œ“¿“‹!!",
                					Toast.LENGTH_LONG);
                			toast.setGravity(Gravity.CENTER, 0, 0);
                			toast.show();   
                	    e.printStackTrace();
                	}
                		//catch END
                	//END MY CODE
                	
                    //Log.i(TAG, "OpenCV loaded successfully");
                   // mOpenCvCameraView.enableView();
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }

		private void displayMat(Mat mat) {
			// TODO Auto-generated method stub
			
		}
    };
	//OPENCV INIT END
	
	
    
    
    

	// STATIC CV CALL
	static {
	    if (!OpenCVLoader.initDebug()) {
	        // Handle initialization error
	    	
	    }
	}
	//END STATIC CV CALL
	
	
	
	

	
	
	
	
	
	
	//
	//Callback 
	
	/*BaseLoaderCallback mOpenCVCallBack = new BaseLoaderCallback() {
	    @Override
	    public void onManagerConnected(int status) {
	       
			switch (status) {
	        case LoaderCallbackInterface.SUCCESS:
	            //DO YOUR WORK/STUFF HERE 
	        	
	        	Toast toast = Toast.makeText(getApplicationContext(), 
		 				"OpenCV Has Loaded",
		 				Toast.LENGTH_LONG);
		 		        toast.setGravity(Gravity.CENTER, 0, 0);
		 		        toast.show(); 
	        	
	        	//END DO YOUR WORK/STUFF HERE
	            break;
	        default:
	            super.onManagerConnected(status);
	            break;
	        }
	    }
	};  */
	
	//END CALLBACK
	//
	
	
	
	
	
	
	

	private static final String CV_FILLED = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cv_final);
		
		
		
		
/*
		
		//OPENCV START
		//final ImageView image= (ImageView) findViewById (R.id.imageView1);
	
		//BitmapDrawable bitm= (BitmapDrawable) getResources().getDrawable(R.drawable.cv1);
		//Mat mat = new Mat(bitm.getHeight(), bitm.getWidth(), CVType.CV_8UC3);
		//Imgproc.drawContours(mat, contours, -1, new Scalar(200,200,0), 2);
		//displayMat(mat);
		
		Bitmap bitm = BitmapFactory.decodeResource(getResources(), R.drawable.cv1);
		int mPhotoWidth = bitm.getWidth();
		int mPhotoHeight = bitm.getHeight();
		Mat mat = new Mat(bitm.getHeight(), bitm.getWidth(), CVType.CV_8UC3);
		Mat mHsvMat = null;
		Imgproc.cvtColor( mat, mHsvMat, Imgproc.COLOR_RGB2HSV, 5 );
		Scalar lowerThreshold = new Scalar ( 120, 100, 100 ); // Blue color ñ lower hsv values
		Scalar upperThreshold = new Scalar ( 179, 255, 255 ); // Blue color ñ higher hsv values
		Mat mMaskMat = null;
		Core.inRange ( mHsvMat, lowerThreshold , upperThreshold, mMaskMat );
		Mat mDilatedMat = null;
		Imgproc.dilate ( mMaskMat, mDilatedMat, new Mat() );
		List<MatOfPoint> contours = null;
		Imgproc.findContours ( mDilatedMat, contours, null, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE );
		for ( int contourIdx=0; contourIdx < contours.size(); contourIdx++ )
		  {
		    // if(contours[contourIdx].size()>100)  // Minimum size allowed for consideration
		    // { 
		         Mat mRgbMat = null;
				Scalar colorGreen = null;
				String thickness;
				Imgproc.drawContours ( mRgbMat, contours, contourIdx, colorGreen);
		    // }
		  }
		
		
		//List<MatOfPoint> contours = null;
		//Imgproc.drawContours(mat, contours, -1, new Scalar(200,200,0), 2);
		//displayMat(mat);
		*/
		//OPENCV END
		
		
		
		
		
		
		
//OPCV222START	almost work-one line mel
		/*Bitmap bitm = BitmapFactory.decodeResource(getResources(), R.drawable.cv1);
		Mat imageA = new Mat(bitm.getHeight(), bitm.getWidth(), CVType.CV_8UC3);
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();    

        Imgproc.findContours(imageA, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        for(int i=0; i< contours.size();i++){
            if (Imgproc.contourArea(contours.get(i)) > 50 ){
                org.opencv.core.Rect rect = Imgproc.boundingRect(contours.get(i));
                if (rect.height > 28){
                    Mat image;
				
					Core.rectangle(image, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
                    Mat ROI = image.submat(rect.y, rect.y + rect.height, rect.x, rect.x + rect.width);

                    Highgui.imwrite("/mnt/sdcard/images/test4.png",ROI);

                }
            }
        }*/
		//OPCV222 END
		
		
		//INIT
		//END INIT
		
		
		//START TRY  BRING ME BACK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		try{
		
		//OPCV3333 START
		Bitmap bitm = BitmapFactory.decodeResource(getResources(), R.drawable.cv1);
		Mat ImageMat= new Mat(bitm.getHeight(), bitm.getWidth(), CVType.CV_8UC3);
		 //convert Bitmap to Mat
        //Mat ImageMat = new Mat ( imgbitmap.getHeight(), imgbitmap.getWidth(), CvType.CV_8U, new Scalar(4));
       // Bitmap myBitmap32 = imgbitmap.copy(Bitmap.Config.ARGB_8888, true);
       // Utils.bitmapToMat(myBitmap32, ImageMat);

		
        //convert to grayscale
        Imgproc.cvtColor(ImageMat, ImageMat, Imgproc.COLOR_RGB2GRAY,4);
       
		}
		//END TRY
		
		//OPCV333 END
		
		
		
		//catch
	 catch (Throwable e) {
		 
		 android.os.SystemClock.sleep(2000);
	
		// THREAD START
			/*Thread myThread=new Thread (
					new Runnable(){
			  public void run(){ */
		//End THREAD PART 1
		 
		 
		 
		 //AlertBuilder Start
		 AlertDialog.Builder builder = new AlertDialog.Builder(CvFinal.this);
			builder.setTitle("OpenCV")
					.setMessage("OpenCV ÌÂ ıÓ˜ÂÚ ‡·ÓÚ‡Ú¸!")
					.setIcon(R.drawable.okay)
					.setCancelable(false)
					.setNegativeButton("OKAY",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			//android.os.SystemClock.sleep(3000);
			alert.show();
			//AlertBuilder END
 
			
			//THREAD 2 Part Start
						/*  }
					}
					);
			  try {
				myThread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  myThread.start();*/
			
			// END THREAD 2 Part 
			
	    e.printStackTrace();
	}
		//BRING ME BACK
		//catch END
		
	
		
		 // THREAD START
		/*Thread myThread=new Thread (
				new Runnable(){
		  public void run(){
			  play();
			  		  }
				}
				);
		  myThread.start();*/
		 	 //END THREAD
		
		
		
		
		//END ONCREATE
	}
	
	

	//private void displayMat(Mat mat) {
		// TODO Auto-generated method stub
	
		
	
	
	
		
		
        
        
        
	}

	/* @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cv_final, menu);
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
	*/
	
	
	
	
	//
	
	
	
// Killed recently !!!     }



























