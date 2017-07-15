//SELECT GALLARY/PHOTO,CROP OPTIONS
//MAINACTIVITY-KFC(2PICTURES)-TAKE PICTURE/SELECT GALLERY
package com.example.c_me;
//http://www.androidhub4you.com/2012/07/how-to-crop-image-from-camera-and.html
import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.FloatMath;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
//Move
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
//import com.example.c_me.roundimage;

public class Large extends Activity {
private static final int PICK_FROM_CAMERA = 1;
private static final int PICK_FROM_GALLERY = 2;
private static final int PICK_BACKGROUND = 3;
ImageView imgview;
Bitmap photo;

//RoundImage
RoundImage roundedImage;


//ZOOM-------------------------------------------------------------------------------------
/*private static final String TAG = "Touch";

//These matrices will be used to move and zoom image
Matrix matrix = new Matrix();
Matrix savedMatrix = new Matrix();  

//We can be in one of these 3 states
static final int NONE = 0;
static final int DRAG = 1;
static final int ZOOM = 2;
static final int DRAW =3;
int mode = NONE;

//Remember some things for zooming
PointF start = new PointF();
PointF mid = new PointF();
float oldDist = 1f;

//Limit zoomable/pannable image
private float[] matrixValues = new float[9];
private float maxZoom;
private float minZoom;
private float height;
private float width;
private RectF viewRect;*/
//END ZOOM
//----------------------------------------------------------------------------------------

/*USUAL Menu*/
public static final int IDM_NEW=101;
public static final int IDM_OPEN=102;
public static final int IDM_SAVE=103;
public static final int IDM_SQUARE=104;
public static final int IDM_SQUARE2=105;
/*END USUAL Menu*/


//FOTO
//final int TYPE_PHOTO = 1;
//RelativeLayout mapRelativeView = (RelativeLayout)findViewById(R.id.relativeLayout1);

//Move
int windowwidth;
int windowheight;
private LayoutParams layoutParams ;


@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
//remove  title
requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    WindowManager.LayoutParams.FLAG_FULLSCREEN);
setContentView(R.layout.activity_large);



//Find Linearlayout
LinearLayout mainLayout1 = (LinearLayout)findViewById(R.id.relativeLayout1);
//End LinearLayout

imgview = (ImageView) findViewById(R.id.imageView1);
Button buttonCamera = (Button) findViewById(R.id.btn_take_camera);
Button buttonGallery = (Button) findViewById(R.id.btn_select_gallery);

//SAVEME button
//Button saveMe = (Button) findViewById(R.id.saveme);// END


//move
windowwidth = getWindowManager().getDefaultDisplay().getWidth();
windowheight = getWindowManager().getDefaultDisplay().getHeight();
//final ImageView balls = (ImageView)findViewById(R.id.ball);
// END MOVE






//MOVE LISTENER
imgview.setOnTouchListener(new View.OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        LayoutParams layoutParams = (LayoutParams) imgview.getLayoutParams();
        switch(event.getAction())
        {
        case MotionEvent.ACTION_DOWN:   
                                        break;
        case MotionEvent.ACTION_MOVE:
                                        int x_cord = (int)event.getRawX();
                                        int y_cord = (int)event.getRawY();

                                        if(x_cord>windowwidth){x_cord=windowwidth;}
                                        if(y_cord>windowheight){y_cord=windowheight;}

                                        layoutParams.leftMargin = x_cord -199;// -199 25 then 155/232
                                        layoutParams.topMargin = y_cord -88;// -288 75

                                        imgview.setLayoutParams(layoutParams);
                                        break;
        default:
                                        break;
        }
            return true;
    }
});

// END MOVE LISTENER--------------------------------------------------------------
























buttonCamera.setOnClickListener(new View.OnClickListener() {

public void onClick(View v) {
// call android default camera
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

//intent.putExtra(MediaStore.EXTRA_OUTPUT,
//MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
// ******** code for crop image
intent.putExtra("crop", "true");
intent.putExtra("aspectX", 0);
intent.putExtra("aspectY", 0);
intent.putExtra("outputX", 200);
intent.putExtra("outputY", 150);

try {

intent.putExtra("return-data", true);
startActivityForResult(intent, PICK_FROM_CAMERA);

} catch (ActivityNotFoundException e) {
// Do nothing for now
}
}
});
buttonGallery.setOnClickListener(new View.OnClickListener() {

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
Intent intent = new Intent();
// call android default gallery
intent.setType("image/*");
intent.setAction(Intent.ACTION_GET_CONTENT);
// ******** code for crop image
intent.putExtra("crop", "true");
intent.putExtra("aspectX", 0);
intent.putExtra("aspectY", 0);
intent.putExtra("outputX", 200);
intent.putExtra("outputY", 150);

try {

intent.putExtra("return-data", true);
startActivityForResult(Intent.createChooser(intent,
"Complete action using"), PICK_FROM_GALLERY);

} catch (ActivityNotFoundException e) {
// Do nothing for now
}
}
});
}
@SuppressLint("NewApi")
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

if (requestCode == PICK_FROM_CAMERA) {
Bundle extras = data.getExtras();
if (extras != null) {
Bitmap photo = extras.getParcelable("data");
imgview.setImageBitmap(photo);

}
}

if (requestCode == PICK_FROM_GALLERY) {
Bundle extras2 = data.getExtras();
if (extras2 != null) {
final Bitmap photo = extras2.getParcelable("data");
//final Bitmap photos=photo;
//Round
/*roundedImage = new RoundImage(photo);
imgview.setImageDrawable(roundedImage);*/
//END round
 roundedImage = new RoundImage(photo);
 imgview.setImageBitmap(photo);


}


} //END CREATE    IS IT???????


//ADDED !!!!!!!!!  TRYING BACGROUND
/*if (requestCode == PICK_BACKGROUND) {
Bundle extras3 = data.getExtras();
if (extras3 != null) {
final Bitmap photo = extras3.getParcelable("data");
LinearLayout mainLayout1 = (LinearLayout)findViewById(R.id.relativeLayout1);
Drawable d = new BitmapDrawable(photo);
mainLayout1.setBackground(d);
//mainLayout1.setBackgroundResource(photo);

 //imgview.setImageBitmap(photo);
}  }  */
//ADDED









//End Classs
}



//CREATE usual MENU !!! Should add onClick actioner
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(Menu.NONE, IDM_NEW, Menu.NONE,"NEW Backround");
		menu.add(Menu.NONE, IDM_OPEN, Menu.NONE,"Default");
		menu.add(Menu.NONE, IDM_SAVE, Menu.NONE,"Round");
		menu.add(Menu.NONE, IDM_SQUARE, Menu.NONE,"Square");
		menu.add(Menu.NONE, IDM_SQUARE2, Menu.NONE,"Zoom");
		return (super.onCreateOptionsMenu(menu));       }
	//END CREATE usual MENU
	
	
	
	
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
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
	    	LinearLayout mainLayout1 = (LinearLayout)findViewById(R.id.relativeLayout1);
	    	mainLayout1.setBackgroundResource(R.drawable.cvtropic);
	    }
	    
	    //second 
	    if (id == IDM_OPEN) {
	    	LinearLayout mainLayout1 = (LinearLayout)findViewById(R.id.relativeLayout1);
	    	mainLayout1.setBackgroundResource(R.drawable.kvv931);
	    }
	    
	    //Third menu  item =Round image //
	    if (id == IDM_SAVE) {
	 		//Round
	   // roundedImage = new RoundImage(photo); it was transfered to on Activity result and works
	    imgview.setImageDrawable(roundedImage);
	    //END round  
	    }
	    
	    
	    //4th menu  item =square image //
	    if (id == IDM_SQUARE) {
	    	
	    	//ADDED!!!!
	    	/*Intent intent = new Intent();
	    	// call android default gallery
	    	intent.setType("image/*");
	    	intent.setAction(Intent.ACTION_GET_CONTENT);
	    	// ******** code for crop image
	    	intent.putExtra("crop", "true");
	    	intent.putExtra("aspectX", 0);
	    	intent.putExtra("aspectY", 0);
	    	intent.putExtra("outputX", 200);
	    	intent.putExtra("outputY", 150);

	    	try {

	    	intent.putExtra("return-data", true);
	    	startActivityForResult(Intent.createChooser(intent,
	    	"Complete action using"), PICK_BACKGROUND);

	    	} catch (ActivityNotFoundException e) {
	    	// Do nothing for now
	    	}  */
	    	//END ADDED
	    	
	    	
	    	imgview.setImageBitmap(photo);
	    //END round  
	    }
	    
	    
	    //5th menu  item =animate image //
	    if (id == IDM_SQUARE2) {
	    	
	    	scaleView(imgview, 1.5f, 1.5f);  //workinh
	    	/*Animation anim = AnimationUtils.loadAnimation(
        			getApplicationContext(), R.anim.scale_up);
	    	imgview.startAnimation(anim);*/
	    }   //END 5th
	    
	    return super.onOptionsItemSelected(item);
	}
	//End menu actioner
	
	
	
//zzz Woking scale function
	public void scaleView(View v, float startScale, float endScale) {
	    Animation anim = new ScaleAnimation(
	            1f, 1f, // Start and end values for the X axis scaling
	            startScale, endScale, // Start and end values for the Y axis scaling
	            Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
	            Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
	    anim.setFillAfter(true); // Needed to keep the result of the animation
	    v.startAnimation(anim);
	}
	//end zzz



	//-------------------------------------------------------------------------------------------------
	//ADDed  SAVEME Save File
	public void onSave(View v) throws IOException{
		//RETURNME!! RelativeLayout mapRelativeView = (RelativeLayout)findViewById(R.id.relativeLayoutG);
		//createBitmap(int width, int height, Bitmap.Config config)
	//Returns a mutable bitmap with the specified width and height.



	//Bitmap image = Bitmap.createBitmap(mapRelativeView.getWidth(), mapRelativeView.getHeight(), Bitmap.Config.RGB_565);
		//RETURNME!! Bitmap image = Bitmap.createBitmap( mapRelativeView.getWidth(), mapRelativeView.getHeight(),Bitmap.Config.RGB_565);
		

	//draw(Canvas canvas) -- Manually render this view
	//(and all of its children) to the given Canvas.
	//yourView.draw(new Canvas(image)); ORIGINALLLLLLLL
		//RETURNME!!  imgview.draw(new Canvas(image));

	//insertImage(ContentResolver cr, Bitmap source, String title, String description)
	//Insert an image and create a thumbnail for it.
	//uri is the path after the image has been saved.
		//RETURNME!!  String uri = Images.Media.insertImage(getContentResolver(), image, "title", null);
		
		//SAVE 22  Almost
		//Bitmap bitmap = findViewById(R.id.relativeLayout1).getDrawingCache();
		//
		LinearLayout view22 = (LinearLayout)findViewById(R.id.relativeLayout1);
		view22.setDrawingCacheEnabled(true);
		view22.buildDrawingCache();
		Bitmap bitmapme = view22.getDrawingCache();
		//
		
		//Generate name 
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "WImage-"+ n +".jpg";
		//END generate name 

		File file = new File(Environment.getExternalStorageDirectory(), /*"wdim.png"*/ fname);
		if(!file.exists())    
		    file.createNewFile();
		try{
		   FileOutputStream ostream = new FileOutputStream(file);
		   bitmapme.compress(CompressFormat.PNG, 70, /*(OutputStream)*/ostream);
		 
		 } 
		catch (Exception e) 
		{
		    e.printStackTrace();
		} 
		
		
		//END SAVE 222
		
		
		
		
		
		
		
		//var 2.111 ALMOST WORK
		/*Bitmap bitmap = findViewById(R.id.relativeLayout1).getDrawingCache();
		String root = Environment.getExternalStorageDirectory().toString();
		File myDir = new File(root + "/saved_images");    
		myDir.mkdirs();
		Random generator = new Random();
		int n = 10000;
		n = generator.nextInt(n);
		String fname = "Image-"+ n +".jpg";
		File file = new File (myDir, fname);
		if (file.exists ()) file.delete (); 
		try {
		       FileOutputStream out = new FileOutputStream(file);
		       bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
		       out.flush();
		       out.close();

		} catch (Exception e) {
		       e.printStackTrace();
		}*/
		//End  var 2.1111
		
		
		
		
		
		
		
		
		
		
		//var 33
		/*File f = new File(Environment.getExternalStorageDirectory().toString() + "/wwimg.png");

	  f.createNewFile();  // your mistake was at here      
	  try {
	  FileOutputStream fos = new FileOutputStream(f);
	  bitmap.compress(CompressFormat.PNG, 100, fos);
	  fos.flush();
	  fos.close();
	  }catch (IOException e){
	      e.printStackTrace();
	  }*/
	      
	 // var3333
	  
		//END SAVE 222
		
		
	Toast toast = Toast.makeText(getApplicationContext(), 
			"PHOTO SAVED!",
			Toast.LENGTH_SHORT);
	toast.setGravity(Gravity.CENTER, 0, 0);
	toast.show();} 



	//END ADDED
	
	
	
	
} 
//THERE was added








