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
		final String[] wordListOne = {"Вова","Алина","Саша","Дима","Катя","Влад","Маша","Таня","Руслан","Артем","Маша","Таня","Алина"};
			final String[] wordListTwo = {"поддерживает","любит","предпочитает","игнорирует","хочет видеть",
					"обожает","ждет","рассчитывает на","разводит на деньги","шлет спам","видит в хорошем настроении",
					"разводит на деньги","скучает по","мечтает о","фантазирует о","вешает лапшу","делает массаж",
					"пьет на брудершафт с","пристает к","отдает зарплату","зажигает  с","строит глазки"
					,"подмазывается к","заигрывает к","мутит с" ,"выпьет с","приготовит обед","советуется с","идет в кино с","отрывается c","тусит c","идет в запой с"};
			final String[] wordListThree = {"Алину","Диму","Сашу","Влада","Машу","Таню","Руслана","Катю","Артема","Вову"};
			//Вычисляем, сколько слов в каждом списке
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
		    	
				//Генерируемтри случайных числа
				int randl = (int) (Math.random() * oneLength) ;
				int rand2 = (int) (Math.random() * twoLength) ;
				
				
				
				
				

				// 2nd  case Edit  Datelniy Padezh*****************************************
				
				 if (wordListTwo[rand2]=="прикалывается о" || wordListTwo[rand2]=="скучает по"
					   || wordListTwo[rand2]=="мечтает о"|| wordListTwo[rand2]=="фантазирует о"
					   || wordListTwo[rand2]=="") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR = {"Алине","Диме","Саше","Владе","Маше","Тане","Руслане","Кате","Артеме","Вове"}; 
				   final int threeLengthR = wordListThreeR.length;
				   int rand3R = (int) (Math.random() * threeLengthR);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR[rand3R];
				   generated.setText("Сегодня " + phrase);
				   appearText();
				}
				
				//End  2nd case  edit  Datelniy Padezh
				
				
				
			   
			   // 3rd Case*************************************
				 else if (wordListTwo[rand2]=="делает массаж"|| wordListTwo[rand2]=="пристает к"|| wordListTwo[rand2]=="отдает зарплату"|| wordListTwo[rand2]=="строит глазки"|| wordListTwo[rand2]=="вешает лапшу" || wordListTwo[rand2]=="подмазывается к"|| wordListTwo[rand2]=="заигрывает к"|| wordListTwo[rand2]=="приготовит обед"|| wordListTwo[rand2]=="шлет спам") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR3 = {"Алине","Диме","Саше","Владу","Маше","Тане","Руслану","Кате","Артему","Вове"}; 
				   final int threeLengthR3 = wordListThreeR3.length;
				   int rand3R3 = (int) (Math.random() * threeLengthR3);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR3[rand3R3];
				   generated.setText("Сегодня " + phrase);
				   appearText();
				}
			   //End 3rd case
			   
			   
			   
			   
			   
			   

			   // 4rd Case*************************************
				 else  if (wordListTwo[rand2]=="пьет на брудершафт с" || wordListTwo[rand2]=="зажигает  с"|| wordListTwo[rand2]=="мутит с"|| wordListTwo[rand2]=="выпьет с"|| wordListTwo[rand2]=="советуется с"|| wordListTwo[rand2]=="идет в кино с"|| wordListTwo[rand2]=="отрывается c"|| wordListTwo[rand2]=="тусит c"|| wordListTwo[rand2]=="идет в запой с") 
				{
				   // Bingo--Chaged
				   final String[] wordListThreeR4 = {"Алиной","Димой","Сашой","Владом","Машей","Таней","Русланом","Катей","Артемом","Вовой"}; 
				   final int threeLengthR4 = wordListThreeR4.length;
				   int rand3R4 = (int) (Math.random() * threeLengthR4);
				   String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThreeR4[rand3R4];
				   generated.setText("Сегодня " + phrase);
				   appearText();
				}
			   //End 4rd case
			   
			   
			   
			   
				
			   else  {
				int rand3 = (int) (Math.random() * threeLength);
				
				
				//Теперь строим фразу
				String phrase = wordListOne[randl] + " " +wordListTwo[rand2] + " " + wordListThree[rand3];
				//System.out.println("Все, что нам нужно, - это " + phrase);
				generated.setText("Сегодня " + phrase);
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
