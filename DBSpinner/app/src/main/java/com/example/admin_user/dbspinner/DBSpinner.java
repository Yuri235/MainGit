package com.example.admin_user.dbspinner;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin_user.dbspinner.DB.DBHelper;

public class DBSpinner extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    TextView textView ;
    ListView listView;
    Spinner spinner;
    String [] array;
    DBHelper dbHelper;
    SQLiteDatabase database;
    ArrayAdapter<String> arrayAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbspinner);


        textView = (TextView) findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.listView);
        spinner = (Spinner) findViewById(R.id.spinner);
        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        array = new String [4];
        imageView = (ImageView) findViewById(R.id.imageView);

        fillDataBase();
        fillArray ();

        arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , array );
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);



    }

    //Заполняем базу данных
    private void fillDataBase(){
        database.delete(DBHelper.TABLE_NAME , null , null);

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.TYPES_ANIMALS , "Выберите тип животных");
        database.insert(DBHelper.TABLE_NAME, null , contentValues);

        contentValues.put(DBHelper.TYPES_ANIMALS , "Млекопитающие");
        database.insert(DBHelper.TABLE_NAME , null , contentValues);

        contentValues.put(DBHelper.TYPES_ANIMALS , "Насекомые");
        database.insert(DBHelper.TABLE_NAME , null , contentValues);

        contentValues.put(DBHelper.TYPES_ANIMALS , "Сумчатые");
        database.insert(DBHelper.TABLE_NAME , null , contentValues);
    }



    private void fillArray (){
        Cursor cursor = database.rawQuery("select * from " + DBHelper.TABLE_NAME , null);
        int indexColumn = cursor.getColumnIndex(DBHelper.TYPES_ANIMALS);
        //Перемещаем курсор на первую строку нашей БД
        cursor.moveToFirst();
        //Заполняем массив
        for ( int i = 0 ; i < 4 ; i++){
            array[i] = cursor.getString(indexColumn);
            cursor.moveToNext();
        }
        cursor.close();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i){
            case 0:
                String [] nothing = {""};
                ArrayAdapter<String> nothingAdapter = new ArrayAdapter <> (this , android.R.layout.simple_list_item_1 , nothing);
                listView.setAdapter(nothingAdapter);
                imageView.setImageResource(R.drawable.white);
                break;

            case 1:
                String [] arr = {"Собака" , "Конь"};
                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , arr );
                listView.setAdapter(arrayAdapter1);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 0:
                                textView.setText("IT IS DOG");
                                imageView.setImageResource(R.drawable.dog);
                                break;
                            case 1:
                                textView.setText("IT IS HORSE");
                                imageView.setImageResource(R.drawable.horse);
                                break;

                        }
                    }
                });
                break;

            case 2:
                String [] arrs = {"spider" , "ant"};
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , arrs);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 0:
                                textView.setText("IT IS SPIDER");
                                imageView.setImageResource(R.drawable.spider);
                                break;
                            case 1:
                                textView.setText("IT IS ANT");
                                imageView.setImageResource(R.drawable.ant);
                                break;
                        }
                    }
                });
                break;
            case 3:
                String [] arrse = {"Kengo" , "opossum"};
                ArrayAdapter<String> adaptere = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , arrse);
                listView.setAdapter(adaptere);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 0:
                                textView.setText("IT IS KANGAROO");
                                imageView.setImageResource(R.drawable.kangaroo);
                                break;
                            case 1:
                                textView.setText("IT IS OPOSSUM");
                                imageView.setImageResource(R.drawable.opossum);
                                break;
                              }
                    }
                });
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

