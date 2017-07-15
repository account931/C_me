package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

//import com.example.screwit.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Select extends Activity {  //ActionBarActivity
	
	/*Alert*/
	 AlertDialog.Builder ad;
	    Context context;
	    
	
	/*PHOTO*/
	  File directory;
	  final int TYPE_PHOTO = 1;
	  final int TYPE_VIDEO = 2;

	  final int REQUEST_CODE_PHOTO = 1;
	  final int REQUEST_CODE_VIDEO = 2;
	  final String TAG = "myLogs";
	  ImageView ivPhoto;
	  /*End PHOTO*/
	  
	  //COLORS CHANGE VAR
	  private RelativeLayout mRelativeLayout;
	//END COLORS CHANGE VAR 
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_select);
		
		
		//COLORS CHANGE VAR START
		mRelativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
		//END COLORS CHANGE VAR 
		
		
		//PHOTO
		createDirectory();
	    ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
	    //END PHOTO
	//}
		
		
		
		
		/*ALERT*/
		context = Select.this;
        String title = "����� ���� ������";
        String message = "�������� ��������";
        String button1String = "��������� ����";
        String button2String = "������� ���";
        
        ad = new AlertDialog.Builder(context);
        ad.setTitle(title);  // ���������
        ad.setMessage(message); // ���������
        ad.setPositiveButton(button1String, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "�������� ����������",
                        Toast.LENGTH_LONG).show();
            }

		
        });
        ad.setNegativeButton(button2String, new OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Toast.makeText(context, "� �������� ����������", Toast.LENGTH_LONG)
                        .show();
            }
        });
        ad.setCancelable(true);
        ad.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(context, "�� ������ �� �������",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onAlert(View v) {
        ad.show();
    }
		 /* END ALERT*/
		
	
	
	
	
	//PHOTO
	public void onClickPhoto(View view) {
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	  //intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri(TYPE_PHOTO));
	    startActivityForResult(intent, REQUEST_CODE_PHOTO);
	  }

	public void onClickVideo(View view) {
	    Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
	    //intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri(TYPE_VIDEO));
	    startActivityForResult(intent, REQUEST_CODE_VIDEO);
	  }

	  @Override
	  protected void onActivityResult(int requestCode, int resultCode,
	      Intent intent) {
	    if (requestCode == REQUEST_CODE_PHOTO) {
	      if (resultCode == RESULT_OK) {
	        if (intent == null) {
	          Log.d(TAG, "Intent is null");
	        } else {
	          Log.d(TAG, "Photo uri: " + intent.getData());
	          Bundle bndl = intent.getExtras();
	          if (bndl != null) {
	            Object obj = intent.getExtras().get("data");
	            if (obj instanceof Bitmap) {
	              Bitmap bitmap = (Bitmap) obj;
	              Log.d(TAG, "bitmap " + bitmap.getWidth() + " x "
	                  + bitmap.getHeight());
	              ivPhoto.setImageBitmap(bitmap);
	            }
	          }
	        }
	      } else if (resultCode == RESULT_CANCELED) {
	        Log.d(TAG, "Canceled");
	      }
	    }

	    if (requestCode == REQUEST_CODE_VIDEO) {
	      if (resultCode == RESULT_OK) {
	        if (intent == null) {
	          Log.d(TAG, "Intent is null");
	        } else {
	          Log.d(TAG, "Video uri: " + intent.getData());
	        }
	      } else if (resultCode == RESULT_CANCELED) {
	        Log.d(TAG, "Canceled");
	      }
	    }
	  }

	  private Uri generateFileUri(int type) {
	    File file = null;
	    switch (type) {
	    case TYPE_PHOTO:
	      file = new File(directory.getPath() + "/" + "photo_"
	          + System.currentTimeMillis() + ".jpg");
	      break;
	    case TYPE_VIDEO:
	      file = new File(directory.getPath() + "/" + "video_"
	          + System.currentTimeMillis() + ".mp4");
	      break;
	    }
	    Log.d(TAG, "fileName = " + file);
	    return Uri.fromFile(file);
	  }

	  private void createDirectory() {
	    directory = new File(
	        Environment
	            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
	        "MyFolder");
	    if (!directory.exists())
	      directory.mkdirs();
	  }

	//END PHOTO
	  
	  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		TextView tvInfo = (TextView) findViewById(R.id.textFORMENU); //TEXTFORM FOR SELECTED MENU 
		
		
		

		// �������� ��� ���������� ������ ����
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast toast = Toast.makeText(getApplicationContext(), 
					"IGNITE!",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			//tvInfo.setText("�� ������� IGNITE!");
			return true;
			
			
			
			
			
		case R.id.action_settings1:
			/*ALERT CHANGE COLOR*/
			context = Select.this;
	        String title = "����� ���� ������";
	        String message = "���������� ���";
	        String button1String = "�������";
	        String button2String = "�������";
	        
	        ad = new AlertDialog.Builder(context);
	        ad.setTitle(title);  // ���������
	        ad.setMessage(message); // ���������
	        // ALERT ON CLICK !ST BUTTON
	        ad.setPositiveButton(button1String, new OnClickListener() {
	            public void onClick(DialogInterface dialog, int arg1) {
	            	mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
	            }

			
	        });
	        ad.setNegativeButton(button2String, new OnClickListener() {
	            public void onClick(DialogInterface dialog, int arg1) {
	            	mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.whiteColor));
	            }
	        });
	        ad.setCancelable(true);
	        ad.setOnCancelListener(new OnCancelListener() {
	            public void onCancel(DialogInterface dialog) {
	                Toast.makeText(context, "�� ������ �� �������",
	                        Toast.LENGTH_LONG).show();
	            }
	        });
	    
	        ad.show();
	    
			 /* END ALERT*/
			return true;
			
			
			
			
			
			
			
			
			
		case R.id.action_settings2:
			tvInfo.setText("�� ������� GOOGLE!");
			return true;
		case R.id.action_settings3:
			tvInfo.setText("�� ������� UKRAINE!");
			return true;
		case R.id.action_settings4:
			tvInfo.setText("�� ������� ZHYTOMYR!");
			return true;
		case R.id.action_settings5:
			Toast toastL = Toast.makeText(getApplicationContext(), 
					"�� �����!",
					Toast.LENGTH_SHORT);
			toastL.setGravity(Gravity.CENTER, 0, 0);
			toastL.show();
			//tvInfo.setText("�� �����!");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	//END OF SWITCH FOR MENU	
		
		
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	} */
   public void goGallery(View view) { /*KFC GALLERY*/
	   Intent intent = new Intent(Select.this, KFC.class);
       startActivity(intent); }
   
   
   //MOVE TO GRID INTENT
   public void onGRID(View view) { 
	   Intent intent = new Intent(Select.this, GridViewDemoActivity.class);
       startActivity(intent); }
   
 //MOVE TO SQL
   public void onSQL(View view) { 
	   Intent intent = new Intent(Select.this, SQL.class);
       startActivity(intent); }
   
   
   //MOVE TO SMS
   public void onSMS(View view) { 
	   Intent intent = new Intent(Select.this, SMS.class);
       startActivity(intent); }
   
   
   
}

//}
