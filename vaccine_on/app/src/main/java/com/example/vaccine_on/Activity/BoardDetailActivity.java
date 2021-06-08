package com.example.vaccine_on.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.vaccine_on.Adapter.BoardAdapter;
import com.example.vaccine_on.BoardItemData;
import com.example.vaccine_on.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class BoardDetailActivity extends AppCompatActivity {
    String boardId;
    private ArrayList<BoardItemData> list = new ArrayList<>();
    private FirebaseFirestore db;
    TextView userName;
    TextView boardTitle;
    TextView content;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_detail);

        db = FirebaseFirestore.getInstance();
        boardId = getIntent().getStringExtra("boardId");
        userName = findViewById(R.id.detail_user_name);
        boardTitle = findViewById(R.id.detail_board_title);
        content = findViewById(R.id.detail_content);
        date = findViewById(R.id.detail_date);

        db.collection("board").document(boardId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot documentSnapshot = task.getResult();
                userName.setText(documentSnapshot.get("user").toString());
                boardTitle.setText(documentSnapshot.get("boardTitle").toString());
                content.setText(documentSnapshot.get("content").toString());
                date.setText(documentSnapshot.get("date").toString());
            } else {
                Log.e("DetailActivity", task.getException().getMessage().toString());
            }
        });
    }
}