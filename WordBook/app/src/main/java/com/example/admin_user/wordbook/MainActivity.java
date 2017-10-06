package com.example.admin_user.wordbook;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import com.example.admin_user.wordbook.DBHelper.DBHelper;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Spinner spinner;
    Button  openWordBook , addWord , startTraining , buttonRusOne , buttonRusTwo , buttonRusThree , buttonEngl;
    EditText editTextEnglish, editTextRussion;
    ArrayAdapter<String> arrayAdapter;
    DBHelper dbHelper;
    SQLiteDatabase database;
    String text = "";
    String[] arr;
    String [] englishArray;
    String [] russianArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] listOfTraining = {"Выберите тренировку", "слово-перевод", "перевод-слово"};
        textView = (TextView) findViewById(R.id.text);
        arr = new String[5000];

        editTextEnglish = (EditText) findViewById(R.id.editText);
        editTextRussion = (EditText) findViewById(R.id.editText2);

        addWord = (Button) findViewById(R.id.button);
        openWordBook = (Button) findViewById(R.id.button2);
        startTraining = (Button) findViewById(R.id.button6);



        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();

        //Прикрепляем слушателя к кнопке
        openWordBook.setOnClickListener(this);
        addWord.setOnClickListener(this);


        database.execSQL("delete from " + DBHelper.TABLE_NAME );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                   englishArray = new String [1000];
                     russianArray = new String [1000];

                    for(int i = 0 ; i < englishArray.length ; i++){
                        if(englishArray[i] == null){
                            englishArray[i] = editTextEnglish.getText().toString();
                            break;
                        }
                    }

                    for(int l = 0; l < russianArray.length; l++){
                        if(russianArray[l] == null) {
                            russianArray[l] = editTextRussion.getText().toString();
                            break;
                        }
                    }


                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBHelper.ENGLISH_WORD , editTextEnglish.getText().toString());
                    contentValues.put(DBHelper.RUSSIAN_WORD , editTextRussion.getText().toString());
                    database.insert(DBHelper.TABLE_NAME , null , contentValues);
                    Toast.makeText(this, "Cлово добавлено" , Toast.LENGTH_SHORT ).show();

                    break;
            case R.id.button2:
                    Cursor cursor = database.rawQuery("select * from " + DBHelper.TABLE_NAME, null);
                    int russianIndex =  cursor.getColumnIndex(DBHelper.RUSSIAN_WORD);
                    int englishIndex =  cursor.getColumnIndex(DBHelper.ENGLISH_WORD);
                    if(cursor.moveToFirst()){
                        do {
                            text = text + cursor.getString(russianIndex) + "    -    " + cursor.getString(englishIndex)
                                    + "_";
                        }while (cursor.moveToNext());
                    }
                    arr = text.split("_");
                    Intent intent = new Intent(this, WordBook.class);
                    intent.putExtra("text", arr);
                    startActivity(intent);
                    cursor.close();
                    break;
            /*
            case R.id.button6:
                    Random random = new Random();
                    int rand = random.nextInt(10) + 1;
                    int otherRand = random.nextInt(10) + 1;
                    int choose = random.nextInt(3) + 1;

                    buttonEngl.setText(englishArray[rand]);

                    if(choose == 1){
                        buttonRusOne.setText(russianArray[rand]);
                        buttonRusTwo.setText(russianArray[otherRand]);
                        buttonRusThree.setText(russianArray[otherRand]);
                    }

                    if(choose == 2){
                        buttonRusOne.setText(russianArray[otherRand]);
                        buttonRusTwo.setText(russianArray[rand]);
                        buttonRusThree.setText(russianArray[otherRand]);
                    }

                    if(choose == 3){
                        buttonRusOne.setText(russianArray[otherRand]);
                        buttonRusTwo.setText(russianArray[otherRand]);
                        buttonRusThree.setText(russianArray[rand]);
                    }
                    break;
            case R.id.button8:
                if(buttonRusOne.getText() == buttonEngl.getText()){
                    Toast.makeText(this, "Правильно!" , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Неверно!" ,Toast.LENGTH_LONG ).show();
                }
            case R.id.button9:
                if(buttonRusTwo.getText() == buttonEngl.getText()){
                    Toast.makeText(this, "Правильно!" , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Неверно!" ,Toast.LENGTH_LONG ).show();
                }
            case R.id.button10:
                if(buttonRusThree.getText() == buttonEngl.getText()){
                    Toast.makeText(this, "Правильно!" , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Неверно!" ,Toast.LENGTH_LONG ).show();
                }
*/
        }



    }
}




















         /*   //Создаем адаптер и прикрепляем его к спиннеру
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfTraining);
        spinner.setAdapter(arrayAdapter);


        //Прикрепляем слушателя к спиннеру
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

*/