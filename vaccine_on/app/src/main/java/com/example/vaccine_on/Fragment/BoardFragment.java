package com.example.vaccine_on.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vaccine_on.Activity.BoardDetailActivity;
import com.example.vaccine_on.Activity.BoardWriteActivity;
import com.example.vaccine_on.Adapter.BoardAdapter;
import com.example.vaccine_on.BoardItemData;
import com.example.vaccine_on.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class BoardFragment extends Fragment {

    private RecyclerView recyclerView;
    private BoardAdapter adapter;
    private ArrayList<BoardItemData> list = new ArrayList<>();
    private FirebaseFirestore db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_board, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.board_recyclerview);
        list = BoardItemData.createContactsList(10);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton writeBtn = rootView.findViewById(R.id.writeBtn);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BoardWriteActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        List<BoardItemData> list = new ArrayList<>();
        db.collection("board").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<DocumentSnapshot> documents = task.getResult().getDocuments();
                for (DocumentSnapshot document : documents) {
                    BoardItemData itemData = new BoardItemData(document.get("date").toString(), document.get("boardTitle").toString(), document.getId());
                    list.add(itemData);
                }
                adapter = new BoardAdapter(this.getContext(), list);
                recyclerView.setAdapter(adapter);
            } else {

            }
        });
    }
}