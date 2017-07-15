package com.example.c_me;
// Phrase generator(Horoskop)
import java.text.SimpleDateFormat;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Generated33 extends Activity {
	
	//Random images 
	//public	Integer[] gorosImages = { R.drawable.gal1, R.drawable.gal2};
	//RETURN// final ImageView imageviewGoros = (ImageView) findViewById(R.id.imageViewGOR);
	
	// Current date
	String date; 
	TextView Date;
	
	//Random Images
	int[] images = new int[] {R.drawable.gal1, R.drawable.gal2,
			R.drawable.gal3, R.drawable.gal4, R.drawable.gal5,
			R.drawable.gal6, R.drawable.gal7, R.drawable.gal8,
			R.drawable.gal9, R.drawable.gal10, R.drawable.gal11,
			R.drawable.gal12,R.drawable.gal13};
	
	private Button buttonGenerated;
    TextView generated;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_generated33);
		
		
		// Start Date display
		Date=(TextView) findViewById(R.id.textDate);
		String date= new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());
		Date.setText(""+" "+date);
		//End  Date  display
		
		
		final ImageView imageviewGoros = (ImageView) findViewById(R.id.imageViewGOR);
		
		

		//
		buttonGenerated = (Button) findViewById(R.id.buttonGenerated);
		
		 generated = (TextView)findViewById(R.id.textGenerated); 
		//
		
		//
		final String[] wordListOne = {"����","�����","����","����","����","����","����","����","������","�����","����","����","�����"};
			final String[] wordListTwo = {"������������","�����","������������","����������","����� ������",
					"�������","����","������������ ��","�������� �� ������","���� ����","����� � ������� ����������",
					"�������� �� ������","������� ��","������� �","����������� �","������ �����","������ ������",
					"���� �� ���������� �","�������� �","������ ��������","��������  �","������ ������"
					,"������������� �","���������� �","����� �" ,"������ �","���������� ����","���������� �","���� � ���� �","���������� c","����� c","���� � ����� �"};
			final String[] wordListThree = {"�����","����","����","�����","����","����","�������","����","������","����"};
			//���������, ������� ���� � ������ ������
			final int oneLength = wordListOne.length;
			final int twoLength = wordListTwo.length;
		    final int threeLength = wordListThree.length;
		    
		    
		    //Images
		   // final int gorImagecount = gorosImages.length;
		    //End Images
		
		
		
		
		// Click
		buttonGenerated.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	//
		    	
				//������������� ��������� �����
				int randl = (int) (Math.random() * oneLength) ;
				int rand2 = (int) (Math.random() * twoLength) ;
				
				
				
				
				

				// 2nd  case Edit  Datelniy Padezh*****************************************
				
				 if (wordListTwo[rand2]=="������������� �" || wordListTwo[rand2]=="������� ��"
					   || wordListTwo[rand2]=="������� �"|| wordListTwo[rand2]=="����������� �"
					   || wordListTwo[rand2]=="") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR = {"�����","����","����","�����","����","����","�������","����","������","����"}; 
				   final int threeLengthR = wordListThreeR.length;
				   int rand3R = (int) (Math.random() * threeLengthR);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR[rand3R];
				   generated.setText("������� " + phrase);
				   appearText();
				}
				
				//End  2nd case  edit  Datelniy Padezh
				
				
				
			   
			   // 3rd Case*************************************
				 else if (wordListTwo[rand2]=="������ ������"|| wordListTwo[rand2]=="�������� �"|| wordListTwo[rand2]=="������ ��������"|| wordListTwo[rand2]=="������ ������"|| wordListTwo[rand2]=="������ �����" || wordListTwo[rand2]=="������������� �"|| wordListTwo[rand2]=="���������� �"|| wordListTwo[rand2]=="���������� ����"|| wordListTwo[rand2]=="���� ����") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR3 = {"�����","����","����","�����","����","����","�������","����","������","����"}; 
				   final int threeLengthR3 = wordListThreeR3.length;
				   int rand3R3 = (int) (Math.random() * threeLengthR3);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR3[rand3R3];
				   generated.setText("������� " + phrase);
				   appearText();
				}
			   //End 3rd case
			   
			   
			   
			   
			   
			   

			   // 4rd Case*************************************
				 else  if (wordListTwo[rand2]=="���� �� ���������� �" || wordListTwo[rand2]=="��������  �"|| wordListTwo[rand2]=="����� �"|| wordListTwo[rand2]=="������ �"|| wordListTwo[rand2]=="���������� �"|| wordListTwo[rand2]=="���� � ���� �"|| wordListTwo[rand2]=="���������� c"|| wordListTwo[rand2]=="����� c"|| wordListTwo[rand2]=="���� � ����� �") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR4 = {"������","�����","�����","������","�����","�����","��������","�����","�������","�����"}; 
				   final int threeLengthR4 = wordListThreeR4.length;
				   int rand3R4 = (int) (Math.random() * threeLengthR4);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR4[rand3R4];
				   generated.setText("������� " + phrase);
				   appearText();
				}
			   //End 4rd case
			   
			   
			   
			   
				
			   else  {
				int rand3 = (int) (Math.random() * threeLength);
				
				
				//������ ������ �����
				String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThree[rand3];
				//System.out.println("���, ��� ��� �����, - ��� " + phrase);
				generated.setText("������� " + phrase);
				appearText();
		    	//
				}	// ELSE 
		        
			   
			   
		    	// Images Start*****************************************
			      // Random images -Working-Just Disabled
				// Get a random between 0 and images.length-1
				/* int imageId = (int)(Math.random() * images.length);
				 imageviewGoros.setBackgroundResource(images[imageId]);*/
				 //End  Random Images 
				 
				 
				 
				 
			imageviewGoros.setImageResource(R.drawable.goposss);
			//Animat
        	Animation anim = AnimationUtils.loadAnimation(
        			getApplicationContext(), R.anim.fadeout);
        	imageviewGoros.startAnimation(anim);
			   //Images END
			   
			   
			   
			   
		    }
		});     
		// END CLICK
		
		
		
		
	}// End onreate
	
	
	//Start function Animation for appearText ****************************************
	public void appearText(){
		//Animat
    	Animation anim = AnimationUtils.loadAnimation(
    			getApplicationContext(), R.anim.gen_text_appear);
    	generated.startAnimation(anim);
		   //Images END
	}
	//End Function
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.generated33, menu);
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
