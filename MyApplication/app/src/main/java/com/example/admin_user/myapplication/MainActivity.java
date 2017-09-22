package com.example.admin_user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.admin_user.myapplication.R.id.parent;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private String [] Types;
    private String [] Mleko;
    private String [] Insectoid;
    private String [] BagBeast;
    private ListView listView;
    private Spinner spinner;
    private TextView textView;
    private final static String DELF_DESCRIPTION = "It is Delf";
    private final static String DOG_DESCRIPTION = "It is Dog";

    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Types = getResources().getStringArray(R.array.TypesOfAnimals);
        Mleko = getResources().getStringArray(R.array.Млекопитающие);
        Insectoid = getResources().getStringArray(R.array.Насекомые);
        BagBeast = getResources().getStringArray(R.array.Сумчатые);

        listView = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Types);
        spinner.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);
     }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i){
            case 0:
                arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , Mleko );
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 0:
                                textView.setText(DELF_DESCRIPTION);
                                break;
                            case 1:
                                textView.setText(DOG_DESCRIPTION);
                                break;
                        }
                    }
                });
                break;
            case 1:
                arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , Insectoid);
                listView.setAdapter(arrayAdapter);
                break;
            case 2:
                arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_dropdown_item_1line , BagBeast);
                listView.setAdapter(arrayAdapter);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
