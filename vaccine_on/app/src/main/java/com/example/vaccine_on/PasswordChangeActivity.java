package com.example.vaccine_on;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PasswordChangeActivity extends AppCompatActivity {
    EditText insert_password;
    Button btn_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        insert_password = (EditText) findViewById(R.id.insert_password);
        btn_password = (Button) findViewById(R.id.btn_password);

        Intent intent = getIntent();
    }
}