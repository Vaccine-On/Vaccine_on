package com.example.vaccine_on.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vaccine_on.R;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        TextView infoView = findViewById(R.id.infoView);
        TextView hospitallInfoView = findViewById(R.id.hospitallInfoView);
        TextView nameView = findViewById(R.id.nameView);
        TextView addrView = findViewById(R.id.addrView);
        TextView telView = findViewById(R.id.telView);
        TextView urlView = findViewById(R.id.urlView);
        TextView name = findViewById(R.id.name);
        TextView address = findViewById(R.id.address);
        TextView tel = findViewById(R.id.tel);
        TextView homepage = findViewById(R.id.homepage);
        Button urlbutton = findViewById(R.id.urlButton);



        Intent intent = getIntent();
        Log.d("겟 인텐트", "성공");
        infoView.setText(intent.getStringExtra("name"));
        name.setText(intent.getStringExtra("name"));
        address.setText(intent.getStringExtra("addr"));
        tel.setText(intent.getStringExtra("tel"));
        homepage.setText(intent.getStringExtra("url"));
        Log.d("상세보기", "성공" + intent.getStringExtra("name"));


        urlbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(homepage.toString()));
                Log.d("홈페이지연결", homepage.toString());
                startActivity(urlIntent);
            }
        });
    }
}