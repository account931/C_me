package com.example.c_me;

import java.util.Random;

import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Xzero extends ActionBarActivity {
	

	/*Context menu*/
	public static final int IDM_RESTORE=201;
	public static final int IDM_PAUSE=202;
	public static final int IDM_GO=203;
	public static final int IDM_TEL=204;
	public static final int IDM_BEATS=205;
	public static final int IDM_SOME=206;
	public static final int IDM_Draw=207;
	public static final int IDM_Draw2=208;
	/*END Context menu*/
	
	//announce buttons
			private Button btn1;
			private Button btn2;
			private Button btn3;
			private Button btn4;
			private Button btn5;
			private Button btn6;
			private Button btn7;
			private Button btn8;
			private Button btn9;
			
		//END announce

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_xzero);
		
		
		//Context
		final LinearLayout game=(LinearLayout) findViewById(R.id.Mainxzero);
		registerForContextMenu(game);
		//END CONTEXT
	
		//find buttons
		btn1 = (Button) findViewById(R.id.td1);
		btn2 = (Button) findViewById(R.id.td2);
		btn3 = (Button) findViewById(R.id.td3);
		btn4 = (Button) findViewById(R.id.td4);
		btn5 = (Button) findViewById(R.id.td5);
		btn6 = (Button) findViewById(R.id.td6);
		btn7 = (Button) findViewById(R.id.td7);
		btn8 = (Button) findViewById(R.id.td8);
		btn9 = (Button) findViewById(R.id.td9);
		//End find buttons
		
		
		
		
		/* 1 button click*/
		btn1.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn1.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	//final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
		    	
		    	//START YOU WIN
		    		/*String Str1 = new String("X");
		    	      String Str2 = btn1.getText().toString();
		    	      String Str3 = new String("This is really not immutable!!");
		    	      boolean retVal;

		    	      retVal = Str1.equals( Str2 );
		    	      if(retVal=true)*/
	if((btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X")) || (btn1.getText().toString().equals("X") && btn4.getText().toString().equals("X") && btn7.getText().toString().equals("X") ))
		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		builder.setTitle(" Good!!!!!!!")
					.setMessage("   You Win  ")
					.setIcon(R.drawable.com)
					.setCancelable(false)
					.setNegativeButton("Œ ",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();  // END ALERT
	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    //END YOU WIN
	
	//START YOU LOSE
	
	if((btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
		    		
		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		builder.setTitle(" Bad!!!!!!!")
					.setMessage("   You Blew It  ")
					.setIcon(R.drawable.comn)
					.setCancelable(false)
					.setNegativeButton("Œkay, I agree",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();  // END ALERT
	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    //END YOU LOSE
	
	
		    	
		    }// END if {}
		});     
		/* END 1 button click*/
		//--------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		
		/* 2 button click*/
		btn2.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn2.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
		    	
		    	
		    	//START YOU WIN
	    		
		    	if((btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X")) || (btn2.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn8.getText().toString().equals("X") ))
	    		
	    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
	    		builder.setTitle(" Good!!!!!!!")
				.setMessage("   You Win  ")
				.setIcon(R.drawable.com)
				.setCancelable(false)
				.setNegativeButton("Œ ",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();  // END ALERT
btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
	    //END YOU WIN
	   
		    	//START YOU LOSE
		    	
		    	if((btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Bad!!!!!!!")
		    					.setMessage("   You Blew It  ")
		    					.setIcon(R.drawable.comn)
		    					.setCancelable(false)
		    					.setNegativeButton("Œkay, I agree",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU LOSE
		    	
		    	
		    }
		});     
		/* END 2 button click*/
		
	//-------------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		
		
		
		/* 3 button click*/
		btn3.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn3.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		       //End random
		    	
		    	//START YOU WIN
	    		
		    	if((btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X")) || (btn3.getText().toString().equals("X") && btn6.getText().toString().equals("X") && btn9.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    									//
		    									btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    							    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText("");
		    									//
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	 }
		    		    //END YOU WIN
		    	
		    	//START YOU LOSE
		    	
		    	if((btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0"))   )
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Bad!!!!!!!")
		    					.setMessage("   You Blew It  ")
		    					.setIcon(R.drawable.comn)
		    					.setCancelable(false)
		    					.setNegativeButton("Œkay, I agree",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    									//
		    									btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    							    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText("");
		    									//
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	 }
		    		    //END YOU LOSE
		    	
		    }
		});     
		/* END 3 button click*/
		
	//-----------------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* 4 button click*/
		btn4.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn4.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
		    	//START YOU WIN
	    		
		    	if((btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")) || (btn1.getText().toString().equals("X") && btn4.getText().toString().equals("X") && btn7.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
		    	
		    	//START YOU LOSE
		    	
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		builder.setTitle(" Bad!!!!!!!")
		    		.setMessage("   You Blew It ")
		    		.setIcon(R.drawable.comn)
		    		.setCancelable(false)
		    		.setNegativeButton("Okay,I agree",
		    				new DialogInterface.OnClickListener() {
		    					public void onClick(DialogInterface dialog, int id) {
		    						dialog.cancel();
		    					}
		    				});
		    	AlertDialog alert = builder.create();
		    	alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    	//END YOU LOSE
		    }
		});     
		/* END 4 button click*/
	//-----------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* 5 button click*/
		btn5.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn5.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
		    	
//START YOU WIN
	    		
		    	if((btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")) || (btn2.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn8.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
//START YOU LOSE
	    		
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
	    		
	    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
	    		builder.setTitle(" Bad!!!!!!!")
				.setMessage("   You Blew It  ")
				.setIcon(R.drawable.comn)
				.setCancelable(false)
				.setNegativeButton("Œkay,I agree",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();  // END ALERT
btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
	    //END YOU LOSE 	

		    	
		    }
		});     
		/* END 5 button click*/
		//-----------------------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
		
		
		/* 6 button click*/
		btn6.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn6.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
                    //START YOU WIN
	    		
		    	if((btn4.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn6.getText().toString().equals("X")) || (btn3.getText().toString().equals("X") && btn6.getText().toString().equals("X") && btn9.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
		    	

                //START YOU LOSE
    		
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0") && btn9.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0"))   )
	    		    		
	    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
	    		    		builder.setTitle(" Bad!!!!!!!")
	    					.setMessage("   You Blew It  ")
	    					.setIcon(R.drawable.comn)
	    					.setCancelable(false)
	    					.setNegativeButton("Œkay,I agree",
	    							new DialogInterface.OnClickListener() {
	    								public void onClick(DialogInterface dialog, int id) {
	    									dialog.cancel();
	    								}
	    							});
	    			AlertDialog alert = builder.create();
	    			alert.show();  // END ALERT
	    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
	    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
	    		    //END YOU LOSE
		    	
		    }
		});     
		/* END 6 button click*/
	//------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		
		
		
		/* 7 button click*/
		btn7.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn7.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
                      //START YOU WIN
	    		
		    	if((btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")) || (btn1.getText().toString().equals("X") && btn4.getText().toString().equals("X") && btn7.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
		    	
 //START YOU LOSE
	    		
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Bad!!!!!!!")
		    					.setMessage("   You Blew It  ")
		    					.setIcon(R.drawable.comn)
		    					.setCancelable(false)
		    					.setNegativeButton("Œkay, I agree",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU LOSE
		    	
		    }
		});     
		/* END 7 button click*/
		
	//---------------------------------------------------------------------------------------	
		
		
		
		
		
		
		
		
		
		
		
		
	
		/* 8 button click*/
		btn8.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn8.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
//START YOU WIN
	    		
		    	if((btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")) || (btn2.getText().toString().equals("X") && btn5.getText().toString().equals("X") && btn8.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
		    	
//START YOU LOSE
	    		
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0"))  || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0")) || (btn3.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn9.getText().toString().equals("0"))   )
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Bad!!!!!!!")
		    					.setMessage("   You Blew It  ")
		    					.setIcon(R.drawable.comn)
		    					.setCancelable(false)
		    					.setNegativeButton("Œkay, I agree",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU LOSE
		    }
		});     
		/* END 8 button click*/
		//------------------------------------------------------------------------------------------
			
		
		
		
		
		
		
		
		
		
		
		/* 9 button click*/
		btn9.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    	btn9.setText("X"); 
		    	//Random start
		    	final Random random = new Random();
		    	int randomme=random.nextInt(9) + 1;
		    	final String randd=String.valueOf(randomme);
		    	//btn2.setText(randd); 
		    	//value of  a button
		    	final String text = btn1.getText().toString();
		    //END value
		    	
		    	// IF 1
		    	//if(randomme==1)
		    	//{btn3.setText("0");}
		    	
		    	//END IF 2
		    	
		    	
		    	
		    	
		    	//Start if 1
		    	if(randomme==1)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn1.getText().toString())) {//2
		    		 btn1.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end1
		    	//End start if 1

		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 2
		    	if(randomme==2)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn2.getText().toString())) {//2
		    		 btn2.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end2
		    	//End start if 2
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 3
		    	if(randomme==3)    { //1 
		    	// if(text!"success".equals('x') ) {//2
		    		
		    		//EQUALS
		    		/*public static void main(String args[]) {
		    		String str1= btn1.getText().toString();
		    		String str2= "x";
		    		StringBuffer str3 = new StringBuffer('x');
		    	    boolean  result = str3.contentEquals( str1 );}*/
		    		
		    		
		    		if(TextUtils.isEmpty(btn3.getText().toString())) {//2
		    		 btn3.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	
		    	} // end3
		    	//End start if 3
		    	
		    	
		    	
		    	
		    	
		    	

		    	//Start if 4
		    	if(randomme==4)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn4.getText().toString())) {//2
		    		 btn4.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 4
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 5
		    	if(randomme==5)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn5.getText().toString())) {//2
		    		 btn5.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 5
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 6
		    	if(randomme==6)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn6.getText().toString())) {//2
		    		 btn6.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 6
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 7
		    	if(randomme==7)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn7.getText().toString())) {//2
		    		 btn7.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 7
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	//Start if 8
		    	if(randomme==8)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn8.getText().toString())) {//2
		    		 btn8.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	else  if (TextUtils.isEmpty(btn9.getText().toString())) {btn9.setText("0");}
		    	} 
		    	//End start if 8
		    	
		    	
		    	
		    	
		    	
		    	//Start if 9
		    	if(randomme==9)    { //1 
		    	
		    		if(TextUtils.isEmpty(btn9.getText().toString())) {//2
		    		 btn9.setText("0");}
		    	 
		    	else  if (TextUtils.isEmpty(btn2.getText().toString())) {btn2.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn3.getText().toString())) {btn3.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn1.getText().toString())) {btn1.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn4.getText().toString())) {btn4.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn6.getText().toString())) {btn6.setText("0");} 
		    	else  if (TextUtils.isEmpty(btn7.getText().toString())) {btn7.setText("0");}
		    	else  if (TextUtils.isEmpty(btn8.getText().toString())) {btn8.setText("0");}
		    	else  if (TextUtils.isEmpty(btn5.getText().toString())) {btn5.setText("0");}
		    	} 
		    	//End start if 9
		    	
		    	
		    	//End random
		    	
//START YOU WIN
	    		
		    	if((btn7.getText().toString().equals("X") && btn8.getText().toString().equals("X") && btn9.getText().toString().equals("X")) || (btn3.getText().toString().equals("X") && btn6.getText().toString().equals("X") && btn9.getText().toString().equals("X") ))
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Good!!!!!!!")
		    					.setMessage("   You Win  ")
		    					.setIcon(R.drawable.com)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ ",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU WIN
		    	
//START YOU LOSE
	    		
		    	if((btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0")) || (btn4.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0"))  || (btn2.getText().toString().equals("0") && btn5.getText().toString().equals("0") && btn8.getText().toString().equals("0")) || (btn1.getText().toString().equals("0") && btn4.getText().toString().equals("0") && btn7.getText().toString().equals("0"))   )
		    		    		
		    		    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
		    		    		builder.setTitle(" Bad!!!!!!!")
		    					.setMessage("   You Blew It  ")
		    					.setIcon(R.drawable.comn)
		    					.setCancelable(false)
		    					.setNegativeButton("Œ , I agree",
		    							new DialogInterface.OnClickListener() {
		    								public void onClick(DialogInterface dialog, int id) {
		    									dialog.cancel();
		    								}
		    							});
		    			AlertDialog alert = builder.create();
		    			alert.show();  // END ALERT
		    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
		    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
		    		    //END YOU LOSE
		    	
		    }
		});     
		/* END 9 button click*/
		//--------------------------------------------------------------------------------------
			
		
		
		
		
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//Start is the } END of onCreate!!!!!!!!!!!!!!!!!!!!!!!!!	
	}
	//End of  the } END of onCreate!!!!!!!!!!!!!!!!!!!!!
	
	
	//CREATE CONTEXT !!! Should add onClick actioner
			@Override
			public void  onCreateContextMenu (ContextMenu menu ,View v,ContextMenuInfo info){
				super.onCreateContextMenu(menu, v, info);
				menu.add(Menu.NONE, IDM_RESTORE, Menu.NONE,"New game");
				menu.add(Menu.NONE, IDM_PAUSE, Menu.NONE,"Some1");
				/*menu.add(Menu.NONE, IDM_TEL, Menu.NONE,"ÕÓÏÂ “ÂÎÂÙÓÌ‡/BlueTooth");
				menu.add(Menu.NONE, IDM_BEATS, Menu.NONE,"Play Sound");
				menu.add(Menu.NONE, IDM_SOME, Menu.NONE,"Go play the game");
				menu.add(Menu.NONE, IDM_Draw, Menu.NONE,"Canvas");
				menu.add(Menu.NONE, IDM_Draw2, Menu.NONE,"N/A");
				menu.add(Menu.NONE, IDM_GO, Menu.NONE,"EXIT");*/
				
			}
			//END CREATE CONTEXT
			
			
			

			// Context Menu onClick actioner
			@Override
			public boolean onContextItemSelected(MenuItem item) 
			{
				
				switch (item.getItemId()) 
				{
				    case IDM_RESTORE:
				    	btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
				    	btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText("");
					        break;
					    
					   
				    case IDM_PAUSE:
		             break;   
											
					   	default:
					    return super.onContextItemSelected(item);
				}
				
				return true;
			}
			// END Menu onClick actioner
			
	
			
			
			// Track click if you win
			public void onClick(View view) 
			{
			    Button button = (Button) view;
			    if(btn1.getText().toString().equals("X") && btn2.getText().toString().equals("X") && btn3.getText().toString().equals("X"))
		    		
	    		{AlertDialog.Builder builder = new AlertDialog.Builder(Xzero.this);
	    		builder.setTitle("Nice")
				.setMessage("   You Win  ")
				.setCancelable(false)
				.setNegativeButton("Œ ",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();  // END ALERT
btn1.setText("");btn2.setText("");btn3.setText("");btn4.setText("");btn5.setText("");
btn6.setText("");btn7.setText("");btn8.setText("");btn9.setText(""); }
	    //END YOU WIN
	    	
	    }// END if {}
			   
			
			//END TRACK
			
			
			
			

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xzero, menu);
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
