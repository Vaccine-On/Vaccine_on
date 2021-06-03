package com.example.vaccine_on;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeNicknameActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    // EditText에 적은 것이 TextView에 나타나도록
    public void btn_Click(View view) {
        TextView textView = (TextView)findViewById(R.id.show_nickname);
        EditText editText = (EditText) findViewById(R.id.insert_nickname);

        textView.setText(editText.getText());
    }
}
