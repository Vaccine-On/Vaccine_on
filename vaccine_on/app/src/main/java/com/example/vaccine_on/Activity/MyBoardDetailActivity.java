package com.example.vaccine_on.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.vaccine_on.MyBoardItemData;
import com.example.vaccine_on.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MyBoardDetailActivity extends AppCompatActivity {

    String postId;

    private ArrayList<MyBoardItemData> list = new ArrayList<>();
    private FirebaseFirestore db;

    TextView myName;
    TextView myTitle;
    TextView myContent;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_board_detail);

        db = FirebaseFirestore.getInstance();
        postId = getIntent().getStringExtra("boardId");
        myName = findViewById(R.id.detail_my_name);
        myTitle = findViewById(R.id.detail_mytitle);
        myContent = findViewById(R.id.detail_mycontent);
        myDate = findViewById(R.id.detail_mydate);

        db.collection("board").document("boardId").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot documentSnapshot = task.getResult();
                myName.setText(documentSnapshot.get("user").toString());
                myTitle.setText(documentSnapshot.get("boardTitle").toString());
                myContent.setText(documentSnapshot.get("content").toString());
                myDate.setText(documentSnapshot.get("date").toString());
            } else {
                Log.e("DetailActivity", task.getException().getMessage().toString());
            }
        });
    }
}