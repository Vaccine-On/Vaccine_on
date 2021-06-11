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
        TextView clCdNmView = findViewById(R.id.clCdNmView);


        // 상세정보 보여주기
        Intent intent = getIntent();
        Log.d("겟 인텐트", "성공");
        infoView.setText(intent.getStringExtra("name"));
        name.setText(intent.getStringExtra("name"));
        address.setText(intent.getStringExtra("addr"));
        tel.setText(intent.getStringExtra("tel"));
        homepage.setText(intent.getStringExtra("url"));
        clCdNmView.setText(intent.getStringExtra("clCdNm"));
        Log.d("상세보기", "성공" + intent.getStringExtra("name"));


        String urlAdress = intent.getStringExtra("url");
        //병원 사이트 이동
        Log.d("연결 전", urlAdress);

        urlbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlAdress));
                    Log.d("홈페이지연결", urlAdress);
                    startActivity(urlIntent);
                } catch (Exception e){
                    Log.d("에러",""+e);
                }
            }
        });
    }
}