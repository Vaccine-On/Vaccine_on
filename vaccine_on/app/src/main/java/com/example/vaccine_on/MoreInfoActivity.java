package com.example.vaccine_on;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Button urlButton = findViewById(R.id.urlButton);
        Button callButton = findViewById(R.id.callButton);


        //상세정보 보여주기
        Intent intent = getIntent();
        Log.d("겟 인텐트", "성공");
        infoView.setText(intent.getStringExtra("name"));
        name.setText(intent.getStringExtra("name"));
        address.setText(intent.getStringExtra("addr"));
        tel.setText(intent.getStringExtra("tel"));
        homepage.setText(intent.getStringExtra("url"));
        Log.d("상세보기", "성공" + intent.getStringExtra("name"));

        String urlAdress = intent.getStringExtra("url");
        String call = intent.getStringExtra("tel");


        //병원 사이트 이동
        Log.d("연결 전", urlAdress);
        urlButton.setOnClickListener(new View.OnClickListener() {
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


        //전화걸기
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String telResult = changeTel(intent.getStringExtra("tel"));

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse(telResult));
                    Log.d("홈페이지연결", call);
                    startActivity(callIntent);
                } catch (Exception e){
                    Log.d("에러",""+e);
                }
            }
        });

    }

    String changeTel (String telOrigin) {
        String telResult = "";
        for (int i=0; i<telOrigin.length(); i++) {
            if (telOrigin.charAt(i) >= '0' && telOrigin.charAt(i) <= '9') {
                telResult += telOrigin.charAt(i);
            }
        }
        Log.d("전화번호", ""+telResult);
        return telResult;
    }
}


