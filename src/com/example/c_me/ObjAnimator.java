package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ObjAnimator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_obj_animator);
		
		
		
		//
		/*View v = findViewById(R.id.text_objanimator);
		ObjectAnimator animation = ObjectAnimator.ofFloat(v, "rotationY", 0.0f, 360f);
		animation.setDuration(3600);
		animation.setRepeatCount(ObjectAnimator.INFINITE);*/
		//animation.setInterpolator(new AccelerateDecelerateInterpolator());
		/*anim.setInterpolator(timeInterpolator);
		animation.start();*/
		//
		
		
		
	} //End onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.obj_animator, menu);
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
}
