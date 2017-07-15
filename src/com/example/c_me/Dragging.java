package com.example.c_me;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Dragging extends Activity {
  
/** Called when the activity is first created. */

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dragging);
    findViewById(R.id.myimage1).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.myimage2).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.myimage3).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.myimage4).setOnTouchListener(new MyTouchListener());
    findViewById(R.id.topleft).setOnDragListener(new MyDragListener());
    findViewById(R.id.topright).setOnDragListener(new MyDragListener());
    findViewById(R.id.bottomleft).setOnDragListener(new MyDragListener());
    findViewById(R.id.bottomright).setOnDragListener(new MyDragListener());

  }

  private final class MyTouchListener implements OnTouchListener {
    @SuppressLint("ClickableViewAccessibility")//added
	public boolean onTouch(View view, MotionEvent motionEvent) {
      if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
        ClipData data = ClipData.newPlainText("", "");
        DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data, shadowBuilder, view, 0);
        view.setVisibility(View.INVISIBLE);
        return true;
      } else {
        return false;
      }
    }
  }

  class MyDragListener implements OnDragListener {
    Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
    Drawable normalShape = getResources().getDrawable(R.drawable.shape);

    @Override
    public boolean onDrag(View v, DragEvent event) {
      int action = event.getAction();
      switch (event.getAction()) {
      case DragEvent.ACTION_DRAG_STARTED:
        // do nothing
        break;
      case DragEvent.ACTION_DRAG_ENTERED:
        v.setBackground/*Drawable*/(enterShape);
        break;
      case DragEvent.ACTION_DRAG_EXITED:
        v.setBackground/*Drawable*/(normalShape);
        break;
      case DragEvent.ACTION_DROP:
        // Dropped, reassign View to ViewGroup
        View view = (View) event.getLocalState();
        ViewGroup owner = (ViewGroup) view.getParent();
        owner.removeView(view);
        LinearLayout container = (LinearLayout) v;
        container.addView(view);
        view.setVisibility(View.VISIBLE);
        break;
      case DragEvent.ACTION_DRAG_ENDED:
        v.setBackground/*Drawable*/(normalShape);
      default:
        break;
      }
      return true;
    }
  }
  
  
  
  
  
  
 
  
  
  
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
			return true;
		}
		
		
		
		
		return super.onOptionsItemSelected(item);
	}
	//End menu 
	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
} 