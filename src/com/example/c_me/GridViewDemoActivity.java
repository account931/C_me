package com.example.c_me;
//list with logos

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewDemoActivity extends Activity {

	private TextView mSelectText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_grid_view_demo);

		//mSelectText = (TextView) findViewById(R.id.info);
		GridView gridview = (GridView) findViewById(R.id.gridView1);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(gridviewOnItemClickListener);
	}
  
	
	
	 //BELOW IS KILLED AS DUPLICATED
	/*private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			// выводим номер позиции
			mSelectText.setText(String.valueOf(position));
		}
	}; */
	
	
	//START FULL SCREEN IMAGE ON CLICK
	private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			
			// Sending image id to FullScreenActivity
			Intent i = new Intent(getApplicationContext(),
					FullImageActivity.class);
			// passing array index
			i.putExtra("id", position);
			startActivity(i);
		}
	};
	//END FULL SCREEN IMAGE ON CLICK
	
	
	
	
	
}