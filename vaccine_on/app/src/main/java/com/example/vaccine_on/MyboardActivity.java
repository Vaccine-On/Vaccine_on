package com.example.vaccine_on;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myboard);

        TextView text_title1 = (TextView) findViewById(R.id.title1);
        TextView text_title2 = (TextView) findViewById(R.id.title2);
        TextView text_title3 = (TextView) findViewById(R.id.title3);
        TextView text_title4 = (TextView) findViewById(R.id.title4);
        TextView text_title5 = (TextView) findViewById(R.id.title5);
        TextView text_title6 = (TextView) findViewById(R.id.title6);

        text_title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View1Activity.class);
                startActivity(intent);

            }
        });

        text_title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View2Activity.class);
                startActivity(intent);

            }
        });

        text_title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View3Activity.class);
                startActivity(intent);

            }
        });

        text_title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View4Activity.class);
                startActivity(intent);

            }
        });

        text_title5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View5Activity.class);
                startActivity(intent);

            }
        });

        text_title6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyboardActivity.this, View6Activity.class);
                startActivity(intent);

            }
        });

    }

}