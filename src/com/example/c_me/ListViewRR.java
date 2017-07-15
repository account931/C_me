package com.example.c_me;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView.AdapterContextMenuInfo;
//import android.support.v7.internal.widget.AdapterViewICS.AdapterContextMenuInfo;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListViewRR extends Activity /* ListActivity implements AdapterView.OnItemLongClickListener */{
	
	//
	public Button TimerSett;

	 private static final int CM_DELETE_ID = 1;
	
  // ����� ��������� ��� Map
  final String ATTRIBUTE_NAME_TEXT = "text";
  final String ATTRIBUTE_NAME_CHECKED = "checked";
  final String ATTRIBUTE_NAME_IMAGE = "image";

  ListView lvSimple;
  
  //Added
  SimpleAdapter sAdapter;
  ArrayList<Map<String, Object>> data;
  Map<String, Object> m;
  //END ADDED

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view);
    
    // Mine
    TimerSett=(Button) findViewById(R.id.buttonSet);
    
    

    // ������� ������
    
 //   ArrayList<String> texts = new ArrayList<String>();   //Mine
    String[] texts = { "sometext 1", "sometext 2", "sometext 3",
        "sometext 4", "sometext 5","textFalse" };
    boolean[] checked = { true, false, false, true, false,false };  //boolean[] checked = { true/*, false, false, true, false,false */};
    int img = R.drawable.ic_launcher;

    // ����������� ������ � �������� ��� �������� ���������
    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
        texts.length);    
    //ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.size()/*length*/);
    
    
    Map<String, Object> m;
    for (int i = 0; i < texts.length; i++) {  // for (int i = 0; i < texts.size()/*length*/; i++) {
      m = new HashMap<String, Object>();
      m.put(ATTRIBUTE_NAME_TEXT, texts[i]); // m.put(ATTRIBUTE_NAME_TEXT, texts[i]);  m.put(ATTRIBUTE_NAME_TEXT, texts.get(i));
      m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
      m.put(ATTRIBUTE_NAME_IMAGE, img);
      data.add(m);
    }
    
  

    // ������ ���� ���������, �� ������� ����� �������� ������
    String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED,
        ATTRIBUTE_NAME_IMAGE };
    // ������ ID View-�����������, � ������� ����� ��������� ������
    int[] to = { R.id.tvText, R.id.cbChecked, R.id.ivImg };

    // ������� �������
    SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item_listview,
        from, to);

    // ���������� ������ � ����������� ��� �������
    lvSimple = (ListView) findViewById(R.id.lvSimple);
    lvSimple.setAdapter(sAdapter); 
    
    //ADDED
    registerForContextMenu(lvSimple);
    
    
  
 // button click
    TimerSett.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
	     
	    	  //
	    	  ArrayList<String> texts = new ArrayList<String>();
	        texts.add("GAV");
	        //SimpleAdapter sAdapter = null;
	        //sAdapter.notifyDataSetChanged();
	        
	        //
	    }
	});     
	/* END CALL button click*/
    
    
    
    
  }  //END ONCREATE
  
  
 
  
  
  //ADDED
/*  public void onButtonClick(View v) {
	    // ������� ����� Map
	    m = new HashMap<String, Object>();
	    m.put(ATTRIBUTE_NAME_TEXT, "sometext " + (data.size() + 1));
	    m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher);
	    // ��������� ��� � ���������
	    data.add(m);
	    // ����������, ��� ������ ����������
	    sAdapter.notifyDataSetChanged();
	  }*/

	  @Override
	  public void onCreateContextMenu(ContextMenu menu, View v,
	      ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    menu.add(0, CM_DELETE_ID, 0, "������� ������");
	  }

	  @Override
	  public boolean onContextItemSelected(MenuItem item) {
	    if (item.getItemId() == CM_DELETE_ID) {
	      // �������� ���� � ������ ������
	      AdapterContextMenuInfo acmi = (AdapterContextMenuInfo) item.getMenuInfo();
	      // ������� Map �� ���������, ��������� ������� ������ � ������
	      data.remove(acmi.position);
	      // ����������, ��� ������ ����������
	      sAdapter.notifyDataSetChanged();
	      return true;
	    }
	    return super.onContextItemSelected(item);
	  }
  //END ADDED
	  
	  
	  
	  
	  
	
} 