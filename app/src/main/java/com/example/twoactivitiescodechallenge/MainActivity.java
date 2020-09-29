package com.example.twoactivitiescodechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivitiescodechallenge.extra.MESSAGE";
    private Button mMessageButton;
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button_one);
        btn2 = findViewById(R.id.button_two);
        btn3 = findViewById(R.id.button_three);
    }


    public void onClick(View view) {
        if(view == btn1){
            mMessageButton = btn1;
        }
        else if(view == btn2) {
            mMessageButton = btn2;
        }
        else if(view == btn3) {
            mMessageButton = btn3;
        }
    }


    public void launchSecondActivity(View view) {
        onClick(view);
        String message = "";

        if(mMessageButton == btn1) {
            Log.d(LOG_TAG, "Button One clicked!");
            message = getResources().getString(R.string.button_one_text);
        }
        else if(mMessageButton == btn2) {
            Log.d(LOG_TAG, "Button Two clicked!");
            message = getResources().getString(R.string.button_two_text);
        }
        else if(mMessageButton == btn3) {
            Log.d(LOG_TAG, "Button Three clicked!");
            message = getResources().getString(R.string.button_three_text);
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}