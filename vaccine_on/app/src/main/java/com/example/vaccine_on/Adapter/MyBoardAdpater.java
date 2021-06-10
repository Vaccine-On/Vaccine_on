package com.example.vaccine_on.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_on.Activity.MyBoardDetailActivity;
import com.example.vaccine_on.R;

import java.util.ArrayList;
import java.util.List;

public class MyBoardAdpater extends RecyclerView.Adapter<MyBoardAdpater.Holder> {

    private Context context;
    private List<MyBoardAdpater> list = new ArrayList<>();
    private String postId;
    private String postDate;
    private String postTitle;


    public MyBoardAdpater(Context context, ArrayList<MyBoardAdpater> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 최초 생성
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myboard_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @NonNull
    public void onBindViewHolder(Holder holder, int position) {
        int itemposition = position;

        holder.postDateText.setText(list.get(itemposition).postDate);
        holder.postTitleText.setText(list.get(itemposition).postTitle);

        Log.e("StudyApp", "onBindViewHolder" + itemposition);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemposition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, MyBoardDetailActivity.class);
                    intent.putExtra("boardId", list.get(itemposition).postId);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size(); // 리사이클러뷰의 size
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView postDateText;
        public TextView postTitleText;

        public Holder(View view) {
            super(view);
            postDateText = (TextView) view.findViewById(R.id.postDate);
            postTitleText = (TextView) view.findViewById(R.id.postTitle);
        }
    }
}
