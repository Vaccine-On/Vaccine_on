package com.example.vaccine_on;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        TextView infoView = findViewById(R.id.infoView);


        Intent intent = getIntent();
        Log.d("겟 인텐트", "성공");
        infoView.setText(intent.getStringExtra("name"));
        Log.d("상세보기", "성공" + intent.getStringExtra("name"));

    }
}