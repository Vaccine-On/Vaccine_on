package com.example.vaccine_on.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vaccine_on.R;

import com.example.vaccine_on.Fragment.MyPageFragment;

public class ChangeNicknameActivity extends AppCompatActivity {
    EditText insert_nickname;
    Button btn_nickname;
    TextView show_nickname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);

        insert_nickname = (EditText) findViewById(R.id.insert_nickname);
        btn_nickname = (Button) findViewById(R.id.btn_nickname);
        show_nickname = (TextView) findViewById(R.id.show_nickname);

        Intent intent = getIntent();

        btn_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show_nickname.setText(insert_nickname.getText());

                Intent intent = new Intent(ChangeNicknameActivity.this, MyPageFragment.class);
                startActivity(intent);
            }
        });

    }
}