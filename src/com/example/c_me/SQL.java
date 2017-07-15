package com.example.c_me;



import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SQL extends FragmentActivity implements LoaderCallbacks<Cursor> {

  private static final int CM_DELETE_ID = 1;
  ListView lvData;
  DB db;
  SimpleCursorAdapter scAdapter;
  
  //INPUT
  private TextView mHelloTextView;
  private EditText mNameEditText;
  private TextView gift;

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sql);
    
    
    //INPUT
   // mHelloTextView = (TextView)findViewById(R.id.newentry);
    mNameEditText = (EditText) findViewById(R.id.newentry);
    //gift = (TextView) mNameEditText.getText();
    
    
    // открываем подключение к БД
    db = new DB(this);
    db.open();
    
    // формируем столбцы сопоставления
    String[] from = new String[] { DB.COLUMN_IMG, DB.COLUMN_TXT };
    int[] to = new int[] { R.id.ivImg, R.id.tvText };

    // создааем адаптер и настраиваем список
    scAdapter = new SimpleCursorAdapter(this, R.layout.item, null, from, to, 0);
    lvData = (ListView) findViewById(R.id.lvData);
    lvData.setAdapter(scAdapter);

    // добавляем контекстное меню к списку
    registerForContextMenu(lvData);
    
    // создаем лоадер для чтения данных
    getSupportLoaderManager().initLoader(0, null, this);
  }

  // обработка нажатия кнопки
  public void onButtonClick(View view) {
    // добавляем запись
	  //
   
	db.addRec(mNameEditText.getText().toString() /*+  (scAdapter.getCount() + 1)*/, R.drawable.ic_launcher);
    // получаем новый курсор с данными
    getSupportLoaderManager().getLoader(0).forceLoad();
    // CLEAR editText after ENTER
    mNameEditText.setText("");
    // END CLEAR editText after ENTER
           //START HIDE KEYBOARD
	InputMethodManager imm = (InputMethodManager)getSystemService(
		      Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(mNameEditText.getWindowToken(), 0);
	//END HIDE KEYBOARD
  }
  
  public void onCreateContextMenu(ContextMenu menu, View v,
      ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    menu.add(0, CM_DELETE_ID, 0, R.string.delete_record);
  }

  public boolean onContextItemSelected(MenuItem item) {
    if (item.getItemId() == CM_DELETE_ID) {
      // получаем из пункта контекстного меню данные по пункту списка
      AdapterContextMenuInfo acmi = (AdapterContextMenuInfo) item
          .getMenuInfo();
      // извлекаем id записи и удаляем соответствующую запись в БД
      db.delRec(acmi.id);
      // получаем новый курсор с данными
      getSupportLoaderManager().getLoader(0).forceLoad();
      return true;
    }
    return super.onContextItemSelected(item);
  }

  protected void onDestroy() {
    super.onDestroy();
    // закрываем подключение при выходе
    db.close();
  }

  @Override
  public Loader<Cursor> onCreateLoader(int id, Bundle bndl) {
    return new MyCursorLoader(this, db);
  }

  @Override
  public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
    scAdapter.swapCursor(cursor);
  }

  @Override
  public void onLoaderReset(Loader<Cursor> loader) {
  }
  
  static class MyCursorLoader extends CursorLoader {

    DB db;
    
    public MyCursorLoader(Context context, DB db) {
      super(context);
      this.db = db;
    }
    
    @Override
    public Cursor loadInBackground() {
      Cursor cursor = db.getAllData();
     // DISABLED SLEEP
      try {
        TimeUnit.SECONDS.sleep(0);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return cursor;
    }
    
  }
}
