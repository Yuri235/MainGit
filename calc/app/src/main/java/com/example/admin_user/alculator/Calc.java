package com.example.admin_user.alculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calc extends AppCompatActivity {
    TextView screen;

    char lastSymbolInDisplay;
    String WhatWeSeeOnDisplay ="";
    String WhatWeSeeOnDisplay2="";
    String WhatWeSeeOnDisplay3="You enter incorrect means";
    String symbolnow;
    String result;
    Button symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        screen = (TextView) findViewById(R.id.textView2);
        screen.setText(WhatWeSeeOnDisplay);
    }


    public void onClickNumber(View view){
        Button number = (Button) view;
    if(WhatWeSeeOnDisplay.length() >= 2) {
        if (WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '/' || WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '+'
                || WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '-' || WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '*') {
            if (number.getText().toString().equals("0")) {
                WhatWeSeeOnDisplay = WhatWeSeeOnDisplay + "";
            } else {
                WhatWeSeeOnDisplay = WhatWeSeeOnDisplay + number.getText();
            }
        }
        else {
            WhatWeSeeOnDisplay = WhatWeSeeOnDisplay + number.getText();
        }
    }
    else{
        WhatWeSeeOnDisplay = WhatWeSeeOnDisplay + number.getText();
    }
    if(WhatWeSeeOnDisplay.charAt(0) == '0' ){
        WhatWeSeeOnDisplay = "";
    }
        screen.setText(WhatWeSeeOnDisplay);
    }

    public void clear(View view){
        WhatWeSeeOnDisplay ="";
        screen.setText(WhatWeSeeOnDisplay);
    }


    public void onClickSymbol(View view){
         symbol = (Button) view;

        if(WhatWeSeeOnDisplay.equals("")){
            WhatWeSeeOnDisplay = "";
            screen.setText(WhatWeSeeOnDisplay);
        }else{
            lastSymbolInDisplay = WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1 );
            if( lastSymbolInDisplay  == '/' ||  lastSymbolInDisplay  == '+'
                    ||  lastSymbolInDisplay == '*' ||  lastSymbolInDisplay == '-') {

                char [] charArray = WhatWeSeeOnDisplay.toCharArray();
                charArray[charArray.length - 1] = symbol.getText().charAt(0);
                WhatWeSeeOnDisplay = new String(charArray);

                screen.setText(WhatWeSeeOnDisplay);
            }

            else{
                WhatWeSeeOnDisplay = WhatWeSeeOnDisplay + symbol.getText();
                screen.setText(WhatWeSeeOnDisplay);
            }
                screen.setText(WhatWeSeeOnDisplay);
        }
    }

    private void calculate (String a , String b  , String symbols ){

        switch (symbols){
            case "+": result =  String.valueOf(Double.valueOf(a) + Double.valueOf(b)) ;
                screen.setText(WhatWeSeeOnDisplay + "\n" +result);
                WhatWeSeeOnDisplay = result;
                break;
            case "-": result = String.valueOf(Double.valueOf(a) - Double.valueOf(b));
                screen.setText(WhatWeSeeOnDisplay + "\n" +result);

                WhatWeSeeOnDisplay = result;
                break;
            case "*": result = String.valueOf(Double.valueOf(a) * Double.valueOf(b));
                screen.setText(WhatWeSeeOnDisplay + "\n" +result);
                WhatWeSeeOnDisplay = result;
                break;
            case "/":
                result = String.valueOf(Double.valueOf(a) / Double.valueOf(b));
                screen.setText(WhatWeSeeOnDisplay + "\n" +result);
                WhatWeSeeOnDisplay = result;
                break;
        }
    }

    public void equal (View view){
        if(WhatWeSeeOnDisplay.equals("")){
            WhatWeSeeOnDisplay = "This operation is unavailable";
            screen.setText(WhatWeSeeOnDisplay);
            WhatWeSeeOnDisplay = "";
            return;
        }
        else{
            if(WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '/' || WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '+'
                    ||WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '*' ||  WhatWeSeeOnDisplay.charAt(WhatWeSeeOnDisplay.length() - 1) == '-' ){
                WhatWeSeeOnDisplay = "You enter wrong mean";
                screen.setText(WhatWeSeeOnDisplay);
                WhatWeSeeOnDisplay = "";
            }
        }
            String [] mas = WhatWeSeeOnDisplay.split(Pattern.quote(symbol.getText().toString()));
            char [] firstmas = mas[0].toCharArray();
            for(int i = 0; i < firstmas.length ; i++){
                if(firstmas[i] == '/' || firstmas[i] == '+'|| firstmas[i] == '*'|| firstmas[i] == '-'){
                    WhatWeSeeOnDisplay = "You enter wrong mean";
                    screen.setText(WhatWeSeeOnDisplay);
                    WhatWeSeeOnDisplay = "";
                    return;
                }
            }
            if(mas.length < 2 || mas.length > 2 ){
                WhatWeSeeOnDisplay = "You enter wrong mean";
                screen.setText(WhatWeSeeOnDisplay);
                WhatWeSeeOnDisplay = "";
            }
            else{
                calculate( mas[0] , mas[1] , symbol.getText().toString());
            }
        }
    }



