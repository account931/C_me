package com.example.c_me;


// THIS is the Adapter used in GridViewDemoActivity.java (i.e Gallery)

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return mThumbIds.length;
	}

	public Object getItem(int position) {
		return mThumbIds[position];
	}

	public long getItemId(int position) {
		return position;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) {
			// if it's not recycled, initialize some attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(165, 105));//(145, 105)(85, 85)
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(4, 4, 4, 4);//(8, 8, 8, 8)
		} else {
			imageView = (ImageView) convertView;
		}

		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}

	// references to our images
	public	Integer[] mThumbIds = { R.drawable.gal1, R.drawable.gal2,
			R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
			R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
			R.drawable.gal9, R.drawable.gal10, R.drawable.gal11,
			R.drawable.gal12,R.drawable.gal13,R.drawable.gal14,R.drawable.gal15,R.drawable.gal16,R.drawable.gal17,
			R.drawable.gal1, R.drawable.gal2,
			R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
			R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
			R.drawable.gal9, R.drawable.gal10, R.drawable.gal11,
			R.drawable.gal12,R.drawable.gal13,R.drawable.gal14,R.drawable.gal15,
			 R.drawable.gal1, R.drawable.gal2,
				R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
				R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
				R.drawable.gal9, R.drawable.gal10, R.drawable.gal11,
				R.drawable.gal12,R.drawable.gal13,R.drawable.gal14,R.drawable.gal15,R.drawable.gal16,R.drawable.gal17,
				R.drawable.gal1, R.drawable.gal2,
				R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
				R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
				R.drawable.gal9, R.drawable.gal10
			};
	
	/*public	Integer[] mThumbIds = { R.drawable.res1, R.drawable.res2,
			R.drawable.res3, R.drawable.res4, R.drawable.res5,
			R.drawable.res6, R.drawable.res7, R.drawable.res8,
			R.drawable.res9, R.drawable.res10, R.drawable.res11,
			R.drawable.res12}; */
}