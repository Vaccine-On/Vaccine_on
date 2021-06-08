package com.example.vaccine_on;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeNicknameActivity extends AppCompatActivity {
    EditText insert_nickname;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);

        insert_nickname = (EditText) findViewById(R.id.insert_nickname);
        button = (Button) findViewById(R.id.button);

        Intent intent = getIntent();



    }

    // EditText에 적은 것이 TextView에 나타나도록
    public void btn_Click(View view) {
        TextView textView = (TextView)findViewById(R.id.show_nickname);
        EditText editText = (EditText) findViewById(R.id.insert_nickname);

        textView.setText(editText.getText());
    }
}