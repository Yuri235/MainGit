package com.example.admin_user.wordbook;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin_user.wordbook.DBHelper.DBHelper;
import com.example.admin_user.wordbook.R;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WordBook extends AppCompatActivity {
    ListView listView;
    Button buttonDel;
    ArrayAdapter<String> adapter;
    DBHelper dbHelper;
    SQLiteDatabase database;
    ArrayAdapter <String> adapt;
    long userId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_book);

        listView = (ListView) findViewById(R.id.listView);
        String [] nothing = {""};
        adapt = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,nothing );

        buttonDel = (Button) findViewById(R.id.button5);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.delete(DBHelper.TABLE_NAME , null , null);
                listView.setAdapter(adapt);
                adapt.notifyDataSetChanged();
            }
        });

        String[] arr = new String[5000];
        Intent intent = getIntent();
        arr = intent.getStringArrayExtra("text");

        adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,arr );
        listView.setAdapter(adapter);


        dbHelper = new DBHelper(getApplicationContext());
        database = dbHelper.getWritableDatabase();
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            }
        });

    }


}




  /*

Cursor cursor = database.rawQuery("select * from " + DBHelper.TABLE_NAME, null);
                if (cursor.moveToFirst()) {
                    do {
                        int indexEnglish = cursor.getColumnIndex(DBHelper.ENGLISH_WORD);
                        int indexRussian = cursor.getColumnIndex(DBHelper.RUSSIAN_WORD);
                        int indexId = cursor.getColumnIndex(DBHelper.ID);
                            text = text + cursor.getInt(indexId) + cursor.getString(indexEnglish) + "        -        "
                                    + cursor.getString(indexRussian) + "\n" + "_" + "\n";

                    } while (cursor.moveToNext());
                }
                cursor.close();
                arr = text.split("_");
                text = "";




button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

   Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }
        if (userId > 0) {
            // получаем элемент по id из бд
            userCursor = database.rawQuery("select * from " + DBHelper.TABLE_NAME + " where " +
                    DBHelper.ID + "=?", new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();
            userCursor.close();
        } else {
            // скрываем кнопку удаления
            button.setVisibility(View.GONE);
        }






  public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selectedPhones.size();i++){
            adapter.remove(selectedPhones.get(i));
        }
        // снимаем все ранее установленные отметки
        phonesList.clearChoices();
        // очищаем массив выбраных объектов
        selectedPhones.clear();

        adapter.notifyDataSetChanged();
    }
}




String phone = adapter.getItem(position);
if(phonesList.isItemChecked(position)==true){
    selectedPhones.add(phone);
}



long[] array  = listView.getCheckedItemIds();
listView.removeViewAt(1);
for (int i = 0; i < array.length; i++) {
        database.delete(DBHelper.TABLE_NAME, DBHelper.ID + "=" + array[i], null);

}*/