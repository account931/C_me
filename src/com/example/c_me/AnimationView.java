package com.example.c_me;





// Start second  variant With Speed BAR

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
 
 Paint paint;
 
 Bitmap bm;
 int bm_offsetX, bm_offsetY;
 
 Path animPath;
 PathMeasure pathMeasure;
 float pathLength;
 
 float step;   //distance each step
 float distance;  //distance moved
 float curX, curY;
  
 float curAngle;  //current angle
 float targetAngle; //target angle
 float stepAngle; //angle each step

 float[] pos;
 float[] tan;
 
 Matrix matrix;
 
 Path touchPath;

 public AnimationView(Context context) {
  super(context);
  initMyView();
 }

 public AnimationView(Context context, AttributeSet attrs) {
  super(context, attrs);
  initMyView();
 }

 public AnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
  super(context, attrs, defStyleAttr);
  initMyView();
 }
 
 public void initMyView(){
  paint = new Paint();
  paint.setColor(Color.BLUE);
  paint.setStrokeWidth(1);
  paint.setStyle(Paint.Style.STROKE);
    
  bm = BitmapFactory.decodeResource(getResources(), R.drawable.avikksmall);
  bm_offsetX = bm.getWidth()/2;
  bm_offsetY = bm.getHeight()/2;
  
  animPath = new Path();
  
  pos = new float[2];
  tan = new float[2];
  
  matrix = new Matrix();
  
  touchPath = new Path();
  
  step = 1;  //default
  stepAngle = 1; //default
 }

 @Override
 protected void onDraw(Canvas canvas) {
  if(animPath.isEmpty()){
   return;
  }
  
  canvas.drawPath(animPath, paint);
  
  matrix.reset();
  
  if((targetAngle-curAngle)>stepAngle){
   curAngle += stepAngle;
   matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
   matrix.postTranslate(curX, curY);
   canvas.drawBitmap(bm, matrix, null);
   
   invalidate();
  }else if((curAngle-targetAngle)>stepAngle){
   curAngle -= stepAngle;
   matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
   matrix.postTranslate(curX, curY);
   canvas.drawBitmap(bm, matrix, null);
   
   invalidate();
  }else{
   curAngle=targetAngle;
   if(distance < pathLength){
    pathMeasure.getPosTan(distance, pos, tan);

    targetAngle = (float)(Math.atan2(tan[1], tan[0])*180.0/Math.PI);
    matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
    
    curX = pos[0]-bm_offsetX;
    curY = pos[1]-bm_offsetY;
    matrix.postTranslate(curX, curY);
    
    canvas.drawBitmap(bm, matrix, null);
    
    distance += step;
    
    invalidate();
   }else{
    matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
    matrix.postTranslate(curX, curY);
    canvas.drawBitmap(bm, matrix, null);
   }
  }

 }

 @Override
 public boolean onTouchEvent(MotionEvent event) {
  
  int action = event.getAction();
  
  switch(action){
  case MotionEvent.ACTION_DOWN:
   touchPath.reset();
   touchPath.moveTo(event.getX(), event.getY());
   break;
  case MotionEvent.ACTION_MOVE:
   touchPath.lineTo(event.getX(), event.getY());
   break;
  case MotionEvent.ACTION_UP:
   touchPath.lineTo(event.getX(), event.getY());
   animPath = new Path(touchPath);
   
   pathMeasure = new PathMeasure(animPath, false);
   pathLength = pathMeasure.getLength();
   
   //step = 1;
   distance = 0;
   curX = 0;
   curY = 0;
   
   //stepAngle = 1; 
   curAngle = 0;
   targetAngle = 0;
   
   invalidate();
   
   break;
    
  }
  
  return true;
 }
 
 public void setSpeed(int sp){
  step = sp;
  stepAngle = sp;
 }

}
//END second  variant -----------------------------------------------------

























//  Draw Finger  1st variant -Not Speed Bar------------------------------------
/*
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	public int flagCanvas;

 
 Paint paint;
 
 Bitmap bm;
 int bm_offsetX, bm_offsetY;
 
 Path animPath;
 PathMeasure pathMeasure;
 float pathLength;
 
 float step;   //distance each step
 float distance;  //distance moved
 float curX, curY;
  
 float curAngle;  //current angle
 float targetAngle; //target angle
 float stepAngle; //angle each step

 float[] pos;
 float[] tan;
 
 Matrix matrix;
 
 Path touchPath;

 public AnimationView(Context context) {
  super(context);
  initMyView();
 }

 public AnimationView(Context context, AttributeSet attrs) {
  super(context, attrs);
  initMyView();
 }

 public AnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
  super(context, attrs, defStyleAttr);
  initMyView();
 }
 
 public void initMyView(){
  paint = new Paint();
  paint.setColor(Color.BLUE);
  paint.setStrokeWidth(1);
  paint.setStyle(Paint.Style.STROKE);
  
  //Mine
  
if (flagCanvas==2){bm = BitmapFactory.decodeResource(getResources(), R.drawable.com);}
 // End Mine
else {
  bm = BitmapFactory.decodeResource(getResources(), R.drawable.avikksmall);}
  bm_offsetX = bm.getWidth()/2;
  bm_offsetY = bm.getHeight()/2;
  
  animPath = new Path();
  
  pos = new float[2];
  tan = new float[2];
  
  matrix = new Matrix();
  
  touchPath = new Path();
 }

 @Override
 protected void onDraw(Canvas canvas) {
  
  if(animPath.isEmpty()){
   return;
  }
  
  canvas.drawPath(animPath, paint);
  
  matrix.reset();
  
  if((targetAngle-curAngle)>stepAngle){
   curAngle += stepAngle;
   matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
   matrix.postTranslate(curX, curY);
   canvas.drawBitmap(bm, matrix, null);
   
   invalidate();
  }else if((curAngle-targetAngle)>stepAngle){
   curAngle -= stepAngle;
   matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
   matrix.postTranslate(curX, curY);
   canvas.drawBitmap(bm, matrix, null);
   
   invalidate();
  }else{
   curAngle=targetAngle;
   if(distance < pathLength){
    pathMeasure.getPosTan(distance, pos, tan);

    targetAngle = (float)(Math.atan2(tan[1], tan[0])*180.0/Math.PI);
    matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
    
    curX = pos[0]-bm_offsetX;
    curY = pos[1]-bm_offsetY;
    matrix.postTranslate(curX, curY);
    
    canvas.drawBitmap(bm, matrix, null);
    
    distance += step;
    
    invalidate();
   }else{
    matrix.postRotate(curAngle, bm_offsetX, bm_offsetY);
    matrix.postTranslate(curX, curY);
    canvas.drawBitmap(bm, matrix, null);
   }
  }

 }

 @Override
 public boolean onTouchEvent(MotionEvent event) {
  
  int action = event.getAction();
  
  switch(action){
  case MotionEvent.ACTION_DOWN:
   touchPath.reset();
   touchPath.moveTo(event.getX(), event.getY());
   break;
  case MotionEvent.ACTION_MOVE:
   touchPath.lineTo(event.getX(), event.getY());
   break;
  case MotionEvent.ACTION_UP:
   touchPath.lineTo(event.getX(), event.getY());
   animPath = new Path(touchPath);
   
   pathMeasure = new PathMeasure(animPath, false);
   pathLength = pathMeasure.getLength();
   
   step = 1;
   distance = 0;
   curX = 0;
   curY = 0;
   
   stepAngle = 1; 
   curAngle = 0;
   targetAngle = 0;
   
   invalidate();
   
   break;
    
  }
  
  return true;
 }

}
*/
//END  Draw Finger  1st variant -Not Speed Bar----------------