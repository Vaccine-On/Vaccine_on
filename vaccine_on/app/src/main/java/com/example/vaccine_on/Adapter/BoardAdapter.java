package com.example.vaccine_on.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine_on.BoardDetailActivity;
import com.example.vaccine_on.BoardItemData;
import com.example.vaccine_on.R;

import java.util.ArrayList;
import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.Holder> {

    private Context context;
    private List<BoardItemData> list = new ArrayList<>();

    public BoardAdapter(Context context, List<BoardItemData> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @NonNull
    public void onBindViewHolder(Holder holder, int position) {
        int itemposition = position;
        holder.postingDateText.setText(list.get(itemposition).postingDate);
        holder.boardTitleText.setText(list.get(itemposition).boardTitle);
        Log.e("StudyApp", "onBindViewHolder" + itemposition);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemposition != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, BoardDetailActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }


    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView postingDateText;
        public TextView boardTitleText;

        public Holder(View view){
            super(view);
            postingDateText = (TextView) view.findViewById(R.id.postingDate);
            boardTitleText = (TextView) view.findViewById(R.id.boardTitle);
        }
    }
}

