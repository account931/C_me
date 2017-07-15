package com.example.c_me;
//erase  IT+xml+menu
import android.support.v7.app.ActionBarActivity;
import android.content.ClipData;

import android.content.ClipDescription;

import android.content.Context;

import android.graphics.drawable.Drawable;

import android.os.Bundle;

import android.view.DragEvent;

import android.view.View;

import android.view.View.DragShadowBuilder;

import android.view.View.OnDragListener;

import android.view.View.OnLongClickListener;

import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.LinearLayout;

import android.widget.TextView;

import android.widget.Toast;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


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

//import com.example.c_me.roundimage;

public class PlaneFly extends Activity {

public ImageView imgview;




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
setContentView(R.layout.activity_plane_fly);



//Find Linearlayout
LinearLayout mainLayout1 = (LinearLayout)findViewById(R.id.relativeLayout1);
//End LinearLayout

imgview = (ImageView) findViewById(R.id.plane);

//move
windowwidth = getWindowManager().getDefaultDisplay().getWidth();
windowheight = getWindowManager().getDefaultDisplay().getHeight();
//final ImageView balls = (ImageView)findViewById(R.id.ball);
//END MOVE






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

//END MOVE LISTENER--------------------------------------------------------------




































//End Create
}





		
		
		
	
		
		
		

	
	
	
} 
//THERE was added




