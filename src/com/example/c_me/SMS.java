package com.example.c_me;

import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;

public class SMS extends Activity {
	
	//ADDRESS
	private static final int CONTACT_PICK_RESULT = 666;
    private static final String LOG_TAG = "my_tag";
    String mContactId;
    String mPhoneNumber;
    String mContactName;
    String mEmail;
    //END ADDRESS
	
	//Browser
	    private WebView mWebView;
	
	//Button Internet
	    private Button btnINET;
	//Button CALL
		private Button btnCALL;
	//Button SEND SMS
		private Button btnSMSSEND;
	
	//INET EDITTEXT
	       private EditText INETEditText;
	//CALL EDITTEXT
		   private EditText CALLEditText;
	//SMS EDITEXT
		   private EditText SMSMESSEditText;
		   private EditText SMSTOEditText;
		
		   //Imagebutton  to  send e-MAIL
		   ImageButton imgbtnmail;
		   
		 //Imagebutton  to  send e-MAIL
		   ImageButton imgaddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//remove  title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
		setContentView(R.layout.activity_sms);
		
		
		//FIND INET BUTTON
		btnINET = (Button) findViewById(R.id.INETME);
		//FIND CALL BUTTON
		btnCALL = (Button) findViewById(R.id.CALLMe);
		//FIND SMS BUTTON
		btnSMSSEND= (Button) findViewById(R.id.SMSME);
		
		
		//FIND Webview
		mWebView = (WebView) findViewById(R.id.webview);
		
		//FIND INET EDITTEXT
		INETEditText = (EditText) findViewById(R.id.INETeditText);
		//FIND CALL EDITTEXT
		CALLEditText = (EditText) findViewById(R.id.CALLeditText);
		//FIND SMSSEND EDITTEXT
		SMSMESSEditText = (EditText) findViewById(R.id.editTextSMS);
		SMSTOEditText = (EditText) findViewById(R.id.editTextSMSTO);
		
		
		//Find ImageButton E-mail
		imgbtnmail = (ImageButton) findViewById(R.id.imageButtonMail);
		
		imgaddress= (ImageButton) findViewById(R.id.imageButtonAdrBook);
		
		/* INET button click*/
		btnINET.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        
		    	
		    	
		  
		    	//Browser
				//mWebView = (WebView) findViewById(R.id.webview);
				// включаем поддержку JavaScript
			    mWebView.getSettings().setJavaScriptEnabled(true);
				// указываем страницу загрузки
			    mWebView.loadUrl("http://"+INETEditText.getText().toString()); 
			   // mWebView.loadUrl("http://smthing.com"); 
				//END Browser
			    Toast toast = Toast.makeText(getApplicationContext(), 
						INETEditText.getText().toString()+" is loading",
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();   
		    	//START HIDE KEYBOARD
				InputMethodManager imm = (InputMethodManager)getSystemService(
					      Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(INETEditText.getWindowToken(), 0);
				//END HIDE KEYBOARD
		    }
		});     
		/* END INET button click*/
		
		
		//LET ALL LINKS
		//THIS CLASS IS IN SEPERATE CLASS= HelloWebViewClient.java
		mWebView.setWebViewClient(new HelloWebViewClient());
		//END LET 
		
		
		
		
		
		
		
		/* CALL button click*/
		btnCALL.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        
		    	
		    	String number = CALLEditText.getText().toString();
		        Intent intent = new Intent(Intent.ACTION_CALL);
		        intent.setData(Uri.parse("tel:" +number ));
		        startActivity(intent);
		    	
		    }
		});     
		/* END CALL button click*/
		
		
		
		
		
		
		/* SEND SMS button click*/
		btnSMSSEND.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		        
		    	
		    	String phoneNumber = SMSMESSEditText.getText().toString();
		    	String messageR = SMSTOEditText .getText().toString();
		    	
		    	 //SmsManager sms = SmsManager.getDefault();
		    	android.telephony.SmsManager sms=android.telephony.SmsManager.getDefault();
		         sms.sendTextMessage(phoneNumber, null, messageR, null, null);
		         
		         Toast toast = Toast.makeText(getApplicationContext(), 
		 				"SMS TO"+phoneNumber+" has been sent",
		 				Toast.LENGTH_SHORT);
		 		        toast.setGravity(Gravity.CENTER, 0, 0);
		 		        toast.show(); 
		    }
		});     
		/* END SEND SMS button click*/
		  
		
		
		
		//E-mail  click  Listener------------------------------------------------------------------------------------------------
		
		imgbtnmail.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View view) {
		    Intent mail=new Intent(SMS.this,Emailme.class);	
		    startActivity(mail);
		    	
		    }
		});
		// END E-mail  click  Listener--------------------------------------------------------------------------------------------
		
		
		
		//Address click  Listener------------------------------------------------------------------------------------------------
		
		imgaddress.setOnClickListener(new OnClickListener() {
				    @Override
				    public void onClick(View view) {
				    	
				    	//
				    	/*Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
				                Contacts.CONTENT_URI);
				    	startActivity(contactPickerIntent);*/
				    	//Function  pickContact
				    	pickContact(view );
				    					    	
				    //	
				    }
				});
				// END Address  click  Listener-----------------------------------------------------------
		
		
		
		
		
	// ONCREATE ENDS	
	}

	
	
	//All Links
	/*private class HelloWebViewClient extends WebViewClient 
	{
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) 
	    {
	        view.loadUrl(url);
	        return true;
	    }
	} */
	//END AlL LINKS
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sm, menu);
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
	
	
	
	
	
	
	// Pick address***************************************
	public void pickContact(View v) {

    	Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, CONTACT_PICK_RESULT);
    }
 
    protected void onActivityResult(int requestCode, int resultCode, 
            Intent data) {
        if (resultCode == RESULT_OK) {
 
            switch (requestCode) {            
                case CONTACT_PICK_RESULT:
                    Uri contactData = data.getData();
                    Cursor c =  getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToNext()) {
                        mContactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                        mContactName = c.getString(c.getColumnIndexOrThrow(
                                ContactsContract.Contacts.DISPLAY_NAME)); 
 
                        String hasPhone = c.getString(c.getColumnIndex(
                                ContactsContract.Contacts.HAS_PHONE_NUMBER));
 
                       Log.d(LOG_TAG, "name: " + mContactName);
                       Log.d(LOG_TAG, "hasPhone:" + hasPhone);
                       Log.d(LOG_TAG, "contactId:" + mContactId);
 
                        // если есть телефоны, получаем и выводим их
                        if (hasPhone.equalsIgnoreCase("1")) {                   	
                            Cursor phones = getContentResolver().query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ mContactId,
                                    null, 
                                    null);
 
                        while (phones.moveToNext()) {
                            mPhoneNumber = phones.getString(phones.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER));
                            Log.d(LOG_TAG, "телефон:" + mPhoneNumber);
                           // SMSMESSEditText.setText(mPhoneNumber);
                        }
                        //My set Number
                        SMSMESSEditText.setText(mPhoneNumber);
                        phones.close();
                    }
 
                    // Достаем email-ы
                    Cursor emails = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + mContactId,
                            null, 
                            null);
                    while (emails.moveToNext()) {
                        mEmail = emails.getString(
                                emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        Log.d(LOG_TAG, "email:" + mEmail);
                    }
                    emails.close();                                                          
                }        	
                break;
            }
 
        } else {            
           Log.d(LOG_TAG, "ERROR");
        }
    	
    }
	// End Pic Address
	
	
	
	
	
	
}
