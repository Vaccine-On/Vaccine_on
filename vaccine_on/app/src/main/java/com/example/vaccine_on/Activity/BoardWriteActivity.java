package com.example.vaccine_on.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vaccine_on.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BoardWriteActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    TextView writeTitle;
    TextView writeContent;
    String TAG = "BoardWrite";

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    String time = mFormat.format(date);
    Button write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        db = FirebaseFirestore.getInstance();
        writeTitle = findViewById(R.id.write_title);
        writeContent = findViewById(R.id.write_content);
        write = findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> board = new HashMap<>();
                board.put("boardTitle", writeTitle.getText().toString());
                board.put("content", writeContent.getText().toString());
                board.put("date", time);
                board.put("image", "");
                board.put("user", "코로롱");

                db.collection("board").document()
                        .set(board)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });

                finish();
            }
        });
    }
}